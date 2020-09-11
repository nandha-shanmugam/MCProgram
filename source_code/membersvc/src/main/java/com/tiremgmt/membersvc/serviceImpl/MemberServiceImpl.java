/**
 * 
 */
package com.tiremgmt.membersvc.serviceImpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.tiremgmt.membersvc.service.MemberService;
import com.tiremgmt.membersvc.utils.Constants;
import com.tiremgmt.membersvc.utils.ValidationUtils;
import com.tiremgmt.tiremgmtcommon.dto.MemberDTO;
import com.tiremgmt.tiremgmtcommon.entity.Member;
import com.tiremgmt.tiremgmtcommon.repo.MemberRepo;
import com.tiremgmt.tiremgmtcommon.utils.HelperUtils;

import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @author javacloudmc275
 *
 */
@Component
@Slf4j
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepo memberRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public MemberDTO getMemberById(Long memberId) {
		log.info("get member by id : {}" ,memberId);
		if (memberId == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_MEMBER_ID);
		Optional<Member> member = memberRepo.findById(memberId);
		if (!member.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					Constants.NO_RECORDS_FOR_INPUT_MEMBER_ID + " " + memberId);
		return modelMapper.map(member.get(),MemberDTO.class);
	}
	
	@Override
	public MemberDTO getMemberByUsername(String username) {
		log.info("get member by username : {}" ,username);
		if (StringUtils.isEmpty(username))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_USERNAME);
		Optional<Member> member = memberRepo.findByUsername(username);
		if (!member.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					Constants.NO_RECORDS_FOR_INPUT_MEMBER_USERNAME + " " + username);
		return modelMapper.map(member.get(),MemberDTO.class);
	}

	@Override
	public Boolean saveMember(MemberDTO memberDTO) {
		log.info("save member.");
		boolean isSaved = false;
		ValidationUtils.validateMemberDetails(memberDTO);
		validateUsername(memberDTO.getUsername());
		Member member = modelMapper.map(memberDTO, Member.class);
		if(member!=null) {
			try {
				setMemberCreatedInfo(member,true);
				memberRepo.save(member);
				isSaved = true;
			}
			catch(DataIntegrityViolationException exception) {
				log.error("DataIntegrityViolationException on save member and vehicle : {}",exception);
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"DataIntegrityViolationException on save member and vehicle.");
			}
			catch(Exception exception)
			{
				log.error("Exception on save member and vehicle : "+exception);
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Exception on save member and vehicle.");
			}
		}
		return isSaved;
	}
	
	private void setMemberCreatedInfo(Member member,boolean isCreated) {
		if(isCreated) {
			member.setCreatedBy(member.getUsername());//(StringUtils.isEmpty(member.getCreatedBy()) ? Constants.DEFAULT_USER_NAME : member.getCreatedBy());
			member.setCreatedTime(HelperUtils.getCurrentTime());
		}
		member.setUpdatedBy(StringUtils.isEmpty(member.getUpdatedBy()) ? Constants.DEFAULT_USER_NAME : member.getUpdatedBy());
		member.setUpdatedTime(HelperUtils.getCurrentTime());
		if(member.getVehicleList()!=null && member.getVehicleList().size()>0) {
			member.getVehicleList().forEach(vehicle -> {
//				if(isCreated || vehicle.getId()==null) {
					vehicle.setCreatedBy(member.getUsername());//(StringUtils.isEmpty(vehicle.getCreatedBy()) ? Constants.DEFAULT_USER_NAME : vehicle.getCreatedBy());
					vehicle.setCreatedTime(HelperUtils.getCurrentTime());
//				}
				vehicle.setUpdatedBy(member.getUsername());//(StringUtils.isEmpty(vehicle.getUpdatedBy()) ? Constants.DEFAULT_USER_NAME : vehicle.getUpdatedBy());
				vehicle.setUpdatedTime(HelperUtils.getCurrentTime());
				vehicle.setMember(member);
			});
		}
	}

	@Override
	public Boolean updateMember(MemberDTO memberDTO) {
		log.info("update member.");
		boolean isUpdated = false;
		ValidationUtils.validateMemberDetails(memberDTO);
//		validateUsername(memberDTO.getUsername());
		Optional<Member> memberById = memberRepo.findById(memberDTO.getId());
		if(memberDTO.getId()==null || !memberById.isPresent()) {
			log.error("Record not found of member id : {}",memberDTO.getId());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Record not found of member id :"+memberDTO.getId());
		}
		Member member = modelMapper.map(memberDTO, Member.class);
		if(member!=null) {
			try {
				setMemberCreatedInfo(member,false);
				member.setCreatedBy(memberById.get().getCreatedBy());
				member.setCreatedTime(memberById.get().getCreatedTime());
				memberRepo.save(member);
				isUpdated = true;
			}
			catch(DataIntegrityViolationException exception) {
				log.error("DataIntegrityViolationException on update member and vehicle : {}",exception);
				throw new ResponseStatusException(HttpStatus.NOT_MODIFIED,"DataIntegrityViolationException on update member and vehicle.");
			}
			catch(Exception exception)
			{
				log.error("Exception on update member and vehicle : "+exception);
				throw new ResponseStatusException(HttpStatus.NOT_MODIFIED,"Exception on update member and vehicle.");
			}
		}
		return isUpdated;
	}

	@Override
	public Boolean validateUsername(String userName) {
		if(memberRepo.findByUsername(userName).isPresent())
		{
			log.error("Username already exists : {}",userName);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Username already exists : " + userName);
		}
		return true;
	}

}

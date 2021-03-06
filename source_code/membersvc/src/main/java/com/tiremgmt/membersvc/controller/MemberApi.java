/**
 * 
 */
package com.tiremgmt.membersvc.controller;

import org.springframework.http.ResponseEntity;

import com.tiremgmt.tiremgmtcommon.dto.MemberDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author javacloudmc275
 *
 */
@Api(tags="Member Service",value="Member Service")
public interface MemberApi {
	
	@ApiOperation(value="Get member details along with vehicle information by member id.",response=MemberDTO.class)
	ResponseEntity<MemberDTO> getMemberDetailsByid(Long memberId);
	
	@ApiOperation(value="Save member details along with vehicle information.",response=Boolean.class)
	ResponseEntity<Boolean> saveMember(MemberDTO memberDTO);
	
	@ApiOperation(value="Update member details along with vehicle information.",response=Boolean.class)
	ResponseEntity<Boolean> updateMember(MemberDTO memberDTO);
	
	@ApiOperation(value="Verify given username(isExists) with existing usernames.",response=Boolean.class)
	ResponseEntity<Boolean> validateUsername(String username);
	
	@ApiOperation(value="Get member details along with vehicle information by member username.",response=MemberDTO.class)
	ResponseEntity<MemberDTO> getMemberDetailsByUsername(String username);

}

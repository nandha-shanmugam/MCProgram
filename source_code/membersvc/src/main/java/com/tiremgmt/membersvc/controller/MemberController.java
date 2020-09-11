/**
 * 
 */
package com.tiremgmt.membersvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiremgmt.membersvc.service.MemberService;
import com.tiremgmt.tiremgmtcommon.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author javacloudmc275
 *
 */
@RestController
@RequestMapping("/api/member")
@Slf4j
public class MemberController implements MemberApi {

	@Autowired
	private MemberService memberService;
	
	@GetMapping(value = "/v1/{id}")
	@CrossOrigin
    public ResponseEntity<MemberDTO> getMemberDetailsByid(@PathVariable("id")Long memberId) {
		log.info("Controller - get member by id : "+memberId);
		return new ResponseEntity<>(memberService.getMemberById(memberId),HttpStatus.OK);
    }
	
	@PostMapping(value = "/v1/save")
	public ResponseEntity<Boolean> saveMember(@RequestBody MemberDTO memberDTO) {
		log.info("Controller - save member.");
		return new ResponseEntity<>(memberService.saveMember(memberDTO),HttpStatus.OK);
	}
	
	@PutMapping(value = "/v1/update")
	public ResponseEntity<Boolean> updateMember(@RequestBody MemberDTO memberDTO) {
		log.info("Controller - update member.");
		return new ResponseEntity<>(memberService.updateMember(memberDTO),HttpStatus.OK);
	}
	
	@GetMapping(value = "/v1/validate/{username}")
    public ResponseEntity<Boolean> validateUsername(@PathVariable("username")String username) {
		log.info("Controller - validate member by username : "+username);
		return new ResponseEntity<>(memberService.validateUsername(username),HttpStatus.OK);
    }
	
	@GetMapping(value = "/v1/username/{username}")
    public ResponseEntity<MemberDTO> getMemberDetailsByUsername(@PathVariable("username")String username) {
		log.info("Controller - get member by username : {}",username);
		return new ResponseEntity<>(memberService.getMemberByUsername(username),HttpStatus.OK);
    }
}

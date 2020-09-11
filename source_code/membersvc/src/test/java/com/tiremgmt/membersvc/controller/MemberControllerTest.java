/**
 * 
 */
package com.tiremgmt.membersvc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.server.ResponseStatusException;

import com.tiremgmt.membersvc.service.MemberService;
import com.tiremgmt.tiremgmtcommon.dto.MemberDTO;

/**
 * @author javacloudmc275
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MemberControllerTest {

	@Mock
	private MemberService memberService;
	
	@Test
	public void getMemberByIdTest() {
		when(memberService.getMemberById(new Long(1))).thenReturn(new MemberDTO(new Long(1),"Nandha","Erode","TN","India","nandha@cts.com","ALKJA0987F","9876789876","21-08-1990","Nandha",null,"Nandha",null,new ArrayList<>()));
		MemberDTO memberDTO = memberService.getMemberById(new Long(1));
		assertEquals("Nandha", memberDTO.getUsername());
	}
	
	@Test(expected = ResponseStatusException.class)
	public void getMemberByIdTestNegative() {
		when(memberService.getMemberById(new Long(16))).thenThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid member id"));
		memberService.getMemberById(new Long(16));
	}
	
	@Test
	public void getMemberByNameTest() {
		when(memberService.getMemberByUsername("Nandha")).thenReturn(new MemberDTO(new Long(1),"Nandha","Erode","TN","India","nandha@cts.com","ALKJA0987F","9876789876","21-08-1990","Nandha",null,"Nandha",null,new ArrayList<>()));
		MemberDTO memberDTO = memberService.getMemberByUsername("Nandha");
		assertEquals("Nandha", memberDTO.getUsername());
	}
	
	@Test(expected = ResponseStatusException.class)
	public void getMemberByNameTestNegative() {
		when(memberService.getMemberByUsername("Kumar")).thenThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid member name."));
		memberService.getMemberByUsername("Kumar");
	}
}

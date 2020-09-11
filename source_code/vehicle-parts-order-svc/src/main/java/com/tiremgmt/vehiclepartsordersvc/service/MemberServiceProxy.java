package com.tiremgmt.vehiclepartsordersvc.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.tiremgmt.vehiclepartsordersvc.dto.MemberDTO;


@FeignClient(name = "member-service")//,url="http://localhost:9000/tiremgmt"
@RibbonClient(name = "member-service")
public interface MemberServiceProxy {
	
	@GetMapping("/api/member/v1/{id}")
    public ResponseEntity<MemberDTO> getMemberDetailsByid(@PathVariable("id")Long memberId);

	@GetMapping("/api/member/v1/username/{username}")
    public ResponseEntity<MemberDTO> getMemberDetailsByUsername(@RequestHeader(value = "Authorization", required = true) String authorizationHeader,@PathVariable("username")String username);
}

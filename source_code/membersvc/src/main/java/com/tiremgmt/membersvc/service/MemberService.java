/**
 * 
 */
package com.tiremgmt.membersvc.service;

import com.tiremgmt.tiremgmtcommon.dto.MemberDTO;

/**
 * @author javacloudmc275
 *
 */
public interface MemberService {

	/**Get member details by member id
	 * @Param memberId
	 * @return MemberDTO
	 */
	MemberDTO getMemberById(Long memberId);
	
	/**
	 * Save member information along with member vehicle details
	 * 
	 * @param memberDTO
	 * @return true/false of save status
	 */
	Boolean saveMember(MemberDTO memberDTO);

	/**
	 * Update member details by member id
	 * 
	 * @param memberDTO
	 * @return true/false of update status
	 */
	Boolean updateMember(MemberDTO memberDTO);

	/**
	 * Check username is already exists or not
	 * 
	 * @param username
	 * @return
	 */
	Boolean validateUsername(String username);

	/**
	 * Get member by user name
	 * 
	 * @param username
	 * @return
	 */
	MemberDTO getMemberByUsername(String username);
}

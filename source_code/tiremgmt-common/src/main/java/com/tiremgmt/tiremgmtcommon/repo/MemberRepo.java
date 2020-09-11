/**
 * 
 */
package com.tiremgmt.tiremgmtcommon.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiremgmt.tiremgmtcommon.entity.Member;

/**
 * @author javacloudmc275
 *
 */
@Repository
public interface MemberRepo extends JpaRepository<Member,Long> {

	Optional<Member> findByUsername(String userName);

}
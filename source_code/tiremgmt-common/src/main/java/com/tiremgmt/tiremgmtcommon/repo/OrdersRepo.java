/**
 * 
 */
package com.tiremgmt.tiremgmtcommon.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiremgmt.tiremgmtcommon.entity.Orders;

/**
 * @author javacloudmc275
 *
 */
@Repository
public interface OrdersRepo extends JpaRepository<Orders,Long> {

	Optional<Orders> findByOrderNumber(String orderNumber);

	Optional<List<Orders>> findByMemberId(Long id);

}

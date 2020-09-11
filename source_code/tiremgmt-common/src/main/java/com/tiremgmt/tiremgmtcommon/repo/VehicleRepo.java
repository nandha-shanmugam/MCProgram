/**
 * 
 */
package com.tiremgmt.tiremgmtcommon.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiremgmt.tiremgmtcommon.entity.Vehicle;

/**
 * @author javacloudmc275
 *
 */
@Repository
public interface VehicleRepo extends JpaRepository<Vehicle,Long> {

}

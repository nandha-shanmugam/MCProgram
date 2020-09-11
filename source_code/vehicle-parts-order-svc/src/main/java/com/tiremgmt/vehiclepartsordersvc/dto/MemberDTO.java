/**
 * 
 */
package com.tiremgmt.vehiclepartsordersvc.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tiremgmt.tiremgmtcommon.dto.VehicleDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author javacloudmc275
 *
 */
@Getter
@Setter	
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2567069564288123855L;

	private Long id;
	private String username;
	private String address;
	private String state;
	private String country;
	private String email;
	private String pan;
	private String contact;
	private String dob;
	@JsonIgnore
	private String createdBy;
	@JsonIgnore
	private Timestamp createdTime;
	@JsonIgnore
	private String updatedBy;
	@JsonIgnore
	private Timestamp updatedTime;
//	private List<VehicleDTO> vehicleList;
	private List<OrdersDTO> orders;
}

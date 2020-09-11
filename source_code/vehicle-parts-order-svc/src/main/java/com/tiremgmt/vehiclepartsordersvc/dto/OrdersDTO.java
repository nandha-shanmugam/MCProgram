/**
 * 
 */
package com.tiremgmt.vehiclepartsordersvc.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
@JsonInclude(Include.NON_NULL)
public class OrdersDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1067876601523277087L;
	private Long id;
	//This is for input
	private String username;
	private String itemName;
	private String itemType;
	private String orderNumber;
	private int quantity;
	private String servicesRequired;
	private String createdBy;
	private Timestamp createdTime;
//	private MemberDTO member;

}

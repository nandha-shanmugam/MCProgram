/**
 * 
 */
package com.tiremgmt.tiremgmtcommon.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class VehicleDTO implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 3927485738022245226L;

	private Long id;

	private String name;
	private String type;
	private int model;
	private String vin;
	@JsonIgnore
	private String createdBy;
	@JsonIgnore
	private Timestamp createdTime;
	@JsonIgnore
	private String updatedBy;
	@JsonIgnore
	private Timestamp updatedTime;
}

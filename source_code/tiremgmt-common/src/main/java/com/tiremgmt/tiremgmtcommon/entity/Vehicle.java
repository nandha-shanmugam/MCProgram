/**
 * 
 */
package com.tiremgmt.tiremgmtcommon.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author javacloudmc275
 *
 */
@Entity
@Table(name = "vehicle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "member_id")
	private Member member;
	
	private String name;
	private String type;
	private int model;
	private String vin;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_time")
	private Timestamp createdTime;
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "updated_time")
	private Timestamp updatedTime;
}

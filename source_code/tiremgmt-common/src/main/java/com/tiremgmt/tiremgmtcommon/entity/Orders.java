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
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="item_name")
	private String itemName;
	@Column(name="item_type")
	private String itemType;
	@Column(name="order_number")
	private String orderNumber;
	private int quantity;
	@Column(name="services_required")
	private String servicesRequired;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_time")
	private Timestamp createdTime;
	
	@ManyToOne//(fetch = FetchType.LAZY)
	private Member member;
}

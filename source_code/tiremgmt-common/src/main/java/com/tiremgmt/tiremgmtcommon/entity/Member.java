/**
 * 
 */
package com.tiremgmt.tiremgmtcommon.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String address;
	private String state;
	private String country;
	private String email;
	private String pan;
	private String contact;
	private String dob;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_time")
	private Timestamp createdTime;
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "updated_time")
	private Timestamp updatedTime;
	
	//Uni directional
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="member_id")
//	@JsonIgnoreProperties("member")
	private List<Vehicle> vehicleList;
	//For bi-directional - add one more attribute => mappedBy = "member" and don't use joincloumn annotation
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="member_id")
	private List<Orders> orders;
}

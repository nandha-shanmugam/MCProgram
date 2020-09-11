/**
 * 
 */
package com.tiremgmt.tiremgmtcommon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author javacloudmc275
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2519212012321994608L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	
	private String username;
	private String password;

}

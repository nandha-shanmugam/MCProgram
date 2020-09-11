/**
 * 
 */
package com.tiremgmt.tiremgmtcommon.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author javacloudmc275
 *
 */
//@Entity
//@Table(name="product")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String quantity;
}

/**
 * 
 */
package com.tiremgmt.vehiclepartsordersvc.dto;

import java.io.Serializable;

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
public class ProductDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2614844354440456084L;
	
	private Long id;
	private String name;
	private String quantity;

	
}

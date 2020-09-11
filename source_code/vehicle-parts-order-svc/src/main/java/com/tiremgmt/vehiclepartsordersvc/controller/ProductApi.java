/**
 * 
 */
package com.tiremgmt.vehiclepartsordersvc.controller;

import org.springframework.http.ResponseEntity;

import com.tiremgmt.vehiclepartsordersvc.dto.ProductDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author javacloudmc275
 *
 */
@Api(tags="Product Service",value="Product Service")
public interface ProductApi {
	
	@ApiOperation(value="Save product details.", response=Boolean.class)
	ResponseEntity<Boolean> saveProduct(ProductDTO productDTO);
	
	@ApiOperation(value="Update product details.", response=Boolean.class)
	ResponseEntity<Boolean> updateProduct(ProductDTO productDTO);
	
	@ApiOperation(value="Get product details by product id.", response=ProductDTO.class)
	ResponseEntity<ProductDTO> getProductById(Long id);

}

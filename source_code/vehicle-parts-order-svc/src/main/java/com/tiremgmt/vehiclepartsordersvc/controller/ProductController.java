/**
 * 
 */
package com.tiremgmt.vehiclepartsordersvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiremgmt.vehiclepartsordersvc.dto.ProductDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author javacloudmc275
 *
 */
@RestController
@RequestMapping(value="/v1/product")
@Slf4j
public class ProductController implements ProductApi {

	@PostMapping(value="/save")
	public ResponseEntity<Boolean> saveProduct(@RequestBody ProductDTO productDTO) {
		log.info("controller - save product.");
		return null;
	}

	@PutMapping(value="/update")
	public ResponseEntity<Boolean> updateProduct(ProductDTO productDTO) {
		log.info("controller - update product.");
		return null;
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable("id")Long id) {
		log.info("controller - get product.");
		return null;
	}

}

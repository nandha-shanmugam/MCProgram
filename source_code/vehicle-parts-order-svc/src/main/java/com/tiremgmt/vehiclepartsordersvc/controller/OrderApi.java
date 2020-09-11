/**
 * 
 */
package com.tiremgmt.vehiclepartsordersvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.tiremgmt.vehiclepartsordersvc.dto.MemberDTO;
import com.tiremgmt.vehiclepartsordersvc.dto.OrdersDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author javacloudmc275
 *
 */
@Api(tags="Order Service",value="Order Service")
public interface OrderApi {

	@ApiOperation(value="Save Order details.", response=String.class)
	ResponseEntity<String> saveOrder(HttpServletRequest request,OrdersDTO ordersDTO);
	
	@ApiOperation(value="Update Order details.", response=Boolean.class)
	ResponseEntity<Boolean> updateOrder(OrdersDTO ordersDTO);
	
	@ApiOperation(value="Get Order details by Order number.", response=OrdersDTO.class)
	ResponseEntity<MemberDTO> getOrderByNumber(HttpServletRequest request,String orderNumber);
	
	@ApiOperation(value="Get all Orders by member user name.", response=MemberDTO.class)
	ResponseEntity<MemberDTO> getAllOrdersByUsername(HttpServletRequest request,String username);


}

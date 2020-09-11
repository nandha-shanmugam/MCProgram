/**
 * 
 */
package com.tiremgmt.vehiclepartsordersvc.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author javacloudmc275
 *
 */
@Configuration
public class AppConfig {

	@Bean
	public ModelMapper createModelMapperBean() {
		return new ModelMapper();
	}
	
	@Bean
	public RestTemplate InitializaeRestTemplateBean() {
		return new RestTemplate();
	}
}

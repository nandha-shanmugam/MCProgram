/**
 * 
 */
package com.tiremgmt.membersvc.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}

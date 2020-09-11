package com.tiremgmt.membersvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.tiremgmt.tiremgmtcommon.TiremgmtCommonApplication;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackageClasses = TiremgmtCommonApplication.class)
@EnableJpaRepositories(basePackageClasses = TiremgmtCommonApplication.class)
public class MembersvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MembersvcApplication.class, args);
	}

}

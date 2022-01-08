package com.idp.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//DROP TABLE IF EXISTS `customer`;
//		CREATE TABLE `customer` (
//		`id` bigint NOT NULL COMMENT 'Primary key ID',
//		`name` varchar(255) NOT NULL COMMENT 'Customer  name',
//		`age` int NOT NULL  COMMENT 'Age',
//		`birthdate` date NOT NULL,
//		`cell` varchar(255) DEFAULT NULL COMMENT 'Cell number',
//		`address` varchar(255) DEFAULT NULL COMMENT 'Address',
//		`school` varchar(255) DEFAULT NULL COMMENT 'Graduation school',
//		`email` varchar(255) DEFAULT NULL COMMENT 'Email address',
//		PRIMARY KEY (`id`)
//		) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Customer info table';
//

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}

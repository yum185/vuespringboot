The following frameworks are used in the project:

```
vue.js
springboot
hibernate
mysql
```
```
java version:8
```

In order to connect mysql server please update the 
```
spring.datasource.username
spring.datasource.password
```
in application.properties in backend-springboot

Please use the following command to set up the database: 

```
CREATE DATABASE idp;
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
                            `id` bigint NOT NULL COMMENT 'Primary key ID',
                            `name` varchar(255) NOT NULL COMMENT 'Customer  name',
                            `age` int NOT NULL  COMMENT 'Age',
			    `birthdate` date NOT NULL,
                            `cell` varchar(255) DEFAULT NULL COMMENT 'Cell number',
                            `address` varchar(255) DEFAULT NULL COMMENT 'Address',
                            `school` varchar(255) DEFAULT NULL COMMENT 'Graduation school',
                            `email` varchar(255) DEFAULT NULL COMMENT 'Email address',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Customer info table';
```

In order to run the frontend-vue, please use the following commands:
```
npm install
npm run serve
```
```
The backend uses port 8089.
The frontend uses port 9876.
```

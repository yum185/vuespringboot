package com.idp.springboot.config;

import com.idp.springboot.dao.CustomerRepository;
import com.idp.springboot.model.Customer;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Configuration
public class CustomerConfig {

//    @Bean
//    @ConfigurationProperties("app.datasource")
//    public HikariDataSource hiKariDataSource(){
//        return DataSourceBuilder.create().type(HikariDataSource.class).build();
//    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository) {
        return args -> {
            Customer Homer = new Customer(1l, "Homer",
                    LocalDate.of(1969, Month.OCTOBER, 1),
                    "15934566",
                    "Evergreen Terrace 12, Springfield",
                    "Springfield Elementary",
                    "homer@yahoo.com");
            Customer Marge = new Customer(2l, "Marge",
                    LocalDate.of(1972, Month.MAY, 3),
                    "11238756",
                    "Evergreen Terrace 12, Springfield",
                    "Springfield College",
                    "marge@yahoo.com");
            Customer Lisa = new Customer(3l, "Lisa",
                    LocalDate.of(2001, Month.JULY, 5),
                    "11234543",
                    "Evergreen Terrace 12, Springfield",
                    "Springfield Elementary",
                    "lisa@yahoo.com");
            Customer Bart = new Customer(4l, "Bart",
                    LocalDate.of(1997, Month.DECEMBER, 6),
                    "11239062",
                    "Evergreen Terrace 12, Springfield",
                    "Springfield Elementary",
                    "bart@yahoo.com");
            Customer Ned = new Customer(5l, "Ned",
                    LocalDate.of(1961, Month.MARCH, 21),
                    "11114566",
                    "Evergreen Terrace 11, Springfield",
                    "Springfield College",
                    "ned@yahoo.com");
            Customer Milhouse = new Customer(6l, "Milhouse",
                    LocalDate.of(2002, Month.JANUARY, 13),
                    "11789566",
                    "Evergreen Terrace 23, Springfield",
                    "Springfield Elementary",
                    "milhouse@yahoo.com");
            Customer Maggie = new Customer(7l, "Maggie",
                    LocalDate.of(2011, Month.NOVEMBER, 16),
                    "14449066",
                    "Evergreen Terrace 12, Springfield",
                    "Springfield Kindergarten",
                    "maggie@yahoo.com");
            repository.saveAll(Arrays.asList(Homer, Marge, Lisa, Bart, Ned, Milhouse, Maggie));
        };
    }
}

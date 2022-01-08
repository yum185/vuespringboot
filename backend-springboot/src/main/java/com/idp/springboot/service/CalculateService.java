package com.idp.springboot.service;

import com.idp.springboot.dao.CustomerRepository;
import com.idp.springboot.model.Customer;
import com.idp.springboot.model.Result;
import com.idp.springboot.model.ResultRecord;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CalculateService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CalculateService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Result<Integer> calcuateMinimumAgeAmount(String startTime, String endTime){
        int startYear;
        int endYear;
        try{
           startYear = Integer.parseInt(startTime);
           endYear =  Integer.parseInt(endTime);
        } catch (Exception e){
            return Result.error("111","Invalid input");
        }
        if(startYear> endYear){
            return Result.error("112","Start year should be before end year.");
        }
        int gap = endYear - startYear;
        int tenYearCount = gap/10+1;
        int index = 0;
        int[] minAgeArray = new int[tenYearCount];

        List<Customer> customerList = customerRepository.findAll();

        for(Customer c: customerList){
            if(c.getBirthdate().getYear()<= endYear && c.getBirthdate().getYear()>=startYear){
                index = (c.getBirthdate().getYear() - startYear)/10;
                if(minAgeArray[index] == 0
                   || (minAgeArray[index] != 0 && c.getAge()<minAgeArray[index])){
                    minAgeArray[index] = c.getAge();
                }
            }
        }
        return Result.success(Arrays.stream(minAgeArray).sum());
    }

}

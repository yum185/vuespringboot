package com.idp.springboot.controller;

import com.idp.springboot.model.Customer;
import com.idp.springboot.model.Result;
import com.idp.springboot.model.ResultRecord;
import com.idp.springboot.service.CalculateService;
import com.idp.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

@RequestMapping("/calculateageamount")
@RestController
public class CalculateController {

    private final CalculateService calculateService;

    @Autowired
    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping
    public Result<Integer> getMinimumAgeAmount(@RequestParam(defaultValue = "0") String startTime,
                                               @RequestParam(defaultValue = "0") String endTime) {

        return calculateService.calcuateMinimumAgeAmount(startTime,endTime);
    }


}

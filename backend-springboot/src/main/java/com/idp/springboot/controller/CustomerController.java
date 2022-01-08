package com.idp.springboot.controller;

import com.idp.springboot.model.Customer;
import com.idp.springboot.model.Result;
import com.idp.springboot.model.ResultRecord;
import com.idp.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Result<?> saveCustomer(@RequestBody Customer customer) {
        if (customer.getBirthdate() != null) {
            customer.setAgeFromNow(customer.getBirthdate());
        }
        return customerService.addNewCustomer(customer);
    }

    @PutMapping
    public Result<?> updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return Result.success();
    }

    @GetMapping
    public Result<?> getCustomersByPage(@RequestParam(defaultValue = "1") Integer pageNumber,
                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                        @RequestParam(defaultValue = "") String searchName,
                                        @RequestParam(defaultValue = "-1") Integer searchAge) {

        ResultRecord<Customer> result = customerService.findExamplePage(pageNumber, pageSize, searchName, searchAge);
        return Result.success(result);
    }

    @DeleteMapping("/{id}")
    public Result<?> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return Result.success();
    }
}

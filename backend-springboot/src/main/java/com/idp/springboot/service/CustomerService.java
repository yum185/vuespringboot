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
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Result<?> addNewCustomer(Customer customer) {
        if(customer.getId() != null){
            Optional<Customer> customerOptional = customerRepository.findById(customer.getId());
            if (customerOptional.isPresent()) {
               return Result.error("404","Record with id " + customer.getId() +" exists!");
            }
        }
        customerRepository.save(customer);
        return Result.success();
    }

    public void deleteCustomer(Long customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
        }
    }


    public ResultRecord<Customer> findExamplePage(Integer pageNumber, Integer pageSize, String searchName, Integer searchAge) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.Direction.ASC, "id");
        Customer customer = new Customer();

        ExampleMatcher matcher = ExampleMatcher.matching();
        if(!StringUtils.isEmpty(searchName)){
            customer.setName(searchName);
            matcher = matcher.withMatcher("name", ExampleMatcher.GenericPropertyMatchers.exact());
        }
        if( searchAge != -1 ){
            customer.setAge(searchAge);
            matcher = matcher.withMatcher("age", ExampleMatcher.GenericPropertyMatchers.exact());
        } else {
            matcher =  matcher.withIgnorePaths("age");
        }

        Example<Customer> example = Example.of(customer, matcher);
        Page<Customer> pageResult = customerRepository.findAll(example, pageable);
        ResultRecord<Customer> result = new ResultRecord<>(pageNumber,
                pageSize,
                pageResult.getTotalPages(),
                pageResult.getTotalElements(),
                pageResult.getContent());
        return result;
    }


    @Transactional
    public void updateCustomer(Customer inputeCustomer) {
        Long customerId = inputeCustomer.getId();
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new IllegalStateException("Customer with id " + customerId + " does not exist."));

        String name = inputeCustomer.getName();
        String cell = inputeCustomer.getCell();
        String address = inputeCustomer.getAddress();
        String school = inputeCustomer.getSchool();
        String email = inputeCustomer.getEmail();
        LocalDate birthdate = inputeCustomer.getBirthdate();

        if (name != null && name.length() > 0 && !Objects.equals(customer.getName(), name)) {
            customer.setName(name);
        }
        if (cell != null && cell.length() > 0 && !Objects.equals(customer.getCell(), cell)) {
            customer.setCell(cell);
        }
        if (address != null && address.length() > 0 && !Objects.equals(customer.getAddress(), address)) {
            customer.setAddress(address);
        }
        if (school != null && school.length() > 0 && !Objects.equals(customer.getSchool(), school)) {
            customer.setSchool(school);
        }
        if (email != null && email.length() > 0 && !Objects.equals(customer.getEmail(), email)) {
            customer.setEmail(email);
        }
        if (birthdate != null && !Objects.equals(customer.getBirthdate(), birthdate)) {
            customer.setBirthdate(birthdate);
            customer.setAgeFromNow(birthdate);
        }
    }

}

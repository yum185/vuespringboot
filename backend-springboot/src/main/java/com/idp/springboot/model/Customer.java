package com.idp.springboot.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private LocalDate birthdate;

    private int age;
    private String cell;
    private String address;
    private String school;
    private String email;

    public Customer(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        Period diff= Period.between(birthdate, LocalDate.now());
        this.age = diff.getYears();
        setAgeFromNow(birthdate);
    }

    public Customer(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Customer(Long id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        setAgeFromNow(birthdate);
    }

    public Customer(Long id, String name, LocalDate birthdate, String cell, String address, String school, String email) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.cell = cell;
        this.address = address;
        this.school = school;
        this.email = email;
        setAgeFromNow(birthdate);
    }

    public Customer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAgeFromNow(LocalDate birth_date) {
        Period diff= Period.between(birth_date, LocalDate.now());
        this.age = diff.getYears();
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}

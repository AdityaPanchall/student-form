package com.studentform.model;

import java.time.LocalDate;

public class Student {

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String gender;
    private String highestQualification;
    private int yearOfPassing;
    private String mobileNumber;

    public Student() {
    }

    public Student(
            String firstName,
            String lastName,
            LocalDate dob,
            String gender,
            String highestQualification,
            int yearOfPassing,
            String mobileNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.highestQualification = highestQualification;
        this.yearOfPassing = yearOfPassing;
        this.mobileNumber = mobileNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHighestQualification() {
        return highestQualification;
    }

    public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }

    public int getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(int yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
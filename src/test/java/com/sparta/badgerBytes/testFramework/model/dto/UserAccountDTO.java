package com.sparta.badgerBytes.testFramework.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAccountDTO extends SuperDTO {

    @JsonProperty("user")
    private User user;

    public User getUser() {
        return user;
    }

    public static class User {

        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("email")
        private String email;
        @JsonProperty("password")
        private String password;
        @JsonProperty("title")
        private String title;
        @JsonProperty("birth_day")
        private String birthDay;
        @JsonProperty("birth_month")
        private String birthMonth;
        @JsonProperty("birth_year")
        private String birthYear;
        @JsonProperty("first_name")
        private String firstName;
        @JsonProperty("last_name")
        private String lastName;
        @JsonProperty("company")
        private String company;
        @JsonProperty("address1")
        private String address1;
        @JsonProperty("address2")
        private String address2;
        @JsonProperty("country")
        private String country;
        @JsonProperty("zipcode")
        private String zipcode;
        @JsonProperty("state")
        private String state;
        @JsonProperty("city")
        private String city;
        @JsonProperty("mobile_number")
        private String mobileNumber;


        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getTitle() {
            return title;
        }

        public String getBirthDay() {
            return birthDay;
        }

        public String getBirthMonth() {
            return birthMonth;
        }

        public String getBirthYear() {
            return birthYear;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getCompany() {
            return company;
        }

        public String getAddress1() {
            return address1;
        }

        public String getAddress2() {
            return address2;
        }

        public String getCountry() {
            return country;
        }

        public String getZipcode() {
            return zipcode;
        }

        public String getState() {
            return state;
        }

        public String getCity() {
            return city;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }
    }
}
package com.sparta.badgerBytes;

public class UserAccountDTO {
    private String name;
    private String email;
    private String password;
    private String title;
    private String birthDate;
    private String birthMonth;
    private String birthYear;
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String country;
    private String zipcode;
    private String state;
    private String city;
    private String mobileNumber;

    public UserAccountDTO(String name, String email, String password, String title, String birthDate, String birthMonth, String birthYear, String firstName, String lastName, String company, String address1, String address2, String country, String zipcode, String state, String city, String mobileNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.title = title;
        this.birthDate = birthDate;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.country = country;
        this.zipcode = zipcode;
        this.state = state;
        this.city = city;
        this.mobileNumber = mobileNumber;
    }

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

    public String getBirthDate() {
        return birthDate;
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

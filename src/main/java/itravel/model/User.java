package itravel.model;

import java.util.List;

public class User {
    private String id;
    private String userType;
    private String fullName;
    private String gender;
    private String state;
    private String city;
    private String street;
    private String zipCode;
    private Integer birthYear;
    private String email;
    private String password;
    // Using for admin
//    private String status; // active, deActive
    private boolean activType = false;

    private List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }


    public User() {
        id          = "";
        userType    = "";
        fullName    = "";
        gender      = "";
        state       = "";
        city        = "";
        street      = "";
        zipCode     = "";
        birthYear   = 1900;
        email       = "";
        password    = "";
        // using for admin
//        status      = "active";
        activType = false;
    }

    public User(boolean activType, String id, String userType, String fullName, String gender, String state, String city, String street,
                String zipCode, Integer birthYear, String email, String password) {
        this.id         = id;
        this.userType   = userType;
        this.fullName   = fullName;
        this.gender     = gender;
        this.state      = state;
        this.city       = city;
        this.street     = street;
        this.zipCode    = zipCode;
        this.birthYear  = birthYear;
        this.email      = email;
        this.password   = password;
        // using for admin
//        this.status      = "active";
        this.activType = activType;
    }

    public User(String id, String userType, String fullName, String gender, String state, String city, String street,
                String zipCode, Integer birthYear, String email, String password) {
        this.id         = id;
        this.userType   = userType;
        this.fullName   = fullName;
        this.gender     = gender;
        this.state      = state;
        this.city       = city;
        this.street     = street;
        this.zipCode    = zipCode;
        this.birthYear  = birthYear;
        this.email      = email;
        this.password   = password;
        // using for admin
//        this.status      = "active";
        this.activType = false;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getStatus() {
//        return status;
//    }

//    public void setStatus(String status) {
//        this.status = status;
//    }

    public boolean getActivType() { return activType; }

    public void setActivType(boolean activType) { this.activType = activType; }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userType='" + userType + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", birthYear=" + birthYear +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", activType=" + activType +
                '}';
    }
}

package com.example.sherif.damakvf;

public class Request {
    private String name,phone,city,bloodType,Date;

    public Request(){}

    public Request(String name, String phone, String city, String bloodType, String date) {
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.bloodType = bloodType;
        Date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}

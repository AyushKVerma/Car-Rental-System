package com.example.car;

public class Rental {
    private Customer customer;
    private Car car;
    private int noOfDays;

    public Rental(Customer customer, Car car, int noOfDays) {
        this.customer = customer;
        this.car = car;
        this.noOfDays = noOfDays;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

}

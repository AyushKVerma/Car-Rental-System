package com.example.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalSystem {
    private List<Rental> rentals;
    private List<Customer> customers;
    private List<Car> cars;

    public RentalSystem() {
        rentals = new ArrayList<>();
        customers = new ArrayList<>();
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addRent(Car car, Customer customer, int days) {
        if(!car.isRented()){
            rentals.add(new Rental(customer, car, days));
            System.out.println("Car Rented Successfully");
            car.rent();
        }else {
            System.out.println("Car is already rented");
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void returnCar(Car car) {
        Rental rentedCar = null;
        for(Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentedCar = rental;
                break;
            }
        }
            if(rentedCar != null){
                rentals.remove(rentedCar);
                System.out.println("Car Returned Successfully");
                car.returnCar();
            }else {
                System.out.println("Car Not Returned");
            }
        }
        public void menu(){
            Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("===Welcome to the Rental System===");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return Car");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            int ch = sc.nextInt();
            int nxt = 0;
            switch(ch){
                case 1:
                    System.out.println("==Rent Car==\n");
                    System.out.println("Available Cars for Rent!!");
                    for(Car car : cars) {
                        if (!car.isRented()) {
                            System.out.println("Car Id: " + car.getCarId() + "\nCar Name: "
                                    + car.getCarName() + "\nCar Brand: " + car.getCarBrand() + "\nCar Price: "+car.getCarPrice()
                            +"\n");
                            nxt++;
                        }
                    }
                    if (nxt == 0) {
                    System.out.println("No car available");
                }
                        System.out.println("Please enter CarId :");
                        String carId = sc.next();
                        System.out.println("Please enter Your Name :");
                        String customerName = sc.next();
                        System.out.println("Please enter No of days :");
                        int days = sc.nextInt();
                        Customer customer = new Customer(customerName,"CUS"+(customers.size()+1));
                        addCustomer(customer);
                        Car selectedCar = null;
                        for(Car car1: cars){
                            if(car1.getCarId().equals(carId) && !car1.isRented()){
                                selectedCar = car1;
                                break;
                            }
                        }
                        if(selectedCar == null){
                            System.out.println("Please Enter Correct Car Id");
                        }
                        if(selectedCar != null){
                            System.out.println("==Rent Info==");
                            System.out.println("Car Id: " + selectedCar.getCarId());
                            System.out.println("Car Name: " + selectedCar.getCarName());
                            System.out.println("Car Brand: " + selectedCar.getCarBrand());
                            System.out.println("Customer Id: "+ customer.getCustomerId());
                            System.out.println("Customer Name: "+ customer.getCustomerName());

                            System.out.println("Total no of Days :"+ days);
                            System.out.println("Total Price :"+ selectedCar.totalPrice(days));

                            System.out.println("Press Y or N to confirm you order:" );
                            String ch1 = sc.next();
                            if(ch1.equalsIgnoreCase("Y")){
                                System.out.println("Rent is confirmed");
                                addRent(selectedCar, customer,days);
                                System.out.println("==Thank You==");
                            }
                            else{
                                System.out.println("Rental Canceled!!");
                            }

                        }
                    break;
                case 2:
                    System.out.println("==Return Car==\n");
                    System.out.println("Enter CarId you want to return:");
                    String carid = sc.next();
                    Car carToReturn = null;
                    int nxt1 = 0;
                    for(Car car: cars){
                        if(car.getCarId().equals(carid) && car.isRented()){
                            carToReturn = car;
                            nxt1++;
                            break;
                        }
                    }
                    if(nxt1 == 0){
                        System.out.println("No such Car rented");
                    }

                    if(carToReturn != null){
                        Customer cust = null;
                        for(Rental rental : rentals){
                            if(rental.getCar() == carToReturn){
                                cust = rental.getCustomer();
                            }
                        }
                        if(cust != null){
                            System.out.println("Car returned Successfully by: "+ cust.getCustomerId());
                            carToReturn.returnCar();
                        }
                    }

                    break;
                case 3:
                    System.out.println("==Thanks for Using Car Rental System==");
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        }
}
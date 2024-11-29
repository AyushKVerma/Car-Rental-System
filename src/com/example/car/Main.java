package com.example.car;


public class Main {
    public static void main(String[] args) {

        //List<Car> cars = new ArrayList<Car>();

        RentalSystem rs = new RentalSystem();
        Car car1 = new Car("C001", "Thar", "Mahindra", 1500);
        Car car2 = new Car("C002", "Astor", "MG", 1000);
        Car car3 = new Car("C003", "Slavia", "Skoda", 1000);
        Car car4 = new Car("C004", "Hector", "MG", 1200);
        Car car5 = new Car("C005", "Safari", "Tata", 1100);
        Car car6 = new Car("C006", "XUV700", "Mahindra", 1800);
        Car car7 = new Car("C007", "Bolero", "Mahindra", 800);

        rs.addCar(car1);
        rs.addCar(car2);
        rs.addCar(car3);
        rs.addCar(car4);
        rs.addCar(car5);
        rs.addCar(car6);
        rs.addCar(car7);

        rs.menu();


    }
}
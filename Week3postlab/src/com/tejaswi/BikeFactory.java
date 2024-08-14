package com.tejaswi;

public class BikeFactory implements VehicleFactory {
  Public Vehicle createVehicle(){
    return new Bike();
  }
}

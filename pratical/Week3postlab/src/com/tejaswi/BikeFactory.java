package com.tejaswi;

public class BikeFactory implements VehicleFactory
{
public Vehicle createVehicle() {
return new Bike();
}


}

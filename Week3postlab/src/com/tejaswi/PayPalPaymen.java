package com.tejaswi;

public class PayPalPaymen implements PaymentMethod
{
public void pay(double amount)
{
System.out.println("Paid $" + amount + "using PayPal..!");
}


}

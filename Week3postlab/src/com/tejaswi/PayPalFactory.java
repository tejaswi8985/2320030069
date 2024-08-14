package com.tejaswi;

public class PayPalFactory  implements PaymentMethodFactory
{
public PaymentMethod createPaymentMethod()
{
return new PayPalPaymen();
}


}

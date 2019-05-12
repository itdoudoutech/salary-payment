package com.doudou.transaction;

import com.doudou.paymentMethod.DirectMethod;
import com.doudou.paymentMethod.PaymentMethod;

public class ChangeDirectTransaction extends ChangeMethodTransaction{

    public ChangeDirectTransaction(int empId) {
        super(empId);
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return new DirectMethod();
    }
}

package com.doudou.transaction;

import com.doudou.paymentMethod.MailMethod;
import com.doudou.paymentMethod.PaymentMethod;

public class ChangeMailTransaction extends ChangeMethodTransaction{

    public ChangeMailTransaction(int empId) {
        super(empId);
    }

    @Override
    protected PaymentMethod getPaymentMethod() {
        return new MailMethod();
    }
}

package com.doudou.transaction;

import com.doudou.emp.Employee;
import com.doudou.paymentMethod.PaymentMethod;

public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction{

    public ChangeMethodTransaction(int empId) {
        super(empId);
    }

    @Override
    public void change(Employee employee) {
        employee.setPaymentMethod(getPaymentMethod());
    }

   protected abstract PaymentMethod getPaymentMethod();
}

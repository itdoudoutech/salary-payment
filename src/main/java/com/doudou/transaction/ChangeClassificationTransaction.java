package com.doudou.transaction;


import com.doudou.emp.Employee;
import com.doudou.paymentClassification.PaymentClassification;
import com.doudou.paymentSchedule.PaymentSchedule;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction{

    public ChangeClassificationTransaction(int empId) {
        super(empId);
    }

    @Override
    public void change(Employee employee) {
        employee.setPaymentClassification(getClassification());
        employee.setPaymentSchedule(getSchedule());
    }

    protected abstract PaymentClassification getClassification();


    protected abstract PaymentSchedule getSchedule();


}

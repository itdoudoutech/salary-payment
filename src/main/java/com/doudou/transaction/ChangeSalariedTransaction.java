package com.doudou.transaction;

import com.doudou.paymentClassification.PaymentClassification;
import com.doudou.paymentClassification.SalariedClassification;
import com.doudou.paymentSchedule.MonthlySchedule;
import com.doudou.paymentSchedule.PaymentSchedule;


public class ChangeSalariedTransaction extends ChangeClassificationTransaction{

    private double salary;

    public ChangeSalariedTransaction(int empId, double salary) {
        super(empId);
        this.salary = salary;
    }

    @Override
    protected PaymentClassification getClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }
}

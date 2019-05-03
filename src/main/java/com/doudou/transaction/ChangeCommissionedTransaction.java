package com.doudou.transaction;

import com.doudou.paymentClassification.CommissionedClassification;
import com.doudou.paymentClassification.PaymentClassification;
import com.doudou.paymentSchedule.BiweeklySchedule;
import com.doudou.paymentSchedule.PaymentSchedule;

public class ChangeCommissionedTransaction extends ChangeClassificationTransaction{

    private double salary;

    private double commissionRate;

    public ChangeCommissionedTransaction(int empId, double salary, double commissionRate) {
        super(empId);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    protected PaymentClassification getClassification() {
        return new CommissionedClassification(salary, commissionRate);
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new BiweeklySchedule();
    }
}

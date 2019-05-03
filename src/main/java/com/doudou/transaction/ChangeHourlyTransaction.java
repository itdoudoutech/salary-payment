package com.doudou.transaction;

import com.doudou.paymentClassification.HourlyClassification;
import com.doudou.paymentClassification.PaymentClassification;
import com.doudou.paymentSchedule.PaymentSchedule;
import com.doudou.paymentSchedule.WeeklySchedule;


public class ChangeHourlyTransaction extends ChangeClassificationTransaction {

    private double hourlyRate;


    public ChangeHourlyTransaction(int empId, double hourlyRate) {
        super(empId);
        this.hourlyRate = hourlyRate;
    }

    @Override
    protected PaymentClassification getClassification() {
        return new HourlyClassification(hourlyRate);
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }
}

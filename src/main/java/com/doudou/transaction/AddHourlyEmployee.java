package com.doudou.transaction;

import com.doudou.paymentClassification.HourlyClassification;
import com.doudou.paymentClassification.PaymentClassification;
import com.doudou.paymentSchedule.PaymentSchedule;
import com.doudou.paymentSchedule.WeeklySchedule;

/**
 * 添加按钟点工
 */
public class AddHourlyEmployee extends AddEmployeeTransaction {

    /**
     * 时薪
     */
    private double hourlyRate;

    public AddHourlyEmployee(int empId, String empName, String empAddress, double hourlyRate) {
        super(empId, empName, empAddress);
        this.hourlyRate = hourlyRate;
    }

    @Override
    PaymentSchedule getPaymentSchedule() {
        return new WeeklySchedule();
    }

    @Override
    PaymentClassification getPaymentClassification() {
        return new HourlyClassification(hourlyRate);
    }
}

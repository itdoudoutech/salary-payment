package com.doudou.transaction;

import com.doudou.paymentClassification.PaymentClassification;
import com.doudou.paymentClassification.SalariedClassification;
import com.doudou.paymentSchedule.MonthlySchedule;
import com.doudou.paymentSchedule.PaymentSchedule;

/**
 * 添加月度发薪雇员
 */
public class AddSalariedEmployee extends AddEmployeeTransaction {

    /**
     * 月薪
     */
    private double salary;

    public AddSalariedEmployee(int empId, String empName, String empAddress, double salary) {
        super(empId, empName, empAddress);
        this.salary = salary;
    }

    @Override
    PaymentSchedule getPaymentSchedule() {
        return new MonthlySchedule();
    }

    @Override
    PaymentClassification getPaymentClassification() {
        return new SalariedClassification(salary);
    }
}

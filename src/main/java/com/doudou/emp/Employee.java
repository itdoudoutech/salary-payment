package com.doudou.emp;

import com.doudou.affiliation.Affiliation;
import com.doudou.affiliation.NoAffiliation;
import com.doudou.paymentClassification.PaymentClassification;
import com.doudou.paymentMethod.PaymentMethod;
import com.doudou.paymentSchedule.PaymentSchedule;
import com.doudou.util.Paycheck;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employee {

    private int empId;
    private String empName;
    private String empAddress;

    private PaymentMethod paymentMethod;
    private PaymentSchedule paymentSchedule;
    private PaymentClassification paymentClassification;

    private Affiliation affiliation = new NoAffiliation();

    public Employee(int empId, String empName, String empAddress) {
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
    }

    public void payDay(Paycheck pc){
        double grossPay = paymentClassification.calculatePay(pc);
        double deductions = affiliation.calculateDeductions(pc);
        double netPay = grossPay - deductions;

        pc.setGrossPay(grossPay);
        pc.setDeductions(deductions);
        pc.setNetPay(netPay);

        paymentMethod.pay(pc);
    }

    public boolean isPayDate(Date payDate) {
        return paymentSchedule.isPayDate(payDate);
    }

    public Date getPayPeriodStartDate(Date payPeriodEndDate){
        return paymentSchedule.getPayPeriodStartDate(payPeriodEndDate);
    }
}

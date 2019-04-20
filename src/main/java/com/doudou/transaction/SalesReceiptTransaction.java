package com.doudou.transaction;

import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;
import com.doudou.paymentClassification.CommissionedClassification;
import com.doudou.paymentClassification.HourlyClassification;
import com.doudou.paymentClassification.SalesReceipt;
import com.doudou.paymentClassification.TimeCard;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class SalesReceiptTransaction implements Transaction{

    private Date date;

    private double amount;

    private int empId;

    @Override
    public void execute() {
        Employee employee = PayrollDatabase.getEmployee(empId);
        if(null == employee){
            throw new RuntimeException("No such employee");
        }
        CommissionedClassification cc = (CommissionedClassification) employee.getPaymentClassification();
        cc.addSalesReceipt(new SalesReceipt(date, amount));
    }
}

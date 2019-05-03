package com.doudou.transaction;

import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;
import com.doudou.paymentClassification.CommissionedClassification;
import com.doudou.paymentClassification.SalesReceipt;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class SalesReceiptTransactionTest extends BaseTest {

    @Test
    public void salesReceiptTest() {
        int empId = 1;
        String name = "Bob";
        String address = "Home";
        double salary = 1000.00;
        double commissionRate = 88.8;
        AddCommissionedEmployee commissionedEmployee = new AddCommissionedEmployee(empId, name, address, salary, commissionRate);
        commissionedEmployee.execute();

        Date today = new Date();
        double amount = 1884.25;
        SalesReceiptTransaction srt = new SalesReceiptTransaction(today, amount, empId);
        srt.execute();

        Employee employee = PayrollDatabase.getEmployee(empId);
        Assert.assertNotNull(employee);
        Assert.assertTrue(employee.getPaymentClassification() instanceof CommissionedClassification);
        SalesReceipt sr = ((CommissionedClassification) employee.getPaymentClassification()).getSalesReceipt(today);
        Assert.assertNotNull(sr);
        Assert.assertEquals(amount, sr.getAmount(), 0.01D);
    }

}

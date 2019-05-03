package com.doudou.transaction;

import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;
import com.doudou.paymentClassification.PaymentClassification;
import com.doudou.paymentClassification.SalariedClassification;
import com.doudou.paymentSchedule.MonthlySchedule;
import org.junit.Assert;
import org.junit.Test;

public class ChangeSalariedTransactionTest extends BaseTest {

    @Test
    public void changeTest() {
        int empId = 1;
        String name = "Bob";
        String address = "Home";
        double salary = 1000.00;
        double commissionRate = 88.8;
        AddCommissionedEmployee commissionedEmployee = new AddCommissionedEmployee(empId, name, address, salary, commissionRate);
        commissionedEmployee.execute();

        ChangeSalariedTransaction cst = new ChangeSalariedTransaction(empId, 500);
        cst.execute();

        Employee employee = PayrollDatabase.getEmployee(empId);
        Assert.assertNotNull(employee);
        PaymentClassification pcf = employee.getPaymentClassification();
        Assert.assertNotNull(pcf);
        Assert.assertTrue(pcf instanceof SalariedClassification);
        Assert.assertEquals(500, ((SalariedClassification) pcf).getSalary(), 0.01);
        Assert.assertTrue(employee.getPaymentSchedule() instanceof MonthlySchedule);
    }
}

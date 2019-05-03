package com.doudou.transaction;

import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;
import com.doudou.paymentClassification.CommissionedClassification;
import com.doudou.paymentClassification.PaymentClassification;
import com.doudou.paymentSchedule.BiweeklySchedule;
import org.junit.Assert;
import org.junit.Test;

public class ChangeCommissionedTransactionTest extends BaseTest {

    @Test
    public void changeTest() {
        int empId = 1;
        String name = "Bob";
        String address = "Home";
        double hourlyRate = 88.8;
        AddHourlyEmployee hourlyEmployee = new AddHourlyEmployee(empId, name, address, hourlyRate);
        hourlyEmployee.execute();

        double salary = 1000.00;
        double commissionRate = 88.8;
        ChangeCommissionedTransaction cct = new ChangeCommissionedTransaction(empId, salary, commissionRate);
        cct.execute();

        Employee employee = PayrollDatabase.getEmployee(empId);
        Assert.assertNotNull(employee);
        PaymentClassification pcf = employee.getPaymentClassification();
        Assert.assertNotNull(pcf);
        Assert.assertTrue(pcf instanceof CommissionedClassification);
        Assert.assertEquals(salary, ((CommissionedClassification) pcf).getSalary(), 0.01);
        Assert.assertEquals(commissionRate, ((CommissionedClassification) pcf).getCommissionRate(), 0.01);
        Assert.assertTrue(employee.getPaymentSchedule() instanceof BiweeklySchedule);
    }
}

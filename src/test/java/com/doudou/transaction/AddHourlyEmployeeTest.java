package com.doudou.transaction;

import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;
import com.doudou.paymentClassification.HourlyClassification;
import com.doudou.paymentMethod.HoldMethod;
import com.doudou.paymentSchedule.WeeklySchedule;
import org.junit.Assert;
import org.junit.Test;


public class AddHourlyEmployeeTest extends BaseTest {

    @Test
    public void addTest() {
        int empId = 1;
        String name = "Bob";
        String address = "Home";
        double hourlyRate = 88.8;
        AddHourlyEmployee hourlyEmployee = new AddHourlyEmployee(empId, name, address, hourlyRate);
        hourlyEmployee.execute();

        Employee employee = PayrollDatabase.getEmployee(empId);
        Assert.assertEquals(name, employee.getEmpName());

        Assert.assertTrue(employee.getPaymentClassification() instanceof HourlyClassification);
        Assert.assertEquals(hourlyRate, ((HourlyClassification) employee.getPaymentClassification()).getHourlyRate(), 0.01D);
        Assert.assertTrue(employee.getPaymentSchedule() instanceof WeeklySchedule);
        Assert.assertTrue(employee.getPaymentMethod() instanceof HoldMethod);
    }

}

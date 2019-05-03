package com.doudou.transaction;

import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;
import com.doudou.paymentClassification.CommissionedClassification;
import com.doudou.paymentMethod.HoldMethod;
import com.doudou.paymentSchedule.BiweeklySchedule;
import org.junit.Assert;
import org.junit.Test;


public class AddCommissionedEmployeeTest extends BaseTest {

    @Test
    public void addTest() {
        int empId = 1;
        String name = "Bob";
        String address = "Home";
        double salary = 1000.00;
        double commissionRate = 88.8;
        AddCommissionedEmployee commissionedEmployee = new AddCommissionedEmployee(empId, name, address, salary, commissionRate);
        commissionedEmployee.execute();

        Employee employee = PayrollDatabase.getEmployee(empId);
        Assert.assertEquals(name, employee.getEmpName());

        Assert.assertTrue(employee.getPaymentClassification() instanceof CommissionedClassification);
        Assert.assertEquals(salary, ((CommissionedClassification) employee.getPaymentClassification()).getSalary(), 0.01D);
        Assert.assertEquals(commissionRate, ((CommissionedClassification) employee.getPaymentClassification()).getCommissionRate(), 0.01D);
        Assert.assertTrue(employee.getPaymentSchedule() instanceof BiweeklySchedule);
        Assert.assertTrue(employee.getPaymentMethod() instanceof HoldMethod);
    }

}

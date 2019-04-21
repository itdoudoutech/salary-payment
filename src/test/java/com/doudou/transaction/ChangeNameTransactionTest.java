package com.doudou.transaction;

import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;
import org.junit.Assert;
import org.junit.Test;

public class ChangeNameTransactionTest {

    @Test
    public void testChangeName(){
        int empId = 1;
        String name = "Bob";
        String address = "Home";
        double hourlyRate = 88.8;
        AddHourlydEmployee hourlyEmployee = new AddHourlydEmployee(empId, name, address, hourlyRate);
        hourlyEmployee.execute();

        String newName = "Bill";
        ChangeNameTransaction ct = new ChangeNameTransaction(empId, newName);
        ct.execute();
        Employee employee = PayrollDatabase.getEmployee(empId);
        Assert.assertNotNull(employee);
        Assert.assertEquals(newName, employee.getEmpName());

    }
}

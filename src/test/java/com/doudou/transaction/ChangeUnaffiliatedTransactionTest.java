package com.doudou.transaction;

import com.doudou.affiliation.Affiliation;
import com.doudou.affiliation.NoAffiliation;
import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;
import org.junit.Assert;
import org.junit.Test;

public class ChangeUnaffiliatedTransactionTest extends BaseTest {

    @Test
    public void changeTest() {
        int empId = 1;
        String name = "Bob";
        String address = "Home";
        double hourlyRate = 88.8;
        AddHourlyEmployee hourlyEmployee = new AddHourlyEmployee(empId, name, address, hourlyRate);
        hourlyEmployee.execute();

        int memberId = 1000;
        ChangeUnaffiliatedTransaction cut = new ChangeUnaffiliatedTransaction(empId);
        cut.execute();

        Employee employee = PayrollDatabase.getEmployee(empId);
        Assert.assertNotNull(employee);

        Affiliation af = employee.getAffiliation();
        Assert.assertNotNull(af);
        Assert.assertTrue(af instanceof NoAffiliation);

        Employee member = PayrollDatabase.getUnionMember(memberId);
        Assert.assertNull(member);
    }
}

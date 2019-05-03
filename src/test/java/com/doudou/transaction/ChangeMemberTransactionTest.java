package com.doudou.transaction;

import com.doudou.affiliation.Affiliation;
import com.doudou.affiliation.UnionAffiliation;
import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;
import org.junit.Assert;
import org.junit.Test;

public class ChangeMemberTransactionTest extends BaseTest {

    @Test
    public void changeTest() {
        int empId = 1;
        String name = "Bob";
        String address = "Home";
        double hourlyRate = 88.8;
        AddHourlyEmployee hourlyEmployee = new AddHourlyEmployee(empId, name, address, hourlyRate);
        hourlyEmployee.execute();

        int memberId = 1000;
        double charge = 88.8;
        ChangeMemberTransaction cmt = new ChangeMemberTransaction(empId, memberId, charge);
        cmt.execute();

        Employee employee = PayrollDatabase.getEmployee(empId);
        Assert.assertNotNull(employee);

        Affiliation af = employee.getAffiliation();
        Assert.assertNotNull(af);
        Assert.assertTrue(af instanceof UnionAffiliation);
        Assert.assertEquals(charge, ((UnionAffiliation) af).getCharge(), 0.01);

        Employee member = PayrollDatabase.getUnionMember(memberId);
        Assert.assertNotNull(member);
        Assert.assertTrue(employee == member);
    }
}

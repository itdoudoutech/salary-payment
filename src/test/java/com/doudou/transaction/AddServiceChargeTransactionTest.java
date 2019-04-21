package com.doudou.transaction;

import com.doudou.affiliation.ServiceCharge;
import com.doudou.affiliation.UnionAffiliation;
import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;
import com.doudou.paymentClassification.HourlyClassification;
import com.doudou.paymentClassification.TimeCard;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class AddServiceChargeTransactionTest {

    @Test
    public void addTest(){
        int empId = 1;
        String name = "Bob";
        String address = "Home";
        double hourlyRate = 88.8;
        AddHourlydEmployee hourlyEmployee = new AddHourlydEmployee(empId, name, address, hourlyRate);
        hourlyEmployee.execute();

        Employee employee = PayrollDatabase.getEmployee(empId);
        Assert.assertNotNull(employee);

        int memberId = 20;
        double charge = 12.50;
        UnionAffiliation af = new UnionAffiliation(memberId, charge);

        employee.setAffiliation(af);
        PayrollDatabase.addUnionMember(memberId, employee);

        Date today = new Date();
        ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, today, charge);
        sct.execute();

        ServiceCharge sc = af.getServiceCharge(today);
        Assert.assertNotNull(sc);
        Assert.assertEquals(charge, sc.getAmount(), 0.01);

    }

}

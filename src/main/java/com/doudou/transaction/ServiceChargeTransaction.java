package com.doudou.transaction;

import com.doudou.affiliation.Affiliation;
import com.doudou.affiliation.UnionAffiliation;
import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class ServiceChargeTransaction implements Transaction{

    private int memberId;

    private Date date;

    private double charge;

    @Override
    public void execute() {
        Employee employee = PayrollDatabase.getUnionMember(memberId);
        Affiliation af = employee.getAffiliation();
        if(af instanceof UnionAffiliation){
            ((UnionAffiliation)af).addServiceCharge(date, charge);
        }
    }
}

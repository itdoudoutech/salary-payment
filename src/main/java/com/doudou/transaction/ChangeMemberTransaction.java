package com.doudou.transaction;

import com.doudou.affiliation.Affiliation;
import com.doudou.affiliation.UnionAffiliation;
import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction {

    private int memberId;

    private double charge;

    public ChangeMemberTransaction(int empId, int memberId, double charge) {
        super(empId);
        this.memberId = memberId;
        this.charge = charge;
    }

    @Override
    protected void recordMembership(Employee employee) {
        PayrollDatabase.addUnionMember(memberId, employee);
    }

    @Override
    protected Affiliation getAffiliation() {
        return new UnionAffiliation(memberId, charge);
    }
}

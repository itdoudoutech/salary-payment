package com.doudou.transaction;

import com.doudou.affiliation.Affiliation;
import com.doudou.affiliation.NoAffiliation;
import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;

public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction{

    public ChangeUnaffiliatedTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void recordMembership(Employee employee) {
        PayrollDatabase.deleteUnionMember(employee.getEmpId());
    }

    @Override
    protected Affiliation getAffiliation() {
        return new NoAffiliation();
    }
}

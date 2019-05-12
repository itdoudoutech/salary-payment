package com.doudou.transaction;

import com.doudou.affiliation.Affiliation;
import com.doudou.affiliation.NoAffiliation;
import com.doudou.affiliation.UnionAffiliation;
import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;

public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction{

    public ChangeUnaffiliatedTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void recordMembership(Employee employee) {
        Affiliation uf = employee.getAffiliation();
        if(uf instanceof UnionAffiliation){
            int memberId = ((UnionAffiliation)uf).getMemberId();
            PayrollDatabase.deleteUnionMember(memberId);
        }
    }

    @Override
    protected Affiliation getAffiliation() {
        return new NoAffiliation();
    }
}

package com.doudou.transaction;

import com.doudou.affiliation.Affiliation;
import com.doudou.emp.Employee;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction{

    public ChangeAffiliationTransaction(int empId) {
        super(empId);
    }

    @Override
    public void change(Employee employee) {
        recordMembership(employee);
        employee.setAffiliation(getAffiliation());
    }

    protected abstract void recordMembership(Employee employee);

    protected abstract Affiliation getAffiliation();

}

package com.doudou.transaction;

import com.doudou.emp.Employee;

public class ChangeNameTransaction extends ChangeEmployeeTransaction {

    private String newName;

    public ChangeNameTransaction(int empId, String newName) {
        super(empId);
        this.newName = newName;
    }

    @Override
    public void change(Employee employee) {
        employee.setEmpName(newName);
    }
}

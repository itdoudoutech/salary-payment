package com.doudou.transaction;

import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;


public abstract class ChangeEmployeeTransaction implements Transaction{

    private int empId;

    protected ChangeEmployeeTransaction(int empId) {
        this.empId = empId;
    }

    @Override
    public void execute() {
        Employee employee = PayrollDatabase.getEmployee(empId);
        if(null != employee){
            change(employee);
        }
    }


    public abstract void change(Employee employee);
}

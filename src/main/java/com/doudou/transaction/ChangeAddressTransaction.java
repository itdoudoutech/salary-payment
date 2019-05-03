package com.doudou.transaction;

import com.doudou.emp.Employee;

public class ChangeAddressTransaction extends ChangeEmployeeTransaction {

    private String newAddress;

    public ChangeAddressTransaction(int empId, String newAddress) {
        super(empId);
        this.newAddress = newAddress;
    }

    @Override
    protected void change(Employee employee) {
        employee.setEmpAddress(newAddress);
    }
}
package com.doudou.transaction;

import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;
import com.doudou.paymentClassification.PaymentClassification;
import com.doudou.paymentMethod.HoldMethod;
import com.doudou.paymentSchedule.PaymentSchedule;

/**
 * 添加雇员操作
 */
public abstract class AddEmployeeTransaction implements Transaction {

    private int empId;
    private String empName;
    private String empAddress;

    public AddEmployeeTransaction(int empId, String empName, String empAddress) {
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
    }

    abstract PaymentSchedule getPaymentSchedule();

    abstract PaymentClassification getPaymentClassification();

    @Override
    public void execute() {
        Employee employee = new Employee(empId, empName, empAddress);
        employee.setPaymentClassification(getPaymentClassification());
        employee.setPaymentMethod(new HoldMethod());
        employee.setPaymentSchedule(getPaymentSchedule());
        PayrollDatabase.addEmployee(employee);
    }
}

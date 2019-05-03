package com.doudou.transaction;

import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;
import com.doudou.util.Paycheck;


import java.util.*;

public class PaydayTransaction implements Transaction {
    private Date date;
    private Map<Integer, Paycheck> paycheckMap = new HashMap<>();

    public PaydayTransaction(Date date) {
        this.date = date;
    }

    @Override
    public void execute() {
        for (Employee employee : PayrollDatabase.getAllEmployee()) {
            if (employee.isPayDate(date)) {
                Paycheck paycheck = new Paycheck(employee.getPayPeriodStartDate(date), date);
                paycheckMap.put(employee.getEmpId(), paycheck);
                employee.payDay(paycheck);
            }
        }
    }

    public Paycheck getPaycheck(int employeeId) {
        return paycheckMap.get(employeeId);
    }
}

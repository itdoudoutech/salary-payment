package com.doudou.transaction;

import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;
import com.doudou.paymentClassification.HourlyClassification;
import com.doudou.paymentClassification.TimeCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class TimeCardTransaction implements Transaction{

    @Getter
    private Date date;

    private double hours;

    private int empId;

    @Override
    public void execute() {
        Employee employee = PayrollDatabase.getEmployee(empId);
        if(null == employee){
            throw new RuntimeException("No such employee");
        }
        HourlyClassification hc = (HourlyClassification) employee.getPaymentClassification();
        hc.addTimeCard(new TimeCard(date, hours));
    }
}

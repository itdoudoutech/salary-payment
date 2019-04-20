package com.doudou.emp;

import com.doudou.paymentClassification.PaymentClassification;
import com.doudou.paymentMethod.PaymentMethod;
import com.doudou.paymentSchedule.PaymentSchedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {

    private int empId;
    private String empName;
    private String empAddress;

    private PaymentMethod paymentMethod;
    private PaymentSchedule paymentSchedule;
    private PaymentClassification paymentClassification;

    public Employee(int empId, String empName, String empAddress) {
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
    }
}

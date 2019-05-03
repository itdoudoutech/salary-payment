package com.doudou.util;

import lombok.Data;

import java.util.Date;

@Data
public class Paycheck {

    private double grossPay;

    private double deductions;

    private double netPay;

    private Date payPeriodStartDate;

    private Date payPeriodEndDate;

    public Paycheck(Date payPeriodStartDate, Date payPeriodEndDate) {
        this.payPeriodStartDate = payPeriodStartDate;
        this.payPeriodEndDate = payPeriodEndDate;
    }
}

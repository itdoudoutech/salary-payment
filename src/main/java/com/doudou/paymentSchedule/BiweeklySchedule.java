package com.doudou.paymentSchedule;

import java.util.Date;

public class BiweeklySchedule extends PaymentSchedule{

    @Override
    public boolean isPayDate(Date date) {
        return false;
    }


    @Override
    public Date getPayPeriodStartDate(Date payPeriodEndDate) {
        return null;
    }
}

package com.doudou.paymentSchedule;

import java.util.Date;

public class MonthlySchedule extends PaymentSchedule{

    @Override
    boolean isPayDate(Date date) {
        return false;
    }
}

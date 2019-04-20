package com.doudou.paymentSchedule;

import java.util.Date;

public class WeeklySchedule extends PaymentSchedule{

    @Override
    boolean isPayDate(Date date) {
        return false;
    }
}

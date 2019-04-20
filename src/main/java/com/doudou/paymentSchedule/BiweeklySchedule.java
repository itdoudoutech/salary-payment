package com.doudou.paymentSchedule;

import java.util.Date;

public class BiweeklySchedule extends PaymentSchedule{

    @Override
    boolean isPayDate(Date date) {
        return false;
    }
}

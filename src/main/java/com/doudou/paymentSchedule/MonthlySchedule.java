package com.doudou.paymentSchedule;

import com.doudou.util.DateUtil;

import java.util.Calendar;
import java.util.Date;

public class MonthlySchedule extends PaymentSchedule{

    @Override
    public boolean isPayDate(Date date) {
        return DateUtil.isLastDayOfMonth(date);
    }

    @Override
    public Date getPayPeriodStartDate(Date payPeriodEndDate) {
        // 当月的第一天
        Calendar cal = Calendar.getInstance();
        cal.setTime(payPeriodEndDate);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        return cal.getTime();
    }
}

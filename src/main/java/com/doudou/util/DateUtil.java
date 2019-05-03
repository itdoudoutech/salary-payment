package com.doudou.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {


    public static boolean isInPayPeriod(Date theDate, Paycheck paychek) {
        Date startDate = paychek.getPayPeriodStartDate();
        Date endDate = paychek.getPayPeriodEndDate();
        return startDate.compareTo(theDate) <= 0 && theDate.compareTo(endDate) <= 0;
    }

    public static boolean isLastDayOfMonth(Date date) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(add(date, Calendar.DAY_OF_YEAR, 1));

        int m1 = c1.get(Calendar.MONTH);
        int m2 = c2.get(Calendar.MONTH);
        return m1 != m2;
    }

    public static Date add(Date date, int field, int value) {
        if (date == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(field, value);
        return cal.getTime();
    }
}

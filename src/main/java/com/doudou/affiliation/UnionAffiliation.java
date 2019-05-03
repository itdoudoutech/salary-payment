package com.doudou.affiliation;

import com.doudou.util.DateUtil;
import com.doudou.util.Paycheck;
import lombok.Getter;

import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UnionAffiliation implements Affiliation {

    @Getter
    private double charge;

    @Getter
    private int memberId;

    private Map<Date, ServiceCharge> serviceCharges;

    public UnionAffiliation(int memberId, double charge) {
        this.memberId = memberId;
        this.charge = charge;
        this.serviceCharges = new HashMap<>();
    }

    public ServiceCharge getServiceCharge(Date date) {
        return serviceCharges.get(date);
    }

    public void addServiceCharge(Date date, double charge) {
        ServiceCharge sc = new ServiceCharge(date, charge);
        serviceCharges.put(date, sc);
    }

    @Override
    public double calculateDeductions(Paycheck paycheck) {
        double deduce = charge * numberOfFridayInPayPeriod(paycheck.getPayPeriodStartDate(), paycheck.getPayPeriodEndDate());
        for (ServiceCharge serviceCharge : serviceCharges.values()) {
            if (DateUtil.isInPayPeriod(serviceCharge.getDate(), paycheck)) {
                deduce += serviceCharge.getAmount();
            }
        }
        return deduce;
    }

    private int numberOfFridayInPayPeriod(Date start, Date end) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(start);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(end);

        int fridays = 0;
        int startDay = startCal.get(Calendar.DAY_OF_YEAR);
        int endDay = endCal.get(Calendar.DAY_OF_YEAR);
        while (startDay <= endDay) {
            if (ifFriday(startCal)) {
                fridays++;
            }
            startCal.set(Calendar.DAY_OF_YEAR, ++startDay);
        }
        return fridays;
    }

    private boolean ifFriday(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_WEEK) == 6;
    }

}

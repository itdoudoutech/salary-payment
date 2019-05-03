package com.doudou.paymentClassification;

import com.doudou.util.DateUtil;
import com.doudou.util.Paycheck;
import lombok.Getter;

import java.util.*;

/**
 * 支付类别 : 按小时支付
 */
public class HourlyClassification extends PaymentClassification {

    private static final double WORK_HOUR_OF_DAY = 8.0;

    private static final double MORE_PAY_RATE = 1.5;

    /**
     * 时薪
     */
    @Getter
    private double hourlyRate;
    /**
     * 时间卡
     */
    private Map<Date, TimeCard> timeCards;

    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
        this.timeCards = new HashMap<>();
    }

    public void addTimeCard(TimeCard timeCard) {
        this.timeCards.put(timeCard.getDate(), timeCard);
    }

    public TimeCard getTimeCard(Date date) {
        return timeCards.get(date);
    }


    @Override
    public double calculatePay(Paycheck paycheck) {
        double totalPay = 0;
        for(TimeCard tc : timeCards.values()){
            if(DateUtil.isInPayPeriod(tc.getDate(), paycheck)){
                totalPay += calculatePayForTimeCard(tc);
            }
        }
        return totalPay;
    }


    private double calculatePayForTimeCard(TimeCard timeCard) {
        double hours = timeCard.getHours();
        double overTime = Math.max(0.0, hours - WORK_HOUR_OF_DAY);
        double straightTime = hours - overTime;
        return straightTime * hourlyRate + overTime * hourlyRate * MORE_PAY_RATE;
    }
}

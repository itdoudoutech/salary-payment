package com.doudou.paymentClassification;

import lombok.Getter;

import java.util.*;

/**
 * 支付类别 : 按小时支付
 */
public class HourlyClassification extends PaymentClassification {

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

    public void addTimeCard(TimeCard timeCard){
        this.timeCards.put(timeCard.getDate(), timeCard);
    }

    public TimeCard getTimeCard(Date date){
        return timeCards.get(date);
    }

    @Override
    public double calculatePay() {
        return 0;
    }
}

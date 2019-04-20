package com.doudou.paymentClassification;

import lombok.Getter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 支付类别 : 底薪 + 提成支付
 */
public class CommissionedClassification extends PaymentClassification{

    /**
     * 底薪
     */
    @Getter
    private double salary;

    /**
     * 提成比例
     */
    @Getter
    private double commissionRate;

    private Map<Date, SalesReceipt> salesReceipts;

    public CommissionedClassification(double salary, double commissionRate) {
        this.salary = salary;
        this.commissionRate = commissionRate;
        salesReceipts = new HashMap<>();
    }

    @Override
    public double calculatePay() {
        return 0;
    }

    public void addSalesReceipt(SalesReceipt salesReceipt){
        salesReceipts.put(salesReceipt.getDate(), salesReceipt);
    }

    public SalesReceipt getSalesReceipt(Date date) {
        return salesReceipts.get(date);
    }
}

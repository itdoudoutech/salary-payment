package com.doudou.paymentClassification;

/**
 * 支付类别 : [按小时支付、按月支付、底薪 + 提成支付]
 */
public abstract class PaymentClassification {

    public abstract double calculatePay();
}

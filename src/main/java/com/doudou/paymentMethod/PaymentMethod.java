package com.doudou.paymentMethod;

import com.doudou.util.Paycheck;

/**
 * 支付方式
 */
public interface PaymentMethod {

    void pay(Paycheck pc);

}

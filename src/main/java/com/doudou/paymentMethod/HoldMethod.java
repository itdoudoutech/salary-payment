package com.doudou.paymentMethod;

import com.doudou.util.Paycheck;

/**
 * 由出纳人保存
 */
public class HoldMethod implements PaymentMethod {

    @Override
    public void pay(Paycheck pc) {
        pc.setDisposition("Hold");
    }
}

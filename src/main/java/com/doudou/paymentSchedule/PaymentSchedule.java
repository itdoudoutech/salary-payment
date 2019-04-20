package com.doudou.paymentSchedule;

import java.util.Date;

/**
 * 支付时间表抽象
 */
public abstract class PaymentSchedule {

    /**
     * 是否是发薪日
     * @param date
     * @return
     */
    abstract boolean isPayDate(Date date);

}

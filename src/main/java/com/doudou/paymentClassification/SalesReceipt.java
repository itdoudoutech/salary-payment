package com.doudou.paymentClassification;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

/**
 * 销售凭条
 */
@Getter
@AllArgsConstructor
public class SalesReceipt {

    /**
     * 日期
     */
    private Date date;

    /**
     * 销售金额
     */
    private double amount;

}

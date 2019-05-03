package com.doudou.paymentClassification;

import com.doudou.util.Paycheck;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 支付类别 ：按月支付
 */
@AllArgsConstructor
@Getter
public class SalariedClassification extends PaymentClassification{

    private double salary;


    @Override
    public double calculatePay(Paycheck paycheck) {
        return salary;
    }
}

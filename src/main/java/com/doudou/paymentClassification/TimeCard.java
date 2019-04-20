package com.doudou.paymentClassification;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.Objects;

/**
 * 钟点工 时间卡
 */
@Getter
@AllArgsConstructor
public class TimeCard {

    /**
     * 日期
     */
    private Date date;

    /**
     * 工作时长
     */
    private double hours;

}

package com.doudou.affiliation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * 服务费用记录
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ServiceCharge {

    private Date date;

    private double amount;
}

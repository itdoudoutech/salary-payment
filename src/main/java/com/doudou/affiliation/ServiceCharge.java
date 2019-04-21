package com.doudou.affiliation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ServiceCharge {

    private Date date;

    private double amount;
}

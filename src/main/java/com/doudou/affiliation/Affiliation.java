package com.doudou.affiliation;

import com.doudou.util.Paycheck;

/**
 * 协会从属关系
 */
public interface Affiliation {

    double calculateDeductions(Paycheck pc);
}

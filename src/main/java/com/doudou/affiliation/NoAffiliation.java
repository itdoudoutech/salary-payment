package com.doudou.affiliation;

import com.doudou.util.Paycheck;

public class NoAffiliation implements Affiliation{

    @Override
    public double calculateDeductions(Paycheck pc) {
        return 0;
    }

}

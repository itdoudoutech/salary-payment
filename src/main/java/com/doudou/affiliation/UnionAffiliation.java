package com.doudou.affiliation;

import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class UnionAffiliation implements Affiliation{

    private double charge;

    private int memberId;

    private Map<Date, ServiceCharge> serviceCharges;

    public UnionAffiliation(int memberId, double charge) {
        this.memberId = memberId;
        this.charge = charge;
        this.serviceCharges = new HashMap<>();
    }

    public ServiceCharge getServiceCharge(Date date){
        return serviceCharges.get(date);
    }

    public void addServiceCharge(Date date, double charge){
        ServiceCharge sc = new ServiceCharge(date, charge);
        serviceCharges.put(date, sc);
    }
}

package com.doudou.transaction;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddCommissionedEmployeeTest.class,
        AddHourlyEmployeeTest.class ,
        AddSalariedEmployeeTest.class,
        AddServiceChargeTransactionTest.class,
        ChangeAddressTransactionTest.class,
        ChangeNameTransactionTest.class,
        SalesReceiptTransactionTest.class,
        TimeCardTransactionTest.class}
        )
public class AllTest {
}

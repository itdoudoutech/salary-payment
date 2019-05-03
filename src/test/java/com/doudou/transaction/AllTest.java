package com.doudou.transaction;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddCommissionedEmployeeTest.class,
        AddHourlyEmployeeTest.class,
        AddSalariedEmployeeTest.class,
        AddServiceChargeTransactionTest.class,
        ChangeAddressTransactionTest.class,
        ChangeCommissionedTransactionTest.class,
        ChangeDirectTransactionTest.class,
        ChangeHoldTransactionTest.class,
        ChangeHourlyTransactionTest.class,
        ChangeMailTransactionTest.class,
        ChangeMemberTransactionTest.class,
        ChangeNameTransactionTest.class,
        ChangeSalariedTransactionTest.class,
        ChangeUnaffiliatedTransactionTest.class,
        PayTest.class,
        SalesReceiptTransactionTest.class,
        TimeCardTransactionTest.class}
)
public class AllTest {
}

package com.doudou.transaction;

import com.doudou.database.PayrollDatabase;
import org.junit.After;
import org.junit.Before;

/**
 * 防止测试用例之间互相干扰，每个测试用例开始和结束时要清空数据库
 */
public class BaseTest {

    private static int count = 1;

    @Before
    public void before() {
        PayrollDatabase.clearAll();
    }

    @After
    public void after() {
        PayrollDatabase.clearAll();
        System.out.printf("当前测试用例个数：%s\n", count++);
    }
}

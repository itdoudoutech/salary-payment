package com.doudou.database;

import com.doudou.emp.Employee;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {

    /**
     * 雇员
     */
    private static Map<Integer, Employee> employees = new HashMap<>();

    /**
     * 雇员 ID - 协会会员 ID
     */
    private static Map<Integer, Integer> empUnions = new HashMap<>();

    public static Employee getEmployee(Integer empId){
        return employees.get(empId);
    }

    public static void addEmployee(Employee employee){
        employees.put(employee.getEmpId(), employee);
    }

    public static Employee deleteEmploy(int empId){
        Employee employee = employees.get(empId);
        employees.remove(empId);
        return employee;
    }
}

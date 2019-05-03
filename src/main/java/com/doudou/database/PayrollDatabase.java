package com.doudou.database;

import com.doudou.emp.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {

    /**
     * 雇员
     */
    private static Map<Integer, Employee> employees = new HashMap<>();

    /**
     * 协会会员 ID -- 雇员
     */
    private static Map<Integer, Employee> empUnions = new HashMap<>();

    public static void addEmployee(Employee employee) {
        employees.put(employee.getEmpId(), employee);
    }

    public static Employee getEmployee(Integer empId) {
        return employees.get(empId);
    }

    public static Employee deleteEmploy(int empId) {
        Employee employee = employees.get(empId);
        employees.remove(empId);
        return employee;
    }

    public static void addUnionMember(int memberId, Employee employee) {
        empUnions.put(memberId, employee);
    }

    public static Employee getUnionMember(Integer memberId) {
        return empUnions.get(memberId);
    }

    public static Employee deleteUnionMember(int memberId) {
        Employee employee = empUnions.get(memberId);
        empUnions.remove(memberId);
        return employee;
    }

    public static Collection<Employee> getAllEmployee(){
        return employees.values();
    }

    public static Collection<Employee> getAllUnionMember(){
        return empUnions.values();
    }

    public static void clearAll() {
        employees.clear();
        empUnions.clear();
    }
}

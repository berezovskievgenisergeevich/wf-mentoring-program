package com.epam.introdactionToJVM.lectures.stackFrame.demo;

import com.epam.introdactionToJVM.lectures.stackFrame.beans.Department;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int v = 1;
        String s = "First level";
        Department department = new Department("Mobile department");

        f1(v, s, department);
        // v Не меняется
        // s не меняется
        // department НЕ изменится
        System.out.println(v + " " + s + " " + department);
    }

    private static void f1(int v, String s, Department department) {
        System.out.println("f1 was called");

        int localV = 2;
        v = localV;

        String localS = "Underground";
        s = localS;

        Department localDepartment = new Department("Backend Developer");
        department = localDepartment;
        // меняется только на этом степе
        System.out.println(department);
        f2(department);

    }

    private static void f2(Department department) {
        System.out.println(department);
        // изменили состояние объекта
        department.setName("Тут изменения остаются");
        int[] arr = {1, 2, 3, 4, 5};
        f3(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void f3(int[] arr) {
        System.out.println("f3 was called");
        arr[2] = 22;
    }
}

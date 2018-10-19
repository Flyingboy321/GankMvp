package hhxy.com.javalib;

import hhxy.com.javalib.kotlinfile.KotlinTest1;

/**
 * Created by Administrator on 2018/10/10.
 */

public class Test {
    public static void main(String[] args) {
        System.out.println("设置什么啊德玛西亚");
        try {
            KotlinTest1 kotlinTest1 = KotlinTest1.class.newInstance();
            int varageSum = kotlinTest1.varageSum(10, 20, 30, 40);
            System.out.println("求和结果："+varageSum);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

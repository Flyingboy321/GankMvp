package hhxy.com.firstkotlinproject;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

//        int sum = KotlinTest.class.newInstance().sum(10, 20);
//        KotlinTest.class.newInstance().printProduct("a", "30");
//        System.out.println("求和：" + sum);
//        KotlinTest kotlinTest = new KotlinTest();
//        double pi = kotlinTest.getPI();
//        kotlinTest.range(0, 10);
//        kotlinTest.bianli();
//        kotlinTest.list();
//        HashMap<String, String> mapList = new HashMap<>();
//        mapList.put("one","1");
//        mapList.put("two","2");
//        mapList.put("three","3");
//        kotlinTest.mapList(mapList);
//        System.out.println("通过new创建kotlin对象调方法：" + pi);

//      通过反射来创建对象
        Kotlin4 kotlin4 = Kotlin4.class.newInstance();
        int varargSum = kotlin4.varargSum(10, 20, 30, 40);
        SystemUtils.println(varargSum);
        kotlin4.rangeTest();
        kotlin4.whenText(1);
        kotlin4.whenText(3);
        kotlin4.whenText(8);
        kotlin4.arrayTest();
//      kotlin没有new关键字，可以通过构造方法来创建对象
        kotlin4.instanceTest();
        Kotlin6 instance = Kotlin6.Companion.getInstance();
        Kotlin7<String> instance1 = Kotlin7.Companion.getInstance();


    }
}
package hhxy.com.javatestlibrary.simplefactorypattern;

/**
 * Created by Administrator on 2018/10/29.
 */

public class SimpleFactoryPattern {
    public static void main(String[] arras) {
        Product b = Factory.Manufacture("B");
        b.show();
        Product a = Factory.Manufacture("A");
        a.show();
        Product c = Factory.Manufacture("C");
        c.show();

    }
}

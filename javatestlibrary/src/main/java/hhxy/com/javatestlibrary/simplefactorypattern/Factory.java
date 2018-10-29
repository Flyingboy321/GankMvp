package hhxy.com.javatestlibrary.simplefactorypattern;

/**
 * Created by Administrator on 2018/10/29.
 * 创建商品工厂
 */

public class Factory {

    //    定义静态生产方法
    public static Product Manufacture(String ProdectName) {
        switch (ProdectName) {
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            case "C":
                return new ProductC();
            default:
                return null;

        }
    }
}

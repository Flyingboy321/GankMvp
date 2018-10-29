package hhxy.com.javatestlibrary.simplefactorypattern;

import hhxy.com.javatestlibrary.utils.SystemUtils;

/**
 * Created by Administrator on 2018/10/29.
 */

public class ProductC implements Product {
    @Override
    public void show() {
        SystemUtils.println("我是商品C");
    }
}

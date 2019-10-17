package com.yaoxiaojian.Singleton;

/**
 * @Author:yaoxiaojian
 * @Description:
 * @Date:create in 2019/10/17 13:48
 * @Modified By:
 */
public class SingletonObject1 {
    private String  name;
    private SingletonObject1() { }
    private static  final  SingletonObject1 singletonObject1 = new SingletonObject1();
    public static SingletonObject1 getInstance(){
        return singletonObject1;
    }
}

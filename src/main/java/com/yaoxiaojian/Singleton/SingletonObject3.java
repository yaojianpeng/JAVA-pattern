package com.yaoxiaojian.Singleton;

/**
 * @Author:yaoxiaojian
 * @Description:
 * @Date:create in 2019/10/17 13:48
 * @Modified By:
 */
public class SingletonObject3 {
    private SingletonObject3() {
        System.out.println("你被加载了");
    }

    /**
     * 用内部类的方式既能保证懒加载 ，又能保证不加锁。
     */
    public static class  InstanceHolder{

        private final  static SingletonObject3  singletonObject3= new SingletonObject3();
    }

    public static SingletonObject3 getInstance(){
        return InstanceHolder.singletonObject3;
    }
}

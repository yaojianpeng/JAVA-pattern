package com.yaoxiaojian.Singleton;

/**
 * @Author:yaoxiaojian
 * @Description:
 * @Date:create in 2019/10/17 13:48
 * @Modified By:
 */
public class SingletonObject2 {
    private SingletonObject2() {
    }
    private static volatile SingletonObject2 singletonObject2;

    /**
     * 不加volatile可能会有异常，如果singletonObject2有很多成员变量可能导致
     * new SingletonObject2()时候没有初始化完成就直接返回，而第二次getInstance()
     * 的时候仍然会new SingletonObject2().
     * @return
     */
    public static  SingletonObject2 getInstance(){
        if(singletonObject2==null){
            synchronized(SingletonObject2.class){
                if(singletonObject2==null){
                    singletonObject2 = new SingletonObject2();
                }
            }
        }
        return  SingletonObject2.singletonObject2;
    }
}

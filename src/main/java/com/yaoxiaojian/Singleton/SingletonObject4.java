package com.yaoxiaojian.Singleton;

/**
 * @Author:yaoxiaojian
 * @Description:
 * @Date:create in 2019/10/17 13:48
 * @Modified By:
 */
public class SingletonObject4 {
    private SingletonObject4() {
    }

    /**
     * 利用枚举类型，枚举构造方法是private的并且一个枚举的构造方法只会执行一次
     */
    private enum Singleton{
        INSTANCE;
        private final SingletonObject4 singletonObject4;
        Singleton(){
            singletonObject4 = new SingletonObject4();
        }
        public SingletonObject4 getInstance(){
            return singletonObject4;
        }
    }

    public static SingletonObject4 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

}

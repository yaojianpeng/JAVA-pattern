package com.yaoxiaojian.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:yaoxiaojian
 * @Description:原生类
 * @Date:create in 2019/10/17 15:19
 * @Modified By:
 */
public class MonkeyJavaClone implements Cloneable{
    public MonkeyJavaClone(Integer age) {
        this.age = age;
    }
    public MonkeyJavaClone() {
    }

    private Integer age;

    private List<MonkeyJavaClone> childs;

    private Banana banana;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<MonkeyJavaClone> getChilds() {
        return childs;
    }

    public void setChilds(List<MonkeyJavaClone> childs) {
        this.childs = childs;
    }

    public Banana getBanana() {
        return banana;
    }

    public void setBanana(Banana banana) {
        this.banana = banana;
    }

    /**
    *@Author:yaoxiaojian on 2019/10/17 15:26
    *@param:
    *@return:
    *@Description:原生的java克隆方法,克隆了一个新对象与原来对象不同，而克隆对象中的基本类型和引用类型均是原对象的实例
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void testJavaClone(){
        List<MonkeyJavaClone> childs = new ArrayList<>();
        MonkeyJavaClone monkeyJavaClone = new MonkeyJavaClone(5);
        childs.add(monkeyJavaClone);
        MonkeyJavaClone monkeyJavaClone1 = new MonkeyJavaClone(15);
        monkeyJavaClone1.setChilds(childs);
        monkeyJavaClone1.setBanana(new Banana());
        MonkeyJavaClone monkeyJavaCloneClone =null;
        try {
            monkeyJavaCloneClone = (MonkeyJavaClone) monkeyJavaClone1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("原来地址"+ monkeyJavaClone1 +";"+"原来基本类型"+ monkeyJavaClone1.getAge()+";"+"原来list"+ monkeyJavaClone1.getChilds()+";"+"原来引用类型"+ monkeyJavaClone1.getBanana());
        System.out.println("克隆地址"+ monkeyJavaCloneClone +";"+"克隆基本类型"+ monkeyJavaCloneClone.getAge()+";"+"克隆list"+ monkeyJavaCloneClone.getChilds()+";"+"克隆引用类型"+ monkeyJavaCloneClone.getBanana());
    }

    public static void main(String[] args) {
        MonkeyJavaClone monkeyJavaClone = new MonkeyJavaClone();
        monkeyJavaClone.testJavaClone();
    }
}

package com.yaoxiaojian.prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:yaoxiaojian
 * @Description:
 * @Date:create in 2019/10/17 15:36
 * @Modified By:
 */
public class MonkeyDeepClone implements Cloneable,Serializable{
    public MonkeyDeepClone(Integer age) {
        this.age = age;
    }
    public MonkeyDeepClone() {
    }

    private Integer age;

    private List<MonkeyDeepClone> childs;

    private Banana banana;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<MonkeyDeepClone> getChilds() {
        return childs;
    }

    public void setChilds(List<MonkeyDeepClone> childs) {
        this.childs = childs;
    }

    public Banana getBanana() {
        return banana;
    }

    public void setBanana(Banana banana) {
        this.banana = banana;
    }

    /**
    *@Author:yaoxiaojian on 2019/10/17 15:37
    *@param:
    *@return:
    *@Description:深度克隆,会把对象中的所有引用类型都克隆一份，表明克隆出来的对象和原来对象完全不相等
     */
    public  Object deepClone() throws IOException, ClassNotFoundException{
        //将对象写到流里
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //从流里读回来
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public void testDeepClone(){
        {
            List<MonkeyDeepClone> childs = new ArrayList<>();
            MonkeyDeepClone monkeyDeepClone = new MonkeyDeepClone(5);
            childs.add(monkeyDeepClone);
            MonkeyDeepClone monkeyDeepClone1 = new MonkeyDeepClone(15);
            monkeyDeepClone1.setChilds(childs);
            monkeyDeepClone1.setBanana(new Banana());
            MonkeyDeepClone testMonkeyDeepClone =null;
            try {
                testMonkeyDeepClone = (MonkeyDeepClone) monkeyDeepClone1.deepClone();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("原来地址"+ monkeyDeepClone1 +";"+"原来基本类型"+ monkeyDeepClone1.getAge()+";"+"原来list"+ monkeyDeepClone1.getChilds()+";"+"原来引用类型"+ monkeyDeepClone1.getBanana());
            System.out.println("克隆地址"+ testMonkeyDeepClone +";"+"克隆基本类型"+ testMonkeyDeepClone.getAge()+";"+"克隆list"+ testMonkeyDeepClone.getChilds()+";"+"克隆引用类型"+ testMonkeyDeepClone.getBanana());
        }
    }

    public static void main(String[] args) {
        MonkeyDeepClone monkeyDeepClone = new MonkeyDeepClone();
        monkeyDeepClone.testDeepClone();
    }

}

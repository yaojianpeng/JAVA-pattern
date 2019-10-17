package test;

import com.yaoxiaojian.Singleton.SingletonObject4;

import java.util.stream.IntStream;


public class SingletonTest {
    public static void main(String[] args) {
        IntStream.rangeClosed(1,100).forEach(i->new Thread(i+""){
            @Override
            public void run() {
                System.out.println(SingletonObject4.getInstance());
            }
        }.start());
    }
    
    
    
  /**
  *@Author:yaoxiaojian on 2019/10/17 12:03
  *@param:
  *@return:
  *@Description:
   */
    public String getaa(int a,String b,SingletonObject4 singletonObject4){
        return "aaa";
    }
}

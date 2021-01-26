package com.phoenixhell.boot.bean;


import java.util.Arrays;
import java.util.List;

/**
 * @author phoenixhell
 * @create 2021/1/12 0012-上午 7:52
 */

public class TestSingleton {

    public void test(){
//        System.out.println(Person.getInstance());
//        System.out.println(Person.getInstance());
        List<String> list = Arrays.asList("99999123","2232","2232","2edsa");
        list.sort((o1, o2) -> o1.compareTo(o2));
        list.add("sadsad");
        System.out.println(list);
    }
}

class Person{
    private Person() {
    }

    private static volatile Person person=null;

    public static Person getInstance() {
        if(person==null){
            synchronized(Person.class){
                if(person==null){
                    System.out.println("new person");
                    person= new Person();
                }
            }
        }
        return person;
    }
}
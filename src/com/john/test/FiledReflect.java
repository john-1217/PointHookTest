package com.john.test;

import java.lang.reflect.Field;

class Point{  
    private int x;  
    public int y;  
    public Point(int x, int y) {  
        super();  
        this.x = x;  
        this.y = y;  
        }  
}  

public class FiledReflect {  
    public static void main(String[] args) throws Exception {  

        Point p1=new Point(5, 39);  
        Point p2=new Point(3, 9);  
        //p1.getClass()是拿到p1对应的类，getField("y")是拿到这个类对应的某个field 
        Field fieldY = p2.getClass().getField("y"); 
        //为了拿到field的具体值，需要某个具体的instance                                            
        int y = (int) fieldY.get(p2);  
        System.out.println(y);  

        //对私有成员变量，可以进行暴力反射  
        Field fieldX = p2.getClass().getDeclaredField("x");  
        fieldX.setAccessible(true);//暴力反射  
        int x = (int) fieldX.get(p2);//取对应p1对象的x字段的值  
        System.out.println(x);                
        }  
}  

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
        //p1.getClass()���õ�p1��Ӧ���࣬getField("y")���õ�������Ӧ��ĳ��field 
        Field fieldY = p2.getClass().getField("y"); 
        //Ϊ���õ�field�ľ���ֵ����Ҫĳ�������instance                                            
        int y = (int) fieldY.get(p2);  
        System.out.println(y);  

        //��˽�г�Ա���������Խ��б�������  
        Field fieldX = p2.getClass().getDeclaredField("x");  
        fieldX.setAccessible(true);//��������  
        int x = (int) fieldX.get(p2);//ȡ��Ӧp1�����x�ֶε�ֵ  
        System.out.println(x);                
        }  
}  

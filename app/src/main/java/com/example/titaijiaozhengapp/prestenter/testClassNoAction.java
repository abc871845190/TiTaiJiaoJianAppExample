package com.example.titaijiaozhengapp.prestenter;

import java.util.Scanner;

public class testClassNoAction {

    public static void main(String[] args){
        test[] tests = new test[10];

        for (int i = 0;i<tests.length;i++){
            System.out.println("写第"+i+"个数值");
            tests[i] = new test(new Scanner(System.in).nextInt());
        }

        for (int i = 0;i<tests.length;i++){
            System.out.println("第"+i+"个test数值为"+tests[i].getNumber());
        }
    }
}
class test{
    private int number;

    public test(int number){
        this.number = number;
    }
    public int getNumber(){
        return number;
    }
}
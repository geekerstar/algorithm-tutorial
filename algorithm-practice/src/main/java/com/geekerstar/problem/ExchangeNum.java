package com.geekerstar.problem;

public class ExchangeNum {
    //不使用第三个数交换两个数的值
    private void swap1() {
        int a=10,b=12;

        a=b-a; //a=2;b=12
        b=b-a; //a=2;b=10
        a=b+a; //a=12;b=10
    }
    private void swap2() {
        int a=10,b=12;

        a=a+b;//a=22,b=12
        b=a-b;//a=22,b=10
        a=a-b;//a=12,b=10
    }
}

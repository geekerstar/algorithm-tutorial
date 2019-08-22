package com.geekerstar.s1002;

import java.util.Stack;

/**
 * @author geekerstar
 * date: 2019/2/27 19:14
 * description:
 *
 * 题目：由两个栈组成的队列
 *
 * 编写一个类，用两个栈实现队列，支持队列的基本操作(add,poll,peek)。
 *
 */
public class TwoStacksImplementQueue {
    public static class TwoStacksQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue(){
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void add(int pushInt){
            stackPush.push(pushInt);
        }

        public int poll(){
            if(stackPop.empty() && stackPush.empty()){
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()){
                while (!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek(){
            if(stackPop.empty() && stackPush.empty()){
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()){
                while (!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }

        public static void main(String[] args) {
            TwoStacksQueue test = new TwoStacksQueue();
            test.add(1);
            test.add(2);
            test.add(3);
            System.out.println(test.peek());
            System.out.println(test.poll());
            System.out.println(test.peek());
            System.out.println(test.poll());
            System.out.println(test.peek());
            System.out.println(test.poll());
        }
    }

}

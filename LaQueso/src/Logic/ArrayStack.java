/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Logic.ExceptionStack;
import Logic.Stack;

/**
 *
 * @author vanes
 */
public class ArrayStack implements Stack{
    
    private Object stack[];
    private int top;
    
    public ArrayStack(int n){
        if(n<=0){
            System.exit(0);
        }
        stack = new Object[n];
        top=-1;
    }

    @Override
    public int getsize() {
      return top+1;
    }

    @Override
    public boolean isEmpty() {
        return top ==-1;
    }

    @Override
    public void cancel() {
        top =-1;
        System.out.println("The stack was cancel");
    }

    @Override
    public Object top() {
        return stack[top];
    }

    @Override
    public void push(Object element) {
        if(getsize()==this.stack.length){
             throw new ExceptionStack("Vacio");      
        }else{
            stack[++top] = element;
            
        }
    }
    

    @Override
    public Object pop() {
        
        return stack[top--];
    }

    @Override
    public String tooString() {
        String message ="";
        for (int i = this.stack.length-1; i >= 0; i--) {
            message = message+this.stack[i];
        }
        return message;
    }

    @Override
    public int getsizeByList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

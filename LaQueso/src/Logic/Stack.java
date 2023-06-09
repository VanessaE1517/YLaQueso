/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Logic;

/**
 *
 * @author vanes
 */
public interface Stack {
    
    public int getsize();
    public int getsizeByList();
    public boolean isEmpty();
    public void cancel();
    public Object top();
    public void push(Object element);
    public Object pop();
    public String tooString();
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Logic;

/**
 *
 * @author Yoselin Porras Reyes
 */
public interface Queue {
    
    public int getSize();
    
    public boolean isEmpty();
    
    public void cancel();
    
    public void insert(Object element);//encolar
    
    public Object delete();//desencolar
    
    public Object firstElement();
            
}

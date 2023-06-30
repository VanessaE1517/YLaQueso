/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Logic;

/**
 *
 * @author vanes
 */
public interface ListC {
    
    public void cancel();
    
    public int getSize();
    
    public boolean isEmpty();
    
    public boolean exists(Object element);
    
    public void addHead(Object element);
    
    public void addEnd(Object element);
    
    public Object getByPosition(int pos);
    
    public void deleteByElement(Object element);
    
    public Object firstInList();
    
    public Object lastInFirst();
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Logic;

/**
 *
 * @author Vane
 */
public interface Graph {
    
    public boolean isEmpty();
    
    public int getSize();
    
    public void addVertex(Object element);
    
    public void addEdge(Object v1, Object v2);
    
    public void addWeight(Object v1, Object v2, int weigth); 
    
    public boolean existVertex(Object element);
    
    public boolean existEdge(Object v1, Object v2);
    
    //anchura breadth first search
    public String bfs();
    
    //profundidad deepth first search
    public String dfs(); 
    
    public String mayores(Object element);
    
    public String menores(Object element);
    
    public boolean esPar(Object element);
    
    public int sumaPesos();
    
    public int sumaVertices();
}

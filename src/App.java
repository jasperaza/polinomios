/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Moon
 */
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import vistas.Inicio;

public class App {
    public static void main(String[] args) {
        PolinomioList p1=new PolinomioList(); 
		p1.insertar(new Nodo(2,0));
		p1.insertar(new Nodo(-1,1)); 
		p1.insertar(new Nodo(1,2));
		System.out.println("p1= "+p1.imprimir()); 
                PolinomioList p2=new PolinomioList();
		p2.insertar(new Nodo(-1,0));
		p2.insertar(new Nodo(1,1));
		p2.insertar(new Nodo(-1,2)); 
		p2.insertar(new Nodo(10,4)); 
		System.out.println("p2="+p2.imprimir()); 
                PolinomioList resultList1= p1.sumar( p2); 
		System.out.println("p1+p2="+resultList1.imprimir());
               PolinomioList resultList2= p1.multiplicar( p2);
                 System.out.println("p1*p2="+resultList2.imprimir());
                 PolinomioList resultList3= p1.escalar(3);
                 System.out.println("3P1="+resultList3.imprimir());
                 new Inicio().setVisible(true);
                 
    }
    
}

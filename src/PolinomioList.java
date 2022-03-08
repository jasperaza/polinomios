/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Moon
 */
public class PolinomioList {

    private Nodo primero;
    private Nodo ultimo;
    private int grado;

    public PolinomioList() {
        primero=ultimo=null;
        grado=0;
    }

    public boolean esVacio() {
        return primero == null&&ultimo==null;
    }

    public void insertar(Nodo nodo) {
        if(esVacio()){
            primero=ultimo=nodo;
        }else{
            ultimo.setSiguiente(nodo);
            nodo.setAnterior(ultimo);
            ultimo=nodo;
        }
        
        
    }

    public String imprimir() {
        String formato="";
        
        for(Nodo i=primero;i!=null;i=i.getSiguiente()){
           if(i==primero){
               formato=i.toString();
           }else{
               if(i.getCoeficiente()<0){
                   formato+=i.toString();
               }else{
                   formato+="+"+i.toString();
               }
           }
        }
        
        return formato;
    }

 
    public  PolinomioList sumar(PolinomioList b) {
        Nodo anext = this.primero;
        Nodo bnext = b.primero;
        PolinomioList resultado = new PolinomioList();
        while (anext != null && bnext != null) {
            int aindex = anext.getExponente();
            int bindex = bnext.getExponente();
            int acoef = anext.getCoeficiente();
            int bcoef = bnext.getCoeficiente();
            if (aindex == bindex) {
                if (acoef + bcoef != 0) {
                    Nodo node = new Nodo(acoef + bcoef, aindex);
                    resultado.insertar(node);
                }
                anext = anext.getSiguiente();
                bnext = bnext.getSiguiente();
            } else if (aindex < bindex) {
                Nodo node = new Nodo(anext.getCoeficiente(), anext.getExponente());
                resultado.insertar(node);
                anext = anext.getSiguiente();
            } else {
                Nodo node = new Nodo(bnext.getCoeficiente(), bnext.getExponente());
                resultado.insertar(node);
                bnext = bnext.getSiguiente();
            }
        }
        while (anext != null) {
            Nodo node = new Nodo(anext.getCoeficiente(), bnext.getExponente());
            resultado.insertar(node);
            anext = anext.getSiguiente();;
        }
        // p polinomio ha completado estadísticas
        while (bnext != null) {
            Nodo node = new Nodo(bnext.getCoeficiente(), bnext.getExponente());
            resultado.insertar(node);
            bnext = bnext.getSiguiente();;
        }
        
        return resultado;
    }

    public  PolinomioList multiplicar( PolinomioList q) {
        Nodo pnext = this.primero;
        Nodo qnext = q.primero;
        PolinomioList resultado = new PolinomioList();
        int coef;
        int index;
        while (qnext != null) {
            while (pnext != null) {
                coef = pnext.getCoeficiente() * qnext.getCoeficiente();
                index = pnext.getExponente() + qnext.getExponente();
                resultado.insertar(new Nodo(coef, index));
                pnext = pnext.getSiguiente();
            }
            qnext = qnext.getSiguiente();
            pnext = this.primero;
        }
        resultado.imprimir();
        // Fusión de elementos similares 
        /*
        Nodo current = resultado.primero;
        Nodo preCurrent = resultado.primero.getAnterior();

        while (current != null) {
            Nodo nextNode = current.getSiguiente(); // El siguiente nodo del nodo actual en la lista de resultados
            while (nextNode != null) {
                if (nextNode.getExponente() == current.getExponente()) {// Determine si el índice es el mismo
                    current.setCoeficiente(current.getCoeficiente() + nextNode.getCoeficiente()); // Establecer el nuevo índice del coeficiente correspondiente	

                }

                nextNode = nextNode.getSiguiente();// Pasar el valor del siguiente nodo,
            }
            // Eliminar elementos con un coeficiente de 0
            if (current.getCoeficiente() == 0) {
                preCurrent.setSiguiente(current.getSiguiente());
            }
            
            current = current.getSiguiente();

        }
            */
        return resultado;
    }
    
    public static PolinomioList restar(PolinomioList a, PolinomioList b){
        Nodo anext=b.primero;
        PolinomioList negativo=new PolinomioList();
        while(anext!=null){
            int coef=anext.getCoeficiente()*-1;
            negativo.insertar(new Nodo(coef,anext.getExponente()));
            anext=anext.getSiguiente();
        }
        
        
        return a.sumar(negativo);
    }
    public PolinomioList escalar(int esca){
        Nodo anext=this.primero;
        PolinomioList result=new PolinomioList();
        
       while(anext!=null){
            int coef=anext.getCoeficiente()*esca;
            result.insertar(new Nodo(coef,anext.getExponente()));
            anext=anext.getSiguiente();
        }
        
        return result;
    }
    

}

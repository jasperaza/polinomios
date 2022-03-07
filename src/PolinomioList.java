/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Moon
 */
public class PolinomioList {

    MoNodo inicio;
    MoNodo actual;

    public PolinomioList() {
        inicio = new MoNodo();
        actual = inicio;
        inicio.siguiente = null;
    }

    public boolean esVacio() {
        return inicio.siguiente == null;
    }

    public void insertar(MoNodo nodo) {
        actual.siguiente = nodo;
        actual = nodo;
    }

    public String imprimir() {
        StringBuilder pl = new StringBuilder();
        MoNodo nodo = inicio.siguiente;
        while (nodo != null) {
            switch (nodo.getExponente()) {
                case 0 -> {
                    pl.append(nodo.getCoeficiente());
                    pl.append(" + ");
                    break;
                }
                case 1 -> {
                    pl.append(nodo.getCoeficiente()).append("x");
                    pl.append(" + ");
                    break;
                }
                default -> {
                    pl.append(nodo.getCoeficiente()).append("x^").append(nodo.getExponente());
                    pl.append(" + ");
                    break;
                }
            }

            nodo = nodo.siguiente;
        }
        return pl.substring(0, pl.length() - 2);
    }

 
    public static PolinomioList sumar(PolinomioList a, PolinomioList b) {
        MoNodo anext = a.inicio.siguiente;
        MoNodo bnext = b.inicio.siguiente;
        PolinomioList resultado = new PolinomioList();
        while (anext != null && bnext != null) {
            int aindex = anext.getExponente();
            int bindex = bnext.getExponente();
            int acoef = anext.getCoeficiente();
            int bcoef = bnext.getCoeficiente();
            if (aindex == bindex) {
                if (acoef + bcoef != 0) {
                    MoNodo node = new MoNodo(acoef + bcoef, aindex);
                    resultado.insertar(node);
                }
                anext = anext.siguiente;
                bnext = bnext.siguiente;
            } else if (aindex < bindex) {
                MoNodo node = new MoNodo(anext.getCoeficiente(), anext.getExponente());
                resultado.insertar(node);
                anext = anext.siguiente;
            } else {
                MoNodo node = new MoNodo(bnext.getCoeficiente(), bnext.getExponente());
                resultado.insertar(node);
                bnext = bnext.siguiente;
            }
        }
        while (anext != null) {
            MoNodo node = new MoNodo(anext.getCoeficiente(), bnext.getExponente());
            resultado.insertar(node);
            anext = anext.siguiente;
        }
        // p polinomio ha completado estadísticas
        while (bnext != null) {
            MoNodo node = new MoNodo(bnext.getCoeficiente(), bnext.getExponente());
            resultado.insertar(node);
            bnext = bnext.siguiente;
        }
        // q polinomio tiene estadísticas completas
        return resultado;
    }

    public  PolinomioList multiplicar( PolinomioList q) {
        MoNodo pnext = this.inicio.siguiente;
        MoNodo qnext = q.inicio.siguiente;
        PolinomioList resultado = new PolinomioList();
        int coef;
        int index;
        while (qnext != null) {
            while (pnext != null) {
                coef = pnext.getCoeficiente() * qnext.getCoeficiente();
                index = pnext.getExponente() + qnext.getExponente();
                resultado.insertar(new MoNodo(coef, index));
                pnext = pnext.siguiente;
            }
            qnext = qnext.siguiente;
            pnext = this.inicio.siguiente;
        }
        // Fusión de elementos similares 
        MoNodo current = resultado.inicio.siguiente;
        MoNodo preCurrent = resultado.inicio;

        while (current != null) {
            MoNodo nextNode = current.siguiente; // El siguiente nodo del nodo actual en la lista de resultados
            while (nextNode != null) {
                if (nextNode.getExponente() == current.getExponente()) {// Determine si el índice es el mismo
                    current.setCoeficiente(current.getCoeficiente() + nextNode.getCoeficiente()); // Establecer el nuevo índice del coeficiente correspondiente	

                }

                nextNode = nextNode.siguiente;// Pasar el valor del siguiente nodo,
            }
            // Eliminar elementos con un coeficiente de 0
            if (current.getCoeficiente() == 0) {
                preCurrent.siguiente = current.siguiente;
            }
            
            current = current.siguiente;

        }

        return resultado;
    }
    
    public static PolinomioList restar(PolinomioList a, PolinomioList b){
        MoNodo anext=b.inicio.siguiente;
        PolinomioList negativo=new PolinomioList();
        while(anext!=null){
            int coef=anext.getCoeficiente()*-1;
            negativo.insertar(new MoNodo(coef,anext.getExponente()));
            anext=anext.siguiente;
        }
        sumar(a,negativo);
        
        return sumar(a,negativo);
    }
    public PolinomioList escalar(int esca){
        MoNodo anext=this.inicio.siguiente;
        PolinomioList result=new PolinomioList();
        
       while(anext!=null){
            int coef=anext.getCoeficiente()*esca;
            result.insertar(new MoNodo(coef,anext.getExponente()));
            anext=anext.siguiente;
        }
        
        return result;
    }

}

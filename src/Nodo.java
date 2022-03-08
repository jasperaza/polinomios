/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Moon
 */
public class Nodo {
    private int coeficiente;
    private int exponente;
    private Nodo siguiente;
    private Nodo anterior;
    
    public Nodo(int coef, int exp){
        this.coeficiente=coef;
        this.exponente=exp;
        siguiente=null;
        anterior=null;
    }

    public int getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(int coeficiente) {
        this.coeficiente = coeficiente;
    }

    public int getExponente() {
        return exponente;
    }

    public void setExponente(int exponente) {
        this.exponente = exponente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        String formato="";
        if(exponente==0){
            formato+=coeficiente;
        }else if(exponente==1){
            if(coeficiente==1){
                formato="x";
            }else if(coeficiente==-1){
                formato="-x";
            }else{
                formato=coeficiente+"x";
            }
           
        }else{
            if(coeficiente==1){
                formato="x^"+exponente;
            }else if(coeficiente==-1){
                formato="-x"+exponente;
            }else{
                formato=coeficiente+"x^"+exponente;
            }
            
        }
        return formato;
    }
    
    
}

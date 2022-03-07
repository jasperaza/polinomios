/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Moon
 */
public class MoNodo {
    private int coeficiente;
    private int exponente;
    public MoNodo siguiente;
    public MoNodo(){
        this(0, 0);
    }
    public MoNodo(int coef, int exp){
        this.coeficiente=coef;
        this.exponente=exp;
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
    
    
}

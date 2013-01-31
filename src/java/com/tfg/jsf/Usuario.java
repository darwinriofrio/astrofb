/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.jsf;

/**
 *
 * @author darwin
 */
public class Usuario {
    public Usuario() {
    }
    private String nombre = "DefaultName";


    public String getNombre() {
       return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
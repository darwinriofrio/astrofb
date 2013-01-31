/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.jsf;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author darwin
 */
public class Observatorio {
    public Observatorio (){
    }
    
    private String titulo = "Clasificador";
    private String descripcion ="La clasificación e identificacion de ciertos "
            + "objetos en imagenes puede resultar una tarea complicada, sobre "
            + "todo si la realiza una sola persona. Ahora con la ayuda de la "
            + "ciencia ciudadana esta tarea es más fácil. Y esto es gracias "
            + "tu colaboración";
    private String pregunta ="¿Que observa en la imagen?";
    private String respuesta1 ="Una estrella rodeada de muchas constelaciones";
    private String respuesta2 ="Una galaxia en el centro de la imagen";
    private String respuesta3 ="Un satelite";
    private String respuesta4 ="Una nave espacial";
    private List<String> images;
    private String nombre;
    
    private String tituloE2 = "Identificar Objetos";
    private String descripcionE2 ="La clasificación e identificacion de ciertos "
            + "objetos en imagenes puede resultar una tarea complicada, sobre "
            + "todo si la realiza una sola persona. Ahora con la ayuda de la "
            + "ciencia ciudadana esta tarea es más fácil. Y esto es gracias "
            + "tu colaboración";
    private List<String> imagesE2;
    
    
    /* ****************************************************************** */
    /* ********************  Geters y Seters  Exp1 ********************** */
    
        /* Nombre */
    public String getNombre() {
       return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /* Titulo */
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    /* Descripcion */
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
        /* Pregunta */
    public String getPregunta() {
        return pregunta;
    }
    
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    

    /* Respuesta1 */
    public String getRespuesta1() {
        return respuesta1;
    }
    
    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }
    
    
    /* Respuesta2 */
    public String getRespuesta2() {
        return respuesta2;
    }
    
    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }
    
    
    /* Respuesta3 */
    public String getRespuesta3() {
        return respuesta3;
    }
    
    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }
    
    
    /* Respuesta4 */
    public String getRespuesta4() {
        return respuesta4;
    }
    
    public void setRespuesta4(String respuesta4) {
        this.respuesta4 = respuesta4;
    }
    
   
    /* ****************************************************************** */
    /* ********************  Geters y Seters  Exp2 ********************** */
    
    
    /* Titulo */
    public String getTituloE2() {
        return tituloE2;
    }
    
    public void setTituloE2(String tituloE2) {
        this.tituloE2 = tituloE2;
    }
    
    
    /* Descripcion */
    public String getDescripcionE2() {
        return descripcionE2;
    }
    
    public void setDescripcionE2(String descripcionE2) {
        this.descripcionE2 = descripcionE2;
    }
    
    
    
    
    
    
    
    
    
    public void refrescarExp1 (Integer i){
        switch(i){
            case 0:
                setPregunta("¿Que observa en la imagen?");
                setRespuesta1("Una estrella rodeada de muchas constelaciones");
                setRespuesta2("Una galaxia en el centro de la imagen");
                setRespuesta3("Un satelite");
                setRespuesta4("Una nave espacial");
                break;
            case 1:
                setPregunta("En la imagen hay un objeto, si dividimos la imagen "
                        + "en cuantro cuadrantes, ¿En que cuadrante se encuentra?");
                setRespuesta1("En el superior izquierdo");
                setRespuesta2("En el superior derecho");
                setRespuesta3("En el inferior izquierdo");
                setRespuesta4("En el inferior derecho");
                break;
            case 2:
                setPregunta("¿Que color es el más representativo en la imagen?");
                setRespuesta1("Negro");
                setRespuesta2("verde");
                setRespuesta3("Azul");
                setRespuesta4("Blanco");
                break;
            case 3:
                setPregunta("¿Cuatos objetos brillantes puedes observar en la imagen?");
                setRespuesta1("Ninguno");
                setRespuesta2("Incontables");
                setRespuesta3("Menos de 10");
                setRespuesta4("Mas de 10");
                break;
                
        }
    
    }
    
    
    
    public void initImages() {
        images = new ArrayList<String>();  
  
        for(int i=1;i<=4;i++) {  
            images.add("/images/exp1/img" + i + ".jpg");  
        }  
    }  
    
    
    public void initImagesE2() {
        imagesE2 = new ArrayList<String>();  
  
        for(int i=1;i<=4;i++) {  
            imagesE2.add("/images/exp2/img" + i + ".jpg");  
        }  
    }  
    
    
    
    
    
    public String nextImagen (Integer i){
        return images.get(i);
    }
    
    public String nextImagenE2 (Integer i){
        return imagesE2.get(i);
    }
    
}

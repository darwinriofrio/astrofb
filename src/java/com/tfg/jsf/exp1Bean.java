/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.jsf;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
/**
 *
 * @author darwin
 */

@ManagedBean
@RequestScoped
public class exp1Bean implements Serializable{

    /**
     * Creates a new instance of exp1Bean
     */
    public exp1Bean() {
    }
    
    private String nombre;
    private String titulo;
    private String descripcion;
    private String pregunta;
    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private String respuesta4;
    private String image;
    private Integer numImg;
    public static Integer num;
    public static String name;
    
    
    private Observatorio observatorio = new Observatorio();
    //private Usuario usuario = new Usuario();
    
    
    
    /* ********************************************************************* */
    /* *****************   Funciones con procesamiento ********************* */
    
    /* Nombre */
    public String getNombre() {
       return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    public String getName() {
       return nombre;
    }
    
    public void setName(String name) {
        this.name = name;
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
    
    
    /* Imagen */
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
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
    
    public Integer getNumImg () {
        return numImg;
    }
    
    public void setNumImg (Integer numImg) {
        this.numImg = numImg;
    }
    
    
    /* ********************************************************************* */
    /* *****************   Funciones con procesamiento ********************* */
    public void iniciarE1 (){
        this.num = 0;
        observatorio.initImages();
        setImage(observatorio.nextImagen(this.num));
        this.num++;
        
        setTitulo(observatorio.getTitulo());
        setDescripcion(observatorio.getDescripcion());
        setPregunta(observatorio.getPregunta());
        setRespuesta1(observatorio.getRespuesta1());
        setRespuesta2(observatorio.getRespuesta2());
        setRespuesta3(observatorio.getRespuesta3());
        setRespuesta4(observatorio.getRespuesta4());
        //setNombre(usuario.getNombre());
    }
    
    public void procesarR1(){
        observatorio.initImages();
        setImage(observatorio.nextImagen(this.num));
        observatorio.refrescarExp1(this.num);
        if (this.num < 3){
            this.num++;
        }
        else{
            this.num = 0;
        }
        setPregunta(observatorio.getPregunta());
        setRespuesta1(observatorio.getRespuesta1());
        setRespuesta2(observatorio.getRespuesta2());
        setRespuesta3(observatorio.getRespuesta3());
        setRespuesta4(observatorio.getRespuesta4());
    }
    public void procesarR2(){
        setImage(observatorio.nextImagen(getNumImg()));
    }
    public void procesarR3(){
        setImage(observatorio.nextImagen(getNumImg()));
    }
    public void procesarR4(){
        setImage(observatorio.nextImagen(getNumImg()));
    }

    
    
    
    
    
    
    
    public void destroyWorld(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "System Error",  "Please try again later.");  
          
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }
    
    
}

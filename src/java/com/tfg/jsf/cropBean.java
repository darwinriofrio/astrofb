/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.jsf;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.CroppedImage;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author darwin
 */
@ManagedBean(name = "cropBean")
@ViewScoped
public class cropBean implements Serializable {

    /**
     * Creates a new instance of cropBean
     */
    public cropBean() {
    }
    
    private StreamedContent imagemEnviada = new DefaultStreamedContent();
    private CroppedImage croppedImage;
    //private String imagenSalida;
    //private Observatorio observatorio = new Observatorio();

    /* getters e setters */
    

    public StreamedContent getImagemEnviada() {
        return this.imagemEnviada;
    }

    public void setImagemEnviada(StreamedContent imagemEnviada) {
        this.imagemEnviada = imagemEnviada;
    }

    public CroppedImage getCroppedImage() {
        return croppedImage;
    }

    public void setCroppedImage(CroppedImage croppedImage) {
        this.croppedImage = croppedImage;
    }



    public void crop() {
        setImagemEnviada(new DefaultStreamedContent(new ByteArrayInputStream(croppedImage.getBytes())));
    }
    
    
    
    
}

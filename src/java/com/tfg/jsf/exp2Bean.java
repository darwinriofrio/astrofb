/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.jsf;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import org.primefaces.model.CroppedImage;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author darwin
 */
@ManagedBean(name = "exp2Bean")
@RequestScoped
public class exp2Bean implements Serializable {

    public exp2Bean() {
    }
    
    @ManagedProperty("#{cropBean}")
    private cropBean cropBean;
    
    private String titulo;
    private String descripcion;
    private String image = "/images/exp2/img1.jpg";
    private StreamedContent imagenRecortada;
    private String newImageName;
    private CroppedImage croppedImage;
    public static Integer numE2;
    
    
    private Observatorio observatorio = new Observatorio();

    /* getters y setters */
    
    
    public cropBean getCropBean() {
        return cropBean;
    }
 
    public void setCropBean(cropBean cropBean) {
        this.cropBean = cropBean;
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
    
    
    public StreamedContent getImagenRecortada() {
        return this.imagenRecortada;
    }
    public void setImagenRecortada(StreamedContent imagenRecortada) {
        this.imagenRecortada = imagenRecortada;
    }

    public CroppedImage getCroppedImage() {
        return this.croppedImage;
    }
    public void setCroppedImage(CroppedImage croppedImage) {
        this.croppedImage = croppedImage;
    }

    public String getNewImageName() {
        return newImageName;
    }

    public void setNewImageName(String newImageName) {
        this.newImageName = newImageName;
    }


    /* ********************************************************************* */
    /* *****************   Funciones con procesamiento ********************* */

    public void iniciarE2() {
        this.numE2 = 0;
        observatorio.initImagesE2();
        setImage(observatorio.nextImagenE2(this.numE2));
        this.numE2++;

        setTitulo(observatorio.getTituloE2());
        setDescripcion(observatorio.getDescripcionE2());
    }

    public void nuevoExp() {
        observatorio.initImagesE2();
        setImage(observatorio.nextImagenE2(this.numE2));

        if (this.numE2 < 3) {
            this.numE2++;
        } else {
            this.numE2 = 0;
        }
    }
    
    public String crop() {

        setNewImageName(getRandomImageName());
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String fileName = servletContext.getRealPath("") + File.separator + "images" + File.separator + "exp2" + File.separator + getNewImageName() + ".jpg";

        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(fileName));
            imageOutput.write(croppedImage.getBytes(), 0,
                    croppedImage.getBytes().length);
            imageOutput.close();
        } catch (FileNotFoundException e) {
            //log errorç
        } catch (IOException e) {
            //log error
        }
        return null;
    }
    
    
    
    public void cortar() {
        cropBean.setCroppedImage(croppedImage);
        cropBean.crop();
        setImagenRecortada(cropBean.getImagemEnviada());
        
    }

    private String getRandomImageName() {
        int i = (int) (Math.random() * 100000);

        return String.valueOf(i);
    }

}
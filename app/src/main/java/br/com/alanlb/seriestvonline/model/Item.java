package br.com.alanlb.seriestvonline.model;


public class Item {
    private String titulo;
    private String imagemURL;

    public Item(String titulo, String imagemURL){
        this.setTitulo(titulo);
        this.setImagemURL(imagemURL);
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagemURL() {
        return imagemURL;
    }

    public void setImagemURL(String imagemURL) {
        this.imagemURL = imagemURL;
    }
}

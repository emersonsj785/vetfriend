package dto;

public class Carrito {
    
    private int item;
    private int cod;
    private String nom;
    private double pre;
    private int can;
    private double subtotal;
    private String imagen;


    public Carrito() {
    }

    public Carrito(int item, int cod, String nom, double pre, int can, 
            double subtotal) {
        this.item = item;
        this.cod = cod;
        this.nom = nom;
        this.pre = pre;
        this.can = can;
        this.subtotal = subtotal;
        this.imagen= imagen;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPre() {
        return pre;
    }

    public void setPre(double pre) {
        this.pre = pre;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}

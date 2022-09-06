package ppe2022_pharmacie;

public class Medicament {
    //Attribut
    private int id;
    private String libelle;
    private int qtteStock;
    private int seuil;
    private String categorie;
    
    //Constructeur
    public Medicament(int pId, String pLibelle, int pQtteStock, int pSeuil, String pCategorie){
        id = pId;
        libelle = pLibelle;
        qtteStock = pQtteStock;
        seuil = pSeuil;
        categorie = pCategorie;
    }
    
    //Accesseur

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public int getQtteStock() {
        return qtteStock;
    }
    
    public int getSeuil() {
        return seuil;
    }
    
    public String getCategorie() {
        return categorie;
    }
    
    //Mutateur

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setQtteStock(int qtteStock) {
        this.qtteStock = qtteStock;
    }
    
    public void setSeuil(int seuil) {
        this.seuil = seuil;
    }
    
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    
    //Méthode

    @Override
    public String toString() {
        return "| id: "+id+" | Libelle: "+libelle+" | Quantitée en Stock: "+qtteStock+" | Seuil: "+seuil+" | Categorie: "+categorie+"\n";
    }
    
}

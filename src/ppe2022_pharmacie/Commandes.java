package ppe2022_pharmacie;

public class Commandes {
    //Attribut
    private int idc;
    private String fournisseur;
    private String medicament;
    private int qtte;
    
    //Constructeur
    public Commandes(int pIdc, String pFournisseur, String pMedicament, int pQtte){
        idc = pIdc;
        fournisseur = pFournisseur;
        medicament = pMedicament;
        qtte = pQtte;
    }
    
    //Accesseur et mutateurs

    public int getIdc() {
        return idc;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public String getMedicament() {
        return medicament;
    }

    public int getQtte() {
        return qtte;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public void setQtte(int qtte) {
        this.qtte = qtte;
    }
    
    @Override
    public String toString() {
        return "| id: "+idc+" | Medicament: "+medicament+" | Quantitée: "+qtte+" | Fournisseur: "+fournisseur+"\n";
    }
}

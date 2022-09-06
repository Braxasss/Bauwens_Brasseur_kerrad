package ppe2022_pharmacie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import static ppe2022_pharmacie.DAO.pdo;

public class CommandeDAO extends DAO<Commandes>{
    @Override
    public Boolean create(Commandes uneCommande) {
        boolean result = false;
        if (pdo == null) {
            Connection();
        }
        int id = uneCommande.getIdc();
        String fournisseur = uneCommande.getFournisseur();
        String medicament = uneCommande.getMedicament();
        int qtte = uneCommande.getQtte();
        String requete = "Insert Into commandes values (?,?,?,?)";

        try {
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, id);
            prepare.setString(2, fournisseur);
            prepare.setString(3, medicament);
            prepare.setInt(4, qtte);
            prepare.executeUpdate();
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    //Read
    @Override
    public Commandes find(int pId) {
        if (pdo == null) {
            Connection();
        }
        Commandes uneCommande = null;
        String requete = "Select libelle,qtte,seuil,categorie From stock Where id=?";
        try {
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, pId);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                String fournisseur = result.getString(1);
                String medicament = result.getString(2);
                int qtte = result.getInt(3);
                uneCommande = new Commandes(pId, fournisseur, medicament, qtte);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return uneCommande;
    }

    //Update
    @Override
    public Boolean update(Commandes uneCommande) {
        boolean result = false;
        if (pdo == null) {
            Connection();
        }
        
        int id = uneCommande.getIdc();
        String fournisseur = uneCommande.getFournisseur();
        String medicament = uneCommande.getMedicament();
        int qtte = uneCommande.getQtte();
        String requete = "Update commandes Set fournisseur=?,medicament=?,qtte=? Where id=?";

        try {
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setString(1, fournisseur);
            prepare.setString(2, medicament);
            prepare.setInt(3, qtte);
            prepare.setInt(4, id);
            prepare.executeUpdate();
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    //Delete
    @Override
    public Boolean delete(Commandes uneCommande){
        boolean result = false;
        if (pdo == null) {
            Connection();
        }
        int id = uneCommande.getIdc();
        String requete = "Delete From commandes where id=?";
        try {
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, id);
            prepare.executeUpdate();
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return result;
    }

    //FindALL

    @Override
    public ArrayList<Commandes> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public  static ArrayList<Commandes> donnerToutesLesCommandes() {
        if (pdo == null) {
            DAO.Connection();
        }
        ArrayList<Commandes> lesCommandes = new ArrayList<Commandes>();
        try {
            Statement state = pdo.createStatement();
            String requete = "select * from commandes";
            ResultSet commandesResultat = state.executeQuery(requete);
            while (commandesResultat.next()) {
                int idc = commandesResultat.getInt(1);
                String fournisseur = commandesResultat.getString(2);
                String medicament = commandesResultat.getString(3);
                int qtte = commandesResultat.getInt(4);
                Commandes uneCommande = new Commandes(idc, fournisseur, medicament, qtte);
                lesCommandes.add(uneCommande);
            }
            commandesResultat.close();
            state.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur donner toutes les commandes");
        }
        return lesCommandes;
    }
    
    public static boolean ajouterCommande(String fournisseur, String medicament, int qtte) {
        if (pdo == null) {
            DAO.Connection();
        }
        try {
            Statement state = pdo.createStatement();
            String requete1 = "select max(idc) from commandes";
            ResultSet stockResultat = state.executeQuery(requete1);
            if (stockResultat.next()) {
                int idc = stockResultat.getInt(1) + 1;
                String requete2 = "insert into commandes (idc,fournisseur, medicament, qtte) values(?, ?, ?, ?)";
                PreparedStatement prepare = pdo.prepareStatement(requete2);
                prepare.setInt(1, idc);
                prepare.setString(2, fournisseur);
                prepare.setString(3, medicament);
                prepare.setInt(4, qtte);
                prepare.executeUpdate();
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans l'ajout de la commande");
        }
        return true;
    }
    
    public static ArrayList<String> donnerFournisseur() {
        if (pdo == null) {
            DAO.Connection();
        }
        ArrayList ArrayFournisseur = new ArrayList();
        try {
            Statement state = pdo.createStatement();
            String requete = "select distinct nom from fournisseur";
            ResultSet stockResultat = state.executeQuery(requete);
            while (stockResultat.next()) {
                String fournisseur = stockResultat.getString(1);
//                Medicament unStock = new Medicament(categorie);
                ArrayFournisseur.add(fournisseur);
            }
            stockResultat.close();
            state.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur donner tous les stocks");
        }
        return ArrayFournisseur;
    }
}

package ppe2022_pharmacie.DAOClass;

import ppe2022_pharmacie.Metiers.Commandes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import ppe2022_pharmacie.*;

public class CommandeDAO extends DAO<Commandes>{
    @Override
    /*
    Cette méthode permet de créer une commande de médicament.
    Paramètre : un objet Commandes
    Type de retour : booléen précisant si la commande a pu être passer ou non
    Insère une ligne dans la table commandes avec pour paramètre : id, fournisseur, médicament et quantité
    */
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
    /*
    Cette méthode permet de chercher un médicament dans le stock.
    Paramètre : un entier correspondant à l'id du médicament dans la table stock
    Valeur de retour : un objet Commandes
    */
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
    /*
    Cette méthode permet de mettre à jour la table commandes
    Paramètre : un objet Commandes
    Type de retour : un booléen indiquant si la commande a pu être modifié ou non
    */
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
    /*
    Cette méthode permet de supprimer une commande
    Paramètre : un objet Commandes
    Type de retour : un booleén indiquant si la commande a pu être supprimé ou non
    */
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
    /*
    Affiche toutes les commandes
    Paramètre : aucun
    Type de retour : une ArrayList de Commandes
    */
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
    /*
    Cette méthode permet d'ajouter une commande
    Paramètre : une chaine de caractères correspondant au fournisseur, une chaine de caractères correspondant au médicament, un entier correspondant à la quantité
    Type de retour : un booléen indiquant si la commande a pu être passé ou non
    */
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
    /*
     * Cette méthode permet de donner la liste de tous les fournisseurs sous formes de Collection.
     * Paramètre : Aucun
     * Type de retour : Collection de chaîne de caractères contenant la liste des fournisseurs.
     */
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

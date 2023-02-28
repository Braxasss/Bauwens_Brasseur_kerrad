package ppe2022_pharmacie.DAOClass;

import ppe2022_pharmacie.Metiers.Demande;
import ppe2022_pharmacie.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sio2021
 */
public class DemandeDAO extends DAO<Demande> {

    /*
    Methode Create:
    Elle crée une demande en prenant pour paramètre: 
    -l'id du service  
    -l'id du médicament 
    -la quantité nécessaire
    Elle retourne un Booléen qui vaut true si la commande a été crée ou un message d'erreur si non 
     */
    @Override
    public Boolean create(Demande unObjet) {
        if (pdo == null) {
            Connection();
        }
        boolean Check = false;
        try {
            String requete = "insert into demande (idservice, idmedicament, quantite) values (?, ?, ?)";
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, unObjet.getService().getIdService());
            prepare.setInt(2, unObjet.getMedicament().getId());
            prepare.setInt(3, unObjet.getQtte());
            int res = prepare.executeUpdate();
            Check = true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur insertion demande");
        }
        return Check;
    }

    /*
    Methode find:
    Elle permet de trouver une commande 
    Elle prends en paramètre l'id d'une commande
    Elle renvoie les informations de la commande
     */
    @Override
    public Demande find(int id) {
        if (pdo == null) {
            Connection();
        }
        Demande uneDemande = null;
        try {
            Statement state = pdo.createStatement();
            String requete = "SELECT idd,ids,idm,qtte FROM demande where iddemande=?";
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, id);
            ResultSet userResultat = prepare.executeQuery();

            if (userResultat.next()) {
                int idD = userResultat.getInt(1);
                int idS = userResultat.getInt(2);
                int idM = userResultat.getInt(3);
                int qtte = userResultat.getInt(4);
                uneDemande = new Demande(idD, idS, idM, qtte);
            }
            userResultat.close();
            state.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Aucun User / id");
        }
        return uneDemande;
    }

    /*
    Methode update:
    Elle met a jour une demande en prenant pour paramètre: 
    -Un objet Demande
    Elle retourne un Booléen qui vaut true si la commande a été modifié ou un message d'erreur si non 
     */
    @Override
    public Boolean update(Demande unObjet) {
        String requete
                = "Update demande set idservice=?, idmedicament=?, quantite=? "
                + "where iddemande=?";
        boolean check = false;
        try {
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, unObjet.getService().getIdService());
            prepare.setInt(2, unObjet.getMedicament().getId());
            prepare.setInt(3, unObjet.getQtte());
            prepare.setInt(4, unObjet.getIdD());
            prepare.executeUpdate();
            check = true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans la modification de la Demande");
        }
        return check;
    }

    /*
    Methode delete:
    Elle supprime une demande en prenant pour paramètre: 
    -un objet demande
    Elle retourne un Booléen qui vaut true si la commande a été supprimé ou un message d'erreur si non 
     */
    @Override
    public Boolean delete(Demande unObjet) {
        if (pdo == null) {
            Connection();
        }
        boolean check = false;
        try {
            String requete = "delete from demande where iddemande=?";
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, unObjet.getIdD());
            prepare.executeUpdate();
            check = true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans la suppression d'une Demande");
        }
        return check;
    }

    /*
    Methode findAll:
    Elle affiche toutes les demande
    Elle ne prends pas de paramètres
    Elle retourne une liste de toutes les commandes
     */
    @Override
    public ArrayList<Demande> findAll() {
        if (pdo == null) {
            Connection();
        }
        ArrayList<Demande> lesDemandes = new ArrayList<Demande>();
        try {
            Statement state = pdo.createStatement();
            String requete = "SELECT idd,ids,idm,qtte FROM demande";
            ResultSet demandeResultat = state.executeQuery(requete);

            while (demandeResultat.next()) {
                int idD = demandeResultat.getInt(1);
                int idS = demandeResultat.getInt(2);
                int idM = demandeResultat.getInt(3);
                int qtte = demandeResultat.getInt(4);
                Demande uneDemande = new Demande(idD, idS, idM, qtte);
                lesDemandes.add(uneDemande);
            }
            demandeResultat.close();
            state.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Aucune Demande ou id");
        }
        return lesDemandes;
    }

    /*
    Methode AfficherDemandeParService:
    Elle affiche toutes les commandes d'un meme service en prenant en paramètres:
    -l'id d'un service
    Elle retourne une liste de toutes les commandes du service  
     */
    public ArrayList<Demande> AfficherDemandeParService(int idService) {
        if (pdo == null) {
            Connection();
        }
        ArrayList<Demande> lesDemandes = new ArrayList<Demande>();
        try {
            String requete = "SELECT idd,ids,idm,qtte FROM demande where idservice=?";
            PreparedStatement prepare = pdo.prepareStatement(requete);

            prepare.setInt(1, idService);

            ResultSet demandeResultat = prepare.executeQuery();

            while (demandeResultat.next()) {
                int idD = demandeResultat.getInt(1);
                int idS = demandeResultat.getInt(2);
                int idM = demandeResultat.getInt(3);
                int qtte = demandeResultat.getInt(4);
                Demande uneDemande = new Demande(idD, idS, idM, qtte);
                lesDemandes.add(uneDemande);
            }
            demandeResultat.close();
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Aucune Demande ou id");
        }
        return lesDemandes;
    }

}

package ppe2022_pharmacie;

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
public class DemandeDAO extends DAO<Demande>{

    @Override
    public Boolean create(Demande unObjet) {
        if (pdo == null) {
            Connection();
        }
        boolean Check=false;
        try {
            String requete = "insert into demande (idservice, idmedicament, quantite) values (?, ?, ?)";
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, unObjet.getService().getIdService());
            prepare.setInt(2, unObjet.getMedicament().getId());
            prepare.setInt(3, unObjet.getQtte());
            int res = prepare.executeUpdate();
            Check=true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur insertion demande");
        }
        return Check;
    }

    @Override
    public Demande find(int id) {
        if (pdo == null) {
            Connection();
        }
        Demande uneDemande=null;
        try {
            Statement state = pdo.createStatement();
            String requete = "SELECT * FROM demande where iddemande=?";
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, id);
            ResultSet userResultat = prepare.executeQuery();

            while (userResultat.next()) {
                int idD = userResultat.getInt(1);
                int idS = userResultat.getInt(2);
                int idM = userResultat.getInt(3);
                int qtte = userResultat.getInt(4);
                uneDemande = new Demande(idD,idS,idM,qtte);
            }
            userResultat.close();
            state.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Aucun User / id");
        }
        return uneDemande;
    }

    @Override
    public Boolean update(Demande unObjet) {
        String requete = "Update demande set idservice=?, idmedicament=?, quantite=? where iddemande=?";
        boolean check=false;
        try {
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, unObjet.getService().getIdService());
            prepare.setInt(2, unObjet.getMedicament().getId());
            prepare.setInt(3, unObjet.getQtte());
            prepare.setInt(4, unObjet.getIdD());
            prepare.executeUpdate();
            check=true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans la modification de la Demande");
        }
        return check;
    }

    @Override
    public Boolean delete(Demande unObjet) {
        if (pdo == null) {
            Connection();
        }
        boolean check=false;
        try {
            String requete = "delete from demande where iddemande=?";
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, unObjet.getIdD());
            prepare.executeUpdate();
            check=true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans la suppression d'une Demande");
        }
        return check;
    }

    @Override
    public ArrayList<Demande> findAll() {
        if (pdo == null) {
            Connection();
        }
        ArrayList<Demande> lesDemandes = new ArrayList<Demande>();
        try {
            Statement state = pdo.createStatement();
            String requete = "SELECT * FROM demande";
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
    
    public ArrayList<Demande> AfficherDemandeParService(int idService) {
        if (pdo == null) {
            Connection();
        }
        ArrayList<Demande> lesDemandes = new ArrayList<Demande>();
        try {
            String requete = "SELECT * FROM demande where idservice=?";
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

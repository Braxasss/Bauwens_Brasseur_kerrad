/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppe2022_pharmacie;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sio2021
 */
public class ServiceDAO extends DAO<Service> {

    @Override
    public Boolean create(Service unObjet) {
        throw new UnsupportedOperationException("Not supported"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    /*
     * Méthode find(int id) :
     * Prend en parametre un id.
     * Retourne un objet Service.
     * Affiche le service correspondant à l'id entrer en parametre.
     * 
     */
    public Service find(int id) {
        String requete = "select libelle from service where idservice = " + id;
        Service service = null;
        String libelleService;
        try {
            Statement state = pdo.createStatement();
            ResultSet serviceResultat = state.executeQuery(requete);
            if (serviceResultat.next()) {
                libelleService = serviceResultat.getString(1);
                service = new Service(id, libelleService);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans la récupération du service");
        }
        return service;
    }

    @Override
    /*
     * Méthode update(Service unObjet) :
     * Prend en parametre un objet Service.
     * Retourne un booléen.
     * Mets à jour les donné d'un service.
     * 
     */
    public Boolean update(Service unObjet) {
        throw new UnsupportedOperationException("Not supported"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    /*
     * Méthode delete(Service unObjet) :
     * Prend en parametre un objet Service.
     * Retourne un booléen.
     * Supprime un service.
     * 
     */
    public Boolean delete(Service unObjet) {
        throw new UnsupportedOperationException("Not supported"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    
    /* Méthode findAll() : 
     * Ne prend pas de parametres.
     * Retourne une Collection de Service.
     * Affiche tout les services.
    */
    public ArrayList<Service> findAll() {
        ArrayList<Service> lesService = new ArrayList<>();
        String requete = "select * from service";
        try {
            Statement state = pdo.createStatement();
            ResultSet serviceResultat = state.executeQuery(requete);
            while (serviceResultat.next()) {
                int idService = serviceResultat.getInt(1);
                String libelle = serviceResultat.getString(2);
                lesService.add(new Service(idService, libelle));
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans la récupération des services");
        }
        return lesService;
    }

    /*
     * Méthode getIdService(String libelle) :
     * Prend en parametre le libelle d'un Service.
     * Retourne un entier.
     * Affiche l'id du service possédant le libelle mis en parametre.
     */
    public int getIdService(String libelle) {
        int idService = 0;
        try {
            Statement state = pdo.createStatement();
            String requete = "select idservice from service where libelle='" + libelle + "'";
            ResultSet authResultat = state.executeQuery(requete);
            if (authResultat.next()) {
                idService = authResultat.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans la récupération de l'id service");
        }
        return idService;
    }
    
}

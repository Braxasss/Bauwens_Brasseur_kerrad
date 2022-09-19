/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppe2022_pharmacie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 *
 * @author sio2021
 * @param <T>
 */

abstract class DAO<T> {

    protected static Connection pdo;
    /*
    Cette méthode permet de se connecter à la base de données PPE2022_Hopital_Pharmacie_BBP
    Aucun paramètre
    Aucun retour
    */
    public static void Connection() {
        String url = "jdbc:postgresql://localhost:5432/PPE2022_Hopital_Pharmacie_BBP";
        String user = "postgres";
        String passwd = "root";
        //Etablir connexion
        try {
            pdo = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");

        } catch (Exception e) {
            System.out.println("Connexion refusé !");
            System.out.println(e.getMessage());
        }
    }
    /*
     * Cette méthode permet de créer un objet
     * Paramètre : un objet abstrait
     * Type de retour : booléen
     */
    public abstract Boolean create(T unObjet);

    /*
     * Cette méthode permet de trouver un objet
     * Paramètre : un entier correspondant à l'id de l'objet
     * Type de retour : Objet
     */
    public abstract T find(int id);

    /*
     * Cette méthode permet de modifier un objet.
     * Paramètre : l'objet voulant être modifié
     * Type de retour : booléen
     */
    public abstract Boolean update(T unObjet);

    /*
     * Cette méthode permet de supprimer un objet
     * Paramètre : l'objet voulant être supprimé
     * Type de retour : booléen
     */
    public abstract Boolean delete(T unObjet);

    /*
     * Cette méthode permet de récuperer une collection d'objet
     * Paramètre : aucun
     * Type de retour : une Collection d'objet
     */
    public abstract ArrayList<T> findAll();
}

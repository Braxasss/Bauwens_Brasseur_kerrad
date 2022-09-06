package ppe2022_pharmacie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MedicamentDAO extends DAO<Medicament>{
    
    @Override
    public Boolean create(Medicament unMedicament) {
        boolean result = false;
        if (pdo == null) {
            Connection();
        }
        int id = unMedicament.getId();
        String libelle = unMedicament.getLibelle();
        int qtte = unMedicament.getQtteStock();
        int seuil = unMedicament.getSeuil();
        String categorie = unMedicament.getCategorie();
        String requete = "Insert Into medicament values (?,?,?,?,?)";

        try {
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, id);
            prepare.setString(2, libelle);
            prepare.setInt(3, qtte);
            prepare.setInt(4, seuil);
            prepare.setString(5, categorie);
            prepare.executeUpdate();
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    //Read
    @Override
    public Medicament find(int pId) {
        if (pdo == null) {
            Connection();
        }
        Medicament unMedicament = null;
        String requete = "Select libelle,qtte,seuil,categorie From medicament Where idm=?";
        try {
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, pId);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                String libelle = result.getString(1);
                int qtte = result.getInt(2);
                int seuil = result.getInt(3);
                String categorie = result.getString(4);
                unMedicament = new Medicament(pId, libelle, qtte, seuil, categorie);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return unMedicament;
    }

    //Update
    @Override
    public Boolean update(Medicament unMedicament) {
        boolean result = false;
        if (pdo == null) {
            Connection();
        }
        int id = unMedicament.getId();
        String libelle = unMedicament.getLibelle();
        int qtte = unMedicament.getQtteStock();
        int seuil = unMedicament.getSeuil();
        String categorie = unMedicament.getCategorie();
        String requete = "Update medicament Set libelle=?,qtte=?,seuil=?,categorie=? Where id=?";

        try {
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setString(1, libelle);
            prepare.setInt(2, qtte);
            prepare.setInt(3, seuil);
            prepare.setString(4, categorie);
            prepare.setInt(5, id);
            prepare.executeUpdate();
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    //Delete
    @Override
    public Boolean delete(Medicament unMedicament){
        boolean result = false;
        if (pdo == null) {
            Connection();
        }
        int id = unMedicament.getId();
        String requete = "Delete From medicament where id=?";
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
    public ArrayList<Medicament> findAll() {
        if (pdo == null) {
            DAO.Connection();
        }
        ArrayList<Medicament> lesStocks = new ArrayList<Medicament>();
        try {
            Statement state = pdo.createStatement();
            String requete = "select * from medicament";
            ResultSet stockResultat = state.executeQuery(requete);
            while (stockResultat.next()) {
                int id = stockResultat.getInt(1);
                String libelle = stockResultat.getString(2);
                int qtteStock = stockResultat.getInt(3);
                int seuil = stockResultat.getInt(4);
                String categorie = stockResultat.getString(5);
                Medicament unStock = new Medicament(id, libelle, qtteStock, seuil, categorie);
                lesStocks.add(unStock);
            }
            stockResultat.close();
            state.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur donner tous les stocks");
        }
        return lesStocks;
    }
    

    public static Medicament donnerUnStock(int idM) {
        if (pdo == null) {
            DAO.Connection();
        }
        Medicament unMedic = null;
        try {
            Statement state = pdo.createStatement();
            String requete = "select * from medicament where idm=?";
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, idM);

            ResultSet res = prepare.executeQuery();
            if (res.next()) {
                int id = res.getInt(1);
                String libelle = res.getString(2);
                int qtteStock = res.getInt(3);
                int seuil = res.getInt(4);
                String categorie = res.getString(5);
                unMedic = new Medicament(id, libelle, qtteStock, seuil, categorie);
            }

            state.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur donner tous les stocks");
        }
        return unMedic;
    }
    
    public static ArrayList<Medicament> donnerStockSeuil() {
        if (pdo == null) {
            DAO.Connection();
        }
        ArrayList<Medicament> lesStocks = new ArrayList<Medicament>();
        try {
            Statement state = pdo.createStatement();
            String requete = "select * from medicament where qtte <= seuil";
            ResultSet stockResultat = state.executeQuery(requete);
            while (stockResultat.next()) {
                int id = stockResultat.getInt(1);
                String libelle = stockResultat.getString(2);
                int qtteStock = stockResultat.getInt(3);
                int seuil = stockResultat.getInt(4);
                String categorie = stockResultat.getString(5);
                Medicament unStock = new Medicament(id, libelle, qtteStock, seuil, categorie);
                lesStocks.add(unStock);
            }
            stockResultat.close();
            state.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur donner tous les stocks");
        }
        return lesStocks;
    }

    public static ArrayList<String> donnerCategorie() {
        if (pdo == null) {
            DAO.Connection();
        }
        ArrayList ArrayCategorie = new ArrayList();
        try {
            Statement state = pdo.createStatement();
            String requete = "select distinct categorie from medicament";
            ResultSet stockResultat = state.executeQuery(requete);
            String Tous = "Tous";
            ArrayCategorie.add(Tous);
            while (stockResultat.next()) {
                String categorie = stockResultat.getString(1);
//                Medicament unStock = new Medicament(categorie);
                ArrayCategorie.add(categorie);
            }
            stockResultat.close();
            state.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur donner tous les stocks");
        }
        return ArrayCategorie;
    }

    public static ArrayList<Medicament> AfficheEnFonctionCategorie(String pCategorie) {
        if (pdo == null) {
            DAO.Connection();
        }
        ArrayList<Medicament> lesStocks = new ArrayList<Medicament>();
        try {
            Statement state = pdo.createStatement();
            String requete = "select * from medicament where categorie = \'" + pCategorie + "\'";
            ResultSet stockResultat = state.executeQuery(requete);
            while (stockResultat.next()) {
                int id = stockResultat.getInt(1);
                String libelle = stockResultat.getString(2);
                int qtteStock = stockResultat.getInt(3);
                int seuil = stockResultat.getInt(4);
                String categorie = stockResultat.getString(5);
                Medicament unStock = new Medicament(id, libelle, qtteStock, seuil, categorie);
                lesStocks.add(unStock);
            }
            stockResultat.close();
            state.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur donner tous les stocks");
        }
        return lesStocks;
    }

    public static ArrayList<Medicament> listerMedicament(String pMedicament) {
        if (pdo == null) {
            DAO.Connection();
        }
        ArrayList<Medicament> lesMedicaments = new ArrayList<Medicament>();
        try {
            Statement state = pdo.createStatement();
            String requete = "select * from medicament ";
            ResultSet medicResultat = state.executeQuery(requete);
            while (medicResultat.next()) {
                int id = medicResultat.getInt(1);
                String libelle = medicResultat.getString(2);
                int qtteStock = medicResultat.getInt(3);
                int seuil = medicResultat.getInt(4);
                String categorie = medicResultat.getString(5);
                Medicament unMedic = new Medicament(id, libelle, qtteStock, seuil, categorie);
                lesMedicaments.add(unMedic);
            }
            medicResultat.close();
            state.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur donner tous les stocks");
        }
        return lesMedicaments;
    }
    
    public static int avoirQtte(int idM) {
        int qtteD = 0;
        if (pdo == null) {
            Connection();
        }
        try {
            Statement state = pdo.createStatement();
            String requete = "SELECT qtte FROM medicament WHERE idm=" + idM;
            ResultSet qtteResultat = state.executeQuery(requete);

            if (qtteResultat.next()) {
                qtteD = qtteResultat.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Aucune Demande ou id");
        }
        return qtteD;
    }
    
    public static void validerQtte(int qtteD, int qtteM, int idM) {
        int qtteF = qtteM - qtteD;
        if (pdo == null) {
            Connection();
        }
        try {
            Statement state = pdo.createStatement();
            String requete = "UPDATE medicament SET qtte=" + qtteF + " WHERE idm=" + idM;
            int r = state.executeUpdate(requete);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Aucune Demande ou id");
        }
    }
    
    public static int derniereid(){
        int id = 0;
        if (pdo == null) {
            DAO.Connection();
        }
        try {
            Statement state = pdo.createStatement();
            String requete1 = "select max(idm) from medicament";
            ResultSet stockResultat = state.executeQuery(requete1);
            while (stockResultat.next()) {
                id = stockResultat.getInt(1) + 1;
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans l'ajout de la commande");
        }
        return id;
    }
}

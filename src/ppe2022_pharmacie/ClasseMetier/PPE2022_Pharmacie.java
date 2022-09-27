package ppe2022_pharmacie.ClasseMetier;
import java.sql.Connection;
import java.sql.DriverManager;
public class PPE2022_Pharmacie {

    public static void main(String[] args) {
        
        String url = "jdbc:postgresql://localhost:5432/PPE2022_Hopital_Pharmacie_BBP";
        String user = "postgres";
        String passwd = "root";
        //Etablir connexion
        try {
            Connection pdo = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");

        } catch (Exception e) {
            System.out.println("Connexion refusé !");
            System.out.println(e.getMessage());
        }
//        public static int avoirQtte(int idD) {
//        int qtteD = 0;
//        if (pdo == null) {
//            Connection();
//        }
//        try {
//            Statement state = pdo.createStatement();
//            String requete = "SELECT qtte FROM stock WHERE idm=" + idD;
//            ResultSet qtteResultat = state.executeQuery(requete);
//
//            if (qtteResultat.next()) {
//                qtteD = qtteResultat.getInt(1);
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//            System.out.println("Aucune Demande ou id");
//        }
//        return qtteD;
//    }
    }
    
}

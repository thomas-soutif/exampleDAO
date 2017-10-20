package fr.univ_amu.iut;

import fr.univ_amu.iut.DAO.JDBC.DAOEtudiantJDBC;
import fr.univ_amu.iut.DAO.JDBC.DAOModuleJDBC;
import fr.univ_amu.iut.beans.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExempleAsso2 {



    public static void main(String[] args) {

        List<Etudiant> listeEtudiant = new DAOEtudiantJDBC().findAll();
        List<Module> listeModule = new DAOModuleJDBC().findAll();




        try {
            Connection conn = ConnexionUnique.getInstance().getConnection();
            Statement etat = conn.createStatement();
            ArrayList liste = new ArrayList();
            ResultSet rset = etat.executeQuery("SELECT * FROM NOTATION");

            AssociationNotation asso = new AssociationNotation();

            while (rset.next()) {

                Module module = new DAOModuleJDBC().getById(rset.getString("CODE"));
                Etudiant etudiant = new DAOEtudiantJDBC().getById(rset.getInt("NUM_ET"));
               Notation notation = new Notation();
                notation.setMoyCC(rset.getInt("MOY_CC"));
                notation.setMoyTest(rset.getInt("MOY_TEST"));



                System.out.println(etudiant.toString() + notation.toString()+ module.toString());

                if(notation != null && etudiant != null && module != null)
                    asso.creerLien(module,etudiant,notation);

                // J'arrive bien à créer chaque objet mais lors de la création de ce lien, il me
                // renvoie une exception d'un pointeur Null, je ne voit pas pourquoi, car
                // mes objets sont tous bien remplie
            }




        } catch (SQLException e) {
            System.out.println("Erreur main");
            System.out.println(e.getMessage() + "\n");
        }


    }








}

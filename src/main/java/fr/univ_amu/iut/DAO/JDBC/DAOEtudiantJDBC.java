package fr.univ_amu.iut.DAO.JDBC;

import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class DAOEtudiantJDBC implements DAOEtudiant{

    public DAOEtudiantJDBC() {
    }

    @Override
    public int computeNbEtudiant() {
        return 0;
    }

    @Override
    public List<Etudiant> findByAnnee(int annee) {
        return null;
    }

    @Override
    public List<Etudiant> findByGroupe(int groupe) {
        return null;
    }

    @Override
    public List<Etudiant> findByNom(String nomEt) {
        return null;
    }

    @Override
    public boolean delete(Etudiant obj) {
        boolean ok = false;
        try {
            Statement etat = conn.createStatement();
            int nb = etat.executeUpdate("DELETE FROM ETUDIANT WHERE NUM_ET = " + obj.getNumEt());
            ok = true;
            System.out.println("L'étudiant + " + obj.getNomEt() + " " + obj.getPrenomEt() + " a bien était supprimé.");


        }
        catch (SQLException e)
        {
            System.out.println("Erreur DAOEtudiantJDBC , delete");
            System.out.println(e.getMessage() + "\n");
        }
        return ok;
    }

    @Override
    public List<Etudiant> findAll() {

        List<Etudiant> list = new ArrayList<>();
        try
        {
            Statement etat = conn.createStatement();
            ResultSet result = etat.executeQuery("SELECT * FROM ETUDIANT ORDER BY NUM_ET");

            while(result.next())
            {
                Etudiant et = new Etudiant();
                et.setNumEt(result.getInt("NUM_ET"));
                et.setNomEt(result.getString("NOM_ET"));
                et.setPrenomEt(result.getString("PRENOM_ET"));
                et.setCpEt(result.getString("CP_ET"));
                et.setVilleEt(result.getString("VILLE_ET"));
                et.setAnnee(result.getInt("ANNEE"));
                et.setGroupe(result.getInt("GROUPE"));
                list.add(et);
            }
        }

        catch (SQLException e)
        {
            System.out.println("Erreur sur DAOEtudiantJDBC / findAll()");
            System.out.println(e.getMessage() + "\n");
        }


        return list;

    }

    @Override
    public Etudiant getById(int id) {

        Etudiant tmp = new Etudiant();
        try {
            Statement etat = conn.createStatement();
            ResultSet result = etat.executeQuery("SELECT * FROM ETUDIANT WHERE NUM_ET = " + id);
            while(result.next()) {

                tmp.setNumEt(result.getInt("NUM_ET"));
                tmp.setNomEt(result.getString("NOM_ET"));
                tmp.setPrenomEt(result.getString("PRENOM_ET"));
                tmp.setCpEt(result.getString("CP_ET"));
                tmp.setVilleEt(result.getString("VILLE_ET"));
                tmp.setAnnee(result.getInt("ANNEE"));
                tmp.setGroupe(result.getInt("GROUPE"));
            }



            }
            catch (SQLException e){
            System.out.println("Erreur DAOEtudiantJDBC , getById");
            System.out.println(e.getMessage() + "\n");
            }

            return tmp;


    }

    @Override
    public Etudiant insert(Etudiant obj) {

        try {
            Statement attribuerNum = conn.createStatement();
            int numEtMin = obj.getAnnee() *1000 + obj.getGroupe() *100;
            int numEtMax = numEtMin + 99; // On a le droit a 99 étudiants maximum par groupe
            ResultSet result = attribuerNum.executeQuery("SELECT NUM_ET FROM ETUDIANT WHERE NUM_ET > " + numEtMin + " AND NUM_ET < "+numEtMax + " ORDER BY NUM_ET");

            int lastNumEt = 0;
            while(result.next())
            {
                lastNumEt = result.getInt("NUM_ET");
            }
            lastNumEt += 1;

            obj.setNumEt(lastNumEt); // Attribution d'une nouvelle clée primaire à l'étudiant

            PreparedStatement etat = conn.prepareStatement("INSERT INTO ETUDIANT (NUM_ET,NOM_ET,PRENOM_ET,CP_ET,VILLE_ET,ANNEE,GROUPE)" +
                    " VALUES (?,?,?,?,?,?,?)");

            etat.setInt(1, obj.getNumEt());
            etat.setString(2, obj.getNomEt());
            etat.setString(3, obj.getPrenomEt());
            etat.setString(4, obj.getCpEt());
            etat.setString(5, obj.getVilleEt());
            etat.setInt(6, obj.getAnnee());
            etat.setInt(7, obj.getGroupe());
            int nb = etat.executeUpdate();
            System.out.println(nb + " étudiant(s) ajouté(s)");
        }
        catch (SQLException e)
        {
            System.out.println("Erreur DAOEtudiantJDBC, insert");
            System.out.println(e.getMessage() + "\n");
        }
        //obj = getById(obj.getNumEt());
        return obj;


    }

    @Override
    public boolean update(Etudiant obj) {
        boolean ok = false;
        try {


            PreparedStatement etat = conn.prepareStatement("UPDATE ETUDIANT SET NOM_ET = ?, PRENOM_ET = ?, CP_ET = ?, VILLE_ET = ?, ANNEE = ?,GROUPE = ? WHERE NUM_ET = ?");


            etat.setString(1, obj.getNomEt());
            etat.setString(2, obj.getPrenomEt());
            etat.setString(3, obj.getCpEt());
            etat.setString(4, obj.getVilleEt());
            etat.setInt(5, obj.getAnnee());
            etat.setInt(6, obj.getGroupe());
            etat.setInt(7, obj.getNumEt());

            int nb  = etat.executeUpdate();
            System.out.println(nb + " étudiant(s) modifié(s)");
            ok = true;
        }
        catch (SQLException e)
        {
            System.out.println("Erreur DAOEtudiantJDBC , update");
            System.out.println(e.getMessage() + "\n");
        }


        return ok;


    }
}

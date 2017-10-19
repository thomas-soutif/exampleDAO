package fr.univ_amu.iut.DAO.JDBC;

import fr.univ_amu.iut.DAO.DAOModule;
import fr.univ_amu.iut.DAO.DAOProf;
import fr.univ_amu.iut.beans.Etudiant;
import fr.univ_amu.iut.beans.Module;
import fr.univ_amu.iut.beans.Prof;

import javax.sql.rowset.serial.SerialException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOProfJDBC implements DAOProf {


    @Override
    public List<Prof> findByNom(String nom) {

        List<Prof> list = new ArrayList<>();

        try {
            Statement etat = conn.createStatement();
            ResultSet result = etat.executeQuery("SELECT * FROM PROF WHERE NOM_PROF = '" + nom + "'");

            while (result.next()) {
                Prof prof = new Prof();
                prof.setNumProf(result.getInt("NUM_PROF"));
                prof.setNomProf(result.getString("NOM_PROF"));
                prof.setPrenomProf(result.getString("PRENOM_PROF"));
                prof.setAdrProf(result.getString("ADR_PROF"));
                prof.setCpProf(result.getString("CP_PROF"));
                prof.setVilleProf(result.getString("VILLE_PROF"));

                DAOModule dao = new DAOModuleJDBC();
                Module mod = dao.getById(result.getString("MAT_SPEC"));
                prof.setMatSpec(mod);

                list.add(prof);
            }

        }
        catch (SQLException e)
        {
            System.out.println("Erreur sur DAOProfJDBC / findByNom()");
            System.out.println(e.getMessage() + "\n");
        }
        return list;

    }

    @Override
    public List<Prof> findMatSpec(Module matSpec) {
        List<Prof> list = new ArrayList<>();

        try {
            Statement etat = conn.createStatement();
            ResultSet result = etat.executeQuery("SELECT * FROM PROF WHERE MAT_SPEC = '" + matSpec.getCode() + "'");

            while (result.next()) {
                Prof prof = new Prof();
                prof.setNumProf(result.getInt("NUM_PROF"));
                prof.setNomProf(result.getString("NOM_PROF"));
                prof.setPrenomProf(result.getString("PRENOM_PROF"));
                prof.setAdrProf(result.getString("ADR_PROF"));
                prof.setCpProf(result.getString("CP_PROF"));
                prof.setVilleProf(result.getString("VILLE_PROF"));

                DAOModule dao = new DAOModuleJDBC();
                Module mod = dao.getById(result.getString("MAT_SPEC"));
                prof.setMatSpec(mod);

                list.add(prof);
            }

        }
        catch (SQLException e)
        {
            System.out.println("Erreur sur DAOProfJDBC / findByMatSpec()");
            System.out.println(e.getMessage() + "\n");
        }
        return list;
    }

    @Override
    public int computeNbProf() {
        try{
            Statement etat = conn.createStatement();
            ResultSet result = etat.executeQuery("SELECT count(NUM_PROF) FROM PROF");
            while(result.next())
            {
                return result.getInt("count(NUM_PROF)");
            }

        }
        catch (SQLException e)
        {
            System.out.println("Erreur sur computeProf");
        }

        return 0;

    }

    @Override
    public boolean delete(Prof obj) {
        boolean ok = false;
        try {
            Statement etat = conn.createStatement();
            int nb = etat.executeUpdate("DELETE FROM PROF WHERE NUM_PROF = " + obj.getNumProf());
            ok = true;
            System.out.println("Le professeur " + obj.getNomProf() + " " + obj.getPrenomProf() + " a bien était supprimé.");


        }
        catch (SQLException e)
        {
            System.out.println("Erreur DAOProfJDBC , delete");
            System.out.println(e.getMessage() + "\n");
        }
        return ok;
    }

    @Override
    public List<Prof> findAll() {

        List<Prof> list = new ArrayList<>();
        try
        {
            Statement etat = conn.createStatement();
            ResultSet result = etat.executeQuery("SELECT * FROM PROF ORDER BY NUM_PROF");

            while(result.next())
            {
                Prof prof = new Prof();
                prof.setNumProf(result.getInt("NUM_PROF"));
                prof.setNomProf(result.getString("NOM_PROF"));
                prof.setPrenomProf(result.getString("PRENOM_PROF"));
                prof.setAdrProf(result.getString("ADR_PROF"));
                prof.setCpProf(result.getString("CP_PROF"));
                prof.setVilleProf(result.getString("VILLE_PROF"));

                DAOModule dao = new DAOModuleJDBC();
                Module mod = dao.getById(result.getString("MAT_SPEC"));
                prof.setMatSpec(mod);

                list.add(prof);
            }
        }

        catch (SQLException e)
        {
            System.out.println("Erreur sur DAOProfJDBC / findAll()");
            System.out.println(e.getMessage() + "\n");
        }


        return list;


    }

    @Override
    public Prof getById(Integer id) {
        Prof pr = new Prof();
        try {
            Statement etat = conn.createStatement();
            ResultSet result = etat.executeQuery("SELECT * FROM PROF WHERE NUM_PROF = " + id);
            while(result.next()) {

                pr.setNumProf(result.getInt("NUM_PROF"));
                pr.setNomProf(result.getString("NOM_PROF"));
                pr.setPrenomProf(result.getString("PRENOM_PROF"));
                pr.setAdrProf(result.getString("ADR_PROF"));
                pr.setCpProf(result.getString("CP_PROF"));
                pr.setVilleProf(result.getString("VILLE_PROF"));

                DAOModule dao = new DAOModuleJDBC();
                Module mod = dao.getById(result.getString("MAT_SPEC"));
                pr.setMatSpec(mod);

            }



        }
        catch (SQLException e){
            System.out.println("Erreur DAOProfJDBC , getById");
            System.out.println(e.getMessage() + "\n");
        }

        return pr;



    }

    @Override
    public Prof insert(Prof obj) {

        try {
            Statement attribuerNum = conn.createStatement();
            ResultSet result = attribuerNum.executeQuery("SELECT NUM_PROF FROM PROF ORDER BY NUM_PROF");

            int lastNumProf = 0;
            while(result.next())
            {
                lastNumProf = result.getInt("NUM_PROF");
            }
            lastNumProf += 1;

            obj.setNumProf(lastNumProf); // Attribution d'une nouvelle clée primaire au professeur

            PreparedStatement etat = conn.prepareStatement("INSERT INTO PROF (NUM_PROF,NOM_PROF,PRENOM_PROF,ADR_PROF,CP_PROF,VILLE_PROF,MAT_SPEC)" +
                    " VALUES (?,?,?,?,?,?,?)");

            etat.setInt(1, obj.getNumProf());
            etat.setString(2, obj.getNomProf());
            etat.setString(3, obj.getPrenomProf());
            etat.setString(4, obj.getAdrProf());
            etat.setString(5, obj.getCpProf());
            etat.setString(6, obj.getVilleProf());
            etat.setString(7,obj.getMatSpec().getCode());
            int nb = etat.executeUpdate();
            System.out.println(nb + " professeur(s) ajouté(s)");
        }
        catch (SQLException e)
        {
            System.out.println("Erreur DAOProfJDBC, insert");
            System.out.println(e.getMessage() + "\n");

        }
        //obj = getById(obj.getNumEt());
        return obj;



    }

    @Override
    public boolean update(Prof obj) {
        boolean ok = false;
        try {
            PreparedStatement etat = conn.prepareStatement("UPDATE PROF SET NOM_PROF = ?, PRENOM_PROF = ?, ADR_PROF = ?, CP_PROF = ?, VILLE_PROF = ?,MAT_SPEC = ? WHERE NUM_PROF = ?");
            etat.setString(1, obj.getNomProf());
            etat.setString(2, obj.getPrenomProf());
            etat.setString(3, obj.getAdrProf());
            etat.setString(4, obj.getCpProf());
            etat.setString(5, obj.getVilleProf());
            etat.setString(6, obj.getMatSpec().getCode());
            etat.setInt(7, obj.getNumProf());

            int nb  = etat.executeUpdate();
            System.out.println(nb + " professeur(s) modifié(s)");
            ok = true;
        }
        catch (SQLException e)
        {
            System.out.println("Erreur DAOProfJDBC , update");
            System.out.println(e.getMessage() + "\n");
        }


        return ok;
    }
}

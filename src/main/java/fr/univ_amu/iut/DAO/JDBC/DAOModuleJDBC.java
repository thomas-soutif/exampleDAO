package fr.univ_amu.iut.DAO.JDBC;

import fr.univ_amu.iut.DAO.DAOModule;
import fr.univ_amu.iut.DAO.DAOProf;
import fr.univ_amu.iut.beans.Module;
import fr.univ_amu.iut.beans.Prof;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOModuleJDBC implements DAOModule {

    @Override
    public List<Module> findByLibelle(String libelle) {

        List<Module> list = new ArrayList<>();

        try {
            Statement etat = conn.createStatement();
            ResultSet result = etat.executeQuery("SELECT * FROM MODULE WHERE LIBELLE = '" + libelle + "'");

            while (result.next()) {
                Module module = new Module();
                module.setCode(result.getString("CODE"));
                module.setLibelle(result.getString("LIBELLE"));
                module.sethCoursPrev(result.getInt("H_COURS_PREV"));
                module.sethCoursRea(result.getInt("H_COURS_REA"));
                module.setDiscipline(result.getString("DISCIPLINE"));
                module.setCoefTest(result.getInt("COEFF_TEST"));
                module.setCoefCc(result.getInt("COEFF_CC"));

                DAOProf dao = new DAOProfJDBC();
                Prof pr = new Prof();
                pr.setNumProf(result.getInt("RESP"));
                module.setResponsable(pr);

                if(result.getString("CODEPERE") != null) {
                    Module mod = getById(result.getString("CODEPERE"));
                    module.setPere(mod);
                }

                list.add(module);
            }

        }
        catch (SQLException e)
        {
            System.out.println("Erreur sur DAOModuleJDBC / findByLibelle()");
            System.out.println(e.getMessage() + "\n");
        }
        return list;


    }

    @Override
    public List<Module> findByDiscipline(String discipline) {

        List<Module> list = new ArrayList<>();

        try {
            Statement etat = conn.createStatement();
            ResultSet result = etat.executeQuery("SELECT * FROM MODULE WHERE DISCIPLINE = '" + discipline + "'");

            while (result.next()) {
                Module module = new Module();
                module.setCode(result.getString("CODE"));
                module.setLibelle(result.getString("LIBELLE"));
                module.sethCoursPrev(result.getInt("H_COURS_PREV"));
                module.sethCoursRea(result.getInt("H_COURS_REA"));
                module.setDiscipline(result.getString("DISCIPLINE"));
                module.setCoefTest(result.getInt("COEFF_TEST"));
                module.setCoefCc(result.getInt("COEFF_CC"));

                DAOProf dao = new DAOProfJDBC();
                Prof pr = new Prof();
                pr.setNumProf(result.getInt("RESP"));
                module.setResponsable(pr);

                if(result.getString("CODEPERE") != null) {
                    Module mod = getById(result.getString("CODEPERE"));
                    module.setPere(mod);
                }

                list.add(module);
            }

        }
        catch (SQLException e)
        {
            System.out.println("Erreur sur DAOModuleJDBC / findByDiscipline()");
            System.out.println(e.getMessage() + "\n");
        }
        return list;
    }

    @Override
    public List<Module> findByResponsable(Prof Responsable) {
        List<Module> list = new ArrayList<>();

        try {
            Statement etat = conn.createStatement();
            ResultSet result = etat.executeQuery("SELECT * FROM MODULE WHERE RESPONSABLE = " + Responsable.getNumProf());

            while (result.next()) {
                Module module = new Module();
                module.setCode(result.getString("CODE"));
                module.setLibelle(result.getString("LIBELLE"));
                module.sethCoursPrev(result.getInt("H_COURS_PREV"));
                module.sethCoursRea(result.getInt("H_COURS_REA"));
                module.setDiscipline(result.getString("DISCIPLINE"));
                module.setCoefTest(result.getInt("COEFF_TEST"));
                module.setCoefCc(result.getInt("COEFF_CC"));

                DAOProf dao = new DAOProfJDBC();
                Prof pr = new Prof();
                pr.setNumProf(result.getInt("RESP"));
                module.setResponsable(pr);

                if(result.getString("CODEPERE") != null) {
                    Module mod = getById(result.getString("CODEPERE"));
                    module.setPere(mod);
                }


                list.add(module);
            }

        }
        catch (SQLException e)
        {
            System.out.println("Erreur sur DAOModuleJDBC / findByResponsable()");
            System.out.println(e.getMessage() + "\n");
        }
        return list;
    }

    @Override
    public boolean delete(Module obj) {

        boolean ok = false;
        try {
            Statement etat = conn.createStatement();
            int nb = etat.executeUpdate("DELETE FROM MODULE WHERE CODE = '" + obj.getCode() +"'");
            ok = true;
            System.out.println("Le module " + obj.getCode() + "("+ obj.getLibelle()+") a bien était supprimé.");


        }
        catch (SQLException e)
        {
            System.out.println("Erreur DAOModuleJDBC , delete");
            System.out.println(e.getMessage() + "\n");
        }
        return ok;
    }

    @Override
    public List<Module> findAll() {
        List<Module> list = new ArrayList<>();

        try {
            Statement etat = conn.createStatement();
            ResultSet result = etat.executeQuery("SELECT * FROM MODULE");

            while (result.next()) {
                Module module = new Module();
                module.setCode(result.getString("CODE"));
                module.setLibelle(result.getString("LIBELLE"));
                module.sethCoursPrev(result.getInt("H_COURS_PREV"));
                module.sethCoursRea(result.getInt("H_COURS_REA"));
                module.setDiscipline(result.getString("DISCIPLINE"));
                module.setCoefTest(result.getInt("COEFF_TEST"));
                module.setCoefCc(result.getInt("COEFF_CC"));

                DAOProf dao = new DAOProfJDBC();
                Prof pr = new Prof();
                pr.setNumProf(result.getInt("RESP"));
                module.setResponsable(pr);

                if(result.getString("CODEPERE") != null) {
                    Module mod = getById(result.getString("CODEPERE"));
                    module.setPere(mod);
                }


                list.add(module);
            }

        }
        catch (SQLException e)
        {
            System.out.println("Erreur sur DAOModuleJDBC / findAll()");
            System.out.println(e.getMessage() + "\n");
        }
        return list;
    }


    @Override
    public Module getById(String s) {


        try {
            Statement etat = conn.createStatement();
            ResultSet result = etat.executeQuery("SELECT * FROM MODULE WHERE CODE = '" + s + "'");

            while (result.next()) {
                Module module = new Module();
                module.setCode(result.getString("CODE"));
                module.setLibelle(result.getString("LIBELLE"));
                module.sethCoursPrev(result.getInt("H_COURS_PREV"));
                module.sethCoursRea(result.getInt("H_COURS_REA"));
                module.setDiscipline(result.getString("DISCIPLINE"));
                module.setCoefTest(result.getInt("COEFF_TEST"));
                module.setCoefCc(result.getInt("COEFF_CC"));


                DAOProf dao = new DAOProfJDBC();
                Prof pr = new Prof();
                pr.setNumProf(result.getInt("RESP"));
                module.setResponsable(pr);

                if(result.getString("CODEPERE") != null) {
                    Module mod = getById(result.getString("CODEPERE"));
                    module.setPere(mod);
                }

                return module;
            }

        }
        catch (SQLException e)
        {
            System.out.println("Erreur sur DAOModuleJDBC / findAll()");
            System.out.println(e.getMessage() + "\n");
        }
        return null;
    }

    @Override
    public Module insert(Module obj) {
        try {
            PreparedStatement etat = conn.prepareStatement("INSERT INTO MODULE (CODE,LIBELLE,H_COURS_PREV,H_COURS_REA,H_TP_PREV,H_TP_REA,DISCIPLINE,COEFF_TEST,COEFF_CC,RESP,CODEPERE" +
                    " VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            etat.setString(1, obj.getCode());
            etat.setString(2, obj.getLibelle());
            etat.setInt(3, obj.gethCoursPrev());
            etat.setInt(4, obj.gethCoursRea());
            etat.setInt(5, obj.gethTpPrev());
            etat.setInt(6, obj.gethTpRea());
            etat.setString(7,obj.getDiscipline());
            etat.setInt(8,obj.getCoefTest());
            etat.setInt(9,obj.getCoefCc());
            etat.setInt(10,obj.getResponsable().getNumProf());
            etat.setString(11,obj.getPere().getCode());
            int nb = etat.executeUpdate();
            System.out.println(nb + " module(s) ajouté(s)");
        }
        catch (SQLException e)
        {
            System.out.println("Erreur DAOModuleJDBC, insert");
            System.out.println(e.getMessage() + "\n");

        }
        //obj = getById(obj.getNumEt());
        return obj;






    }

    @Override
    public boolean update(Module obj) {
        boolean ok = false;
        try {
            PreparedStatement etat = conn.prepareStatement("UPDATE MODULE SET LIBELLE = ?,H_COURS_PREV = ?,H_COURS_REA = ?,H_TP_PREV = ?,H_TP_REA = ?,DISCIPLINE = ?,COEFF_TEST = ?,COEFF_CC = ?,RESP = ?,CODEPERE = ? WHERE CODE = ?  ");


            etat.setString(1, obj.getLibelle());
            etat.setInt(2, obj.gethCoursPrev());
            etat.setInt(3, obj.gethCoursRea());
            etat.setInt(4, obj.gethTpPrev());
            etat.setInt(5, obj.gethTpRea());
            etat.setString(6,obj.getDiscipline());
            etat.setInt(7,obj.getCoefTest());
            etat.setInt(8,obj.getCoefCc());
            etat.setInt(9,obj.getResponsable().getNumProf());
            etat.setString(10,obj.getPere().getCode());
            etat.setString(11, obj.getCode());



            int nb  = etat.executeUpdate();
            System.out.println(nb + " modules(s) modifié(s)");
            ok = true;
        }
        catch (SQLException e)
        {
            System.out.println("Erreur DAOModuleJDBC , update");
            System.out.println(e.getMessage() + "\n");
        }


        return ok;

    }
}

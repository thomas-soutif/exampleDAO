package fr.univ_amu.iut.DAO.JDBC;

import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DAOEtudiantJDBC implements DAOEtudiant{
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
        return false;
    }

    @Override
    public List<Etudiant> FindAll() {
        return null;
    }

    @Override
    public Etudiant getById(int id) {

        Etudiant tmp = new Etudiant();
        try {
            Statement etat = conn.createStatement();
            ResultSet result = etat.executeQuery("SELECT * FROM ETUDIANT WHERE NUM_ET = " + id);
            result.next();

            tmp.setNumEt(result.getInt("NUM_ET"));
            tmp.setNomEt(result.getString("NOM_ET"));
            tmp.setPrenomEt(result.getString("PRENOM_ET"));
            tmp.setCpEt(result.getString("CP_ET"));
            tmp.setVilleEt(result.getString("VILLE_ET"));
            tmp.setAnnee(result.getInt("ANNEE"));
            tmp.setGroupe(result.getInt("GROUPE"));




            }
            catch (SQLException e){
            System.out.println("Erreur main");
            System.out.println(e.getMessage() + "\n");
            }

            return tmp;


    }

    @Override
    public Etudiant insert(Etudiant obj) {


        try {
            Statement etat = conn.createStatement();

            int nb = etat.executeUpdate("INSERT INTO ETUDIANT(NUM_ET,NOM_ET,PRENOM_ET,CP_ET,VILLE_ET,ANNEE,GROUPE)" +
                    "VALUES (" + obj.getNumEt() + "," + obj.getNomEt() + "," + obj.getPrenomEt() + "," + obj.getCpEt() + "," + obj.getVilleEt() + "," + obj.getAnnee() + "," + obj.getGroupe());
        }
        catch (SQLException e)
        {
            System.out.println("Erreur main");
            System.out.println(e.getMessage() + "\n");
        }
        return obj;


    }

    @Override
    public boolean update(Etudiant obj) {
        return false;
    }
}

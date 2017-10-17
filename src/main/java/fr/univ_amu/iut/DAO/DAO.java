package fr.univ_amu.iut.DAO;

import fr.univ_amu.iut.beans.ConnexionUnique;

import java.sql.Connection;
import java.util.List;

public interface DAO<T> {

    public Connection conn = ConnexionUnique.getInstance().getConnection();
    /**
     * Permet la suppression d'un tuple de la base
     *
     * @param obj
     */
    boolean delete(T obj);

    /**
     * Permet de récupérer tous les objets d'une table
     *
     * @return
     */
    List<T> findAll();

    /**
     * Permet de récupérer un objet via son ID
     *
     * @param id
     * @return
     */
    T getById(int id);

    /**
     * Permet de créer une entrée dans la base de données par rapport à un objet
     *
     * @param obj
     */
    T insert(T obj);

    /**
     * Permet de mettre à jour les données d'un tuple dans la base à partir d'un
     * objet passé en paramètre
     *
     * @param obj
     */
    boolean update(T obj);
}
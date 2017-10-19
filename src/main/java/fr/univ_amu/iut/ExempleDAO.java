package fr.univ_amu.iut;

import fr.univ_amu.iut.DAO.DAO;
import fr.univ_amu.iut.DAO.DAOModule;
import fr.univ_amu.iut.DAO.DAOProf;
import fr.univ_amu.iut.DAO.JDBC.DAOModuleJDBC;
import fr.univ_amu.iut.DAO.JDBC.DAOProfJDBC;
import fr.univ_amu.iut.beans.Module;
import fr.univ_amu.iut.beans.Prof;

import java.util.List;

public class ExempleDAO {



    public static void main(String [] args){




       /* Prof prof = new Prof();

        prof.setNomProf("SOUTIF");
        prof.setPrenomProf("THOMAS");
        prof.setCpProf("13100");
        prof = dao.insert(prof);

        System.out.println(dao.computeNbProf());
        List<Prof> list = dao.findAll();

        for(Prof pr : list)
            System.out.println(pr.toString());

        prof.setVilleProf("Aix en Provence");



        dao.update(prof);
        System.out.println(dao.getById(prof.getNumProf()));
*/


        DAOModule daoMod = new DAOModuleJDBC();
        DAOProf daoProf = new DAOProfJDBC();

        Module mod = daoMod.getById("ADA");
        System.out.println(mod);
        System.out.println(mod.getPere());

        Prof pr = daoProf.getById(mod.getResponsable().getNumProf());

        System.out.println(pr);

       daoMod.delete(mod); // On a pas le droit de supprimer une clée primaire référencé en tant que clé étrangére autre
        // part. Bien entendu, j'ai définit tout les contraintes d'intégrité sur ma base en locale, donc si vous voulez
        // que ça fonctionne, vérifiait bien que votre base posséde les bonnes contraintes.
        // Sinon le module "ADA" sera vraiment supprimer , ce qui sort de la logique, puisque tout ses fils devrait
        // etre suprimer. Bien sur on peut définir lors de la contrainte un DELETE ON CASCADE mais j'ai juger
        // cette solution bien trop dangereuse au main d'un clien inexpérimenté.

        List<Prof> list = daoProf.findMatSpec(mod);
        for(Prof p : list )
            System.out.println(p);

        System.out.println("Liste des professeurs au nom de BOITARD : ");

        list = daoProf.findByNom("BOITARD");
        for(Prof p : list)
            System.out.println(p);

    }
}

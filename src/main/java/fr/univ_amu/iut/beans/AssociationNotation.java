package fr.univ_amu.iut.beans;

import java.util.Set;

public class AssociationNotation {


    private Set<Lien> liens;
    private AssociationNotation instance;

    public void creerLien(Module mod,Etudiant et,Notation not){

    Lien lien = new Lien(mod,et);
    lien.setNote(not);
    liens.add(lien);


    };
    public void supprimerLien(Module mod, Etudiant et){};
    public void supprimerLien(Lien lien){};
    public Lien getLien(Module mod, Etudiant et){return null;};
    public Set<Lien> getLiens(Etudiant et){return null;};
    public Set<Lien> getLiens(Module mod){return null;};
    public Set<Module> getModules(Etudiant et){return null;};
    public Set<Etudiant> getEtudiants(Module mo){return null;};
    public AssociationNotation getInstance() {
        if(instance == null)
            instance = new AssociationNotation();

        return instance;




    };


}

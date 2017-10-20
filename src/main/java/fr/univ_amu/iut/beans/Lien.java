package fr.univ_amu.iut.beans;

public class Lien {

    private Module module;
    private Etudiant etudiant;
    private Notation note;


    public Lien(Module mod, Etudiant et)
    {
        this.etudiant = et;
        this.module = mod;
    }

    public Module getModule() {
        return module;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Notation getNotation() {
        return note;
    }

    public void setNote(Notation note) {
        this.note = note;
    }
}

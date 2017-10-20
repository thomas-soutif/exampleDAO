package fr.univ_amu.iut.beans;

public class Notation {

    private float moyCC;
    private float moyTest;

    public Notation(){}

    public void setMoyCC(float moyCC) {
        this.moyCC = moyCC;
    }

    public void setMoyTest(float moyTest) {
        this.moyTest = moyTest;
    }

    @Override
    public String toString() {
        return "Notation{" +
                "moyCC=" + moyCC +
                ", moyTest=" + moyTest +
                '}';
    }
}

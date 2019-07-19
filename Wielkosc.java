package Obiektowe.pizzeria_pelnia_program;

public enum Wielkosc {

    DUZA(4, 40),
    MALA(3, 30);

    private int wielkoscWCm;
    private int id;

    Wielkosc(int id, int wielkoscWCm) {
        this.id = id;
        this.wielkoscWCm = wielkoscWCm;
    }

    public int getWielkoscWCm() {
        return wielkoscWCm;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Wielkość pizy: " +
                 wielkoscWCm +
                "cm \n id: " + id ;
    }
}

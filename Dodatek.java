package Obiektowe.pizzeria_pelnia_program;

public enum Dodatek {

    POMIDOROWY("sos pomidorowy",1),
    CZOSNKOWY("sos czosnkowy",2),
    OLIWA_CZOSNKOWA("oliwa czosnkowa",3),
    OLIWA_PIKANTNA("oliwa pikantna",4),
    BRAK("brak",-1);


    private String nazwa;
    private int id;

    Dodatek(String nazwa,int id) {
        this.nazwa = nazwa;
        this.id = id;

    }

    public String getNazwa() {
        return nazwa;
    }

    public static void wyswietlWszystkieDodatki() {

        for (Dodatek value : values()) {
            if (value.equals(BRAK)) {
                continue;
            }
            System.out.println(value + " " + value.id);

        }
    }

    public static int ileJestDodatkow() {

        return values().length - 1;
    }

    public static Dodatek znajdzPoId(int id) {
        for (Dodatek dodatek : Dodatek.values()) {
            if (dodatek.id == id) {
                return dodatek;
            }
        }
        return BRAK;
    }

}

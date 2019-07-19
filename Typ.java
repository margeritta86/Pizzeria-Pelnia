package Obiektowe.pizzeria_pelnia_program;

import Obiektowe.program_do_pizzerii.Skladniki;

import java.rmi.server.SkeletonNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;


public enum Typ {


    MARGERITTA(new ArrayList(Arrays.asList(33, 0, 29)), "MARGHERITTA",01),
    FUNGHI(new ArrayList(Arrays.asList(33, 0, 1, 29)), "FUNGHI",02),
    PROSCIUTTO(new ArrayList(Arrays.asList(33, 0, 3, 29)), "PROSCIUTTO",03),
    SALAME(new ArrayList(Arrays.asList(33, 0, 2, 29)), "SALAME",04),
    SALAME_E_FUNGHI(new ArrayList(Arrays.asList(33, 0, 2, 29)), "SALAME E FUNGHI",05),
    HAWAII(new ArrayList(Arrays.asList(33, 0, 3, 5, 29)), "HAWAII",06),
    PEPPERONI(new ArrayList(Arrays.asList(33, 0, 4, 6, 29)), "PEPPERONI",07),
    PROSCIUTOO_E_FUNGHI(new ArrayList(Arrays.asList(33, 0, 1, 3, 29)), "PROSCIUTTO E FUNGHI",08),
    PROSCIUTTO_E_MAIS(new ArrayList(Arrays.asList(33, 0, 3, 7, 29)), "PROSCIUTTO E MAIS",09),
    DIAVOLO(new ArrayList(Arrays.asList(33, 0, 4, 8, 28, 29)), "DIAVOLO",10),
    PANCETTE_E_SPINACHI(new ArrayList(Arrays.asList(33, 0, 9, 11, 10, 29)), "PANCETTE E SPINACHI",11),
    TONNO(new ArrayList(Arrays.asList(33, 0, 37, 12, 13, 29)), "TONNO",12),
    RUCOLA(new ArrayList(Arrays.asList(33, 0, 14, 15, 16)), "RUCOLA",13),
    QUATRO_FORMAGGI(new ArrayList(Arrays.asList(33, 0, 17, 18, 16, 29)), "QUATRO FORMAGGI",14),
    CAPRICIOSA(new ArrayList(Arrays.asList(33, 0, 1, 3, 6, 20, 29)), "CAPRICIOSA",15),
    OLIVIO(new ArrayList(Arrays.asList(33, 0, 3, 8, 13, 19, 20, 29)), "OLIVIO",16),
    FIGARO_E_RUCOLA(new ArrayList(Arrays.asList(33, 0, 3, 21, 18, 14, 36)), "FIGARO E RUCOLA",17),
    RUCOLA_E_PARMA(new ArrayList(Arrays.asList(33, 0, 9, 14, 22, 16)), "RUCOLA E PARMA",18),
    GRUSZKA_E_LAZUR(new ArrayList(Arrays.asList(35, 0, 23, 11, 18)), "GRUSZKA E LAZUR",19),
    RUCOLA_E_FETA(new ArrayList(Arrays.asList(33, 0, 9, 14, 24, 31)), "RUCOLA E FETA",20),
    CARBON(new ArrayList(Arrays.asList(34, 0, 11, 12, 16, 29)), "CARBON",21),
    SPINACHI(new ArrayList(Arrays.asList(34, 0, 10, 29)), "SPINACHI",22),
    MOLTO_CARNE(new ArrayList(Arrays.asList(33, 0, 3, 11, 2, 12, 29)), "MOLTO CARNE",23),
    UNGHERESE(new ArrayList(Arrays.asList(33, 0, 2, 11, 25, 29)), "UNGHERESE",24),
    BARBABIETOLLA(new ArrayList(Arrays.asList(34, 0, 26, 27, 30, 32)), "BARBABIETOLLA",30),
    SALOMON_CON_ASET(new ArrayList(Arrays.asList(33, 0, 38, 13, 39, 40)), "SALOMON CON ASET",32),
    BRAK(new ArrayList<>(), "",-1);

    private ArrayList<Skladnik> skladniki;
    private String nazwaPizzy;
    private int idPizzy;



    Typ(ArrayList<Integer> skladnikiId, String nazwaPizzy, int idPizzy) {
        skladniki = new ArrayList<>();
        for (Integer id : skladnikiId) {
            skladniki.add(Skladnik.znajdzPoId(id));
        }
        this.skladniki = skladniki;
        this.nazwaPizzy = nazwaPizzy;
        this.idPizzy = idPizzy;
    }



    public ArrayList<Skladnik> getSkladniki() {
        return skladniki;
    }

    public void setSkladniki(ArrayList<Skladnik> skladniki) {
        this.skladniki = skladniki;
    }

    public static void wyswietlTypy(){
        for (Typ typ : values()) {
            System.out.println(typ);

        }
    }


    public static void wyswietlTypZId(){
        for (Typ typ : values()) {
            if(typ.equals(BRAK)){
                continue;
            }
            System.out.println(typ.idPizzy+" "+typ.nazwaPizzy);

        }
    }

    public static Typ znajdzPoId(int nrId){
        for (Typ typ : values()) {
            if (typ.idPizzy == nrId) {
                return typ;
            }
        }
        return BRAK;

    }

    public String getNazwaPizzy() {
        return nazwaPizzy;
    }

    public int getIdPizzy() {
        return idPizzy;
    }
}

//wrzucić typy pizz, dać w konstruktorze liste z numerami składników, wzorcowe skladniki dla określonego rodzaju.



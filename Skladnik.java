package Obiektowe.pizzeria_pelnia_program;

import jdk.management.jfr.ConfigurationInfo;

import java.util.ArrayList;
import java.util.List;

public enum Skladnik {
    BRAK(-1, "ERROR - BRAK"),
    MOZZARELLA(0, "mozzarella"),
    PIECZARKI(1, "pieczarki"),
    SALAMI(2, "salami"),
    SZYNKA(3, "szynka"),
    SALAMI_PEPPERONI(4, "salami pepperoni"),
    ANANAS(5, "ananas"),
    PAPRYKA_PEPPERONI(6, "papryka pepperoni"),
    KUKURYDZA(7, "kukurydza"),
    PAPRYKA_JALAPENO(8, "papryka jalapeno"),
    SUSZONE_POMIDORY(9, "suszonepomidory"),
    SWIEZY_SZPINAK(10, "świeży szpinak"),
    BOCZEK(11, "boczek"),
    CEBULA(12, "cebula"),
    KAPARY(13, "kapary"),
    RUKOLA(14, "rukola"),
    POMIDORKI_KOKTAJLOWE(15, "pomidorki koktajlowe"),
    PARMEZAN(16, "parmezan"),
    SER_WEDZONY(17, "ser wędzony"),
    SER_LAZUR(18, "ser lazur"),
    OLIWKI_CZARNE(19, "oliwki czarne"),
    OLIWKI_ZIELONE(20, "oliwki zielone"),
    FIGI(21, "figi"),
    SZYNKA_PARMENSKA(22, "szynka parmeńska"),
    GRUSZKA(23, "gruszka"),
    FETA(24, "feta"),
    SWIEZA_PAPRYKA(25, "świeża papryka"),
    BURAKI(26, "buraki"),
    SER_KOZI(27, "ser kozi"),
    PLATKI_CHILLI(28, "płatki chilli"),
    OREGANO(29, "oregano"),
    ORZECHY_WLOSKIE(30, "orzechy włoskie"),
    SOS_MIODOWO_MUSZTARDOWY(31, "sos miodowo-musztardowy"),
    SOS_BALSAMICZNY(32, "sos balsamiczny"),
    SOS_POMIDOROWY_DO_PIZZY(33, "sos pomidorowy do pizzy"),
    SOS_BIALY_DO_PIZZY(34, "sos biały do pizzy"),
    OLIWA_CZOSNKOWA(35, "oliwa czosnkowa"),
    SOL_MORSKA(36, "sól morska"),
    TUNCZYK(37, "tuńczyk"),
    WEDZONY_LOSOS(38, "wędzony łosoś"),
    KOPEREK(39, "koperek"),
    CYTRYNA(40, "cytryna");


    private String nazwa;
    private int id;

    Skladnik(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nazwa;

    }

    public static Skladnik znajdzPoId(int id) {
        for (Skladnik skladnik : Skladnik.values()) {
            if (skladnik.getId() == id) {
                return skladnik;
            }
        }
        return BRAK;
    }

    public static void wyswietlWszystkieSKladniki() {

        for (Skladnik value : values()) {
            if (value.equals(BRAK)) {
                continue;
            }
            System.out.println(value.id + " " + value);

        }
    }

    public static int ileJestSkladnikow() {

        return values().length - 1;
    }

    public boolean czySos(){

        return name().startsWith("SOS");

    }
    //skladniki do pizzy +id ich


}

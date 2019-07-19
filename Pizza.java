package Obiektowe.pizzeria_pelnia_program;

import java.util.ArrayList;

public class Pizza {

    private ArrayList<Rodzaj> skladowa;
    private Wielkosc wielkosc;


    public Pizza(Wielkosc wielkosc, ArrayList<Rodzaj> skladowa) {
        this.wielkosc = wielkosc;
        this.skladowa = skladowa;
        posortujSkladnikiZmienione();

    }

    private void posortujSkladnikiZmienione() {
        for (Rodzaj rodzaj : skladowa) {
            Utils.sortByValue(rodzaj.getSkladnikiZmienione());
        }
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "skladowa=" + skladowa +
                ", wielkosc=" + wielkosc +
                '}';
    }



    public String generujWyswietlenieDlaKuchni() {
        Rodzaj rodzajPierwszej = skladowa.get(0);
        StringBuilder wyswietlenie = new StringBuilder();
        wyswietlenie.append(wielkosc.getId()).append(rodzajPierwszej.getTyp().getIdPizzy());
        if (!czyPolNaPol()) {
            wyswietlenie.append("\n");
            wyswietlenie.append(rodzajPierwszej.generujWyswietlenieRodzajuDlaKuchni());
            return wyswietlenie.toString();
        } else {
            Rodzaj rodzajDrugiej = skladowa.get(1);

            wyswietlenie.append("/").append(rodzajDrugiej.getTyp().getIdPizzy()).append("\n");
            wyswietlenie.append(rodzajPierwszej.generujWyswietleniePolNaPolDlaKuchni(rodzajDrugiej));
//            wyswietlenie.append(rodzajPierwszej.generujSkladnikiUzytkownikowi());
//            wyswietlenie.append((rodzajDrugiej.generujSkladnikiUzytkownikowi()));
            return wyswietlenie.toString(); //TODO!!!!!!!!!! generujWyswietlaniePolNaPolDlaKuchni(){}
        }
    }

    public boolean czyPolNaPol() {
        return skladowa.size() == 2;
    }


    /*public String toString() {
        return "Pizza{" +
                "skladowa=" + skladowa +
                ", wielkosc=" + wielkosc +
                '}';
    }*/
}

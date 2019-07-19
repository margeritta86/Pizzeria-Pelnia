package Obiektowe.pizzeria_pelnia_program;

import java.util.ArrayList;

public class GeneratorZamowienia {

    private FabrykaPizzy fabryka;
    private Ankieter ankieter;
    private MenagerZamowien menager;

    GeneratorZamowienia(FabrykaPizzy fabryka, Ankieter ankieter, MenagerZamowien menager) {
        this.fabryka = fabryka;
        this.ankieter = ankieter;
        this.menager = menager;

    }

    public Zamowienie przyjmijZamowienie() {
        Zamowienie zamowienie = new Zamowienie(ankieter.podajNumerZamowienia());
        do {
            Pizza pizza = zamowPizze();
            zamowienie.dodajPizze(pizza);
            System.out.println("Stworzono pizzę...\nDodaję pizzę...");//
        } while (ankieter.czyDodacKolejnaPizze());
        zamowDodatki(zamowienie);
        zamowienie.generowaniePrzewidywanejGodzinyZamowienia(ankieter.podajPrzewidywanyczasRealizacjiZamowienia());
        System.out.println("Zamowienie gotowe");//

        if (!zatwierdzZamowienie(zamowienie)) {
            zamowienie = przyjmijZamowienie();
        }

        System.out.println("Wyświetlenie dla kuchni: \n");
        System.out.println(zamowienie.generujWyswietlenieZamowieniaDlaKuchni());
        menager.dodajZamowienie(zamowienie);
        return zamowienie;
    }

    public Pizza zamowPizze() {

        ArrayList<Rodzaj> rodzaje = new ArrayList<>();
        Wielkosc wielkosc = ankieter.czyDuzaCzyMala();
        boolean czyPolNaPol = false;
        if (wielkosc.equals(Wielkosc.DUZA)) {
            if (czyPolNaPol = ankieter.czyPolNaPol()) {
                rodzaje.add(przygotujRodzajPizzy(czyPolNaPol));
            }
        }
        rodzaje.add(przygotujRodzajPizzy(czyPolNaPol));
        skorygujPoprawnoscPizzy(rodzaje);


        //TODO wyświetlanie całego zamówienia
        //POL/POL
        // 12 -buraki + parmezan/13 - rukola + boczek + kapary
        // 316

        return new Pizza(wielkosc, rodzaje);

    }

    public void zamowDodatki(Zamowienie zamowienie) {
        ankieter.dodajDodatki(zamowienie);

    }

    public boolean zatwierdzZamowienie(Zamowienie zamowienie) {
        ankieter.wyswietylZamowienie(zamowienie);
        return ankieter.czyZatwierdzicZamowienie();
    }

    public Rodzaj przygotujRodzajPizzy(boolean czyPolNaPol) {
        Typ typ = ankieter.jakiTypPizzy();
        if (czyPolNaPol && typ.equals(Typ.GRUSZKA_E_LAZUR)) {
            System.err.println("Pizzy Gruszka e lazur nie robimy pół na pół!");
            return przygotujRodzajPizzy(czyPolNaPol);
        }
        Rodzaj rodzaj = new Rodzaj(typ);
        ankieter.czyZmodyfikowacSkladniki(rodzaj);
        return rodzaj;

    }

    public void skorygujPoprawnoscPizzy(ArrayList<Rodzaj> rodzaje) {

        if (rodzaje.size() != 2) {
            return;
        }
        Rodzaj rodzajPierwszej = rodzaje.get(0);
        Rodzaj rodzajDrugiej = rodzaje.get(1);
        boolean sosPierwszyBialy = rodzajPierwszej.getSosy().contains(Skladnik.SOS_BIALY_DO_PIZZY);
        boolean sosDrugiBialy = rodzajDrugiej.getSosy().contains(Skladnik.SOS_BIALY_DO_PIZZY);

        if (sosPierwszyBialy == sosDrugiBialy) {
            return;
        }
        Skladnik sos = ankieter.zapytajKtorySosZostawic();
        rodzajPierwszej.zamienSosy(sos);
        rodzajDrugiej.zamienSosy(sos);

    }
    //toString zamowienie,enumy, 
}

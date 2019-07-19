package Obiektowe.pizzeria_pelnia_program;

import Obiektowe.program_do_pizzerii.Skladniki;

import java.util.ArrayList;

public class Ankieter {

    private UpgradedScanner scanner = new UpgradedScanner();


    public boolean czyDodacKolejnaPizze() {

        return scanner.poprosOZatwierdzenie("Czy chcesz dodać kolejną pizzę do zamowienia?");
    }

    public boolean czyZatwierdzicZamowienie() {

        return scanner.poprosOZatwierdzenie("Czy chcesz zatwierdzić zamówienie?");
    }

    public void wyswietylZamowienie(Zamowienie zamowienie) {
        System.out.println(zamowienie.generujWyswietlenieZamowieniaDlaKuchni());


    }

    public Wielkosc czyDuzaCzyMala() {
        if (scanner.poprosOZatwierdzenie("Czy duża pizza?")) {
            return Wielkosc.DUZA;
        }
        return Wielkosc.MALA;
    }

    public boolean czyPolNaPol() {

        return scanner.poprosOZatwierdzenie("Czy pizza pół na pół?");

    }

    public Typ jakiTypPizzy() {
        Typ.wyswietlTypZId();
        return Typ.znajdzPoId(scanner.dajLiczbe("Podaj numer pizzy:"));

    }

    public void czyZmodyfikowacSkladniki(Rodzaj rodzaj) {
        dodajSkladniki(rodzaj);
        odejmijSkladniki(rodzaj);
    }


    public void dodajSkladniki(Rodzaj rodzaj) {
        ArrayList<Skladnik> listaDodanych = new ArrayList<>();

        int nrSkladnika;
        if (!scanner.poprosOZatwierdzenie("Czy dodać składniki?")) {
            return;

        }

        do {
            Skladnik.wyswietlWszystkieSKladniki();
            nrSkladnika = scanner.dajLiczbe("Który składnik dodać?");
            if (nrSkladnika >= 0 && nrSkladnika <= Skladnik.ileJestSkladnikow()) {
                listaDodanych.add(Skladnik.znajdzPoId(nrSkladnika));

            }


        } while (scanner.poprosOZatwierdzenie("Czy dodać kolejny składnik?"));
        for (Skladnik dodane : listaDodanych) {
            System.out.println(dodane);
        }
        if (scanner.poprosOZatwierdzenie("Czy dodane składniki się zgadzają?")) {
            rodzaj.dodajSkladniki(listaDodanych);

        } else {
            dodajSkladniki(rodzaj);
        }


    }

    public void odejmijSkladniki(Rodzaj rodzaj) {
        ArrayList<Skladnik> listaOdjetych = new ArrayList<>();

        int nrSkladnika;
        if (!scanner.poprosOZatwierdzenie("Czy odjąć składniki?")) {
            return;

        }

        do {
            System.out.println("Oryginalne składniki pizzy to:\n");
            System.out.println(rodzaj.wygenerujSkladnikiOryginalne());
            nrSkladnika = scanner.dajLiczbe("Który składnik odjąć?");
            if (nrSkladnika >= 0 && nrSkladnika <= Skladnik.ileJestSkladnikow()) {
                listaOdjetych.add(Skladnik.znajdzPoId(nrSkladnika));

            }


        } while (scanner.poprosOZatwierdzenie("Czy odjąć kolejny składnik?"));
        for (Skladnik odjete : listaOdjetych) {
            System.out.println(odjete);
        }
        if (scanner.poprosOZatwierdzenie("Czy odjęte składniki się zgadzają?")) {
            rodzaj.odejmijSkladniki(listaOdjetych);

        } else {
            odejmijSkladniki(rodzaj);
        }


    }


    public void dodajDodatki(Zamowienie zamowienie) {
        ArrayList<Dodatek> listaDodanych = new ArrayList<>();

        int nrDodatku;
        if (!scanner.poprosOZatwierdzenie("Czy dodać dodatki?")) {
            return;

        }

        do {
            Dodatek.wyswietlWszystkieDodatki();
            nrDodatku = scanner.dajLiczbe("Który dodatek dodać?");
            if (nrDodatku >= 0 && nrDodatku <= Dodatek.ileJestDodatkow()) {
                listaDodanych.add(Dodatek.znajdzPoId(nrDodatku));

            }


        } while (scanner.poprosOZatwierdzenie("Czy dodać kolejny dodatek?"));
        for (Dodatek dodane : listaDodanych) {
            System.out.println(dodane);
        }
        if (scanner.poprosOZatwierdzenie("Czy dodane dodatki się zgadzają?")) {
            zamowienie.dodajDodatki(listaDodanych);

        } else {
            dodajDodatki(zamowienie);
        }


    }

    public Skladnik zapytajKtorySosZostawic() {

        char znak = scanner.dajZnak("Który sos zostawić:\n b - biały sos\n p - pomidorowy ");

        switch(znak){
            case 'b': return Skladnik.SOS_BIALY_DO_PIZZY;
            case 'p': return Skladnik.SOS_POMIDOROWY_DO_PIZZY;
            default: return zapytajKtorySosZostawic();

        }

    }



    public int podajNumerZamowienia(){
        return scanner.dajLiczbe("Podaj numer zamówienia: ");

    }

    public int podajPrzewidywanyczasRealizacjiZamowienia(){
        return scanner.dajLiczbe("Podaj przewidywany czas realizacji zamówienia( 15/30/45/60/75/90/120 minut ) :");
    }

}


//czy duza czy mala pizza
//czy pol na pol - jesli jest pizza jest mala to omijamy to pytanie
//typ pizzy - jesli pizza pol na pol to dwa typy pizzy
//czy odejmujemy skladniki
//czy dodajemy skladniki
//czy sos do tego


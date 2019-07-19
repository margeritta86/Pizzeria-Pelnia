package Obiektowe.pizzeria_pelnia_program;

import java.util.ArrayList;

public class Interfejs {


    private ArrayList<Zamowienie> otwarte;
    private ArrayList<Zamowienie> zamkniete;
    private ArrayList<String> opcje;
    private GeneratorZamowienia generatorZamowienia;
    private UpgradedScanner scanner = new UpgradedScanner();
    private boolean programDziala = true;
    private MenagerZamowien menager;


    Interfejs() {
        FabrykaPizzy fabryka = new FabrykaPizzy();
        Ankieter ankieter = new Ankieter();
        menager = new MenagerZamowien();
        otwarte = new ArrayList<>();
        zamkniete = new ArrayList<>();
        generatorZamowienia = new GeneratorZamowienia(fabryka, ankieter,menager);
        wygenerujOpcje();
    }

    private void wygenerujOpcje() {
        opcje = new ArrayList<>();
        opcje.add("Dodaj zamówienie.");
        opcje.add("Wyświetl aktywne zamowienia.");
        opcje.add("Wyświetl zamknięte zamówienia.");
        opcje.add("Zakończ program");
    }


    public void uruchom() {

        do {
            wyswietlOpcje();
            wybierzOpcje(pobierzWyborOpcji());

        } while (programDziala);


    }

    public void wyswietlOpcje() {


        for (int i = 0; i < opcje.size(); i++) {
            String opcja = opcje.get(i);
            System.out.printf("%d. %s\n", i + 1, opcja);

        }

    }

    public int pobierzWyborOpcji() {

        return scanner.wybierzOpcje(opcje.size());

    }

    public void wybierzOpcje(int wybor) {
        switch (wybor) {
            case 1: dodajZamowienie();
                break;
            case 2: //wyswietlAktywneZamowienia();
                break;
            case 3:
                //wyswietlZamknieteZamowienia();
                break;
            case 4:
                zamknijProgram();
                break;
        }
    }

    public void dodajZamowienie() {
generatorZamowienia.przyjmijZamowienie();

    }

    public void wyswietlAktywneZamowienia() {
        System.out.println("Zamówione pizze: ");


    }

    public void wyswietlZamknieteZamowienia() {


    }

    public void zamknijProgram() {
        if (!scanner.poprosOZatwierdzenie("Czy na pewno chcesz zamknąć program?")) {

            return;
        }
        wyswietlAktywneZamowienia();
        System.out.println("Program zakończono.");
        programDziala = false;


        //wyswietlpodsumowanie ilosci sprzedanych duzych pizz, małych

    }


}

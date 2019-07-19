package Obiektowe.pizzeria_pelnia_program;

import java.util.Scanner;

public class UpgradedScanner {


    public Scanner scanner = new Scanner(System.in);


    // pobranie tekstu
    public String dajTekst(String pytanie) {
        System.out.println(pytanie);
        return scanner.nextLine();
    }

    // pobranie znaku
    public char dajZnak(String pytanie) {
        System.out.println(pytanie);
        String odpowiedz = scanner.nextLine();
        if (odpowiedz.isEmpty()) {
            return ' ';
        }
        return odpowiedz.charAt(0);
    }


    // zatrzymanie programu do wcisniecia entera
    public void zaczekajNaEnter() {
        System.out.println("Naciśnij <ENTER> aby kontynuować");
        scanner.nextLine();
    }

    // odpowiedz tak/nie
    public boolean poprosOZatwierdzenie(String pytanie) {
        char odpowiedz = dajZnak(pytanie + " Odpowiedz literą t/n:");
        return odpowiedz == 't' || odpowiedz == 'T';
    }

    public int dajLiczbe(String pytanie) {
        System.out.println(pytanie);
        String bycMozeLiczba = scanner.nextLine();
        char[] znaki = bycMozeLiczba.toCharArray();
        StringBuilder naPewnoLiczba = new StringBuilder();
        for (char znak : znaki) {
            if (Character.isDigit(znak)) {
                naPewnoLiczba.append(znak);
            }
        }
        if (naPewnoLiczba.toString().isEmpty()) {
            return -1;
        } else {
            return Integer.parseInt(naPewnoLiczba.toString());
        }
    }

    //wybierz opcje

    public int wybierzOpcje(int iloscOpcji) {
        int wybranaOpcja = dajLiczbe("Wybierz opcje:");
        if (wybranaOpcja > iloscOpcji || wybranaOpcja < 1) {
            System.out.println("Nie ma takiej opcji. Spróbój jeszcze raz.");
            wybranaOpcja = wybierzOpcje(iloscOpcji);
        }
        return wybranaOpcja;

    }


    // pobranie liczby


}


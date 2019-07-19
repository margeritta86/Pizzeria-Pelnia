package Obiektowe.pizzeria_pelnia_program;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Zamowienie {

    private ArrayList<Pizza> pizzas = new ArrayList<>();
    private int numer;
    private ArrayList<Dodatek> dodatki = new ArrayList<>();
    private LocalDateTime dataIGodzina = LocalDateTime.now();
    private DateTimeFormatter Formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy ' ' hh:mm a");
    private LocalDateTime przewidywanaGodzinaZamowienia;

    public Zamowienie(int numer) {
        this.numer = numer;
    }

    public void dodajPizze(Pizza pizza) {
        pizzas.add(pizza);

    }

    public void dodajDodatek(Dodatek dodatek) {
        dodatki.add(dodatek);

    }

    public void dodajDodatki(ArrayList<Dodatek> dodatki) {
        this.dodatki.addAll(dodatki);
    }



    public String generujWyswietlenieZamowieniaDlaKuchni() {
        StringBuilder wyswietlenie = new StringBuilder();

        wyswietlenie.append(generowanieFormatuDatyIGodziny(dataIGodzina)).append("\n");
        wyswietlenie.append("Przewidywany czas zrealizowania zamówienia: \n");
        wyswietlenie.append(generowanieFormatuDatyIGodziny(przewidywanaGodzinaZamowienia)).append("\n");
        wyswietlenie.append("nr zamówienia: ").append(numer).append("\n");
        wyswietlenie.append("ilość pizz: ").append(pizzas.size()).append("\n\n");

        for (Pizza pizza : pizzas) {
            wyswietlenie.append(pizza.generujWyswietlenieDlaKuchni()).append("\n");

        }
        if (!dodatki.isEmpty()) {
            wyswietlenie.append("Dodatki: \n");

            for (Dodatek dodatek : dodatki) {
                wyswietlenie.append(dodatek.getNazwa()).append("\n");
            }
        }
        return wyswietlenie.toString();
    }

    public LocalDateTime generowaniePrzewidywanejGodzinyZamowienia(int czasWMinutach) {


        return przewidywanaGodzinaZamowienia = dataIGodzina.plusMinutes(czasWMinutach);

    }

    public String generowanieFormatuDatyIGodziny(LocalDateTime dataigodzina) {
        String nowaDataiGodzina = Formatter.format(dataigodzina);
        return nowaDataiGodzina;
    }

    @Override
    public String toString() {
        return "Zamowienie:" +
                "pizza: " + pizzas +
                "\nnumer: " + numer +
                "\ndodatki=" + dodatki;
    }
}

//TODO przewidywany czas zamowienia (15min/30/45/60/75/90-2h)

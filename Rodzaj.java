package Obiektowe.pizzeria_pelnia_program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rodzaj {

    private List<Skladnik> skladniki;
    private Map<Skladnik, Character> skladnikiZmienione;
    private Typ typ;
//TODO dodać mapę i sortowanie

    public Rodzaj(Typ typ) {
        skladniki = typ.getSkladniki();
        this.typ = typ;
        skladnikiZmienione = new HashMap<>();

    }


    public void dodajSkladnik(Skladnik skladnik) {
        skladnikiZmienione.put(skladnik, '+');

    }


    public void odejmijSkladnik(Skladnik skladnik) {
        skladniki.remove(skladnik);
        skladnikiZmienione.put(skladnik, '-');

    }

    public void dodajSkladniki(ArrayList<Skladnik> listaSkladnikow) {
        for (Skladnik skladnik : listaSkladnikow) {
            skladnikiZmienione.put(skladnik, '+');
        }
    }

    public void odejmijSkladniki(ArrayList<Skladnik> listaSkladnikow) {

        skladniki.removeAll(listaSkladnikow);
        for (Skladnik skladnik : listaSkladnikow) {
            skladnikiZmienione.put(skladnik, '-');
        }
    }

    public String wygenerujSkladnikiOryginalne() {
        return wygenerujSkladniki(typ.getSkladniki());
    }

    private String wygenerujSkladniki(ArrayList<Skladnik> listaSkladnikow) {
        StringBuilder wyswietlenie = new StringBuilder();

        for (Skladnik skladnik : listaSkladnikow) {
            wyswietlenie.append(skladnik.getId()).append(" ").append(skladnik).append("\n");

        }

        return wyswietlenie.toString();

    }


    @Override
    public String toString() {
        return "Rodzaj{" +
                "skladniki=" + skladniki +
                ", typ=" + typ +
                '}';
    }

    public ArrayList<Skladnik> getSosy() {
        ArrayList<Skladnik> sosy = new ArrayList<>();
        for (Skladnik skladnik : skladniki) {
            if (skladnik.czySos()) {
                sosy.add(skladnik);
            }
        }

        return sosy;
    }

    public void zamienSosy(Skladnik sos) {

        switch (sos) {
            case SOS_POMIDOROWY_DO_PIZZY:
                odejmijSkladnik(Skladnik.SOS_BIALY_DO_PIZZY);
                dodajSkladnik(sos);
                break;
            case SOS_BIALY_DO_PIZZY:
                odejmijSkladnik(Skladnik.SOS_POMIDOROWY_DO_PIZZY);
                dodajSkladnik(sos);
                break;
        }


    }

    public String generujWyswietlenieRodzajuDlaKuchni() {
        StringBuilder wyswietlenie = new StringBuilder();
        wyswietlenie.append(typ.getNazwaPizzy()).append("\n");


        for (Skladnik skladnik : skladnikiZmienione.keySet()) {
            wyswietlenie.append(skladnikiZmienione.get(skladnik)).append(" ").append(skladnik).append("\n");
        }
        return wyswietlenie.toString();
    }

    public String generujWyswietleniePolNaPolDlaKuchni(Rodzaj rodzajDrugiej) {
        StringBuilder wyswietlenie = new StringBuilder();

        List<String> lines = new ArrayList<>();
        wyswietlenie.append(String.format("%-26s%-26s\n", typ.getNazwaPizzy(), rodzajDrugiej.getTyp().getNazwaPizzy()));
        Map<Skladnik, Character> skladnikiZmienione2 = rodzajDrugiej.skladnikiZmienione;
        for (Skladnik skladnik : skladnikiZmienione.keySet()) {
            lines.add(String.format("%2s %-23s",skladnikiZmienione.get(skladnik),skladnik));
        }
        int index = 0;
        for (Skladnik skladnik : skladnikiZmienione2.keySet()) {
            if (index >= lines.size()) {
                lines.add(String.format("%26s%2s %-23s\n","",  skladnikiZmienione.get(skladnik),skladnik));

            } else {
                lines.set(index, lines.get(index) + String.format("%2s %-23s\n",skladnikiZmienione2.get(skladnik),skladnik));
            }
            index++;
        }

        for (int i = 0; i < lines.size(); i++) {
            if (!lines.get(i).endsWith("\n")) {
                lines.set(i, lines.get(i) + "\n");
            }
        }

        for (String line : lines) {
            wyswietlenie.append(line);
        }

        return wyswietlenie.toString();
    }


    public Typ getTyp() {
        return typ;
    }

    /*public String toString() {
        return "Rodzaj{" +
                "skladniki=" + skladniki +
                ", typ=" + typ +
                '}';
    }*/

    public Map<Skladnik, Character> getSkladnikiZmienione() {
        return skladnikiZmienione;
    }
}

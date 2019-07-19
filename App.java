package Obiektowe.pizzeria_pelnia_program;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        ZapisDoPliku.zapiszZamowienie("zamowienie2","Oto zamówienie, które jest gotowe" );

        Interfejs interfejs = new Interfejs();
        interfejs.uruchom();

    }
}

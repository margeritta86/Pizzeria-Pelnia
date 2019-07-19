package Obiektowe.pizzeria_pelnia_program;

import java.io.FileWriter;
import java.io.IOException;

public class ZapisDoPliku {

    public static void zapiszZamowienie(String zamowienie, String trescZamowienia) throws IOException {

        FileWriter writer = new FileWriter(String.format("%s.txt", zamowienie));
        writer.write(trescZamowienia);
        writer.close();



    }


}

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String ODDELOVAC = "";

    public static void main(String[] args) throws Exception {
        List<Zakaznik> zaznamy = new ArrayList<>();
        zaznamy.add(new Zakaznik("Karel Dvořák", 45
        ));
        zaznamy.add(new Zakaznik("Petr Pavel", 69
        ));

        //Metoda pro odebrání posledního zákazníka
        zaznamy.remove(zaznamy.size()-1);

        //Metoda pro zvýšení prodejů u prvního zákazníka
        zaznamy.get(0).zvysPocetProdeju(2);

        //Zápis do souboru
        writeToFile(zaznamy, "seznam.txt",":");
    }
    private static void writeToFile(List<Zakaznik> seznam, String soubor, String ODDELOVAC){
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(soubor))
        )) {
            for (Zakaznik z : seznam){
                pw.println(
                        z.getJmeno()+ODDELOVAC+z.getPocetProdeju());
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

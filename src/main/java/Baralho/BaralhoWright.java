package Baralho;
import java.util.ArrayList;
import java.util.List;

public class BaralhoWright implements Baralho {
    public static List<Carta> criaBaralhoWright() {
        Carta ShaunOfTheDead = new Carta("Todo Mundo Quase Morto", 2004, 99, 4.0, 30.0);
        Carta HotFuzz = new Carta("Chumbo Grosso", 2007, 121, 14.0, 80.7);
        Carta ScottPilgrim = new Carta("Scott Pilgrim", 2010, 112, 77.5, 49.3);
        Carta TheWorldsEnd = new Carta("Heróis de Ressaca", 2013, 109, 20.0, 46.1);
        Carta BabyDriver = new Carta("Em Ritmo de Fuga", 2007, 113, 34.0, 226.9);
        Carta LastNightInSoho = new Carta("Noite Passada em Soho", 2021, 116, 43.0, 23.0);
        return new ArrayList<>(List.of(ShaunOfTheDead, HotFuzz, ScottPilgrim, TheWorldsEnd, BabyDriver, LastNightInSoho));
    }

}
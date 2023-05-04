package Baralho;
import java.util.ArrayList;
import java.util.List;

public class BaralhoTarantino implements Baralho {
    public static List<Carta> criaBaralhoTarantino() {
        Carta ReservoirDogs = new Carta("Cães de Alguel", 1992, 99, 3.0, 2.9);
        Carta PulpFiction = new Carta("Pulp Fiction", 1994, 154, 8.5, 213.9);
        Carta JackieBrown = new Carta("Jackie Brown", 1997, 152, 12.0, 74.7);
        Carta KillBill1 = new Carta("Kill Bill Vol.1", 2003, 111, 30.0, 180.9);
        Carta KillBill2 = new Carta("Kill Bill Vol.2", 2004, 137, 31.0, 152.2);
        Carta DeathProof = new Carta("À Prova de Morte", 2007, 113, 29.0, 31.1);
        return new ArrayList<>(List.of(ReservoirDogs, PulpFiction, JackieBrown, KillBill1, KillBill2, DeathProof));
    }

}


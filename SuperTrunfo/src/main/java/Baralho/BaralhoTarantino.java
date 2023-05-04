package Baralho;

import Mecanica.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaralhoTarantino implements Baralho{

    public static List<Carta> criaBaralhoCompleto(){

        Carta ReservoirDogs = new Carta("Cães de Alguel", 1992, 99, 3.0,2.9);
        Carta PulpFiction = new Carta("Pulp Fiction", 1994, 154, 8.5, 213.9);
        Carta JackieBrown  = new Carta("Jackie Brown", 1997, 152, 12.0,74.7);
        Carta KillBill1 = new Carta("Kill Bill Vol.1", 2003, 111, 30.0, 180.9);
        Carta KillBill2 = new Carta("Kill Bill Vol.2", 2004, 137, 31.0, 152.2);
        Carta DeathProof = new Carta("À Prova de Morte", 2007, 113, 29.0, 31.1);
        return new ArrayList<>(List.of(ReservoirDogs,PulpFiction, JackieBrown, KillBill1, KillBill2, DeathProof));
    }

    public static void daAsCartas(List<Carta> baralho, List<Carta>  cartasJog, List<Carta> cartasPC, Player jogador1, Player jogadorPC){
        int marcador=0;
        Integer[] cartasNaMao = {0, 0};
        do {
            int cont = new Random().nextInt(baralho.size());
            if (marcador==0) {
                cartasJog.add(baralho.get(cont));
                cartasNaMao[marcador]++;
                marcador=1;
            } else {
                cartasPC.add(baralho.get(cont));
                cartasNaMao[marcador]++;
                marcador=0;
            }
            baralho.remove(cont);
        } while (baralho.size() != 0);
//        System.out.println("Cartas do Jogador: \n" + cartasJog);
//        System.out.println("Cartas do PC: \n" + cartasPC);
        jogador1.setCartasNaMao(cartasNaMao[0]);
        jogadorPC.setCartasNaMao(cartasNaMao[1]);
    }
}


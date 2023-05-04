package Baralho;

import Mecanica.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface Baralho {

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


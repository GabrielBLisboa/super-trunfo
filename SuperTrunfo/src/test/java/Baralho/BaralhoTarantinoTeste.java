package Baralho;
import Mecanica.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Baralho.BaralhoTarantino.criaBaralhoCompleto;
import static Baralho.BaralhoTarantino.daAsCartas;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.ArrayList;
import java.util.List;

public class BaralhoTarantinoTeste {
    static Player jogador1, jogadorPC;
    static List<Carta> baralho, cartasJog, cartasPC;

    @BeforeEach
    public void setup(){
        jogador1 = new Player("Jogador 1", 0);
        jogadorPC = new Player("Computador", 0);
        cartasJog = new ArrayList<>();
        cartasPC = new ArrayList<>();
        baralho = criaBaralhoCompleto();
    }

   @Test
    public void baralhoFoiCriadoTeste(){
       assertNotNull(baralho);
//       O baralho foi criado portanto dever� ter 6 cartas
       System.out.println("O baralho possui: " + baralho.size() + " cartas");
    }

    @Test
    public void deuAsCartasTeste(){
        daAsCartas(baralho, cartasJog, cartasPC, jogador1, jogadorPC);
//        O baralho dever� estar zerado porque as cartas foram distribu�das igualmente entre os jogadores
        assertEquals(0, baralho.size());
        assertEquals(3, (int) jogador1.getCartasNaMao());
        assertEquals(3, (int) jogadorPC.getCartasNaMao());
    }
}

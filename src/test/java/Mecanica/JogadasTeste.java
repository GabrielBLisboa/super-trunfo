package Mecanica;
import Baralho.Carta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Baralho.Baralho.*;
import static Baralho.BaralhoTarantino.criaBaralhoTarantino;
import static Mecanica.Jogadas.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;


public class JogadasTeste{
    Player jogador1, jogadorPC;
    List<Carta> baralho, cartasJog, cartasPC;

    private final InputStream systemIn = System.in;

    @BeforeEach
    public void setup() {
        jogador1 = new Player("Jogador 1", 0);
        jogadorPC = new Player("Computador", 0);
        cartasJog = new ArrayList<>();
        cartasPC = new ArrayList<>();
        baralho = criaBaralhoTarantino();
    }
    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void sortearQuemComecaTeste(){
        int cont=0;
        int pcFoiEscolhido = 0, jogadorFoiEscolhido = 0;

        do {
            sortearQuemComeca();
            cont++;
            if (marcador == 1){
                pcFoiEscolhido++;
            } else{
                jogadorFoiEscolhido++;
            }
        }while (cont<10);

//  O pc e o jogador foram sorteados para começar pelo menos 1
        assertTrue(pcFoiEscolhido>0);
        assertTrue(jogadorFoiEscolhido>0);
    }

    @Test
    public void pcEscolheAtributoTeste(){
        int cont = 0;
        daAsCartas(baralho, cartasJog, cartasPC, jogador1, jogadorPC);
        marcador = 1;
        do {
            cont++;
            quemEscolheAtributo();
            assertTrue(atributo<6 && atributo>0);
            System.out.println(atributo);
        }while (cont<10);
    }

    @Test
    public void jogadorEscolheAtributo(){
        int cont = 0;
        daAsCartas(baralho, cartasJog, cartasPC, jogador1, jogadorPC);
        marcador = 0;
        String[] teste = {"1","2","3","4","5"};
//        do {
            cont++;
            int num = new Random().nextInt(1,7);
            provideInput(teste[num-1]);
            quemEscolheAtributo();
            assertTrue(atributo<6 && atributo>0);
            System.out.println(atributo);
//        }while (cont<10);
    }
    @Test
    public void jogadorEscolheAtributoERROdeFormato(){
        int cont = 0;
        daAsCartas(baralho, cartasJog, cartasPC, jogador1, jogadorPC);
        marcador = 0;
        String teste = "palavra";
        provideInput(teste);
        InputMismatchException thrown = assertThrows(InputMismatchException.class, Jogadas::quemEscolheAtributo);
        assertTrue(thrown.getMessage().contentEquals("\nVocê deve digitar um número entre 1 e 5"));
        System.out.println(atributo);
    }
}

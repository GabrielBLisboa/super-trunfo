package Main;

import Baralho.*;
import Mecanica.*;

import java.util.ArrayList;
import java.util.List;
import static Baralho.BaralhoTarantino.criaBaralhoCompleto;
import static Baralho.BaralhoTarantino.daAsCartas;
import static Mecanica.Jogadas.*;

public class Main {

/*

- Criar um baralho com 8 cartas pr�-definidas.
- Criar 2 jogadores -> Jogador e PC.
- Distribuir aleatoriamente 4 cartas para os dois jogadores.
- Sortear quem come�a.
- Comprar 1 carta aleat�ria para cada um.
- Quem come�a escolhe um atributo da carta comprada (o computador escolhe aleatoriamente).
- Comparar o atributo de ambas as cartas. O n�mero maior vence.
- Quem vencer:
            Ganha a carta do oponente. As duas cartas em jogo v�o para o fim do baralho do vencedor.
            Escolhe o pr�ximo atributo.
- O jogo � encerrado quando um dos jogadores ficar com 0 cartas

 */

    public static void main(String[] args) {
//        DisplayImage();

        Player jogador1, jogadorPC;
        jogador1 = new Player("Humano", 0);
        jogadorPC = new Player("Computador", 0);

        List<Carta> baralho, cartasJog, cartasPC;

        cartasJog = new ArrayList<>();
        cartasPC = new ArrayList<>();

        baralho = criaBaralhoCompleto();

        daAsCartas(baralho, cartasJog, cartasPC, jogador1, jogadorPC);

        sortearQuemComeca();

        while(!verificaVitoria(cartasJog, cartasPC, jogador1, jogadorPC)){

            cartaNaMaoDoJogador(cartasJog);
            quemEscolheAtributo();

            Double[] valorDoAtributo = pegaValorDoAtributo(cartasJog,  cartasPC);

            comparaAtributo(cartasJog,  cartasPC,  valorDoAtributo);

//            System.out.println("Cartas do Jogador: \n" + cartasJog);
//            System.out.println("Cartas do PC: \n" + cartasPC);
//            System.out.println(jogador1.getCartasNaMao());
//            System.out.println(jogadorPC.getCartasNaMao());
        }
    }
}

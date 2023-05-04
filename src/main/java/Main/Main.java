package Main;

import Baralho.*;
import Mecanica.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static Baralho.Baralho.daAsCartas;
import static Baralho.BaralhoTarantino.*;
import static Baralho.BaralhoWright.criaBaralhoWright;
import static Mecanica.Jogadas.*;

public class Main {

/*

- Criar um baralho com 8 cartas pré-definidas.
- Criar 2 jogadores -> Jogador e PC.
- Distribuir aleatoriamente 4 cartas para os dois jogadores.
- Sortear quem começa.
- Comprar 1 carta aleatória para cada um.
- Quem começa escolhe um atributo da carta comprada (o computador escolhe aleatoriamente).
- Comparar o atributo de ambas as cartas. O número maior vence.
- Quem vencer:
            Ganha a carta do oponente. As duas cartas em jogo vão para o fim do baralho do vencedor.
            Escolhe o próximo atributo.
- O jogo é encerrado quando um dos jogadores ficar com 0 cartas

 */

    public static void main(String[] args) throws EscolherBaralhoException {

        Player jogador1, jogadorPC;
        jogador1 = new Player("Humano", 0);
        jogadorPC = new Player("Computador", 0);

        List<Carta> baralho, cartasJog, cartasPC;

        cartasJog = new ArrayList<>();
        cartasPC = new ArrayList<>();

        System.out.println("Com qual baralho você deseja jogar?");
        System.out.println("------ Digite 1 ou 2 ------");
        int escolha = escolheBaralho();

        if (escolha==1){
            baralho = criaBaralhoTarantino();
            daAsCartas(baralho, cartasJog, cartasPC, jogador1, jogadorPC);
        } else if (escolha==2) {
            baralho = criaBaralhoWright();
            daAsCartas(baralho, cartasJog, cartasPC, jogador1, jogadorPC);
        }

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


        };

    public static int escolheBaralho(){
        System.out.println("1 - Quentin Tarantino ou 2 - Edgar Wright?");
        Scanner scan = new Scanner(System.in);
        int valor = 0;
        try {
            valor = scan.nextInt();
            checaEscolhaDoBaralho(valor);
        } catch (Exception InputMismatchException) {
            System.out.println("Digite 1 ou 2");
            escolheBaralho();
        }
        return valor;
    }

    static void checaEscolhaDoBaralho(int valor) throws EscolherBaralhoException{
            if (!(valor == 1 || valor == 2)) {
                throw new EscolherBaralhoException("Digite 1 ou 2");
            }
        }
}

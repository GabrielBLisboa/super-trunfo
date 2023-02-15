package Mecanica;

import Baralho.Carta;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jogadas {
 static int marcador = 0 ;
 static int atributo = 0;
 static boolean verifica = false;

    public static void sortearQuemComeca(){
        marcador = new Random().nextInt(2);
        if(marcador==0){
            System.out.println("O Jogador começa!");
            System.out.println("---------------------------------------------");
        } else{
            System.out.println("O PC começa!");
            System.out.println("---------------------------------------------");
        }
    }

    public static void cartaNaMaoDoJogador(List<Carta>  cartasJog){
        System.out.println("Carta na mão do Jogador: ");
        System.out.println(cartasJog.get(0));
    }

    public static void quemEscolheAtributo() {
        if (marcador == 0) {
            atributo = jogadorEscolheAtributo();
        } else if (marcador == 1) {
//              O atributo "escolhido" pelo PC é gerado aleatoriamente
            atributo = new Random().nextInt(1,6);
        }

    }

    public static int jogadorEscolheAtributo(){
        int atributo =0;

        System.out.println("Escolha um atributo - Digite o número!");
        System.out.println("1 - Ano");
        System.out.println("2 - Duração");
        System.out.println("3 - Orçamento");
        System.out.println("4 - Bilheteria");
        System.out.println("5 - Lucro");
        Scanner scan = new Scanner(System.in);

            try{
                atributo = scan.nextInt();
                checaEntrada(atributo);
            } catch (Exception InputMismatchException){
                System.out.println("\nVocê deve digitar um número entre 1 e 5");
                System.out.println("---------------------------------------------");
                jogadorEscolheAtributo();
            }
        return atributo;
    }

    static void checaEntrada(Integer atributo) throws MenuException {
        if (atributo>5){
            throw new MenuException("\n Você deve digitar um número entre 1 e 5");
        }
        else if (atributo<1){
            throw new MenuException("\n Você deve digitar um número entre 1 e 5");
        }
    }

    public static Double[] pegaValorDoAtributo(List<Carta>  cartasJog, List<Carta> cartasPC) {
        Carta cartaDaJogadaJog = cartasJog.get(0);
        Carta cartaDaJogadaPC = cartasPC.get(0);
        Double[] valorDoAtributo = {0.0,0.0};
        switch (atributo) {
            case 1 -> {
                valorDoAtributo[0] = (double) cartaDaJogadaJog.getAno();
                valorDoAtributo[1] = (double) cartaDaJogadaPC.getAno();
                System.out.println("O atributo escolhido foi ANO de produção");
            }
            case 2 -> {
                valorDoAtributo[0] = (double) cartaDaJogadaJog.getDuracao();
                valorDoAtributo[1] = (double) cartaDaJogadaPC.getDuracao();
                System.out.println("O atributo escolhido foi a DURAÇÃO");
            }
            case 3 -> {
                valorDoAtributo[0] = cartaDaJogadaJog.getOrcamento();
                valorDoAtributo[1] = cartaDaJogadaPC.getOrcamento();
                System.out.println("O atributo escolhido foi o ORÇAMENTO");
            }
            case 4 -> {
                valorDoAtributo[0] = cartaDaJogadaJog.getBilheteria();
                valorDoAtributo[1] = cartaDaJogadaPC.getBilheteria();
                System.out.println("O atributo escolhido foi a BILHETERIA");
            }
            case 5 -> {
                valorDoAtributo[0] = cartaDaJogadaJog.getLucro();
                valorDoAtributo[1] = cartaDaJogadaPC.getLucro();
                System.out.println("O atributo escolhido foi o LUCRO");
            }
        }
        System.out.println("---------------------------------------------");
        return valorDoAtributo;
    }

    public static void comparaAtributo(List<Carta>  cartasJog, List<Carta> cartasPC, Double[] valorDoAtributo){
        Carta cartaDaJogadaJog = cartasJog.get(0);
        Carta cartaDaJogadaPC = cartasPC.get(0);
        if (valorDoAtributo[0] > valorDoAtributo[1]){
            System.out.println("Jogador ganhou!\n");
            System.out.println("A Carta do PC era: ");
            System.out.println(cartaDaJogadaPC);
            transfereACarta(cartaDaJogadaPC, cartasPC, cartasJog);
            jogaCartaNoFim(cartasJog);
            marcador = 0;
        } else if (valorDoAtributo[1] > valorDoAtributo[0]){
            System.out.println("O PC ganhou!\n");
            System.out.println("A Carta do PC era: ");
            System.out.println(cartaDaJogadaPC);
            transfereACarta(cartaDaJogadaJog, cartasJog, cartasPC);
            jogaCartaNoFim(cartasPC);
            marcador = 1;
        }
    }

    public static void transfereACarta(Carta carta, List<Carta> cartasPerdedor, List<Carta> cartasVencedor){
        cartasVencedor.add(carta);
        cartasPerdedor.remove(carta);
    }

    public static void jogaCartaNoFim(List<Carta> cartasVencedor){
        int quantasCartas = cartasVencedor.size();
        Carta cartaNoTopo =  cartasVencedor.get(0);
        cartasVencedor.remove(0);
        cartasVencedor.add(quantasCartas -1,cartaNoTopo);
    }

    public static boolean verificaVitoria(List<Carta>  cartasJog, List<Carta> cartasPC, Player jogador1, Player jogadorPC){

        Scanner scan = new Scanner(System.in);

        jogador1.setCartasNaMao(cartasJog.size());
        jogadorPC.setCartasNaMao(cartasPC.size());
        System.out.println("Você tem + " + jogador1.getCartasNaMao() + " cartas na mão");
        System.out.println("O PC tem + " + jogadorPC.getCartasNaMao() + " cartas na mão");
        System.out.println("---------------------------------------------");

        System.out.println("Pressione ENTER para continuar");
        scan.nextLine();


        if (jogador1.getCartasNaMao() == 0 || jogadorPC.getCartasNaMao() == 0){
            verifica = true;
            System.out.println("O jogo acabou!");
        }
        return verifica;
    }
}


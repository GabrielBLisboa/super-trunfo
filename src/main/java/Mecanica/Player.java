package Mecanica;

public class Player {

    public Player(String nome, Integer cartasNaMao) {
        this.nome = nome;
        this.cartasNaMao = cartasNaMao;

    }

    String nome;
    Integer cartasNaMao;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCartasNaMao() {
        return cartasNaMao;
    }

    public void setCartasNaMao(Integer cartasNaMao) {
        this.cartasNaMao = cartasNaMao;
    }

}

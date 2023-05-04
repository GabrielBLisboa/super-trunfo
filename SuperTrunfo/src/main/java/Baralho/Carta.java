package Baralho;

public class Carta {

    public Carta(String nome, Integer ano, Integer duracao, Double orcamento, Double bilheteria) {
        this.nome = nome;
        this.ano = ano;
        this.duracao = duracao;
        this.orcamento = orcamento;
        this.bilheteria = bilheteria;
        this.lucro = Math.floor(((bilheteria - orcamento) * 100)/100);
    }

    String nome;
    Integer ano;
    Integer duracao;
    Double orcamento;
    Double bilheteria;
    Double lucro;



    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getBilheteria() {
        return bilheteria;
    }

    public void setBilheteria(Double bilheteria) {
        this.bilheteria = bilheteria;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getLucro() {
        return lucro;
    }

    public void setLucro(Double lucro) {
        this.lucro = lucro;
    }

    @Override
    public String toString() {
        return
                "___________________________\n"+
                " Carta:'" + nome + "' \n"+
                " Ano: " + ano + " \n"+
                " Duração: " + duracao + " minutos \n"+
                " Orçamento: " + orcamento + " milhões\n"+
                " Bilheteria: " + bilheteria + " milhões \n"+
                " Lucro: " + lucro + " milhões \n"+
                "___________________________\n";
    }
}

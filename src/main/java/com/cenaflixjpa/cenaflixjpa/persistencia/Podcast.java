package com.cenaflixjpa.cenaflixjpa.persistencia;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Podcast {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPodcast;
    private String produtor;
    private String nome;
    private String numero;
    private String duracao;
    private String url;
    
    public void transpose(Podcast podcast){
        this.produtor = podcast.getProdutor();
        this.nome = podcast.getNome();
        this.numero = podcast.getNumero();
        this.duracao = podcast.getDuracao();
        this.url = podcast.getUrl();
    }

    public Podcast() {
    }

    public boolean checkVazio(){
        if (this.produtor.isBlank() ||
            this.nome.isBlank() ||
            this.numero.isBlank() ||
            this.duracao.isBlank() ||
            this.url.isBlank()){
                return false;                
        } else {
                return true;
        }
    }

    public int getId() {
        return idPodcast;
    }

    public void setId(int id) {
        this.idPodcast = id;
    }

    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Podcast{" + "id=" + idPodcast + ", produtor=" + produtor + ", nome=" + nome + ", numero=" + numero + ", duracao=" + duracao + ", url=" + url + '}';
    }
    
}
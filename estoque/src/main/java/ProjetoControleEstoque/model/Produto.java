package ProjetoControleEstoque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private int quantidade;
    private double preco;

    public Produto() {

    }

    public Produto(String nome, String descricao, int quantidade, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // --- Getters ---
    public Long getId()
    {
        return id;
    }

    public String getNome()
    {
        return nome;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public int getQuantidade()
    {
        return quantidade;
    }

    public double getPreco ()
    {
        return preco;
    }

    // --- Setters ---
    public void setId(Long id)
    {
        this.id = id;
    }
    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }

    public void setQuantidade(int quantidade) {

        this.quantidade = quantidade;
    }

    public void setPreco(double preco) 
    {
        this.preco = preco;
    }

    @Override
    public String toString()
    {
        return "Produto{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", descricao='" + descricao + '\'' +
               ", quantidade=" + quantidade +
               ", preco=" + preco +
               '}';
    }
}



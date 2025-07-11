package ProjetoControleEstoque.service;

import ProjetoControleEstoque.model.Produto;
import ProjetoControleEstoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService 
{
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll()
    {
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long id)
    {
        return produtoRepository.findById(id);
    }

    public Produto save(Produto produto)
    {
        return produtoRepository.save(produto);
    }

    public void deleteById(Long id)
    {
        produtoRepository.deleteById(id);
    }

    public Produto update(Long id, Produto produtoAtualizado) {
        return produtoRepository.findById(id).map(produto -> {
            produto.setNome(produtoAtualizado.getNome());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setQuantidade(produtoAtualizado.getQuantidade());
            produto.setPreco(produtoAtualizado.getPreco());
            return produtoRepository.save(produto); 
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));
    }
}

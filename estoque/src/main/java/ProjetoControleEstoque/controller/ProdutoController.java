package ProjetoControleEstoque.controller;

import ProjetoControleEstoque.model.Produto; 
import ProjetoControleEstoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Endpoint GET para buscar todos os produtos
    // URL: GET http://localhost:8080/api/produtos
    @GetMapping 
    public List<Produto> getAllProdutos()
    {
        return produtoService.findAll();
    }

    // Endpoint GET para buscar um produto por ID
    // URL: GET http://localhost:8080/api/produtos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long Id)
    {
        return produtoService.findById(Id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint POST para criar um novo produto
    // URL: POST http://localhost:8080/api/produtos
    // Body: JSON do produto
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto createProduto(@RequestBody Produto produto)
    {
        return produtoService.save(produto);
    }

    // Endpoint PUT para atualizar um produto existente
    // URL: PUT http://localhost:8080/api/produtos/{id}
    // Body: JSON do produto com dados atualizados
    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produto)
    {
        try {
            Produto updatedProduto = produtoService.update(id, produto);
            return ResponseEntity.ok(updatedProduto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint DELETE para deletar um produto por ID
    // URL: DELETE http://localhost:8080/api/produtos/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduto(@PathVariable Long id)
    {
        produtoService.deleteById(id);
    }
}

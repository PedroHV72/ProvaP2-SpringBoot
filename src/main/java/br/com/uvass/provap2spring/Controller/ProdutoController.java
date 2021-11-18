package br.com.uvass.provap2spring.Controller;

import br.com.uvass.provap2spring.Model.Entity.Produto;
import br.com.uvass.provap2spring.Model.Repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private ProdutoRepository produtoRepository;

    public ProdutoController(JdbcTemplate jdbcTemplate) {
        produtoRepository = new ProdutoRepository(jdbcTemplate);
    }

    @CrossOrigin("*")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public ArrayList<Produto> buscarProdutos() throws Exception {
        return produtoRepository.buscarTodosProdutos();
    }
}

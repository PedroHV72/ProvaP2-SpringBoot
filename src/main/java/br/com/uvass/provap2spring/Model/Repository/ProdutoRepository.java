package br.com.uvass.provap2spring.Model.Repository;

import br.com.uvass.provap2spring.Model.Entity.Produto;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

public class ProdutoRepository {

    private JdbcTemplate jdbcTemplate;

    public ProdutoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArrayList<Produto> buscarTodosProdutos() throws Exception {
        String sql = "SELECT * FROM produto";
        ArrayList<Produto> buscar = (ArrayList<Produto>) jdbcTemplate.query(sql, new ProdutoMapper());

        if (buscar.size() > 0) {
            return (ArrayList<Produto>) jdbcTemplate.query(sql, new ProdutoMapper());
        }
        throw new Exception("Nenhum produto encontrado");
    }

}

package br.com.uvass.provap2spring.Model.Repository;

import br.com.uvass.provap2spring.Model.Entity.Parcela;
import br.com.uvass.provap2spring.Model.Entity.Produto;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

public class ProdutoRepository {

    private JdbcTemplate jdbcTemplate;
    private ParcelaRepository parcelaRepository;

    public ProdutoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.parcelaRepository = new ParcelaRepository(jdbcTemplate);
    }

    public ArrayList<Produto> buscarTodosProdutos() throws Exception {
        String sql = "SELECT * FROM produto";
        ArrayList<Produto> buscar = (ArrayList<Produto>) jdbcTemplate.query(sql, new ProdutoMapper());

        buscar.forEach(produto -> {
            Parcela parcela = parcelaRepository.procurarParcela(produto.getParcela_id());
            produto.setParcela(parcela);
        });

        if (buscar.size() > 0) {
            return buscar;
        }

        throw new Exception("Nenhum produto encontrado");
    }

}

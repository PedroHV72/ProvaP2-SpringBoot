package br.com.uvass.provap2spring.Model.Repository;

import br.com.uvass.provap2spring.Model.Entity.Parcela;
import br.com.uvass.provap2spring.Model.Entity.Produto;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoMapper implements RowMapper<Produto> {

    @Override
    public Produto mapRow(ResultSet resultSet, int i) throws SQLException {
        Produto produto = new Produto();
        Parcela parcela = new Parcela();
        produto.setId(resultSet.getInt("id"));
        produto.setName(resultSet.getString("nome"));
        produto.setDescription(resultSet.getString("descricao"));
        produto.setImage(resultSet.getString("fotoUrl"));
        produto.setOldPrice(resultSet.getFloat("precoAntigo"));
        parcela.setId(resultSet.getInt("id"));
        produto.setParcela(parcela);

        return produto;
    }
}

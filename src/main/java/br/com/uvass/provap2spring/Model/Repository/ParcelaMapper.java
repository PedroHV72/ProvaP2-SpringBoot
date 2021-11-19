package br.com.uvass.provap2spring.Model.Repository;

import br.com.uvass.provap2spring.Model.Entity.Parcela;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParcelaMapper implements RowMapper<Parcela> {
    @Override
    public Parcela mapRow(ResultSet resultSet, int i) throws SQLException {
        Parcela parcela = new Parcela();
        parcela.setId(resultSet.getInt("id"));
        parcela.setCount(resultSet.getInt("numeroParcela"));
        parcela.setValue(resultSet.getFloat("valorParcela"));
        return parcela;
    }
}

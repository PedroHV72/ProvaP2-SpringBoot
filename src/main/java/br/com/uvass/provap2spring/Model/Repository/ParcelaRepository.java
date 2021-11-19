package br.com.uvass.provap2spring.Model.Repository;

import br.com.uvass.provap2spring.Model.Entity.Parcela;
import org.springframework.jdbc.core.JdbcTemplate;

public class ParcelaRepository {

    private JdbcTemplate jdbcTemplate;

    public ParcelaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Parcela procurarParcela(int id) {
        String sql = "SELECT * FROM parcela WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new ParcelaMapper(), id);
    }
}

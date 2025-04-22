package com.entomologia.entomologiaProject.repository;

import com.entomologia.entomologiaProject.model.Coletor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ColetorRepository implements RepositoryPattern<Coletor> {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private RowMapper<Coletor> rowMapper = new RowMapper<Coletor>() {
        @Override
        public Coletor mapRow(ResultSet rs, int rowNum) throws SQLException {
            Coletor coletor = new Coletor();
            coletor.setIdColetor(rs.getLong("idColetor"));
            coletor.setNomeColetor(rs.getString("nomeColetor"));
            coletor.setCpfColetor(rs.getString("cpfColetor"));

            return coletor;
        }
    };

    @Override
    public void save(Coletor coletor) {
        String sql = "INSERT INTO coletor (nomeColetor, cpfColetor) VALUES (?, ?);";

        jdbcTemplate.update(sql, coletor.getNomeColetor(), coletor.getCpfColetor());
    }

    @Override
    public void update(Coletor coletor) {
        String sql = "UPDATE coletor SET nomeColetor = ?, cpfColetor = ? WHERE idColetor = ?;";

        jdbcTemplate.update(sql, coletor.getNomeColetor(), coletor.getCpfColetor(), coletor.getIdColetor());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM coletor WHERE idColetor = ?;";

        jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Coletor> findById(Long id) {
        String sql = "SELECT * FROM coletor WHERE idColetor = ?;";

        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, rowMapper, id));
    }

    @Override
    public List<Coletor> findAll() {
        String sql = "SELECT * FROM coletor;";

        return jdbcTemplate.query(sql, rowMapper);
    }
}

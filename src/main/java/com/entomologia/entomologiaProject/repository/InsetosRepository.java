package com.entomologia.entomologiaProject.repository;

import com.entomologia.entomologiaProject.model.Insetos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class InsetosRepository implements RepositoryPattern<Insetos> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final RowMapper<Insetos> mapper = new RowMapper<Insetos>() {
        @Override
        public Insetos mapRow(ResultSet rs, int rowNum) throws SQLException {
            Insetos insetos = new Insetos();
            insetos.setId(rs.getLong("id"));
            insetos.setNome(rs.getString("nome"));
            insetos.setDataColeta(rs.getDate("dataColeta").toLocalDate());
            insetos.setLocalColeta(rs.getString("localColeta"));
            insetos.setNomeColetor(rs.getString("nomeColetor"));
            insetos.setTag(rs.getString("tag"));
            insetos.setFamilia(rs.getString("familia"));
            insetos.setGenero(rs.getString("genero"));
            insetos.setOrdem(rs.getString("ordem"));
            return insetos;
        }
    };

    @Override
    public void save(Insetos insetos) {
        String sql = "INSERT INTO entomologia (nome, dataColeta, localColeta, nomeColetor, tag, familia, genero, ordem) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, insetos.getNome(), insetos.getDataColeta(), insetos.getLocalColeta()
                , insetos.getNomeColetor(), insetos.getTag(), insetos.getFamilia(), insetos.getGenero(), insetos.getOrdem());
    }

    @Override
    public void update(Insetos insetos) {
        String sql = "UPDATE entomologia set nome = ?, dataColeta = ?, localColeta = ?, nomeColetor = ?, tag = ?, familia = ?, genero = ?, ordem = ? where id = ?;";
        jdbcTemplate.update(sql, insetos.getNome(), insetos.getDataColeta(), insetos.getLocalColeta()
                , insetos.getNomeColetor(), insetos.getTag(), insetos.getFamilia(), insetos.getGenero(), insetos.getOrdem(), insetos.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM entomologia WHERE id = ?;";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Insetos> findById(Long id) {
        String sql = "SELECT * FROM entomologia WHERE id = ?;";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, mapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty(); // Nenhum resultado encontrado, retorna Optional vazio
        }
    }

    @Override
    public List<Insetos> findAll() {
        String sql = "SELECT * FROM entomologia;";
        return jdbcTemplate.query(sql, mapper);
    }
}

package com.entomologia.entomologiaProject.repository;

import com.entomologia.entomologiaProject.model.ImagemInseto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ImagemInsetoRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final RowMapper<ImagemInseto> rowMapper = new RowMapper<>() {
        @Override
        public ImagemInseto mapRow(ResultSet rs, int rowNum) throws SQLException {
            ImagemInseto imagem = new ImagemInseto();
            imagem.setId(rs.getLong("id"));
            imagem.setIdInseto(rs.getLong("idInseto"));
            imagem.setNomeArquivo(rs.getString("nomeArquivo"));
            imagem.setTipo(rs.getString("tipo"));
            imagem.setDados(rs.getBytes("dados"));
            return imagem;
        }
    };

    public void salvarImagem(ImagemInseto imagem) {
        String sql = "INSERT INTO imagem_inseto (idInseto, nomeArquivo, tipo, dados) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, imagem.getIdInseto(), imagem.getNomeArquivo(), imagem.getTipo(), imagem.getDados());
    }

    public List<ImagemInseto> buscarPorInseto(Long idInseto) {
        String sql = "SELECT * FROM imagem_inseto WHERE idInseto = ?";
        return jdbcTemplate.query(sql, rowMapper, idInseto);
    }

    public Optional<ImagemInseto> buscarPorId(Long id) {
        String sql = "SELECT * FROM imagem_inseto WHERE id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, rowMapper, id));
    }
}

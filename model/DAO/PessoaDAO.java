package model.DAO;

import model.VO.PessoaVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    private Connection conn;

    public PessoaDAO(Connection connection) {
        this.conn = connection;
    }

    public void inserir(PessoaVO pessoa) throws SQLException {
        String sql = "INSERT INTO PESSOA (nome, cpf, telefone, email, endereco) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getCpf());
            stmt.setString(3, pessoa.getTelefone());
            stmt.setString(4, pessoa.getEmail());
            stmt.setString(5, pessoa.getEndereco());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                pessoa.setId(rs.getInt(1));
            }
        }
    }

    public void atualizar(PessoaVO pessoa) throws SQLException {
        String sql = "UPDATE PESSOA SET nome = ?, cpf = ?, telefone = ?, email = ?, endereco = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getCpf());
            stmt.setString(3, pessoa.getTelefone());
            stmt.setString(4, pessoa.getEmail());
            stmt.setString(5, pessoa.getEndereco());
            stmt.setInt(6, pessoa.getId());
            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM PESSOA WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public PessoaVO buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM PESSOA WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapearPessoa(rs);
            }
            return null;
        }
    }

    public List<PessoaVO> listarTodos() throws SQLException {
        List<PessoaVO> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM PESSOA";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pessoas.add(mapearPessoa(rs));
            }
        }
        return pessoas;
    }

    private PessoaVO mapearPessoa(ResultSet rs) throws SQLException {
        PessoaVO pessoa = new PessoaVO();
        pessoa.setId(rs.getInt("id"));
        pessoa.setNome(rs.getString("nome"));
        pessoa.setCpf(rs.getString("cpf"));
        pessoa.setTelefone(rs.getString("telefone"));
        pessoa.setEmail(rs.getString("email"));
        pessoa.setEndereco(rs.getString("endereco"));
        return pessoa;
    }
}
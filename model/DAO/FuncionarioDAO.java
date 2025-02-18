package model.DAO;

import model.VO.FuncionarioVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO extends PessoaDAO {
    private Connection conn;

    public FuncionarioDAO(Connection conn) {
        super(conn);
        this.conn = conn;
    }

    public void inserir(FuncionarioVO funcionario) throws SQLException {
        super.inserir(funcionario);

        if (funcionario.getId() == 0) {
            throw new SQLException("Erro ao obter o ID do funcionário após a inserção na tabela PESSOA.");
        }

        String sql = "INSERT INTO FUNCIONARIO (pessoaId, cargo, salario, dataContratacao, turno) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, funcionario.getId());
            stmt.setString(2, funcionario.getCargo());
            stmt.setBigDecimal(3, funcionario.getSalario());
            stmt.setTimestamp(4, funcionario.getDataContratacao() != null ? Timestamp.valueOf(funcionario.getDataContratacao()) : null);
            stmt.setString(5, funcionario.getTurno());
            stmt.executeUpdate();
        }
    }

    public FuncionarioVO buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM FUNCIONARIO WHERE pessoaId = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                FuncionarioVO funcionario = new FuncionarioVO();
                funcionario.setId(rs.getInt("pessoaId"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setSalario(rs.getBigDecimal("salario"));
                funcionario.setDataContratacao(rs.getTimestamp("dataContratacao").toLocalDateTime());
                funcionario.setTurno(rs.getString("turno"));
                return funcionario;
            }
            return null;
        }
    }

    @Override
    public List<FuncionarioVO> listarTodos() throws SQLException {
        List<FuncionarioVO> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM FUNCIONARIO";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FuncionarioVO funcionario = new FuncionarioVO();
                funcionario.setId(rs.getInt("pessoaId"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setSalario(rs.getBigDecimal("salario"));
                funcionario.setDataContratacao(rs.getTimestamp("dataContratacao").toLocalDateTime());
                funcionario.setTurno(rs.getString("turno"));
                funcionarios.add(funcionario);
            }
        }
        return funcionarios;
    }
}
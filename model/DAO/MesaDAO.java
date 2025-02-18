package model.DAO;

import model.VO.FuncionarioVO;
import model.VO.MesaVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MesaDAO {
        private Connection conn;

        public MesaDAO(Connection connection) {
            this.conn = connection;
        }

        public void inserir(MesaVO mesa) throws SQLException {
            String sql = "INSERT INTO MESA (numero, capacidade, status, funcionarioId) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, mesa.getNumero());
                stmt.setInt(2, mesa.getCapacidade());
                stmt.setString(3, mesa.getStatus());
                if (mesa.getFuncionario() != null) {
                    stmt.setInt(4, mesa.getFuncionario().getId());
                } else {
                    stmt.setNull(4, Types.INTEGER);
                }
                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    mesa.setId(rs.getInt(1));
                }
            }
        }

        public void atualizar(MesaVO mesa) throws SQLException {
            String sql = "UPDATE MESA SET numero = ?, capacidade = ?, status = ?, funcionarioId = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, mesa.getNumero());
                stmt.setInt(2, mesa.getCapacidade());
                stmt.setString(3, mesa.getStatus());
                if (mesa.getFuncionario() != null) {
                    stmt.setInt(4, mesa.getFuncionario().getId());
                } else {
                    stmt.setNull(4, Types.INTEGER);
                }
                stmt.setInt(5, mesa.getId());
                stmt.executeUpdate();
            }
        }

        public List<MesaVO> buscarMesasDisponiveis() throws SQLException {
            String sql = "SELECT * FROM MESA WHERE status = 'DISPONIVEL'";
            List<MesaVO> mesas = new ArrayList<>();
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    mesas.add(mapearMesa(rs));
                }
            }
            return mesas;
        }

        private MesaVO mapearMesa(ResultSet rs) throws SQLException {
            MesaVO mesa = new MesaVO();
            mesa.setId(rs.getInt("id"));
            mesa.setNumero(rs.getInt("numero"));
            mesa.setCapacidade(rs.getInt("capacidade"));
            mesa.setStatus(rs.getString("status"));

            int funcionarioId = rs.getInt("funcionarioId");
            if (!rs.wasNull()) {
                FuncionarioVO funcionario = new FuncionarioDAO(conn).buscarPorId(funcionarioId);
                mesa.setFuncionario(funcionario);
            }

            return mesa;
        }
}

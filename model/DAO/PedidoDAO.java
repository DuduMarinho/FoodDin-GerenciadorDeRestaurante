package model.DAO;

import model.VO.PedidoVO;
import java.sql.*;


public class PedidoDAO {
    private Connection conn;

    public PedidoDAO(Connection connection) {
        this.conn = connection;
    }

    public void inserir(PedidoVO pedido) throws SQLException {
        String sql = "INSERT INTO PEDIDO (mesaId, clienteId, funcionarioId, dataPedido, status, valorTotal) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, pedido.getMesa().getId());
            stmt.setInt(2, pedido.getCliente().getId());
            stmt.setInt(3, pedido.getFuncionario().getId());
            stmt.setTimestamp(4, Timestamp.valueOf(pedido.getDataPedido()));
            stmt.setString(5, pedido.getStatus());
            stmt.setBigDecimal(6, pedido.getValorTotal());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                pedido.setId(rs.getInt(1));
            }
        }
    }

    public void alterar(PedidoVO pedido) throws SQLException {
        String sql = "UPDATE PEDIDO SET mesaId = ?, clienteId = ?, funcionarioId = ?, dataPedido = ?, status = ?, valorTotal = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getMesa().getId());
            stmt.setInt(2, pedido.getCliente().getId());
            stmt.setInt(3, pedido.getFuncionario().getId());
            stmt.setTimestamp(4, Timestamp.valueOf(pedido.getDataPedido()));
            stmt.setString(5, pedido.getStatus());
            stmt.setBigDecimal(6, pedido.getValorTotal());
            stmt.setInt(7, pedido.getId());
            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM PEDIDO WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public PedidoVO buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM PEDIDO WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                PedidoVO pedido = new PedidoVO();
                pedido.setId(rs.getInt("id"));
                pedido.setDataPedido(rs.getTimestamp("dataPedido").toLocalDateTime());
                pedido.setStatus(rs.getString("status"));
                pedido.setValorTotal(rs.getBigDecimal("valorTotal"));
                return pedido;
            }
            return null;
        }
    }
}
package model.VO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PedidoVO {
    private Integer id;
    private MesaVO mesa;
    private ClienteVO cliente;
    private FuncionarioVO funcionario;
    private LocalDateTime dataPedido;
    private String status;
    private BigDecimal valorTotal;
    private List<ItemPedidoVO> itens;

    public PedidoVO() {
        this.itens = new ArrayList<>();
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public MesaVO getMesa() { return mesa; }
    public void setMesa(MesaVO mesa) { this.mesa = mesa; }

    public ClienteVO getCliente() { return cliente; }
    public void setCliente(ClienteVO cliente) { this.cliente = cliente; }

    public FuncionarioVO getFuncionario() { return funcionario; }
    public void setFuncionario(FuncionarioVO funcionario) { this.funcionario = funcionario; }

    public LocalDateTime getDataPedido() { return dataPedido; }
    public void setDataPedido(LocalDateTime dataPedido) { this.dataPedido = dataPedido; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    public List<ItemPedidoVO> getItens() { return itens; }
    public void setItens(List<ItemPedidoVO> itens) { this.itens = itens; }
}


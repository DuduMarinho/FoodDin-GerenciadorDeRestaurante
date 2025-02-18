package model.VO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContaVO {
    private Integer id;
    private PedidoVO pedido;
    private BigDecimal valorTotal;
    private BigDecimal desconto;
    private String formaPagamento;
    private String status;
    private LocalDateTime dataPagamento;

    public ContaVO() {}

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public PedidoVO getPedido() { return pedido; }
    public void setPedido(PedidoVO pedido) { this.pedido = pedido; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    public BigDecimal getDesconto() { return desconto; }
    public void setDesconto(BigDecimal desconto) { this.desconto = desconto; }

    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(LocalDateTime dataPagamento) { this.dataPagamento = dataPagamento; }
}
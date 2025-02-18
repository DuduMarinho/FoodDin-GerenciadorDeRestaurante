package model.VO;

import java.time.LocalDateTime;

public class ClienteVO extends PessoaVO {
    private Integer pontosFidelidade;
    private LocalDateTime ultimaVisita;

    public ClienteVO(Integer id, String nome, String cpf, String telefone, String email,
                     String endereco, Integer pontosFidelidade, LocalDateTime ultimaVisita) {
        super(id, nome, cpf, telefone, email, endereco);
        this.pontosFidelidade = pontosFidelidade;
        this.ultimaVisita = ultimaVisita;
    }

    public Integer getPontosFidelidade() { return pontosFidelidade; }
    public void setPontosFidelidade(Integer pontosFidelidade) { this.pontosFidelidade = pontosFidelidade; }

    public LocalDateTime getUltimaVisita() { return ultimaVisita; }
    public void setUltimaVisita(LocalDateTime ultimaVisita) { this.ultimaVisita = ultimaVisita; }
}

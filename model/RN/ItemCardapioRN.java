package model.RN;

import model.VO.ItemCardapioVO;
import model.DAO.ItemCardapioDAO;
import java.math.BigDecimal;

public class ItemCardapioRN {

    private ItemCardapioDAO itemCardapioDAO;

    public ItemCardapioRN() {
        this.itemCardapioDAO = new ItemCardapioDAO();
    }

    public void adicionarItemCardapio(ItemCardapioVO item) {
        // Validações antes de adicionar o item ao cardápio
        if (item.getNome() == null || item.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do item não pode ser nulo.");
        }
        if (item.getPreco() == null || item.getPreco().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O preço do item deve ser maior que zero.");
        }
        if (item.getCategoria() == null || item.getCategoria().isEmpty()) {
            throw new IllegalArgumentException("A categoria do item não pode ser vazia.");
        }

        itemCardapioDAO.inserir(item);
    }

    public void atualizarPrecoItem(ItemCardapioVO item, BigDecimal novoPreco) {
        if (novoPreco == null || novoPreco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O novo preço deve ser maior que zero.");
        }

        item.setPreco(novoPreco);

        itemCardapioDAO.atualizar(item);
    }

    public ItemCardapioVO buscarItemPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do item não pode ser nulo.");
        }
        return itemCardapioDAO.buscarPorId(id);
    }

    public void removerItemCardapio(ItemCardapioVO item) {
        if (item == null) {
            throw new IllegalArgumentException("O Item não pode ser nulo.");
        }
        itemCardapioDAO.deletar(item.getId());
    }

    public List<ItemCardapioVO> listarTodosItens() {
        return itemCardapioDAO.listarTodos();
    }
}
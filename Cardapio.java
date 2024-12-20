import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private List<ItemCardapio> items;

    public Cardapio() {
        this.items = new ArrayList<>();
    }


    public void adicionarItem(ItemCardapio itemCardapio) {
        items.add(itemCardapio);
    }
    public void removerItem(ItemCardapio itemCardapio) {
        items.remove(itemCardapio);
    }
    public List<ItemCardapio> buscarPorCategoria(String categoria) {
        List<ItemCardapio> resultados = new ArrayList<>();
        for (ItemCardapio item : items) {
            if (item.getCategoria().equalsIgnoreCase(categoria)) {
                resultados.add(item);
            }
        }
        return resultados;
    }
    public void editarItem(ItemCardapio itemEditado) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getNome().equals(itemEditado.getNome())) {
                items.set(i, itemEditado);
                break;
            }
        }
    }
    public List<ItemCardapio> getItems() { return items; }
}

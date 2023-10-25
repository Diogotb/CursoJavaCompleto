import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ControleVendaCarros {
    private ArrayList<Carro> carros = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList();
    private DefaultTableModel carrosTableModel;

    public ControleVendaCarros(DefaultTableModel carrosTableModel) {
        this.carrosTableModel = carrosTableModel;
    }

    public void cadastrarCarro(String marca, String modelo, int ano, String cor) {
        Carro carro = new Carro(marca, modelo, ano, cor);
        carros.add(carro);
        atualizarTabelaCarros();
    }

    public void cadastrarCliente(String nome, String cpf) {
        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);
    }

    public void registrarVenda(int carroIndex, int clienteIndex) {
        if (carroIndex >= 0 && carroIndex < carros.size() && clienteIndex >= 0 && clienteIndex < clientes.size()) {
            Carro carro = carros.get(carroIndex);
            Cliente cliente = clientes.get(clienteIndex);
            // Implemente a lógica de registro da venda aqui, como criar uma nova entidade "Venda" e associá-la ao cliente e carro.
        }
    }

    public void filtrarCarros(String marca, int ano, String cor) {
        // Implemente a lógica de filtragem aqui e atualize a tabela com os resultados.
    }

    private void atualizarTabelaCarros() {
        carrosTableModel.setRowCount(0);
        for (Carro carro : carros) {
            carrosTableModel.addRow(new Object[]{carro.marca, carro.modelo, carro.ano, carro.cor});
        }
    }
   
}
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VendaCarros extends JFrame {
    private ArrayList<Carro> carros = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private DefaultTableModel carrosTableModel;
    private ControleVendaCarros controle;
    private DefaultTableModel clientesTableModel;

    public VendaCarros() {
        setTitle("Venda de Carros");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        carrosTableModel = new DefaultTableModel(new String[]{"Marca", "Modelo", "Ano", "Cor"}, 0);
        JTable carrosTable = new JTable(carrosTableModel);

        clientesTableModel = new DefaultTableModel(new String[]{"Nome", "CPF"}, 0);
        JTable clientesTable = new JTable(clientesTableModel);

        JButton cadastrarCarroButton = new JButton("Cadastrar Carro");
        JButton cadastrarClienteButton = new JButton("Cadastrar Cliente");
        JButton registrarVendaButton = new JButton("Registrar Venda");

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(cadastrarCarroButton);
        buttonPanel.add(cadastrarClienteButton);
        buttonPanel.add(registrarVendaButton);

        JTextField filtroMarca = new JTextField(20);
        JTextField filtroAno = new JTextField(20);
        JTextField filtroCor = new JTextField(20);

        JButton filtroButton = new JButton("Filtrar");
        filtroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implemente a lógica de filtragem aqui
            }
        });

        JPanel filtroPanel = new JPanel();
        filtroPanel.add(new JLabel("Filtrar por Marca: "));
        filtroPanel.add(filtroMarca);
        filtroPanel.add(new JLabel("Ano: "));
        filtroPanel.add(filtroAno);
        filtroPanel.add(new JLabel("Cor: "));
        filtroPanel.add(filtroCor);
        filtroPanel.add(filtroButton);

        JPanel mainPanel = new JPanel();
        JPanel tablePanel = new JPanel(new GridLayout(2,1));
        tablePanel.add(new JScrollPane(carrosTable));
        //tablePanel.add(new JScrollPane(clientesTable));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        mainPanel.add(filtroPanel, BorderLayout.SOUTH);

        controle = new ControleVendaCarros(carrosTableModel);

        cadastrarCarroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca = JOptionPane.showInputDialog("Marca do carro:");
                String modelo = JOptionPane.showInputDialog("Modelo do carro:");
                int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano do carro:"));
                String cor = JOptionPane.showInputDialog("Cor do carro:");

                controle.cadastrarCarro(marca, modelo, ano, cor);
            }
        });

        cadastrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome do cliente:");
                String cpf = JOptionPane.showInputDialog("CPF do cliente:");

                controle.cadastrarCliente(nome, cpf);
            }
        });

        registrarVendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int carroIndex = carrosTable.getSelectedRow();
                int clienteIndex = clientesTable.getSelectedRow();

                if (carroIndex != -1 && clienteIndex != -1) {
                    controle.registrarVenda(carroIndex, clienteIndex);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um carro e um cliente para registrar a venda.");
                }
            }
        });

        filtroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca = filtroMarca.getText();
                int ano = Integer.parseInt(filtroAno.getText());
                String cor = filtroCor.getText();

                controle.filtrarCarros(marca, ano, cor);
            }
        });
    }

    public void run(){
        this.pack();
        this.setVisible(true);
    }


}

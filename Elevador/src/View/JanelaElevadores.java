package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaElevadores extends JFrame {

    private JButton[] botoesAndares;
    private JLabel[] labelsElevadores;

    public JanelaElevadores(int totalAndares, int totalElevadores) {
        // Configuração da janela principal
        setTitle("Controle de Elevadores");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicialização dos componentes
        inicializarComponentes(totalAndares, totalElevadores);

        // Adição dos componentes à janela
        adicionarComponentes();

        // Configuração da visibilidade
        setVisible(true);
    }

    private void inicializarComponentes(int totalAndares, int totalElevadores) {
        // Inicialização do array de botões para representar os andares
        botoesAndares = new JButton[totalAndares];
        for (int i = 0; i < totalAndares; i++) {
            botoesAndares[i] = new JButton("Andar " + i);
            final int andar = i;
            botoesAndares[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Implemente a lógica para solicitar o elevador aqui
                }
            });
        }

        // Inicialização do array de labels para representar os elevadores
        labelsElevadores = new JLabel[totalElevadores];
        for (int i = 0; i < totalElevadores; i++) {
            labelsElevadores[i] = new JLabel("Elevador " + (i + 1));
        }
    }

    private void adicionarComponentes() {
        // Configuração do layout
        setLayout(new BorderLayout());

        // Adição dos botões dos andares na parte central da janela
        JPanel panelAndares = new JPanel(new GridLayout(botoesAndares.length, 1));
        for (int i = botoesAndares.length - 1; i >= 0; i--) {
            panelAndares.add(botoesAndares[i]);
        }
        add(panelAndares, BorderLayout.CENTER);

        // Adição dos labels dos elevadores na parte direita da janela
        JPanel panelElevadores = new JPanel(new GridLayout(labelsElevadores.length, 1));
        for (int i = 0; i < labelsElevadores.length; i++) {
            panelElevadores.add(labelsElevadores[i]);
        }
        add(panelElevadores, BorderLayout.EAST);
    }
}

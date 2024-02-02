package Controller;

import javax.swing.*;

import Model.Elevador;
import View.JanelaElevadores;

public class ControleElevadores {

    private static void iniciarControleElevadores() {
        int totalAndares = 9;
        int totalElevadores = 2;

        // Criação da janela de elevadores
        JanelaElevadores janelaElevadores = new JanelaElevadores(totalAndares, totalElevadores);

        // Criação dos objetos Elevador
        Elevador[] elevadores = new Elevador[totalElevadores];
        for (int i = 0; i < totalElevadores; i++) {
            elevadores[i] = new Elevador();
        }

        // Implemente a lógica para interação entre a janela e os objetos Elevador aqui
    }
}

package Model;

public class Elevador {
    private int andarAtual;

    public Elevador() {
        this.andarAtual = 0;
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public void moverPara(int destino) {
        if (destino > andarAtual) {
            // Mover para cima
            for (int i = andarAtual + 1; i <= destino; i++) {
                andarAtual = i;
                pausar(500);  // Simulação de movimento, pausa de 500 milissegundos
            }
        } else if (destino < andarAtual) {
            // Mover para baixo
            for (int i = andarAtual - 1; i >= destino; i--) {
                andarAtual = i;
                pausar(500);  // Simulação de movimento, pausa de 500 milissegundos
            }
        }
    }

    private void pausar(int milissegundos) {
        // Método para simular uma pausa
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
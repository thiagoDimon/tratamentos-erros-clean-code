package org.example;

public class Main {
    public static void main(String[] args) {
        Torneio torneio = new Torneio();

        // Adicionando times
        torneio.adicionarTime("Brasil");
        torneio.adicionarTime(""); // ❌ Erro: Nome inválido
        torneio.adicionarTime("Canadá");
        torneio.adicionarTime("Argentina");
        torneio.adicionarTime("Angola");

        // Criando partidas
        torneio.criarPartida("Brasil", "Canadá", 1L, 0L);
        torneio.criarPartida("Argentina", "Angola", 2L, 0L);
        torneio.criarPartida("Brasil", "Argentina", -10L, -2L); // ❌ Erro: Número inválido de gols
        torneio.criarPartida("Brasil", "Argentina", 0L, 2L);
        torneio.criarPartida("Angola", "Canadá", 1L, 1L);
        torneio.criarPartida("Brasil", "Angola", 3L, 2L);
        torneio.criarPartida("Argentina", "Nigéria", 3L, 3L); // ❌ Erro: Time não existe
        torneio.criarPartida("Argentina", "Canadá", 2L, 4L);

        // Exibe a classificação final e o resultado de cada partida
        ResultadoTorneio resultados = torneio.jogar();
        resultados.imprimirClassificacao();
        resultados.imprimirResultados();

    }
}
package org.example;

import java.util.List;
import java.util.Map;

public class ResultadoTorneio {
    protected Map<String, Long> pontuacao;
    protected List<Partida> partidas;

    public ResultadoTorneio (Map<String, Long> pontuacao, List<Partida> partidas) {
        this.pontuacao = pontuacao;
        this.partidas = partidas;
    }

    public void imprimirClassificacao() {
        System.out.println("Classificação Final:");
        pontuacao.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + " pontos"));
    }

    public void imprimirResultados() {
        System.out.println("\nResultados das partidas:");
        for (Partida partida : partidas) {
            System.out.println(partida.timeMandante + " " + partida.golsMandante + " x " + partida.golsVisitante + " " + partida.timeVisitante);
        }
    }
}

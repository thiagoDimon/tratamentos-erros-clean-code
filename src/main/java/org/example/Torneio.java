package org.example;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Torneio {
    protected Set<String> times = new HashSet<>();
    protected List<Partida> partidas = new ArrayList<>();
    protected static final Logger logger = Logger.getLogger(Torneio.class.getName());

    static {
        try {
            LogManager.getLogManager().readConfiguration(Torneio.class.getClassLoader().getResourceAsStream("logger.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adicionarTime(String nomeTime) {
        try {
            if (nomeTime == null || nomeTime.isEmpty()) {
                throw new IllegalAccessException("Nome do time inválido!");
            }
            times.add(nomeTime);
        } catch (IllegalAccessException e) {
            logger.log(Level.SEVERE, "Erro ao adicionar time: " + nomeTime, e);
        }
    }

    public void criarPartida(String timeMandante, String timeVisitante, Long golsMandante, Long golsVisitante) {
        try {
            if (!times.contains(timeMandante) || !times.contains(timeVisitante)) {
                throw new IllegalArgumentException("Um dos times informados não está cadastrado!");
            }
            if (golsMandante < 0 || golsVisitante < 0) {
                throw new IllegalArgumentException("Quantidade de gols inválido!");
            }
            partidas.add(new Partida(timeMandante, timeVisitante, golsMandante, golsVisitante));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao criar partida entre " + timeMandante + " x " + timeVisitante, e);
        }
    }

    public ResultadoTorneio jogar() {
        Map<String, Long> pontuacao = new HashMap<>();

        for (String time : times) {
            pontuacao.put(time, 0L);
        }

        for (Partida partida : partidas) {
            String timeMandante = partida.getTimeMandante();
            String timeVisitante = partida.getTimeVisitante();
            Long golsMandante = partida.getGolsMandante();
            Long golsVisitante = partida.getGolsVisitante();

            if (golsMandante > golsVisitante) {
                pontuacao.put(timeMandante, pontuacao.get(timeMandante) + 3);
            } else if (golsVisitante > golsMandante) {
                pontuacao.put(timeVisitante, pontuacao.get(timeVisitante) + 3);
            } else {
                pontuacao.put(timeMandante, pontuacao.get(timeMandante) + 1);
                pontuacao.put(timeVisitante, pontuacao.get(timeVisitante) + 1);
            }
        }

        return new ResultadoTorneio(pontuacao, partidas);
    }
}

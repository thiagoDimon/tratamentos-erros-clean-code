package org.example;

public class Partida {
    protected String timeMandante;
    protected String timeVisitante;
    protected Long golsMandante;
    protected Long golsVisitante;

    public Partida(String timeMandante, String timeVisitante, Long golsMandante, Long golsVisitante) {
        this.timeMandante = timeMandante;
        this.timeVisitante = timeVisitante;
        this.golsMandante = golsMandante;
        this.golsVisitante = golsVisitante;
    }

    public String getTimeMandante() {
        return timeMandante;
    }

    public void setTimeMandante(String timeMandante) {
        this.timeMandante = timeMandante;
    }

    public String getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(String timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

    public Long getGolsMandante() {
        return golsMandante;
    }

    public void setGolsMandante(Long golsMandante) {
        this.golsMandante = golsMandante;
    }

    public Long getGolsVisitante() {
        return golsVisitante;
    }

    public void setGolsVisitante(Long golsVisitante) {
        this.golsVisitante = golsVisitante;
    }

}

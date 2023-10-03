package org.example.maze.components;

import org.example.utils.Coordinate;

public class FusionRangBox implements Box{
    private Integer distance;
    private Integer murEst;
    private Integer murSud;
    private Coordinate pere;
    private Integer rang;
    private Integer presence;

    public FusionRangBox(Coordinate coordinate) {
        this.distance = 0;
        this.murEst = 1;
        this.murSud = 1;
        this.pere = coordinate;
        this.rang = 0;
        this.presence = 0;
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getMurEst() {
        return murEst;
    }

    public Integer getMurSud() {
        return murSud;
    }

    public Coordinate getPere() {
        return pere;
    }

    public Integer getRang() {
        return rang;
    }

    public Integer getPresence() {
        return presence;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public void setMurEst(Integer murEst) {
        this.murEst = murEst;
    }

    public void setMurSud(Integer murSud) {
        this.murSud = murSud;
    }

    public void setPere(Coordinate pere) {
        this.pere = pere;
    }

    public void setRang(Integer rang) {
        this.rang = rang;
    }

    public void setPresence(Integer presence) {
        this.presence = presence;
    }
}

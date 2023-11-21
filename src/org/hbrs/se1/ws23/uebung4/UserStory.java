package org.hbrs.se1.ws23.uebung4;

import java.io.Serializable;

public class UserStory implements Comparable<UserStory>, Serializable {

    private String titel;
    private int aufwand;
    private int id;
    private int mehrwert;
    private int risk ;
    private int strafe;
    private double prio;
    private String project;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public UserStory(int id, String titel, int mehrwert, int strafe,
                     int aufwand, int risk, String project) {
        this.id = id;
        this.titel = titel;
        this.mehrwert = mehrwert;
        this.strafe = strafe;
        this.aufwand = aufwand;
        this.risk = risk;
        this.prio = calcPrio(mehrwert,strafe,risk,aufwand);
        this.project = project;
    }

    public UserStory() {
    }

    public double getPrio() {
        return prio;
    }

    public void setPrio(double prio) {
        this.prio = prio;
    }

    public String getTitel() {
        return titel;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public int getAufwand() {
        return aufwand;
    }
    public void setAufwand(int aufwand) {
        this.aufwand = aufwand;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMehrwert() {
        return mehrwert;
    }
    public void setMehrwert(int mehrwert) {
        this.mehrwert = mehrwert;
    }

    public int getRisk() {
        return risk;
    }
    public void setRisk(int risk) {
        this.risk = risk;
    }
    public int getStrafe() {
        return strafe;
    }
    public void setStrafe(int strafe) {
        this.strafe = strafe;
    }

    public static double calcPrio(int mehrwert, int strafe, int risiko, int aufwand) {
        return ((double) (mehrwert + strafe)) / ((double) (aufwand + risiko));
    }

    @Override
    public String toString() {
        return "UserStory{" +
                "titel='" + titel + '\'' +
                ", aufwand=" + aufwand +
                ", id=" + id +
                ", mehrwert=" + mehrwert +
                ", risk=" + risk +
                ", strafe=" + strafe +
                ", prio=" + prio +
                ", project='" + project + '\'' +
                '}';
    }

    @Override
    public int compareTo(UserStory userStory) {
        return Double.compare(getPrio(),userStory.getPrio());
    }
}

package model;

import java.util.ArrayList;
import java.util.List;

public class TabelaDeSimbolo {

    private List<String> tabelaSimbolo =  new ArrayList<>();

    public TabelaDeSimbolo(List<String> tabelaSimbolo) {
        this.tabelaSimbolo = tabelaSimbolo;
    }

    public List<String> getTabelaSimbolo() {
        return tabelaSimbolo;
    }

    public void setTabelaSimbolo(List<String> tabelaSimbolo) {
        this.tabelaSimbolo = tabelaSimbolo;
    }

    public TabelaDeSimbolo() {
    }
}

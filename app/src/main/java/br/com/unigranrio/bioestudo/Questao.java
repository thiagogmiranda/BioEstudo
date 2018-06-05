package br.com.unigranrio.bioestudo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Questao {
    private String texto;
    private Map<String, String> alternativas;
    private String alternativaCorreta;

    public Questao() {
        alternativas = new TreeMap<>();
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(String alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }

    public void adicionarAlternativa(String letra, String resposta) {
        alternativas.put(letra, resposta);
    }

    public Map<String, String> getAlternativas() {
        return alternativas;
    }
}

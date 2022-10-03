package com.solucao;

import com.problema.Problema;

import java.util.Arrays;

public class Solucao {

    //Atributos

    protected boolean[] solucaoAtual;

    protected boolean[] melhorSolucao;

    protected int movimento;

    protected Problema problema;

    protected double melhorRetorno;

    protected double risco;

    //Construct

    public Solucao(Problema problema){

        setProblema(problema);

        this.melhorSolucao = new boolean[problema.getNumeroAtivos()];

        this.melhorRetorno = 0;

        for (int i = 0; i<problema.getNumeroAtivos(); i++){

            this.solucaoAtual = new boolean[problema.getNumeroAtivos()];

            this.solucaoAtual[i] = true;

            if(problema.calculoRetornoUnitario(solucaoAtual)/problema.calculoCustoSimples(solucaoAtual) >
                    this.melhorRetorno &&
                problema.calculoRisco(solucaoAtual) < problema.getRiscoMaximo()){

                setMelhorRetorno(problema.calculoRetornoUnitario(solucaoAtual)/problema.calculoCustoSimples(solucaoAtual));
                setMelhorSolucao(getSolucaoAtual());
            }

        }

        setSolucaoAtual(Arrays.copyOf(getMelhorSolucao(), getMelhorSolucao().length));
        getProblema().setX(Arrays.copyOf(getMelhorSolucao(), getMelhorSolucao().length));
        this.risco = getProblema().calculoRisco(getMelhorSolucao());

    }


    //Metodos

    public boolean checkCusto(boolean[] sol) {
        return this.problema.calculoCustoSimples(sol) <= this.problema.getBudjet();
    }

    public boolean checkRisco(boolean[] sol) {
        return this.problema.calculoRisco(sol) <= this.problema.getRiscoMaximo();
    }

    public double getRisco() {
        return risco;
    }

    public void setRisco(double risco) {
        this.risco = risco;
    }

    public int getMovimento() {
        return movimento;
    }

    public Problema getProblema() {
        return problema;
    }

    public double getMelhorRetorno() {
        return melhorRetorno;
    }

    public boolean[] getSolucaoAtual() {
        return solucaoAtual;
    }

    public void setSolucaoAtual(boolean[] solucaoAtual) {
        this.solucaoAtual = solucaoAtual;
    }

    public boolean[] getMelhorSolucao() {
        return melhorSolucao;
    }

    public void setMelhorSolucao(boolean[] melhorSolucao) {
        this.melhorSolucao = melhorSolucao;
    }

    public void setMovimento(int movimento) {
        this.movimento = movimento;
    }

    public void setProblema(Problema problema) {
        this.problema = problema;
    }

    public void setMelhorRetorno(double melhorRetorno) {
        this.melhorRetorno = melhorRetorno;
    }
}

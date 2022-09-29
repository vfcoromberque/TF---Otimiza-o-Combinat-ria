package com.solucao;

import com.problema.Problema;

public class Solucao {

    //Atributos

    protected boolean[] solucaoAtual;

    protected boolean[] melhorSolucao;

    protected Problema problema;

    protected double melhorRetorno;

    //Construct

    public Solucao(Problema problema){

        this.problema = problema;

        this.melhorSolucao = new boolean[problema.getNumeroAtivos()];

        this.melhorRetorno = 0;

        for (int i = 0; i<problema.getNumeroAtivos(); i++){

            this.solucaoAtual = new boolean[problema.getNumeroAtivos()];

            this.solucaoAtual[i] = true;

            if(problema.calculoRetornoUnitario(solucaoAtual) > this.melhorRetorno &&
                problema.calculoRisco(solucaoAtual) < problema.getRiscoMaximo()){
                this.melhorRetorno = problema.calculoRetornoUnitario(solucaoAtual);
                this.melhorSolucao = this.solucaoAtual;
            }

        }

        this.solucaoAtual = this.melhorSolucao;

    }


    //Metodos


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
}

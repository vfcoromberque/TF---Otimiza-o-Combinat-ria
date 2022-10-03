package com.tabu;

import com.problema.Problema;
import com.solucao.Solucao;

import java.util.ArrayList;
import java.util.Arrays;

public class Tabu {

    //Atributos

    protected boolean[] matrizTabu;

    protected Problema problema;

    protected Solucao solucao;


    //Construct

    public Tabu(Problema problema, Solucao solucao){

        this.problema = problema;

        this.solucao = solucao;

        this.matrizTabu = new boolean[problema.getNumeroAtivos()];

    }

    //Metodos

    public void solve(int numInteracoes){

        int tabuSize = 2;

        int[] auxTabu = new int[tabuSize];

        for (int i = 0; i<=numInteracoes; i++){
            iteracaoVizinhos();

            this.matrizTabu[auxTabu[tabuSize-1]] = false;
            this.matrizTabu[getSolucao().getMovimento()] = true;

            for (int j = auxTabu.length-1; j> 0; j--) {
                auxTabu[j] = auxTabu[j-1];
            }
            auxTabu[0] = getSolucao().getMovimento();

        }

        for (int i = 0; i<getProblema().getNumeroAtivos(); i++){
            if (getSolucao().getMelhorSolucao()[i]){
                getProblema().getY()[i] = 1;
            }
        }

    }

    public void solveMochila() {

        ArrayList<Integer> auxiliar = new ArrayList<>();
        ArrayList<Integer> auxiliarSort = new ArrayList<>();


        for (int i = 0; i < getProblema().getNumeroAtivos(); i++) {

            if (getSolucao().getMelhorSolucao()[i]) {
                auxiliar.add(i);
            }

        }

        while (!auxiliar.isEmpty()){

            int maior = 0;

            for (int i = 0; i < auxiliar.size(); i++) {
                if(getProblema().getRetornoAtivos()[auxiliar.get(i)]/getProblema().getCustoAtivos()[auxiliar.get(i)] >
                        getProblema().getRetornoAtivos()[auxiliar.get(maior)]/getProblema().getCustoAtivos()[maior]){
                    maior = i;
                }
            }

            auxiliarSort.add(auxiliar.get(maior));
            auxiliar.remove(maior);

        }


        for (Integer integer : auxiliarSort) {

            while (getProblema().calculoCustoTotal(getProblema().getY()) <= getProblema().getBudjet()) {
                ++getProblema().getY()[integer];
            }

            --getProblema().getY()[integer];

        }

        getSolucao().setMelhorRetorno(getProblema().calculoRetornoTotal());

    }

    public void iteracaoVizinhos() {

        boolean[] auxiliar;
        boolean[] menosPior = new boolean[getProblema().getNumeroAtivos()];
        int movimentoMenosPior = 0;
        double diferenca = 0;

        for (int i = 0; i < this.problema.getNumeroAtivos(); i++) {

            auxiliar = Arrays.copyOf(getSolucao().getSolucaoAtual(), getProblema().getNumeroAtivos());

            auxiliar[i] = !auxiliar[i];

            if (!this.matrizTabu[i]) {
                if (this.solucao.checkRisco(auxiliar)) {
                    if (this.solucao.checkCusto(auxiliar)) {
                        if (this.problema.calculoRetornoUnitario(getSolucao().getMelhorSolucao())/
                                this.problema.calculoCustoSimples(getSolucao().getMelhorSolucao())<=
                                this.problema.calculoRetornoUnitario(auxiliar)/
                                        this.problema.calculoCustoSimples(auxiliar)) {


                            getSolucao().setMelhorSolucao(Arrays.copyOf(auxiliar, auxiliar.length));
                            getSolucao().setMovimento(i);


                        } else if (getProblema().calculoRetornoUnitario(getSolucao().getSolucaoAtual())/
                                this.problema.calculoCustoSimples(getSolucao().getSolucaoAtual()) -
                                getProblema().calculoRetornoUnitario(auxiliar)/
                                        this.problema.calculoCustoSimples(auxiliar) > diferenca) {

                            menosPior = Arrays.copyOf(auxiliar, auxiliar.length);
                            movimentoMenosPior = i;
                            diferenca = getProblema().calculoRetornoUnitario(getSolucao().getSolucaoAtual()) -
                                    getProblema().calculoRetornoUnitario(auxiliar);

                        }

                    }
                }
            }
        }

        if(this.problema.calculoRetornoUnitario(getProblema().getX()) <
                this.solucao.getMelhorRetorno()){
            this.problema.setX(Arrays.copyOf(getSolucao().getMelhorSolucao(), getProblema().getNumeroAtivos()));
        }

        if (!Arrays.equals(getSolucao().getSolucaoAtual(), getSolucao().getMelhorSolucao())) {
            getSolucao().setMelhorRetorno(this.problema.calculoRetornoUnitario(getSolucao().getMelhorSolucao()));
        } else {
            getSolucao().setMovimento(movimentoMenosPior);
            getSolucao().setMelhorSolucao(Arrays.copyOf(menosPior, menosPior.length));

        }

        getSolucao().setSolucaoAtual(Arrays.copyOf(getSolucao().getMelhorSolucao(), getSolucao().getMelhorSolucao().length));
        getSolucao().setRisco(getProblema().calculoRisco(getSolucao().getMelhorSolucao()));

    }

    public Problema getProblema() {
        return problema;
    }

    public Solucao getSolucao() {
        return solucao;
    }

}

package com.problema;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Problema {

    //Atributos

        //Variaveis
            protected boolean[] x;             //Vetor binário, identificando os ativos escolhidos

            protected int[] y;                 //Vetor de inteiros, identificando o número de ativos comprados


        //Constantes

            protected int numeroAtivos;

            protected double[] custoAtivos;              //Custo Ativos

            protected double[] retornoAtivos;              //Retorno Esperado dos Ativos

            protected double[][] cov;        //Covariancia entre Ativos

            protected double[][] cor;        //Correlação entre Ativos

            protected double riscoTotal;                 //Risco entre Ativos

            protected double riscoMaximo;              //Risco Máximo

            protected double Tmax;              //Correlação Máxima entre Ativos

            protected double t;                 //Percentagem Máxima de ativos selecionados com cor_ij acima de Tmax

            protected double Budjet;                 //Budjet para compra de ativos


    //Construct

        public Problema(int numProblema){

            //Construindo a Instância do problema conforme o número dado de 1 a 9, so receber
            //um número =! [9] o problema 1 será utilizado.

            try {
                File file = new File(escolhaDeProblema(numProblema));
                Scanner scanner = new Scanner(file);

                try {

                    this.numeroAtivos = scanner.nextInt();

                    this.x = new boolean[numeroAtivos];

                    this.y = new int[numeroAtivos];

                    this.Budjet = Double.parseDouble(scanner.next());

                    this.riscoMaximo = Double.parseDouble(scanner.next());

                    this.t = Double.parseDouble(scanner.next());

                    this.Tmax = Double.parseDouble(scanner.next());

                    this.custoAtivos = new double[numeroAtivos];

                    for (int i = 0; i<numeroAtivos; i++){
                        this.custoAtivos[i] = Double.parseDouble(scanner.next());
                    }

                    this.retornoAtivos = new double[numeroAtivos];

                    for (int i = 0; i<numeroAtivos; i++){
                        this.retornoAtivos[i] = Double.parseDouble(scanner.next());
                    }

                    this.cov = new double[numeroAtivos][numeroAtivos];

                    for (int i = 0; i<numeroAtivos; i++){
                        for (int j = 0; j<numeroAtivos; j++)
                            this.cov[i][j] = Double.parseDouble(scanner.next());
                    }

                    this.cor = new double[numeroAtivos][numeroAtivos];

                    for (int i = 0; i<numeroAtivos; i++){
                        for (int j = 0; j<numeroAtivos; j++)
                            this.cor[i][j] = Double.parseDouble(scanner.next());
                    }

                } catch (InputMismatchException e) {
                    throw new RuntimeException(e);
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }



    //Metodos

        protected String escolhaDeProblema(int i) {
            String str;
            switch (i) {
                case 2 -> {
                    str = "problema3-instancias-resultados/problema3-instancias/instance_62.dat";
                    break;
                }
                case 3 -> {
                    str = "problema3-instancias-resultados/problema3-instancias/instance_89.dat";
                    break;
                }
                case 4 -> {
                    str = "problema3-instancias-resultados/problema3-instancias/instance_100.dat";
                    break;
                }
                case 5 -> {
                    str = "problema3-instancias-resultados/problema3-instancias/instance_138.dat";
                    break;
                }
                case 6 -> {
                    str = "problema3-instancias-resultados/problema3-instancias/instance_165.dat";
                    break;
                }
                case 7 -> {
                    str = "problema3-instancias-resultados/problema3-instancias/instance_497.dat";
                    break;
                }
                case 8 -> {
                    str = "problema3-instancias-resultados/problema3-instancias/instance_692.dat";
                    break;
                }
                case 9 -> {
                    str = "problema3-instancias-resultados/problema3-instancias/instance_983.dat";
                    break;
                }
                case 10 -> {
                    str = "problema3-instancias-resultados/problema3-instancias/instance_1785.dat";
                    break;
                }
                default -> {
                    str = "problema3-instancias-resultados/problema3-instancias/instance_40.dat";
                    break;
                }
            }
            return str;
        }


        public double calculoRisco(boolean[] possivelSolucao){
            double result = 0;

            for (int i = 0; i<numeroAtivos; i++){
                for (int j = i; j<numeroAtivos; j++){
                    if(possivelSolucao[i] && possivelSolucao[j]){
                        result += cov[i][j];
                    }
                }
            }

            return result;
        }

        public  double calculoCustoTotal(int[] possivelSolucao){
            double result = 0;

            for (int i = 0; i<numeroAtivos; i++){
                if(possivelSolucao[i] > 0){
                    result += custoAtivos[i] * possivelSolucao[i];
                }
            }

            return result;
        }

    public double calculoCustoSimples(boolean[] possivelSolucao){
        double result = 0;

        for (int i = 0; i<numeroAtivos; i++){
            if(possivelSolucao[i]){
                result += custoAtivos[i];
            }
        }

        return result;
    }

        public double calculoRetornoUnitario(boolean[] possivelSolucao){
            double result = 0;

            for (int i = 0; i<numeroAtivos; i++){
                if(possivelSolucao[i]){
                    result += retornoAtivos[i];
                }
            }

            return result;
        }

    public double calculoRetornoTotal(){
        double result = 0;

        for (int i = 0; i<numeroAtivos; i++){
            if(y[i]>0){
                result += retornoAtivos[i] * y[i];
            }
        }

        return result;
    }

        public int getNumeroAtivos() {
            return numeroAtivos;
        }

        public boolean[] getX() {
            return x;
        }

        public void setX(boolean[] x) {
            this.x = x;
        }

        public int[] getY() {
                return y;
        }

        public double[] getCustoAtivos() {
            return custoAtivos;
        }

        public double[] getRetornoAtivos() {
            return retornoAtivos;
        }

        public double[][] getCov() {
            return cov;
        }

        public double[][] getCor() {
            return cor;
        }

        public double getRiscoTotal() {
            return riscoTotal;
        }

        public double getRiscoMaximo() {
            return riscoMaximo;
        }

        public double getTmax() {
            return Tmax;
        }

        public double getT() {
            return t;
        }

        public double getBudjet() {
            return Budjet;
        }

    public void setY(int[] y) {
        this.y = y;
    }

    public void setNumeroAtivos(int numeroAtivos) {
        this.numeroAtivos = numeroAtivos;
    }

    public void setCustoAtivos(double[] custoAtivos) {
        this.custoAtivos = custoAtivos;
    }

    public void setRetornoAtivos(double[] retornoAtivos) {
        this.retornoAtivos = retornoAtivos;
    }

    public void setCov(double[][] cov) {
        this.cov = cov;
    }

    public void setCor(double[][] cor) {
        this.cor = cor;
    }

    public void setRiscoTotal(double riscoTotal) {
        this.riscoTotal = riscoTotal;
    }

    public void setRiscoMaximo(double riscoMaximo) {
        this.riscoMaximo = riscoMaximo;
    }

    public void setTmax(double tmax) {
        Tmax = tmax;
    }

    public void setT(double t) {
        this.t = t;
    }

    public void setBudjet(double budjet) {
        Budjet = budjet;
    }
}

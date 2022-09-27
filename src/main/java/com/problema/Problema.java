package com.problema;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Problema {

    //Atributos

        //Variaveis
            protected boolean[] xi;             //Vetor binário, identificando os ativos escolhidos

            protected int[] yi;                 //Vetor de inteiros, identificando o número de ativos comprados

            //Não sei se precisa ser utilizado na implementação
//            protected boolean[][] zij;           //Vetor que identifica se ativos xi e xj são utilizados (xi AND xj)

        //Contantes

            protected int numeroAtivos;

            protected double[] ci;              //Custo Ativos

            protected double[] vi;              //Retorno Esperado dos Ativos

            protected double[][] cov_ij;        //Covariancia entre Ativos

            protected double[][] cor_ij;        //Correlação entre Ativos

            protected double R;                 //Risco entre Ativos

            protected double Rmax;              //Risco Máximo

            protected double Tmax;              //Correlação Máxima entre Ativos

            protected double t;                 //Percentagem Máxima de ativos selecionados com cor_ij acima de Tmax

            protected double C;                 //Budjet para compra de ativos


    //Construct

        public Problema(int numProblema){

            //Construindo a Instância do problema conforme o número dado de 1 a 9, so receber
            //um número =! [9] o problema 1 será utilizado.

            try {
                File file = new File(escolhaDeProblema(numProblema));
                Scanner scanner = new Scanner(file);

                try {

                    this.numeroAtivos = scanner.nextInt();

                    this.C = Double.parseDouble(scanner.next());

                    this.Rmax = Double.parseDouble(scanner.next());

                    this.t = Double.parseDouble(scanner.next());

                    this.Tmax = Double.parseDouble(scanner.next());

                    this.ci = new double[numeroAtivos];

                    for (int i = 0; i<numeroAtivos; i++){
                        this.ci[i] = Double.parseDouble(scanner.next());
                    }

                    this.vi = new double[numeroAtivos];

                    for (int i = 0; i<numeroAtivos; i++){
                        this.vi[i] = Double.parseDouble(scanner.next());
                    }

                    this.cov_ij = new double[numeroAtivos][numeroAtivos];

                    for (int i = 0; i<numeroAtivos; i++){
                        for (int j = 0; j<numeroAtivos; j++)
                            this.cov_ij[i][j] = Double.parseDouble(scanner.next());
                    }

                    this.cor_ij = new double[numeroAtivos][numeroAtivos];

                    for (int i = 0; i<numeroAtivos; i++){
                        for (int j = 0; j<numeroAtivos; j++)
                            this.cor_ij[i][j] = Double.parseDouble(scanner.next());
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

        //Como ainda não sei se precisa ser uttilizado vetor zij não implementei ainda
//        public double calculoRisco(){
//            double result;
//
//            for (int i = 0; i<numeroAtivos; i++){
//                for (int j = i; j<numeroAtivos; j++){
//
//                }
//            }
//        }

        public int getNumeroAtivos() {
            return numeroAtivos;
        }

        public boolean[] getXi() {
            return xi;
        }

        public int[] getYi() {
            return yi;
        }

        public double[] getCi() {
            return ci;
        }

        public double[] getVi() {
            return vi;
        }

        public double[][] getCov_ij() {
            return cov_ij;
        }

        public double[][] getCor_ij() {
            return cor_ij;
        }

        public double getR() {
            return R;
        }

        public double getRmax() {
            return Rmax;
        }

        public double getTmax() {
            return Tmax;
        }

        public double getT() {
            return t;
        }

        public double getC() {
            return C;
        }
}

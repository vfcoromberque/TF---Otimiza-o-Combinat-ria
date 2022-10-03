import com.problema.Problema;
import com.solucao.Solucao;
import com.tabu.Tabu;
import org.junit.Test;

import java.util.Arrays;

public class TabuTest {

    @Test
    public void test(){
        Problema problema = new Problema(1);
        Solucao solucao = new Solucao(problema);
        Tabu tabu = new Tabu(problema, solucao);

        System.out.println(Arrays.toString(tabu.getSolucao().getMelhorSolucao()));
        System.out.println(tabu.getSolucao().getMovimento());
        System.out.println(tabu.getSolucao().getMelhorRetorno());

        tabu.iteracaoVizinhos();

        System.out.println(Arrays.toString(tabu.getSolucao().getMelhorSolucao()));
        System.out.println(tabu.getSolucao().getMovimento());
        System.out.println(tabu.getSolucao().getMelhorRetorno());


    }

    @Test
    public void testSolve(){
        Problema problema = new Problema(1);
        Solucao solucao = new Solucao(problema);
        Tabu tabu = new Tabu(problema, solucao);

        System.out.println(Arrays.toString(tabu.getProblema().getY()));
        System.out.println(tabu.getSolucao().getMelhorRetorno());

        tabu.solve(600);

        System.out.println(Arrays.toString(tabu.getProblema().getY()));
        System.out.println(tabu.getSolucao().getMelhorRetorno());

    }

    @Test
    public void testSolveMochila(){
        Problema problema = new Problema(1);
        Solucao solucao = new Solucao(problema);
        Tabu tabu = new Tabu(problema, solucao);

        tabu.solve(400);

        System.out.println(Arrays.toString(tabu.getProblema().getY()));

        System.out.println(tabu.getSolucao().getMelhorRetorno());

        tabu.solveMochila();

        System.out.println(Arrays.toString(tabu.getProblema().getY()));


        System.out.println(tabu.getSolucao().getMelhorRetorno());

    }

}

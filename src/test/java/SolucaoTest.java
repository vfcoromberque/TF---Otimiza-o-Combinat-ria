import com.problema.Problema;
import com.solucao.Solucao;
import org.junit.Test;

import java.util.Arrays;

public class SolucaoTest {

    @Test
    public void testeSolucaoInicialComMaiorRetornoUnitario(){
        Problema problema = new Problema(1);
        Solucao solucao = new Solucao(problema);

        boolean[] calculatedValue = solucao.getMelhorSolucao();

        boolean[] expectedValue = new boolean[problema.getNumeroAtivos()];
        expectedValue[33] = true;

        System.out.println(Arrays.toString(calculatedValue));

        System.out.println(Arrays.toString(solucao.getSolucaoAtual()));

        System.out.println(Arrays.toString(expectedValue));

        System.out.println(solucao.getMelhorRetorno());
    }

}

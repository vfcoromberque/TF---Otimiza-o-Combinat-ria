import com.problema.Problema;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ProblemaTest {

    @Test
    public void testeInstanciacaoDoProblema(){
        Problema problema = new Problema(1);
        System.out.println(problema.getNumeroAtivos());
        System.out.println(problema.getBudjet());
        System.out.println(problema.getRiscoMaximo());
        System.out.println(problema.getT());
        System.out.println(problema.getTmax());
        System.out.println(Arrays.toString(problema.getCustoAtivos()));
        System.out.println(Arrays.toString(problema.getRetornoAtivos()));

        System.out.println(Arrays.toString(problema.getCov()[0]));

        System.out.println(Arrays.toString(problema.getCor()[0]));


    }

    @Test
    public void TesteCalculoRisco(){
        Problema problema = new Problema(1);
        boolean[] var = new boolean[problema.getNumeroAtivos()];
        var[0] = true;
        problema.setX(var);
        double expectedValue = problema.getCov()[0][0];
        double calculatedValue = problema.calculoRisco();

        Assert.assertEquals(expectedValue, calculatedValue, 0.01);
    }

    @Test
    public void testeMenorQueRiscoTotal(){
        Problema problema = new Problema(1);
        boolean[] var = new boolean[problema.getNumeroAtivos()];
        var[0] = true;
        problema.setX(var);
        double value = problema.calculoRisco();

        boolean calculatedValue = value <= problema.getRiscoMaximo();

        Assert.assertTrue(calculatedValue);
    }

}

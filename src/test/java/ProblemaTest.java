import com.problema.Problema;
import org.junit.Test;

import java.util.Arrays;

public class ProblemaTest {

    @Test
    public void test(){
        Problema problema = new Problema(1);
        System.out.println(problema.getNumeroAtivos());
        System.out.println(problema.getC());
        System.out.println(problema.getRmax());
        System.out.println(problema.getT());
        System.out.println(problema.getTmax());
        System.out.println(Arrays.toString(problema.getCi()));
        System.out.println(Arrays.toString(problema.getVi()));

        System.out.println(Arrays.toString(problema.getCov_ij()[0]));

        System.out.println(Arrays.toString(problema.getCor_ij()[0]));


    }

}

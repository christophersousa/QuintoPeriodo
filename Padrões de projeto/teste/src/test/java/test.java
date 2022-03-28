import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class test {
    private teste t = new teste();

    @Test
    public void validar() {
        List<String> dados = new ArrayList<String>();

        dados.add("Lorim Impsulom");
        dados.add("Lorim Impsulom");
        dados.add("Lorim Impsulom");

        String oi = teste.exportBody("Hello Word", dados);
        System.out.println(oi);
    }
}

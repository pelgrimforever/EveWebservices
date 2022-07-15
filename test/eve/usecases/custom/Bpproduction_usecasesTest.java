package eve.usecases.custom;

import eve.logicview.View_userbp;
import eve.logicview.View_userbpmaterial;
import eve.usecases.Bpproduction_usecases;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author pelgrim
 */
public class Bpproduction_usecasesTest {
    
    public Bpproduction_usecasesTest() {
    }
    
    @Test
    public void calculateproductionprice_market_usecase_test() {
        View_userbp view_userbp = new View_userbp();
        view_userbp.setMaterialefficiency(10);
        view_userbp.setStationfee(1000d);
        ArrayList<View_userbpmaterial> view_userbpmaterials = new ArrayList<>();
        View_userbpmaterial userbpmaterial = new View_userbpmaterial();
        userbpmaterial.setMarketaverage(1000000d);
        userbpmaterial.setAmount(10);
        view_userbpmaterials.add(userbpmaterial);
        userbpmaterial = new View_userbpmaterial();
        userbpmaterial.setMarketaverage(2000000d);
        userbpmaterial.setAmount(1);
        view_userbpmaterials.add(userbpmaterial);
        Bpproduction_usecases bpproduction_usecases = new Bpproduction_usecases(false);
        double result = bpproduction_usecases.calculateproductionprice_market_usecase(view_userbp, view_userbpmaterials);
        double expectedresult = 10801000d;
        double delta = 0.1d;
        Assert.assertEquals(result, expectedresult, delta);
    }
 
    @Test
    public void calculateproductionprice4user_usecase_test() {
        View_userbp view_userbp = new View_userbp();
        view_userbp.setStationfee(1000d);
        view_userbp.setMaterialefficiency(10);
        ArrayList<View_userbpmaterial> view_userbpmaterials = new ArrayList<>();
        View_userbpmaterial mat = new View_userbpmaterial();
        mat.setMaterialinputaverage(0);
        mat.setMarketaverage(2000);
        mat.setAmount(1);
        view_userbpmaterials.add(mat);
        mat = new View_userbpmaterial();
        mat.setMaterialinputaverage(1600);
        mat.setAmount(10);
        view_userbpmaterials.add(mat);
        Bpproduction_usecases bpproduction_usecases = new Bpproduction_usecases(false);
        double result = bpproduction_usecases.calculateproductionprice4user_usecase(view_userbp, view_userbpmaterials);
        double expectedresult = 17200;
        double delta = 0.1d;
        Assert.assertEquals(result, expectedresult, delta);
    }
}

package eve.usecases.custom;

import eve.usecases.custom.Bpsimulatemarket_usecases;
import eve.usecases.custom.Bpsimulatemarket_parameters;
import eve.logicview.View_evetypes;
import eve.logicview.View_userbpmaterial;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author pelgrim
 */
public class Bpsimulatemarket_usecasesTest {

    public Bpsimulatemarket_parameters parameters;
    public ArrayList<View_userbpmaterial> view_userbpmaterials;
    
    public Bpsimulatemarket_usecasesTest() {
        parameters = new Bpsimulatemarket_parameters();
        parameters.setUsername("testuser");
        View_evetypes view_evetypes = new View_evetypes();
        view_evetypes.setCategory(0);
        view_evetypes.setConfiguredbp(true);
        view_evetypes.setId(0);
        view_evetypes.setName("testbp");
        view_evetypes.setTypegroupid(0);
        view_evetypes.setTypegroupname("testgroup");
        parameters.setViewevetype(view_evetypes);
        parameters.setBpprice(200000);
        parameters.setBpbreakeven(20);
        parameters.setBpmaterialefficiency(10);
        parameters.setResearchcost(5000);
        parameters.setStationfee(200);
        
        view_userbpmaterials = new ArrayList<>();
        View_userbpmaterial mat1 = new View_userbpmaterial();
        mat1.setAmount(1);
        mat1.setBp(0);
        mat1.setCategory(0);
        mat1.setMarketaverage(100);
        mat1.setMaterial(1001);
        mat1.setMaterialinputaverage(90);
        mat1.setName("mat1");
        mat1.setUsername("tetsuser");
        view_userbpmaterials.add(mat1);
        mat1 = new View_userbpmaterial();
        mat1.setAmount(2);
        mat1.setBp(0);
        mat1.setCategory(0);
        mat1.setMarketaverage(200);
        mat1.setMaterial(1002);
        mat1.setMaterialinputaverage(0);
        mat1.setName("mat2");
        mat1.setUsername("tetsuser");
        view_userbpmaterials.add(mat1);
    }

    @Test
    public void calculateproductionprice_market_usecase_test() {
        Bpsimulatemarket_usecases bpsimulatemarket_usecases = new Bpsimulatemarket_usecases(parameters);
        double result = bpsimulatemarket_usecases.calculateproductionprice_market_usecase(view_userbpmaterials);
        double expectedresult = 10900d;
        double delta = 0.1d;
        Assert.assertEquals(result, expectedresult, delta);
    }

    @Test
    public void calculateproductionprice4user_usecase_test() {
        Bpsimulatemarket_usecases bpsimulatemarket_usecases = new Bpsimulatemarket_usecases(parameters);
        double result = bpsimulatemarket_usecases.calculateproductionprice4user_usecase(view_userbpmaterials);
        double expectedresult = 10891d;
        double delta = 0.1d;
        Assert.assertEquals(result, expectedresult, delta);
    }
}

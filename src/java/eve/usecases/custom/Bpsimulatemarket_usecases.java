package eve.usecases.custom;

import eve.BusinessObject.Logic.BLuserbp;
import eve.logicview.View_userbpmaterial;
import eve.usecases.Bpproduction_usecases;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class Bpsimulatemarket_usecases {
    
    private Bpsimulatemarket_parameters parameters;
    
    public Bpsimulatemarket_usecases(Bpsimulatemarket_parameters parameters) {
        this.parameters = parameters;
    }
    
    public double calculateproductionprice_market_usecase(ArrayList<View_userbpmaterial> view_userbpmaterials) {
        double totalprice = calculate_non_material_price();
        double materialefficiency = parameters.getBpmaterialefficiency();
        for(View_userbpmaterial mat: view_userbpmaterials)
            totalprice += Bpproduction_usecases.calculate_net_materialprice(materialefficiency, mat.getMarketaverage(), mat.getAmount());
        return totalprice;
    }
    
    public double calculateproductionprice4user_usecase(ArrayList<View_userbpmaterial> view_userbpmaterials) {
        double totalprice = calculate_non_material_price();
        for(View_userbpmaterial mat: view_userbpmaterials)
            totalprice += calculate_material_price(mat);
        return totalprice;
    }
    
    private double calculate_non_material_price() {
        return parameters.getStationfee() + (parameters.getBpprice() + parameters.getResearchcost()) / parameters.getBpbreakeven();
    }
    
    private double calculate_material_price(View_userbpmaterial mat) {
        double materialefficiency = parameters.getBpmaterialefficiency();
        double materialprice = 0;
        if(mat.getMaterialinputaverage()==0)
            materialprice = mat.getMarketaverage();
        else
            materialprice = mat.getMaterialinputaverage();
        return Bpproduction_usecases.calculate_net_materialprice(materialefficiency, materialprice, mat.getAmount());
    }
}

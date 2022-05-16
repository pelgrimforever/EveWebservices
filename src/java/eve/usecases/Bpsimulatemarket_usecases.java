package eve.usecases;

import eve.BusinessObject.Logic.BLview_evetypes;
import eve.BusinessObject.Logic.BLview_userbpmaterial;
import eve.logicview.View_evetypes;
import eve.logicview.View_userbpmaterial;
import general.exception.DBException;
import general.exception.DatahandlerException;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class Bpsimulatemarket_usecases {
    
    private boolean loggedin = false;
    private Bpsimulatemarket_parameters parameters;
    private BLview_evetypes blview_evetypes;
    private BLview_userbpmaterial blview_userbpmaterial;
    private double bpcostfraction;
    private View_evetypes view_evetyperesult;
    private ArrayList<View_userbpmaterial> view_userbpmaterials;
    
    public Bpsimulatemarket_usecases(boolean loggedin, Bpsimulatemarket_parameters parameters) throws DBException, DatahandlerException {
        this.loggedin = loggedin;
        this.parameters = parameters;
        blview_evetypes = new BLview_evetypes();
        blview_evetypes.setAuthenticated(loggedin);
        blview_userbpmaterial = new BLview_userbpmaterial();
        blview_userbpmaterial.setAuthenticated(loggedin);
        bpcostfraction = ((double)parameters.getBpprice() + parameters.getResearchcost()) / parameters.getBpbreakeven();
        view_evetyperesult = blview_evetypes.getBlueprintresult(parameters.getViewevetype());
        view_userbpmaterials = blview_userbpmaterial.getView_userbpmaterials(parameters.getViewevetype().getId(), parameters.getUsername());
    }
 
    public View_evetypes getBlueprintresult_usecase() throws DBException, DatahandlerException {
        return view_evetyperesult;
    }
    
    public ArrayList<View_userbpmaterial> getView_userbpmaterials() throws DBException, DatahandlerException {
        return view_userbpmaterials;
    }

    public double calculateproductionprice_market_usecase() {
        double totalprice = parameters.getStationfee();
        //put division last to avoid rounding errors, all numbers are type long
        for(View_userbpmaterial mat: view_userbpmaterials)
            totalprice += mat.getMarketaverage() * Math.ceil((double)mat.getAmount() * (100-parameters.getBpmaterialefficiency()) / 100);
        return totalprice;
    }
    
    public double calculateproductionprice4user_usecase() throws DBException {
        double totalprice = parameters.getStationfee();
        for(View_userbpmaterial mat: view_userbpmaterials) {
            totalprice += calculate_material_price(mat);
        }
        return totalprice;
    }
    
    public double calculate_material_price(View_userbpmaterial mat) {
        double matprice = 0;
        if(mat.getMaterialinputaverage()==0)
            matprice = mat.getMarketaverage();
        else
            matprice = mat.getMaterialinputaverage();
        //put division last to avoid rounding errors, all numbers are type long
        return matprice * Math.ceil(mat.getAmount() * (100-parameters.getBpmaterialefficiency()) / 100);
    }
}

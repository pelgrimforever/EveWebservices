package eve.usecases;

import eve.BusinessObject.Logic.BLuserbp;
import eve.BusinessObject.Logic.BLview_userbpmaterial;
import eve.logicview.View_userbp;
import eve.logicview.View_userbpmaterial;
import general.exception.DBException;
import general.exception.DatahandlerException;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class Bpproduction_usecases {
    
    private boolean loggedin = false;
    private BLview_userbpmaterial blview_userbpmaterial;
    private BLuserbp bluserbp;
    
    public Bpproduction_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_userbpmaterial = new BLview_userbpmaterial();
        blview_userbpmaterial.setAuthenticated(loggedin);
        bluserbp = new BLuserbp();
        bluserbp.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_userbpmaterial> find_user_materials_for_blueprint_usecase(long bp, int serialnumber, String username) throws DBException, DatahandlerException {
        return blview_userbpmaterial.getView_userbpmaterials(bp, serialnumber, username);
    }
    
    public double calculateproductionprice_market_usecase(View_userbp view_userbp, ArrayList<View_userbpmaterial> view_userbpmaterials) throws DBException, DatahandlerException {
        return bluserbp.calculateproductionprice_market(view_userbp, view_userbpmaterials);
    }
    
    public double calculateproductionprice4user_usecase(View_userbp view_userbp, ArrayList<View_userbpmaterial> view_userbpmaterials) throws DBException, DatahandlerException {
        return bluserbp.calculateproductionprice4user(view_userbp, view_userbpmaterials);
    }
}

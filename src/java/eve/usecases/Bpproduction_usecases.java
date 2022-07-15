package eve.usecases;

import db.SQLreader;
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
    private SQLreader sqlreader;
    private BLview_userbpmaterial blview_userbpmaterial;
    private BLuserbp bluserbp;
    
    public Bpproduction_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        sqlreader = new SQLreader();
        blview_userbpmaterial = new BLview_userbpmaterial(sqlreader);
        blview_userbpmaterial.setAuthenticated(loggedin);
        bluserbp = new BLuserbp(sqlreader);
        bluserbp.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_userbpmaterial> find_user_materials_for_blueprint_usecase(long bp, int serialnumber, String username) throws DBException, DatahandlerException {
        return blview_userbpmaterial.getView_userbpmaterials(bp, serialnumber, username);
    }
    
    public ArrayList<View_userbpmaterial> getView_userbpmaterials_for_blueprint_user_usecase(long bp, String username) throws DBException, DatahandlerException {
        return blview_userbpmaterial.getView_userbpmaterials(bp, username);
    }
    
    public double calculateproductionprice_market_usecase(View_userbp view_userbp, ArrayList<View_userbpmaterial> view_userbpmaterials) {
        double totalprice = view_userbp.getStationfee();
        double materialefficiency = view_userbp.getMaterialefficiency();
        for(View_userbpmaterial mat: view_userbpmaterials) {
            totalprice += calculate_net_materialprice(materialefficiency, mat.getMarketaverage(), mat.getAmount());
        }
        return totalprice;
    }
    
    public double calculateproductionprice4user_usecase(View_userbp view_userbp, ArrayList<View_userbpmaterial> view_userbpmaterials) {
        double totalprice = view_userbp.getStationfee();
        double materialefficiency = view_userbp.getMaterialefficiency();
        double materialprice = 0;
        for(View_userbpmaterial mat: view_userbpmaterials) {
            if(mat.getMaterialinputaverage()==0) {
                materialprice = mat.getMarketaverage();
            } else {
                materialprice = mat.getMaterialinputaverage();
            }
            totalprice += calculate_net_materialprice(materialefficiency, materialprice, mat.getAmount());
        }
        return totalprice;
    }

    public static double calculate_net_materialprice(double materialefficiency, double materialprice, double amount) {
        return materialprice * amount * (100-materialefficiency) / 100;
    }
    
}

/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.11.2021 18:23
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.*;
import eve.logicview.View_evetypes;
import eve.BusinessObject.view.Bview_evetypes;
import eve.conversion.entity.EMview_evetypes;
import eve.searchentity.View_evetypessearch;
import java.util.ArrayList;

public class BLview_evetypes extends Bview_evetypes {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public BLview_evetypes(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList<View_evetypes> getShips() throws DBException {
        Object[][] parameter = {{ "category", BLcategory.SHIP }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
    
    public ArrayList<View_evetypes> getModules() throws DBException {
        Object[][] parameter = {{ "category", BLcategory.MODULE }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
    
    public ArrayList<View_evetypes> getCharges() throws DBException {
        Object[][] parameter = {{ "category", BLcategory.CHARGE }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
    
    public ArrayList<View_evetypes> getDrones() throws DBException {
        Object[][] parameter = {{ "category", BLcategory.DRONE }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
    
    public ArrayList<View_evetypes> getDeployables() throws DBException {
        Object[][] parameter = {{ "category", BLcategory.DEPLOYABLE }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
        
    public ArrayList<View_evetypes> getMinerals() throws DBException {
        Object[][] parameter = {{ "typegroupid", BLtypegroup.MINERALS }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_evetypes.SQLSelect4Typegroup, sqlparameters);
    }
        
    public ArrayList<View_evetypes> getSalvagedmaterials() throws DBException {
        Object[][] parameter = {{ "typegroupid", BLtypegroup.SALVAGEDMATERIAL }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_evetypes.SQLSelect4Typegroup, sqlparameters);
    }
        
    public ArrayList<View_evetypes> getBlueprints(String searchstring) throws DBException {
        Object[][] parameter = {{ "category", BLcategory.BLUEPRINT }, { "searchstring", searchstring }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_evetypes.SQLSelect4Categorysearch, sqlparameters);
    }

    public View_evetypes getBlueprintresult(View_evetypes bpview) throws DBException {
        int bpsuffixlength = 10; //" Blueprint" at end of a BP name 
        String bpname = bpview.getName();
        String name = bpname.substring(0, bpname.length() - bpsuffixlength);
        View_evetypessearch search = new View_evetypessearch();
        String[] names = { name };
        search.name(names);
        ArrayList<View_evetypes> viewevetypes = viewio.search(search);
        View_evetypes result = null;
        if(viewevetypes.size()>0)
            result = viewevetypes.get(0);
        return result;
    }
    
    public ArrayList<View_evetypes> getCommodities(String searchstring) throws DBException {
        Object[][] parameter = {{ "category", BLcategory.COMMODITY }, { "searchstring", searchstring }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_evetypes.SQLSelect4Categorysearch, sqlparameters);
    }

    public ArrayList<View_evetypes> getMaterials() throws DBException {
        Object[][] parameter = {{ "category", BLcategory.MATERIAL }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
    
    public ArrayList<View_evetypes> getPlanetarycommodities() throws DBException {
        Object[][] parameter = {{ "category", BLcategory.PLANETARYCOMMODITY }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }    
    
}

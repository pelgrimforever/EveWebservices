/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.gis.shape.piPoint;
import eve.interfaces.searchentity.*;
import eve.logicview.*;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.logicentity.*;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

public class View_stocktrade_system_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_stocktrade_system blview_stocktrade_system = new BLview_stocktrade_system(sqlreader);
    
    public View_stocktrade_system_usecases() {
        this(false);
    }
    
    public View_stocktrade_system_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_stocktrade_system.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_stocktrade_system> get_all() throws DBException {
        return blview_stocktrade_system.getView_stocktrade_systems();
    }
    
//Custom code, do not change this line
//add here custom operations
    private Usersettings_usecases usersettings_usecases = new Usersettings_usecases();
    private BLusersettings blusersettings = new BLusersettings(sqlreader);
    private BLsyssettings blsyssettings = new BLsyssettings(sqlreader);
    
    public ArrayList<View_stocktrade_system> getView_stocktrade_system4username_usecase(String username) throws DataException, DBException {
        blusersettings.setAuthenticated(loggedin);
        blsyssettings.setAuthenticated(loggedin);
        
        ArrayList<Usersettings> usersettings = usersettings_usecases.get_all_4user_usecase(username);
        Usersettings usersettingStocksystemid = blusersettings.getUsersetting(usersettings, Settings.STOCKSYSTEMID);
        Syssettings syssettingBrokerfee = blsyssettings.getSyssettings(Syssettings.BROKER_FEE);
        float perc_tax = Float.valueOf(syssettingBrokerfee.getValue());
        float perc_net = 1 - perc_tax;        
        boolean usersettingStocksystemid_found = usersettingStocksystemid!=null && usersettingStocksystemid.getValue()!=null;
        ArrayList<View_stocktrade_system> viewstocktradesystems = new ArrayList();
        if(usersettingStocksystemid_found)
            viewstocktradesystems = get_and_calculate_sellprices(usersettingStocksystemid, username, perc_net);
        return viewstocktradesystems;
    }

    private ArrayList<View_stocktrade_system> get_and_calculate_sellprices(
            Usersettings usersettingStocksystemid, 
            String username, 
            float perc_net) 
            throws DBException, NumberFormatException, DataException {
        long stocksystemid = Long.valueOf(usersettingStocksystemid.getValue());
        ArrayList<View_stocktrade_system> viewstocktradesystems = blview_stocktrade_system.getViewstocktradesystems_for_user_startsystem(username, stocksystemid);
        for(View_stocktrade_system stocktradesystem: viewstocktradesystems)
            stocktradesystem.setSellprice(stocktradesystem.getSellprice()*perc_net);
        return viewstocktradesystems;
    }
//Custom code, do not change this line   

}


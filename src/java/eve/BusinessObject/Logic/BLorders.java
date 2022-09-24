/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 20.4.2021 16:1
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IOrders;
import eve.logicentity.Orders;
import db.*;
import data.conversion.JSONConversion;
import db.*;
import db.SQLTqueue;
import eve.BusinessObject.table.Borders;
import eve.conversion.entity.EMorders;
import eve.data.Swagger;
import eve.entity.pk.EvetypePK;
import eve.entity.pk.OrdersPK;
import eve.entity.pk.Security_islandPK;
import eve.entity.pk.SystemPK;
import general.exception.DataException;
import eve.interfaces.entity.pk.IEvetypePK;
import eve.interfaces.entity.pk.ISystemPK;
import java.util.ArrayList;
import org.json.simple.JSONObject;

public class BLorders extends Borders {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLorders(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLorders(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }



    public void resetorders(SQLTqueue transactionqueue) throws DBException, DataException {
        Object[][] parameter = {{ "isopen", false }};
        SQLparameters sqlparameter = new SQLparameters(parameter);
        addStatement(transactionqueue, EMorders.SQLreset, sqlparameter);
    }
    
    public void deleteorders(SQLTqueue transactionqueue) throws DBException, DataException {
        addStatement(transactionqueue, EMorders.Truncate);
    }
    
    public ArrayList<Orders> load_sellorders4system(ISystemPK systemPK, double max_cargovolume, double net_perc) throws DBException {
        Object[][] parameter = { { "max_cargovolume", max_cargovolume }, { "net_perc", net_perc } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        sqlparameters.add(systemPK.getSQLprimarykey());
        return getEntities(EMorders.SQLgetSellorders4system2, sqlparameters);
    }

    public ArrayList<Orders> load_sellorders4systemevetype(ISystemPK systemPK, IEvetypePK evetypePK) throws DBException {
        SQLparameters sqlparameters = new SQLparameters(systemPK.getSQLprimarykey(), evetypePK.getSQLprimarykey());
        return getEntities(EMorders.SQLgetSellorders4systemevetype, sqlparameters);
    }

    public ArrayList<Orders> load_buyorders4systemevetype(ISystemPK systemPK, IEvetypePK evetypePK) throws DBException {
        SQLparameters sqlparameters = new SQLparameters(systemPK.getSQLprimarykey(), evetypePK.getSQLprimarykey());
        return getEntities(EMorders.SQLgetBuyorders4systemevetype, sqlparameters);
    }

    public ArrayList<Orders> load_buyorders4system(ISystemPK systemPK, double max_cargovolume, double net_perc) throws DBException {
        Object[][] parameter = { { "max_cargovolume", max_cargovolume }, { "net_perc", net_perc } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        sqlparameters.add(systemPK.getSQLprimarykey(), systemPK.getSQLprimarykey());
        return getEntities(EMorders.SQLgetBuyorders4system2, sqlparameters);
    }    

    public ArrayList<Orders> load_buyorders4evetype(Security_islandPK security_islandPK, IEvetypePK evetypePK) throws DBException {
        SQLparameters sqlparameters = new SQLparameters(security_islandPK.getSQLprimarykey(), evetypePK.getSQLprimarykey());
        return getEntities(EMorders.SQLgetBuyorders4evetype, sqlparameters);
    }    

    public ArrayList<Orders> load_buyorders4evetype(SystemPK systemPK, IEvetypePK evetypePK) throws DBException {
        SQLparameters sqlparameters = new SQLparameters(systemPK.getSQLprimarykey(), evetypePK.getSQLprimarykey());
        return getEntities(EMorders.SQLgetClosestBuyorders4evetype, sqlparameters);
    }    

    public ArrayList<Orders> load_Tradebuyorders() throws DBException {
        return getEntities(EMorders.SQLgetOrdersTradebuy);
    }
    
    public ArrayList<Orders> load_Tradesellorders(OrdersPK ordersPK) throws DBException {
        return getEntities(EMorders.SQLgetOrdersTradesell4order, ordersPK.getSQLprimarykey());
    }
    
}

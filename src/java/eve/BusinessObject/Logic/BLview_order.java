/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.6.2021 14:35
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import db.*;
import general.exception.DBException;
import eve.logicview.View_order;
import eve.BusinessObject.view.Bview_order;
import eve.conversion.entity.EMview_order;
import eve.entity.pk.EvetypePK;
import eve.entity.pk.RegionPK;
import eve.entity.pk.SystemPK;
import eve.interfaces.entity.pk.IOrdersPK;
import eve.interfaces.logicentity.ISyssettings;
import eve.logicentity.Syssettings;
import general.exception.DataException;
import java.util.ArrayList;

public class BLview_order extends Bview_order {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_order(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList getOrders4Wishlist(String username) throws DBException {
        Object[][] parameter = {{ "username", username }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_order.SQLSelect4wishlist, sqlparameters);
    }
    
    public View_order getView_order(IOrdersPK orderPK) throws DBException {
        return (View_order)viewio.getEntity(EMview_order.SQLSelectOne, orderPK.getSQLprimarykey());
    }

    public ArrayList getView_orders4evetype_sell(EvetypePK evetypePK) throws DBException {
        return viewio.getEntities(EMview_order.SQLSelect4Evetypesell, evetypePK.getSQLprimarykey());
    }

    public ArrayList getView_orders4evetyperegion_sell(EvetypePK evetypePK, RegionPK regionPK) throws DBException {
        SQLparameters sqlparameters = new SQLparameters(evetypePK.getSQLprimarykey(), regionPK.getSQLprimarykey());
        return viewio.getEntities(EMview_order.SQLSelect4Evetyperegionsell, sqlparameters);
    }

    public ArrayList getView_orders4evetype_buy(EvetypePK evetypePK) throws DBException {
        return viewio.getEntities(EMview_order.SQLSelect4Evetypebuy, evetypePK.getSQLprimarykey());
    }

    public ArrayList getView_ordersAtselllowprice(SystemPK systemPK) throws DBException, DataException {
        BLsyssettings blsyssettings = new BLsyssettings(viewio.getSQLreader());
        Syssettings set_maxcargo = blsyssettings.getSyssettings(ISyssettings.MAXCARGO);
        float max_cargo = Float.valueOf(set_maxcargo.getValue());
        Object[][] parameters = { { "maxcargo", max_cargo }, { "pricefactor", 10 } };
        SQLparameters sqlparameters = new SQLparameters(parameters);
        sqlparameters.add(systemPK.getSQLprimarykey());
        return viewio.getEntities(EMview_order.SQLSelect4selllowprice, sqlparameters);
    }
}

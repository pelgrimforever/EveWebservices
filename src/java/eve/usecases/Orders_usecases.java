/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.*;
import eve.logicentity.Orders;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Orders_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLorders blorders = new BLorders(sqlreader);
    
    public Orders_usecases() {
        this(false);
    }
    
    public Orders_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blorders.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public Orderupdate_data get_ordersupdate_usecase(OrdersPK sellordersPK, OrdersPK buyordersPK) throws DBException {
        Orderupdate_data orderupdate_data = new Orderupdate_data();
        orderupdate_data.setSellamount(get_order_amount_from_swagger(sellordersPK));
        orderupdate_data.setBuyamount(get_order_amount_from_swagger(buyordersPK));
        return orderupdate_data;
    }
    
    public long get_order_amount_from_swagger(OrdersPK ordersPK) throws DBException {
        View_order_usecases view_order_usecases = new View_order_usecases(loggedin);
        eve.logicview.View_order order = view_order_usecases.getView_order_for_primarykey_usecase(ordersPK);
        eve.usecases.custom.Swagger_usecases swagger_usecases = new eve.usecases.custom.Swagger_usecases();
        org.json.simple.JSONObject jsonsellorder = swagger_usecases.findOrder(order.getRegion(), order.getPage(), ordersPK.getId());
        if(jsonsellorder!=null)
            return JSONConversion.getLong(jsonsellorder, "volume_remain");
        else
            return 0;
    }
    
    public class Orderupdate_data {
        private long sellamount = 0;
        private long buyamount = 0;

        public long getSellamount() {
            return sellamount;
        }

        public void setSellamount(long sellamount) {
            this.sellamount = sellamount;
        }

        public long getBuyamount() {
            return buyamount;
        }

        public void setBuyamount(long buyamount) {
            this.buyamount = buyamount;
        }
    }

    private org.json.simple.JSONObject findOrder(org.json.simple.JSONArray jsonorders, long orderid) {
        org.json.simple.JSONObject result = null;
        org.json.simple.JSONObject jsonorder;
        Iterator<org.json.simple.JSONObject> jsonordersI = jsonorders.iterator();
        boolean keeprunning = true;
        while(jsonordersI.hasNext() && keeprunning) {
            jsonorder = jsonordersI.next();
            if(JSONConversion.getLong(jsonorder, "order_id")==orderid) {
                result = jsonorder;
                keeprunning = false;
            }
        }
        return result;
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blorders.count();
    }
    
    public ArrayList<Orders> get_all() throws DBException {
        return blorders.getOrderss();
    }
    
    public boolean getOrdersExists(IOrdersPK ordersPK) throws DBException {
        return blorders.getOrdersExists(ordersPK);
    }
    
    public Orders get_orders_by_primarykey(IOrdersPK ordersPK) throws DBException {
        return blorders.getOrders(ordersPK);
    }

    public ArrayList<Orders> get_orders_with_foreignkey_evetype(IEvetypePK evetypePK) throws CustomException {
        return blorders.getOrderss4evetype(evetypePK);
    }
    
    public ArrayList<Orders> get_orders_with_foreignkey_system(ISystemPK systemPK) throws CustomException {
        return blorders.getOrderss4system(systemPK);
    }
    
    public Orders get_orders_with_externalforeignkey_tradecombined_sellBuy_order_id(ITradecombined_sellPK tradecombined_sellBuy_order_idPK) throws CustomException {
        return blorders.getTradecombined_sellbuy_order_id(tradecombined_sellBuy_order_idPK);
    }
    
    public Orders get_orders_with_externalforeignkey_tradecombined_sellSell_order_id(ITradecombined_sellPK tradecombined_sellSell_order_idPK) throws CustomException {
        return blorders.getTradecombined_sellsell_order_id(tradecombined_sellSell_order_idPK);
    }
    
    public Orders get_orders_with_externalforeignkey_shipfitorderselected(IShipfitorderselectedPK shipfitorderselectedPK) throws CustomException {
        return blorders.getShipfitorderselected(shipfitorderselectedPK);
    }
    
    public Orders get_orders_with_externalforeignkey_tradeSell_order_id(ITradePK tradeSell_order_idPK) throws CustomException {
        return blorders.getTradesell_order_id(tradeSell_order_idPK);
    }
    
    public Orders get_orders_with_externalforeignkey_tradeBuy_order_id(ITradePK tradeBuy_order_idPK) throws CustomException {
        return blorders.getTradebuy_order_id(tradeBuy_order_idPK);
    }
    
    public ArrayList<Orders> search_orders(IOrderssearch orderssearch) throws CustomException {
        return blorders.search(orderssearch);
    }
    
    public long search_orders_count(IOrderssearch orderssearch) throws CustomException {
        return blorders.searchcount(orderssearch);
    }

    public void insertOrders(IOrders orders) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blorders.insertOrders(tq, orders);
        sqlwriter.Commit2DB(tq);
    }

    public void updateOrders(IOrders orders) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blorders.updateOrders(tq, orders);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteOrders(IOrders orders) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blorders.deleteOrders(tq, orders);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Evetype(IEvetypePK evetypePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blorders.delete4evetype(tq, evetypePK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_System(ISystemPK systemPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blorders.delete4system(tq, systemPK);
        sqlwriter.Commit2DB(tq);
    }
    
}


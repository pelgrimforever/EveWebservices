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

public class View_tradecombined_sell_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_tradecombined_sell blview_tradecombined_sell = new BLview_tradecombined_sell(sqlreader);
    
    public View_tradecombined_sell_usecases() {
        this(false);
    }
    
    public View_tradecombined_sell_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_tradecombined_sell.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_tradecombined_sell> get_all() throws DBException {
        return blview_tradecombined_sell.getView_tradecombined_sells();
    }
    
//Custom code, do not change this line
//add here custom operations
    private View_order_usecases view_order_usecases = new View_order_usecases(loggedin);
    private eve.usecases.custom.Swagger_usecases swagger_usecases = new eve.usecases.custom.Swagger_usecases();
    
    public ArrayList<View_tradecombined_sell> getView_tradecombined_sells_for_evetype(TradecombinedPK tradecombinedPK) throws DBException {
        ArrayList<View_tradecombined_sell> tradelines = blview_tradecombined_sell.getView_tradecombined_sells_for_evetype(tradecombinedPK);
        for(View_tradecombined_sell tradeline: tradelines)
            update_tradeline_volume_remain(tradeline);
        return tradelines;
    }

    private void update_tradeline_volume_remain(View_tradecombined_sell tradeline) throws DBException {
        View_order sellorder = view_order_usecases.getView_order_for_orderid_usecase(tradeline.getSell_id());
        View_order buyorder = view_order_usecases.getView_order_for_orderid_usecase(tradeline.getBuy_id());
        org.json.simple.JSONObject swaggersellorder = getSwaggerorder(sellorder);
        org.json.simple.JSONObject swaggerbuyorder = getSwaggerorder(buyorder);
        if(swaggersellorder!=null)
            tradeline.setSell_updated(JSONConversion.getLong(swaggersellorder, "volume_remain"));
        if(swaggerbuyorder!=null)
            tradeline.setBuy_updated(JSONConversion.getLong(swaggerbuyorder, "volume_remain"));
    }
    
    private org.json.simple.JSONObject getSwaggerorder(View_order view_order) {
        return swagger_usecases.findOrder(view_order.getRegion(), view_order.getPage(), view_order.getId());
    }

    public ArrayList<View_tradecombined_sell> getView_tradecombined_sells_for_all_evetypes(SystemPK sell_systemPK, SystemPK buy_systemPK) throws DBException {
        ArrayList<View_tradecombined_sell> tradelines = blview_tradecombined_sell.getView_tradecombined_sells_for_all_evetypes(sell_systemPK, buy_systemPK);
        for(View_tradecombined_sell tradeline: tradelines)
            update_tradeline_volume_remain(tradeline);
        return tradelines;
    }
//Custom code, do not change this line   

}


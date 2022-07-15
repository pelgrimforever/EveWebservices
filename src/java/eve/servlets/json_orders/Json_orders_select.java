/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.json_orders;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IJson_orders;
import eve.interfaces.servlet.IJson_ordersOperation;
import eve.interfaces.searchentity.IJson_orderssearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Json_orders_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name="Json_orders_select", urlPatterns={"/eve.Json_orders_select"})
public class Json_orders_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Json_orders_usecases json_ordersusecases = new Json_orders_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IJson_ordersOperation.SELECT_ALL:
                    dataobject = json_ordersusecases.get_all();
                    break;
                case IJson_ordersOperation.SELECT_JSON_ORDERS:
                    dataobject = get_json_orders_with_primarykey(json_ordersusecases);
                    break;
                case IJson_ordersOperation.SELECT_SEARCH:
                    dataobject = search_json_orders(json_ordersusecases);
                    break;
                case IJson_ordersOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_json_orders_count(json_ordersusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    private Object get_json_orders_with_primarykey(Json_orders_usecases json_ordersusecases) throws DBException {
        IJson_ordersPK json_ordersPK = (IJson_ordersPK)parser.getJavaObject("json_orderspk");
        return json_ordersusecases.get_json_orders_by_primarykey(json_ordersPK);
    }

    private Object search_json_orders(Json_orders_usecases json_ordersusecases) throws CustomException {
        IJson_orderssearch search = (IJson_orderssearch)parser.getJavaObject("search");
        return json_ordersusecases.search_json_orders(search);
    }
    
    private Object search_json_orders_count(Json_orders_usecases json_ordersusecases) throws CustomException {
        IJson_orderssearch json_orderssearch = (IJson_orderssearch)parser.getJavaObject("search");
        return json_ordersusecases.search_json_orders_count(json_orderssearch);
    }

    @Override
    public String getServletInfo() {
        return "json_orders_select";
    }

}

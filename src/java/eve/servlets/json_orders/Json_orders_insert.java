/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
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

@WebServlet(name="Json_orders_insert", urlPatterns={"/eve.Json_orders_insert"})
public class Json_orders_insert extends SecurityDataServlet {
   
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
                case IJson_ordersOperation.INSERT_JSON_ORDERS:
                    insert_json_orders(json_ordersusecases);
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

    private void insert_json_orders(Json_orders_usecases json_ordersusecases) throws CustomException {
        IJson_orders json_orders = (IJson_orders)parser.getJavaObject("json_orders");
        json_ordersusecases.insertJson_orders(json_orders);
    }
    
    @Override
    public String getServletInfo() {
        return "json_orders_insert";
    }

}


/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 8.5.2021 19:33
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IJson_orders;
import eve.interfaces.servlet.IJson_ordersOperation;
import eve.interfaces.searchentity.IJson_orderssearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Franky Laseure
 */
@WebServlet(name="Json_orders", urlPatterns={"/eve.Json_orders"})
public class Json_orders extends SecurityDataServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLjson_orders bljson_orders = new BLjson_orders();
        bljson_orders.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IJson_ordersPK json_ordersPK;
                    IJson_orders json_orders;
                    switch(this.operation) {
                        case IJson_ordersOperation.SELECT_ALL:
                            dataobject = bljson_orders.getJson_orderss();
                            break;
                        case IJson_ordersOperation.SELECT_JSON_ORDERS:
                            json_ordersPK = (IJson_ordersPK)parser.getJavaObject("json_orderspk");
                            dataobject = bljson_orders.getJson_orders(json_ordersPK);
                            break;
                        case IJson_ordersOperation.SELECT_SEARCH:
                            IJson_orderssearch search = (IJson_orderssearch)parser.getJavaObject("search");
                            dataobject = bljson_orders.search(search);
                            break;
                        case IJson_ordersOperation.SELECT_SEARCHCOUNT:
                            IJson_orderssearch json_orderssearch = (IJson_orderssearch)parser.getJavaObject("search");
                            dataobject = bljson_orders.searchcount(json_orderssearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IJson_ordersOperation.INSERT_JSON_ORDERS:
                            json_orders = (IJson_orders)parser.getJavaObject("json_orders");
                            bljson_orders.insertJson_orders(json_orders);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IJson_ordersOperation.UPDATE_JSON_ORDERS:
                            json_orders = (IJson_orders)parser.getJavaObject("json_orders");
                            bljson_orders.updateJson_orders(json_orders);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IJson_ordersOperation.DELETE_JSON_ORDERS:
                            json_orders = (IJson_orders)parser.getJavaObject("json_orders");
                            bljson_orders.deleteJson_orders(json_orders);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_BACKUP:
                    switch(this.operation) {
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line
                    }
                    break;
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "json_orders";
    }

}


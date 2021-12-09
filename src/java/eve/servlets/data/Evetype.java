/*
 * Evetype.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 9.11.2021 14:30
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IEvetype;
import eve.interfaces.servlet.IEvetypeOperation;
import eve.interfaces.searchentity.IEvetypesearch;
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
@WebServlet(name="Evetype", urlPatterns={"/eve.Evetype"})
public class Evetype extends SecurityDataServlet {
   
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
        BLevetype blevetype = new BLevetype();
        blevetype.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IEvetypePK evetypePK;
                    IEvetype evetype;
                    switch(this.operation) {
                        case IEvetypeOperation.SELECT_ALL:
                            dataobject = blevetype.getEvetypes();
                            break;
                        case IEvetypeOperation.SELECT_EVETYPE:
                            evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            dataobject = blevetype.getEvetype(evetypePK);
                            break;
                        case IEvetypeOperation.SELECT_Market_group:
                            IMarket_groupPK market_groupPK = (IMarket_groupPK)parser.getJavaObject("market_grouppk");
                            dataobject = blevetype.getEvetypes4market_group(market_groupPK);
                            break;
                        case IEvetypeOperation.SELECT_Typegroup:
                            ITypegroupPK typegroupPK = (ITypegroupPK)parser.getJavaObject("typegrouppk");
                            dataobject = blevetype.getEvetypes4typegroup(typegroupPK);
                            break;
                        case IEvetypeOperation.SELECT_Graphic:
                            IGraphicPK graphicPK = (IGraphicPK)parser.getJavaObject("graphicpk");
                            dataobject = blevetype.getEvetypes4graphic(graphicPK);
                            break;
                        case IEvetypeOperation.SELECT_Stock:
                            IStockPK stockPK = (IStockPK)parser.getJavaObject("stockpk");
                            dataobject = blevetype.getStock(stockPK);
                            break;
                        case IEvetypeOperation.SELECT_Order_history:
                            IOrder_historyPK order_historyPK = (IOrder_historyPK)parser.getJavaObject("order_historypk");
                            dataobject = blevetype.getOrder_history(order_historyPK);
                            break;
                        case IEvetypeOperation.SELECT_Tradecombined:
                            ITradecombinedPK tradecombinedPK = (ITradecombinedPK)parser.getJavaObject("tradecombinedpk");
                            dataobject = blevetype.getTradecombined(tradecombinedPK);
                            break;
                        case IEvetypeOperation.SELECT_SEARCH:
                            IEvetypesearch search = (IEvetypesearch)parser.getJavaObject("search");
                            dataobject = blevetype.search(search);
                            break;
                        case IEvetypeOperation.SELECT_SEARCHCOUNT:
                            IEvetypesearch evetypesearch = (IEvetypesearch)parser.getJavaObject("search");
                            dataobject = blevetype.searchcount(evetypesearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IEvetypeOperation.INSERT_EVETYPE:
                            evetype = (IEvetype)parser.getJavaObject("evetype");
                            blevetype.insertEvetype(evetype);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IEvetypeOperation.UPDATE_EVETYPE:
                            evetype = (IEvetype)parser.getJavaObject("evetype");
                            blevetype.updateEvetype(evetype);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IEvetypeOperation.DELETE_EVETYPE:
                            evetype = (IEvetype)parser.getJavaObject("evetype");
                            blevetype.deleteEvetype(evetype);
                            break;
                        case IEvetypeOperation.DELETE_Market_group:
                            IMarket_groupPK market_groupPK = (IMarket_groupPK)parser.getJavaObject("market_grouppk");
                            blevetype.delete4market_group(market_groupPK);
                            break;
                        case IEvetypeOperation.DELETE_Typegroup:
                            ITypegroupPK typegroupPK = (ITypegroupPK)parser.getJavaObject("typegrouppk");
                            blevetype.delete4typegroup(typegroupPK);
                            break;
                        case IEvetypeOperation.DELETE_Graphic:
                            IGraphicPK graphicPK = (IGraphicPK)parser.getJavaObject("graphicpk");
                            blevetype.delete4graphic(graphicPK);
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
        return "evetype";
    }

}


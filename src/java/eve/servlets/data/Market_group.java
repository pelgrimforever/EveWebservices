/*
 * Market_group.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 6.9.2021 16:29
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IMarket_group;
import eve.interfaces.servlet.IMarket_groupOperation;
import eve.interfaces.searchentity.IMarket_groupsearch;
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
@WebServlet(name="Market_group", urlPatterns={"/eve.Market_group"})
public class Market_group extends SecurityDataServlet {
   
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
        BLmarket_group blmarket_group = new BLmarket_group();
        blmarket_group.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IMarket_groupPK market_groupPK;
                    IMarket_group market_group;
                    switch(this.operation) {
                        case IMarket_groupOperation.SELECT_ALL:
                            dataobject = blmarket_group.getMarket_groups();
                            break;
                        case IMarket_groupOperation.SELECT_MARKET_GROUP:
                            market_groupPK = (IMarket_groupPK)parser.getJavaObject("market_grouppk");
                            dataobject = blmarket_group.getMarket_group(market_groupPK);
                            break;
                        case IMarket_groupOperation.SELECT_Market_groupparent_id:
                            IMarket_groupPK market_groupParent_idPK = (IMarket_groupPK)parser.getJavaObject("market_grouppk");
                            dataobject = blmarket_group.getMarket_groups4market_groupParent_id(market_groupParent_idPK);
                            break;
                        case IMarket_groupOperation.SELECT_SEARCH:
                            IMarket_groupsearch search = (IMarket_groupsearch)parser.getJavaObject("search");
                            dataobject = blmarket_group.search(search);
                            break;
                        case IMarket_groupOperation.SELECT_SEARCHCOUNT:
                            IMarket_groupsearch market_groupsearch = (IMarket_groupsearch)parser.getJavaObject("search");
                            dataobject = blmarket_group.searchcount(market_groupsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IMarket_groupOperation.INSERT_MARKET_GROUP:
                            market_group = (IMarket_group)parser.getJavaObject("market_group");
                            blmarket_group.insertMarket_group(market_group);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IMarket_groupOperation.UPDATE_MARKET_GROUP:
                            market_group = (IMarket_group)parser.getJavaObject("market_group");
                            blmarket_group.updateMarket_group(market_group);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IMarket_groupOperation.DELETE_MARKET_GROUP:
                            market_group = (IMarket_group)parser.getJavaObject("market_group");
                            blmarket_group.deleteMarket_group(market_group);
                            break;
                        case IMarket_groupOperation.DELETE_Market_groupparent_id:
                            IMarket_groupPK market_groupParent_idPK = (IMarket_groupPK)parser.getJavaObject("market_grouppk");
                            blmarket_group.delete4market_groupParent_id(this.getServletName(), market_groupParent_idPK);
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
        return "market_group";
    }

}


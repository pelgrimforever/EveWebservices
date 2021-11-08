/*
 * Systemtrade.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 8.10.2021 7:21
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ISystemtrade;
import eve.interfaces.servlet.ISystemtradeOperation;
import eve.interfaces.searchentity.ISystemtradesearch;
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
@WebServlet(name="Systemtrade", urlPatterns={"/eve.Systemtrade"})
public class Systemtrade extends SecurityDataServlet {
   
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
        BLsystemtrade blsystemtrade = new BLsystemtrade();
        blsystemtrade.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ISystemtradePK systemtradePK;
                    ISystemtrade systemtrade;
                    switch(this.operation) {
                        case ISystemtradeOperation.SELECT_ALL:
                            dataobject = blsystemtrade.getSystemtrades();
                            break;
                        case ISystemtradeOperation.SELECT_SYSTEMTRADE:
                            systemtradePK = (ISystemtradePK)parser.getJavaObject("systemtradepk");
                            dataobject = blsystemtrade.getSystemtrade(systemtradePK);
                            break;
                        case ISystemtradeOperation.SELECT_Systemsell_system:
                            ISystemPK systemSell_systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            dataobject = blsystemtrade.getSystemtrades4systemSell_system(systemSell_systemPK);
                            break;
                        case ISystemtradeOperation.SELECT_Systembuy_system:
                            ISystemPK systemBuy_systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            dataobject = blsystemtrade.getSystemtrades4systemBuy_system(systemBuy_systemPK);
                            break;
                        case ISystemtradeOperation.SELECT_Systemtrade_order:
                            ISystemtrade_orderPK systemtrade_orderPK = (ISystemtrade_orderPK)parser.getJavaObject("systemtrade_orderpk");
                            dataobject = blsystemtrade.getSystemtrade_order(systemtrade_orderPK);
                            break;
                        case ISystemtradeOperation.SELECT_SEARCH:
                            ISystemtradesearch search = (ISystemtradesearch)parser.getJavaObject("search");
                            dataobject = blsystemtrade.search(search);
                            break;
                        case ISystemtradeOperation.SELECT_SEARCHCOUNT:
                            ISystemtradesearch systemtradesearch = (ISystemtradesearch)parser.getJavaObject("search");
                            dataobject = blsystemtrade.searchcount(systemtradesearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ISystemtradeOperation.INSERT_SYSTEMTRADE:
                            systemtrade = (ISystemtrade)parser.getJavaObject("systemtrade");
                            blsystemtrade.insertSystemtrade(systemtrade);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ISystemtradeOperation.UPDATE_SYSTEMTRADE:
                            systemtrade = (ISystemtrade)parser.getJavaObject("systemtrade");
                            blsystemtrade.updateSystemtrade(systemtrade);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ISystemtradeOperation.DELETE_SYSTEMTRADE:
                            systemtrade = (ISystemtrade)parser.getJavaObject("systemtrade");
                            blsystemtrade.deleteSystemtrade(systemtrade);
                            break;
                        case ISystemtradeOperation.DELETE_Systemsell_system:
                            ISystemPK systemSell_systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            blsystemtrade.delete4systemSell_system(systemSell_systemPK);
                            break;
                        case ISystemtradeOperation.DELETE_Systembuy_system:
                            ISystemPK systemBuy_systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            blsystemtrade.delete4systemBuy_system(systemBuy_systemPK);
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
        return "systemtrade";
    }

}


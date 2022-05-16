/*
 * Tradecombined.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 11.4.2022 9:13
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ITradecombined;
import eve.interfaces.servlet.ITradecombinedOperation;
import eve.interfaces.searchentity.ITradecombinedsearch;
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
@WebServlet(name="Tradecombined", urlPatterns={"/eve.Tradecombined"})
public class Tradecombined extends SecurityDataServlet {
   
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
        BLtradecombined bltradecombined = new BLtradecombined();
        bltradecombined.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.SELECT:
                    ITradecombinedPK tradecombinedPK;
                    ITradecombined tradecombined;
                    switch(this.operation) {
                        case ITradecombinedOperation.SELECT_ALL:
                            dataobject = bltradecombined.getTradecombineds();
                            break;
                        case ITradecombinedOperation.SELECT_TRADECOMBINED:
                            tradecombinedPK = (ITradecombinedPK)parser.getJavaObject("tradecombinedpk");
                            dataobject = bltradecombined.getTradecombined(tradecombinedPK);
                            break;
                        case ITradecombinedOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            dataobject = bltradecombined.getTradecombineds4evetype(evetypePK);
                            break;
                        case ITradecombinedOperation.SELECT_Systembuy_system:
                            ISystemPK systemBuy_systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            dataobject = bltradecombined.getTradecombineds4systemBuy_system(systemBuy_systemPK);
                            break;
                        case ITradecombinedOperation.SELECT_Systemsell_system:
                            ISystemPK systemSell_systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            dataobject = bltradecombined.getTradecombineds4systemSell_system(systemSell_systemPK);
                            break;
                        case ITradecombinedOperation.SELECT_Tradecombined_sell:
                            ITradecombined_sellPK tradecombined_sellPK = (ITradecombined_sellPK)parser.getJavaObject("tradecombined_sellpk");
                            dataobject = bltradecombined.getTradecombined_sell(tradecombined_sellPK);
                            break;
                        case ITradecombinedOperation.SELECT_SEARCH:
                            ITradecombinedsearch search = (ITradecombinedsearch)parser.getJavaObject("search");
                            dataobject = bltradecombined.search(search);
                            break;
                        case ITradecombinedOperation.SELECT_SEARCHCOUNT:
                            ITradecombinedsearch tradecombinedsearch = (ITradecombinedsearch)parser.getJavaObject("search");
                            dataobject = bltradecombined.searchcount(tradecombinedsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.INSERT:
                    switch(this.operation) {
                        case ITradecombinedOperation.INSERT_TRADECOMBINED:
                            tradecombined = (ITradecombined)parser.getJavaObject("tradecombined");
                            bltradecombined.insertTradecombined(tradecombined);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.UPDATE:
                    switch(this.operation) {
                        case ITradecombinedOperation.UPDATE_TRADECOMBINED:
                            tradecombined = (ITradecombined)parser.getJavaObject("tradecombined");
                            bltradecombined.updateTradecombined(tradecombined);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.DELETE:
                    switch(this.operation) {
                        case ITradecombinedOperation.DELETE_TRADECOMBINED:
                            tradecombined = (ITradecombined)parser.getJavaObject("tradecombined");
                            bltradecombined.deleteTradecombined(tradecombined);
                            break;
                        case ITradecombinedOperation.DELETE_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            bltradecombined.delete4evetype(evetypePK);
                            break;
                        case ITradecombinedOperation.DELETE_Systembuy_system:
                            ISystemPK systemBuy_systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            bltradecombined.delete4systemBuy_system(systemBuy_systemPK);
                            break;
                        case ITradecombinedOperation.DELETE_Systemsell_system:
                            ISystemPK systemSell_systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            bltradecombined.delete4systemSell_system(systemSell_systemPK);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.BACKUP:
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
        return "tradecombined";
    }

}


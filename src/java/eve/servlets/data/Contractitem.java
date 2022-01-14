/*
 * Contractitem.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 14.0.2022 16:56
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IContractitem;
import eve.interfaces.servlet.IContractitemOperation;
import eve.interfaces.searchentity.IContractitemsearch;
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
@WebServlet(name="Contractitem", urlPatterns={"/eve.Contractitem"})
public class Contractitem extends SecurityDataServlet {
   
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
        BLcontractitem blcontractitem = new BLcontractitem();
        blcontractitem.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IContractitemPK contractitemPK;
                    IContractitem contractitem;
                    switch(this.operation) {
                        case IContractitemOperation.SELECT_ALL:
                            dataobject = blcontractitem.getContractitems();
                            break;
                        case IContractitemOperation.SELECT_CONTRACTITEM:
                            contractitemPK = (IContractitemPK)parser.getJavaObject("contractitempk");
                            dataobject = blcontractitem.getContractitem(contractitemPK);
                            break;
                        case IContractitemOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            dataobject = blcontractitem.getContractitems4evetype(evetypePK);
                            break;
                        case IContractitemOperation.SELECT_Contract:
                            IContractPK contractPK = (IContractPK)parser.getJavaObject("contractpk");
                            dataobject = blcontractitem.getContractitems4contract(contractPK);
                            break;
                        case IContractitemOperation.SELECT_SEARCH:
                            IContractitemsearch search = (IContractitemsearch)parser.getJavaObject("search");
                            dataobject = blcontractitem.search(search);
                            break;
                        case IContractitemOperation.SELECT_SEARCHCOUNT:
                            IContractitemsearch contractitemsearch = (IContractitemsearch)parser.getJavaObject("search");
                            dataobject = blcontractitem.searchcount(contractitemsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IContractitemOperation.INSERT_CONTRACTITEM:
                            contractitem = (IContractitem)parser.getJavaObject("contractitem");
                            blcontractitem.insertContractitem(contractitem);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IContractitemOperation.UPDATE_CONTRACTITEM:
                            contractitem = (IContractitem)parser.getJavaObject("contractitem");
                            blcontractitem.updateContractitem(contractitem);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IContractitemOperation.DELETE_CONTRACTITEM:
                            contractitem = (IContractitem)parser.getJavaObject("contractitem");
                            blcontractitem.deleteContractitem(contractitem);
                            break;
                        case IContractitemOperation.DELETE_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            blcontractitem.delete4evetype(evetypePK);
                            break;
                        case IContractitemOperation.DELETE_Contract:
                            IContractPK contractPK = (IContractPK)parser.getJavaObject("contractpk");
                            blcontractitem.delete4contract(contractPK);
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
        return "contractitem";
    }

}


/*
 * Allnodes_stargate.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 16.11.2021 15:46
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IAllnodes_stargate;
import eve.interfaces.servlet.IAllnodes_stargateOperation;
import eve.interfaces.searchentity.IAllnodes_stargatesearch;
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
@WebServlet(name="Allnodes_stargate", urlPatterns={"/eve.Allnodes_stargate"})
public class Allnodes_stargate extends SecurityDataServlet {
   
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
        BLallnodes_stargate blallnodes_stargate = new BLallnodes_stargate();
        blallnodes_stargate.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IAllnodes_stargatePK allnodes_stargatePK;
                    IAllnodes_stargate allnodes_stargate;
                    switch(this.operation) {
                        case IAllnodes_stargateOperation.SELECT_ALL:
                            dataobject = blallnodes_stargate.getAllnodes_stargates();
                            break;
                        case IAllnodes_stargateOperation.SELECT_ALLNODES_STARGATE:
                            allnodes_stargatePK = (IAllnodes_stargatePK)parser.getJavaObject("allnodes_stargatepk");
                            dataobject = blallnodes_stargate.getAllnodes_stargate(allnodes_stargatePK);
                            break;
                        case IAllnodes_stargateOperation.SELECT_SEARCH:
                            IAllnodes_stargatesearch search = (IAllnodes_stargatesearch)parser.getJavaObject("search");
                            dataobject = blallnodes_stargate.search(search);
                            break;
                        case IAllnodes_stargateOperation.SELECT_SEARCHCOUNT:
                            IAllnodes_stargatesearch allnodes_stargatesearch = (IAllnodes_stargatesearch)parser.getJavaObject("search");
                            dataobject = blallnodes_stargate.searchcount(allnodes_stargatesearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IAllnodes_stargateOperation.INSERT_ALLNODES_STARGATE:
                            allnodes_stargate = (IAllnodes_stargate)parser.getJavaObject("allnodes_stargate");
                            blallnodes_stargate.insertAllnodes_stargate(allnodes_stargate);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IAllnodes_stargateOperation.UPDATE_ALLNODES_STARGATE:
                            allnodes_stargate = (IAllnodes_stargate)parser.getJavaObject("allnodes_stargate");
                            blallnodes_stargate.updateAllnodes_stargate(allnodes_stargate);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IAllnodes_stargateOperation.DELETE_ALLNODES_STARGATE:
                            allnodes_stargate = (IAllnodes_stargate)parser.getJavaObject("allnodes_stargate");
                            blallnodes_stargate.deleteAllnodes_stargate(allnodes_stargate);
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
        return "allnodes_stargate";
    }

}


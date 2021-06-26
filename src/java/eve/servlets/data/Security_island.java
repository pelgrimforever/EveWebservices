/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.5.2021 16:2
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ISecurity_island;
import eve.interfaces.servlet.ISecurity_islandOperation;
import eve.interfaces.searchentity.ISecurity_islandsearch;
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
@WebServlet(name="Security_island", urlPatterns={"/eve.Security_island"})
public class Security_island extends SecurityDataServlet {
   
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
        BLsecurity_island blsecurity_island = new BLsecurity_island();
        blsecurity_island.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ISecurity_islandPK security_islandPK;
                    ISecurity_island security_island;
                    switch(this.operation) {
                        case ISecurity_islandOperation.SELECT_ALL:
                            dataobject = blsecurity_island.getSecurity_islands();
                            break;
                        case ISecurity_islandOperation.SELECT_SECURITY_ISLAND:
                            security_islandPK = (ISecurity_islandPK)parser.getJavaObject("security_islandpk");
                            dataobject = blsecurity_island.getSecurity_island(security_islandPK);
                            break;
                        case ISecurity_islandOperation.SELECT_SEARCH:
                            ISecurity_islandsearch search = (ISecurity_islandsearch)parser.getJavaObject("search");
                            dataobject = blsecurity_island.search(search);
                            break;
                        case ISecurity_islandOperation.SELECT_SEARCHCOUNT:
                            ISecurity_islandsearch security_islandsearch = (ISecurity_islandsearch)parser.getJavaObject("search");
                            dataobject = blsecurity_island.searchcount(security_islandsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ISecurity_islandOperation.INSERT_SECURITY_ISLAND:
                            security_island = (ISecurity_island)parser.getJavaObject("security_island");
                            blsecurity_island.insertSecurity_island(security_island);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ISecurity_islandOperation.UPDATE_SECURITY_ISLAND:
                            security_island = (ISecurity_island)parser.getJavaObject("security_island");
                            blsecurity_island.updateSecurity_island(security_island);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ISecurity_islandOperation.DELETE_SECURITY_ISLAND:
                            security_island = (ISecurity_island)parser.getJavaObject("security_island");
                            blsecurity_island.deleteSecurity_island(security_island);
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
        return "security_island";
    }

}


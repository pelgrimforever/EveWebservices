/*
 * Routetype.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 25.9.2021 15:16
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IRoutetype;
import eve.interfaces.servlet.IRoutetypeOperation;
import eve.interfaces.searchentity.IRoutetypesearch;
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
@WebServlet(name="Routetype", urlPatterns={"/eve.Routetype"})
public class Routetype extends SecurityDataServlet {
   
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
        BLroutetype blroutetype = new BLroutetype();
        blroutetype.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IRoutetypePK routetypePK;
                    IRoutetype routetype;
                    switch(this.operation) {
                        case IRoutetypeOperation.SELECT_ALL:
                            dataobject = blroutetype.getRoutetypes();
                            break;
                        case IRoutetypeOperation.SELECT_ROUTETYPE:
                            routetypePK = (IRoutetypePK)parser.getJavaObject("routetypepk");
                            dataobject = blroutetype.getRoutetype(routetypePK);
                            break;
                        case IRoutetypeOperation.SELECT_Security_island:
                            ISecurity_islandPK security_islandPK = (ISecurity_islandPK)parser.getJavaObject("security_islandpk");
                            dataobject = blroutetype.getRoutetypes4security_island(security_islandPK);
                            break;
                        case IRoutetypeOperation.SELECT_Route:
                            IRoutePK routePK = (IRoutePK)parser.getJavaObject("routepk");
                            dataobject = blroutetype.getRoute(routePK);
                            break;
                        case IRoutetypeOperation.SELECT_SEARCH:
                            IRoutetypesearch search = (IRoutetypesearch)parser.getJavaObject("search");
                            dataobject = blroutetype.search(search);
                            break;
                        case IRoutetypeOperation.SELECT_SEARCHCOUNT:
                            IRoutetypesearch routetypesearch = (IRoutetypesearch)parser.getJavaObject("search");
                            dataobject = blroutetype.searchcount(routetypesearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IRoutetypeOperation.INSERT_ROUTETYPE:
                            routetype = (IRoutetype)parser.getJavaObject("routetype");
                            blroutetype.insertRoutetype(routetype);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IRoutetypeOperation.UPDATE_ROUTETYPE:
                            routetype = (IRoutetype)parser.getJavaObject("routetype");
                            blroutetype.updateRoutetype(routetype);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IRoutetypeOperation.DELETE_ROUTETYPE:
                            routetype = (IRoutetype)parser.getJavaObject("routetype");
                            blroutetype.deleteRoutetype(routetype);
                            break;
                        case IRoutetypeOperation.DELETE_Security_island:
                            ISecurity_islandPK security_islandPK = (ISecurity_islandPK)parser.getJavaObject("security_islandpk");
                            blroutetype.delete4security_island(security_islandPK);
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
        return "routetype";
    }

}


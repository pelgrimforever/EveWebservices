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
import eve.interfaces.logicentity.IRoute;
import eve.interfaces.servlet.IRouteOperation;
import eve.interfaces.searchentity.IRoutesearch;
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
@WebServlet(name="Route", urlPatterns={"/eve.Route"})
public class Route extends SecurityDataServlet {
   
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
        BLroute blroute = new BLroute();
        blroute.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IRoutePK routePK;
                    IRoute route;
                    switch(this.operation) {
                        case IRouteOperation.SELECT_ALL:
                            dataobject = blroute.getRoutes();
                            break;
                        case IRouteOperation.SELECT_ROUTE:
                            routePK = (IRoutePK)parser.getJavaObject("routepk");
                            dataobject = blroute.getRoute(routePK);
                            break;
                        case IRouteOperation.SELECT_Routetype:
                            IRoutetypePK routetypePK = (IRoutetypePK)parser.getJavaObject("routetypepk");
                            dataobject = blroute.getRoutes4routetype(routetypePK);
                            break;
                        case IRouteOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            dataobject = blroute.getRoutes4system(systemPK);
                            break;
                        case IRouteOperation.SELECT_SEARCH:
                            IRoutesearch search = (IRoutesearch)parser.getJavaObject("search");
                            dataobject = blroute.search(search);
                            break;
                        case IRouteOperation.SELECT_SEARCHCOUNT:
                            IRoutesearch routesearch = (IRoutesearch)parser.getJavaObject("search");
                            dataobject = blroute.searchcount(routesearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IRouteOperation.INSERT_ROUTE:
                            route = (IRoute)parser.getJavaObject("route");
                            blroute.insertRoute(route);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IRouteOperation.UPDATE_ROUTE:
                            route = (IRoute)parser.getJavaObject("route");
                            blroute.updateRoute(route);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IRouteOperation.DELETE_ROUTE:
                            route = (IRoute)parser.getJavaObject("route");
                            blroute.deleteRoute(route);
                            break;
                        case IRouteOperation.DELETE_Routetype:
                            IRoutetypePK routetypePK = (IRoutetypePK)parser.getJavaObject("routetypepk");
                            blroute.delete4routetype(this.getServletName(), routetypePK);
                            break;
                        case IRouteOperation.DELETE_System:
                            ISystemPK systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            blroute.delete4system(this.getServletName(), systemPK);
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
        return "route";
    }

}


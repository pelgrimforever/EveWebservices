/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.security_island;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ISecurity_island;
import eve.interfaces.servlet.ISecurity_islandOperation;
import eve.interfaces.searchentity.ISecurity_islandsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Security_island_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name="Security_island_select", urlPatterns={"/eve.Security_island_select"})
public class Security_island_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Security_island_usecases security_islandusecases = new Security_island_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ISecurity_islandOperation.SELECT_ALL:
                    dataobject = security_islandusecases.get_all();
                    break;
                case ISecurity_islandOperation.SELECT_SECURITY_ISLAND:
                    dataobject = get_security_island_with_primarykey(security_islandusecases);
                    break;
                case ISecurity_islandOperation.SELECT_SEARCH:
                    dataobject = search_security_island(security_islandusecases);
                    break;
                case ISecurity_islandOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_security_island_count(security_islandusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    private Object get_security_island_with_primarykey(Security_island_usecases security_islandusecases) throws DBException {
        ISecurity_islandPK security_islandPK = (ISecurity_islandPK)parser.getJavaObject("security_islandpk");
        return security_islandusecases.get_security_island_by_primarykey(security_islandPK);
    }

    private Object search_security_island(Security_island_usecases security_islandusecases) throws CustomException {
        ISecurity_islandsearch search = (ISecurity_islandsearch)parser.getJavaObject("search");
        return security_islandusecases.search_security_island(search);
    }
    
    private Object search_security_island_count(Security_island_usecases security_islandusecases) throws CustomException {
        ISecurity_islandsearch security_islandsearch = (ISecurity_islandsearch)parser.getJavaObject("search");
        return security_islandusecases.search_security_island_count(security_islandsearch);
    }

    @Override
    public String getServletInfo() {
        return "security_island_select";
    }

}


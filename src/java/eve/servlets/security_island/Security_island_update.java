/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.security_island;

import general.exception.CustomException;
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
@WebServlet(name="Security_island_update", urlPatterns={"/eve.Security_island_update"})
public class Security_island_update extends SecurityDataServlet {
   
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
                case ISecurity_islandOperation.UPDATE_SECURITY_ISLAND:
                    update_security_island(security_islandusecases);
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

    private void update_security_island(Security_island_usecases security_islandusecases) throws CustomException {
        ISecurity_island security_island = (ISecurity_island)parser.getJavaObject("security_island");
        security_islandusecases.updateSecurity_island(security_island);
    }
    
    @Override
    public String getServletInfo() {
        return "security_island_insert";
    }

}


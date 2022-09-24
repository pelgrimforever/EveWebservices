/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
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

@WebServlet(name="Security_island_insert", urlPatterns={"/eve.Security_island_insert"})
public class Security_island_insert extends SecurityDataServlet {
   
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
                case ISecurity_islandOperation.INSERT_SECURITY_ISLAND:
                    insert_security_island(security_islandusecases);
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

    private void insert_security_island(Security_island_usecases security_islandusecases) throws CustomException {
        ISecurity_island security_island = (ISecurity_island)parser.getJavaObject("security_island");
        security_islandusecases.insertSecurity_island(security_island);
    }
    
    @Override
    public String getServletInfo() {
        return "security_island_insert";
    }

}


/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.routetype;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IRoutetype;
import eve.interfaces.servlet.IRoutetypeOperation;
import eve.interfaces.searchentity.IRoutetypesearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Routetype_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Routetype_delete", urlPatterns={"/eve.Routetype_delete"})
public class Routetype_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Routetype_usecases routetypeusecases = new Routetype_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IRoutetypeOperation.DELETE_ROUTETYPE:
                    delete_routetype(routetypeusecases);
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

    private void delete_routetype(Routetype_usecases routetypeusecases) throws CustomException {
        IRoutetype routetype = (IRoutetype)parser.getJavaObject("routetype");
        routetypeusecases.deleteRoutetype(routetype);
    }
    
    @Override
    public String getServletInfo() {
        return "routetype_insert";
    }

}


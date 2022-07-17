/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
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

/**
 * @author Franky Laseure
 */
@WebServlet(name="Routetype_insert", urlPatterns={"/eve.Routetype_insert"})
public class Routetype_insert extends SecurityDataServlet {
   
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
                case IRoutetypeOperation.INSERT_ROUTETYPE:
                    insert_routetype(routetypeusecases);
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

    private void insert_routetype(Routetype_usecases routetypeusecases) throws CustomException {
        IRoutetype routetype = (IRoutetype)parser.getJavaObject("routetype");
        routetypeusecases.insertRoutetype(routetype);
    }
    
    @Override
    public String getServletInfo() {
        return "routetype_insert";
    }

}


/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.constellation_neighbour;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IConstellation_neighbour;
import eve.interfaces.servlet.IConstellation_neighbourOperation;
import eve.interfaces.searchentity.IConstellation_neighboursearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Constellation_neighbour_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Constellation_neighbour_delete", urlPatterns={"/eve.Constellation_neighbour_delete"})
public class Constellation_neighbour_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Constellation_neighbour_usecases constellation_neighbourusecases = new Constellation_neighbour_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IConstellation_neighbourOperation.DELETE_CONSTELLATION_NEIGHBOUR:
                    delete_constellation_neighbour(constellation_neighbourusecases);
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

    private void delete_constellation_neighbour(Constellation_neighbour_usecases constellation_neighbourusecases) throws CustomException {
        IConstellation_neighbour constellation_neighbour = (IConstellation_neighbour)parser.getJavaObject("constellation_neighbour");
        constellation_neighbourusecases.deleteConstellation_neighbour(constellation_neighbour);
    }
    
    @Override
    public String getServletInfo() {
        return "constellation_neighbour_insert";
    }

}


/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
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

/**
 * @author Franky Laseure
 */
@WebServlet(name="Constellation_neighbour_update", urlPatterns={"/eve.Constellation_neighbour_update"})
public class Constellation_neighbour_update extends SecurityDataServlet {
   
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
                case IConstellation_neighbourOperation.UPDATE_CONSTELLATION_NEIGHBOUR:
                    update_constellation_neighbour(constellation_neighbourusecases);
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

    private void update_constellation_neighbour(Constellation_neighbour_usecases constellation_neighbourusecases) throws CustomException {
        IConstellation_neighbour constellation_neighbour = (IConstellation_neighbour)parser.getJavaObject("constellation_neighbour");
        constellation_neighbourusecases.updateConstellation_neighbour(constellation_neighbour);
    }
    
    @Override
    public String getServletInfo() {
        return "constellation_neighbour_insert";
    }

}


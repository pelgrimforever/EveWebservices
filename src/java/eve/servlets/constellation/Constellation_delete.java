/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.constellation;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IConstellation;
import eve.interfaces.servlet.IConstellationOperation;
import eve.interfaces.searchentity.IConstellationsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Constellation_usecases;
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
@WebServlet(name="Constellation_delete", urlPatterns={"/eve.Constellation_delete"})
public class Constellation_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Constellation_usecases constellationusecases = new Constellation_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IConstellationOperation.DELETE_CONSTELLATION:
                    delete_constellation(constellationusecases);
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

    private void delete_constellation(Constellation_usecases constellationusecases) throws CustomException {
        IConstellation constellation = (IConstellation)parser.getJavaObject("constellation");
        constellationusecases.deleteConstellation(constellation);
    }
    
    @Override
    public String getServletInfo() {
        return "constellation_insert";
    }

}


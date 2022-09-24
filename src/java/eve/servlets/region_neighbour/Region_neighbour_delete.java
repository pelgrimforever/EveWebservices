/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.region_neighbour;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IRegion_neighbour;
import eve.interfaces.servlet.IRegion_neighbourOperation;
import eve.interfaces.searchentity.IRegion_neighboursearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Region_neighbour_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Region_neighbour_delete", urlPatterns={"/eve.Region_neighbour_delete"})
public class Region_neighbour_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Region_neighbour_usecases region_neighbourusecases = new Region_neighbour_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IRegion_neighbourOperation.DELETE_REGION_NEIGHBOUR:
                    delete_region_neighbour(region_neighbourusecases);
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

    private void delete_region_neighbour(Region_neighbour_usecases region_neighbourusecases) throws CustomException {
        IRegion_neighbour region_neighbour = (IRegion_neighbour)parser.getJavaObject("region_neighbour");
        region_neighbourusecases.deleteRegion_neighbour(region_neighbour);
    }
    
    @Override
    public String getServletInfo() {
        return "region_neighbour_insert";
    }

}


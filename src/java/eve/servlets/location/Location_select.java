/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.location;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ILocation;
import eve.interfaces.servlet.ILocationOperation;
import eve.interfaces.searchentity.ILocationsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Location_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Location_select", urlPatterns={"/eve.Location_select"})
public class Location_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Location_usecases locationusecases = new Location_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ILocationOperation.SELECT_ALL:
                    dataobject = locationusecases.get_all();
                    break;
                case ILocationOperation.SELECT_LOCATION:
                    dataobject = get_location_with_primarykey(locationusecases);
                    break;
                case ILocationOperation.SELECT_System:
                    dataobject = get_location_with_foreignkey_system(locationusecases);
                    break;
                case ILocationOperation.SELECT_SEARCH:
                    dataobject = search_location(locationusecases);
                    break;
                case ILocationOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_location_count(locationusecases);
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

    private Object get_location_with_primarykey(Location_usecases locationusecases) throws DBException {
        ILocationPK locationPK = (ILocationPK)parser.getJavaObject("locationpk");
        return locationusecases.get_location_by_primarykey(locationPK);
    }

    private Object get_location_with_foreignkey_system(Location_usecases locationusecases) throws CustomException {
        ISystemPK systemPK = (ISystemPK)parser.getJavaObject("systempk");
        return locationusecases.get_location_with_foreignkey_system(systemPK);
    }
    
    private Object search_location(Location_usecases locationusecases) throws CustomException {
        ILocationsearch search = (ILocationsearch)parser.getJavaObject("search");
        return locationusecases.search_location(search);
    }
    
    private Object search_location_count(Location_usecases locationusecases) throws CustomException {
        ILocationsearch locationsearch = (ILocationsearch)parser.getJavaObject("search");
        return locationusecases.search_location_count(locationsearch);
    }

    @Override
    public String getServletInfo() {
        return "location_select";
    }

}


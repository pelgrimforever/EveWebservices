/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.region_neighbour;

import general.exception.*;
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

/**
 * @author Franky Laseure
 */
@WebServlet(name="Region_neighbour_select", urlPatterns={"/eve.Region_neighbour_select"})
public class Region_neighbour_select extends SecurityDataServlet {
   
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
                case IRegion_neighbourOperation.SELECT_ALL:
                    dataobject = region_neighbourusecases.get_all();
                    break;
                case IRegion_neighbourOperation.SELECT_REGION_NEIGHBOUR:
                    dataobject = get_region_neighbour_with_primarykey(region_neighbourusecases);
                    break;
                case IRegion_neighbourOperation.SELECT_Regionregion:
                    dataobject = get_region_neighbour_with_foreignkey_regionRegion(region_neighbourusecases);
                    break;
                case IRegion_neighbourOperation.SELECT_Regionneighbour:
                    dataobject = get_region_neighbour_with_foreignkey_regionNeighbour(region_neighbourusecases);
                    break;
                case IRegion_neighbourOperation.SELECT_SEARCH:
                    dataobject = search_region_neighbour(region_neighbourusecases);
                    break;
                case IRegion_neighbourOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_region_neighbour_count(region_neighbourusecases);
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

    private Object get_region_neighbour_with_primarykey(Region_neighbour_usecases region_neighbourusecases) throws DBException {
        IRegion_neighbourPK region_neighbourPK = (IRegion_neighbourPK)parser.getJavaObject("region_neighbourpk");
        return region_neighbourusecases.get_region_neighbour_by_primarykey(region_neighbourPK);
    }

    private Object get_region_neighbour_with_foreignkey_regionRegion(Region_neighbour_usecases region_neighbourusecases) throws CustomException {
        IRegionPK regionRegionPK = (IRegionPK)parser.getJavaObject("regionpk");
        return region_neighbourusecases.get_region_neighbour_with_foreignkey_regionRegion(regionRegionPK);
    }
    
    private Object get_region_neighbour_with_foreignkey_regionNeighbour(Region_neighbour_usecases region_neighbourusecases) throws CustomException {
        IRegionPK regionNeighbourPK = (IRegionPK)parser.getJavaObject("regionpk");
        return region_neighbourusecases.get_region_neighbour_with_foreignkey_regionNeighbour(regionNeighbourPK);
    }
    
    private Object search_region_neighbour(Region_neighbour_usecases region_neighbourusecases) throws CustomException {
        IRegion_neighboursearch search = (IRegion_neighboursearch)parser.getJavaObject("search");
        return region_neighbourusecases.search_region_neighbour(search);
    }
    
    private Object search_region_neighbour_count(Region_neighbour_usecases region_neighbourusecases) throws CustomException {
        IRegion_neighboursearch region_neighboursearch = (IRegion_neighboursearch)parser.getJavaObject("search");
        return region_neighbourusecases.search_region_neighbour_count(region_neighboursearch);
    }

    @Override
    public String getServletInfo() {
        return "region_neighbour_select";
    }

}


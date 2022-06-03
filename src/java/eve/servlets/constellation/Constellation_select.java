/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.constellation;

import general.exception.*;
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
@WebServlet(name="Constellation_select", urlPatterns={"/eve.Constellation_select"})
public class Constellation_select extends SecurityDataServlet {
   
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
                case IConstellationOperation.SELECT_ALL:
                    dataobject = constellationusecases.get_all();
                    break;
                case IConstellationOperation.SELECT_CONSTELLATION:
                    dataobject = get_constellation_with_primarykey(constellationusecases);
                    break;
                case IConstellationOperation.SELECT_Region:
                    dataobject = get_constellation_with_foreignkey_region(constellationusecases);
                    break;
                case IConstellationOperation.SELECT_Constellation_neighbourneighbour:
                    dataobject = get_constellation_with_externalforeignkey_constellation_neighbourNeighbour(constellationusecases);
                    break;
                case IConstellationOperation.SELECT_Constellation_neighbourconstellation:
                    dataobject = get_constellation_with_externalforeignkey_constellation_neighbourConstellation(constellationusecases);
                    break;
                case IConstellationOperation.SELECT_SEARCH:
                    dataobject = search_constellation(constellationusecases);
                    break;
                case IConstellationOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_constellation_count(constellationusecases);
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

    private Object get_constellation_with_primarykey(Constellation_usecases constellationusecases) throws DBException {
        IConstellationPK constellationPK = (IConstellationPK)parser.getJavaObject("constellationpk");
        return constellationusecases.get_constellation_by_primarykey(constellationPK);
    }

    private Object get_constellation_with_foreignkey_region(Constellation_usecases constellationusecases) throws CustomException {
        IRegionPK regionPK = (IRegionPK)parser.getJavaObject("regionpk");
        return constellationusecases.get_constellation_with_foreignkey_region(regionPK);
    }
    
    private Object get_constellation_with_externalforeignkey_constellation_neighbourNeighbour(Constellation_usecases constellationusecases) throws CustomException {
        IConstellation_neighbourPK constellation_neighbourNeighbourPK = (IConstellation_neighbourPK)parser.getJavaObject("constellation_neighbourpk");
        return constellationusecases.get_constellation_with_externalforeignkey_constellation_neighbourNeighbour(constellation_neighbourNeighbourPK);
    }
    
    private Object get_constellation_with_externalforeignkey_constellation_neighbourConstellation(Constellation_usecases constellationusecases) throws CustomException {
        IConstellation_neighbourPK constellation_neighbourConstellationPK = (IConstellation_neighbourPK)parser.getJavaObject("constellation_neighbourpk");
        return constellationusecases.get_constellation_with_externalforeignkey_constellation_neighbourConstellation(constellation_neighbourConstellationPK);
    }
    
    private Object search_constellation(Constellation_usecases constellationusecases) throws CustomException {
        IConstellationsearch search = (IConstellationsearch)parser.getJavaObject("search");
        return constellationusecases.search_constellation(search);
    }
    
    private Object search_constellation_count(Constellation_usecases constellationusecases) throws CustomException {
        IConstellationsearch constellationsearch = (IConstellationsearch)parser.getJavaObject("search");
        return constellationusecases.search_constellation_count(constellationsearch);
    }

    @Override
    public String getServletInfo() {
        return "constellation_select";
    }

}


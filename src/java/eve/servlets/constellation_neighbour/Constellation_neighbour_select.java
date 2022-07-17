/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.constellation_neighbour;

import general.exception.*;
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
@WebServlet(name="Constellation_neighbour_select", urlPatterns={"/eve.Constellation_neighbour_select"})
public class Constellation_neighbour_select extends SecurityDataServlet {
   
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
                case IConstellation_neighbourOperation.SELECT_ALL:
                    dataobject = constellation_neighbourusecases.get_all();
                    break;
                case IConstellation_neighbourOperation.SELECT_CONSTELLATION_NEIGHBOUR:
                    dataobject = get_constellation_neighbour_with_primarykey(constellation_neighbourusecases);
                    break;
                case IConstellation_neighbourOperation.SELECT_Constellationneighbour:
                    dataobject = get_constellation_neighbour_with_foreignkey_constellationNeighbour(constellation_neighbourusecases);
                    break;
                case IConstellation_neighbourOperation.SELECT_Constellationconstellation:
                    dataobject = get_constellation_neighbour_with_foreignkey_constellationConstellation(constellation_neighbourusecases);
                    break;
                case IConstellation_neighbourOperation.SELECT_SEARCH:
                    dataobject = search_constellation_neighbour(constellation_neighbourusecases);
                    break;
                case IConstellation_neighbourOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_constellation_neighbour_count(constellation_neighbourusecases);
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

    private Object get_constellation_neighbour_with_primarykey(Constellation_neighbour_usecases constellation_neighbourusecases) throws DBException {
        IConstellation_neighbourPK constellation_neighbourPK = (IConstellation_neighbourPK)parser.getJavaObject("constellation_neighbourpk");
        return constellation_neighbourusecases.get_constellation_neighbour_by_primarykey(constellation_neighbourPK);
    }

    private Object get_constellation_neighbour_with_foreignkey_constellationNeighbour(Constellation_neighbour_usecases constellation_neighbourusecases) throws CustomException {
        IConstellationPK constellationNeighbourPK = (IConstellationPK)parser.getJavaObject("constellationpk");
        return constellation_neighbourusecases.get_constellation_neighbour_with_foreignkey_constellationNeighbour(constellationNeighbourPK);
    }
    
    private Object get_constellation_neighbour_with_foreignkey_constellationConstellation(Constellation_neighbour_usecases constellation_neighbourusecases) throws CustomException {
        IConstellationPK constellationConstellationPK = (IConstellationPK)parser.getJavaObject("constellationpk");
        return constellation_neighbourusecases.get_constellation_neighbour_with_foreignkey_constellationConstellation(constellationConstellationPK);
    }
    
    private Object search_constellation_neighbour(Constellation_neighbour_usecases constellation_neighbourusecases) throws CustomException {
        IConstellation_neighboursearch search = (IConstellation_neighboursearch)parser.getJavaObject("search");
        return constellation_neighbourusecases.search_constellation_neighbour(search);
    }
    
    private Object search_constellation_neighbour_count(Constellation_neighbour_usecases constellation_neighbourusecases) throws CustomException {
        IConstellation_neighboursearch constellation_neighboursearch = (IConstellation_neighboursearch)parser.getJavaObject("search");
        return constellation_neighbourusecases.search_constellation_neighbour_count(constellation_neighboursearch);
    }

    @Override
    public String getServletInfo() {
        return "constellation_neighbour_select";
    }

}


/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.race;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IRace;
import eve.interfaces.servlet.IRaceOperation;
import eve.interfaces.searchentity.IRacesearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Race_usecases;
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
@WebServlet(name="Race_select", urlPatterns={"/eve.Race_select"})
public class Race_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Race_usecases raceusecases = new Race_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IRaceOperation.SELECT_ALL:
                    dataobject = raceusecases.get_all();
                    break;
                case IRaceOperation.SELECT_RACE:
                    dataobject = get_race_with_primarykey(raceusecases);
                    break;
                case IRaceOperation.SELECT_Faction:
                    dataobject = get_race_with_foreignkey_faction(raceusecases);
                    break;
                case IRaceOperation.SELECT_SEARCH:
                    dataobject = search_race(raceusecases);
                    break;
                case IRaceOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_race_count(raceusecases);
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

    private Object get_race_with_primarykey(Race_usecases raceusecases) throws DBException {
        IRacePK racePK = (IRacePK)parser.getJavaObject("racepk");
        return raceusecases.get_race_by_primarykey(racePK);
    }

    private Object get_race_with_foreignkey_faction(Race_usecases raceusecases) throws CustomException {
        IFactionPK factionPK = (IFactionPK)parser.getJavaObject("factionpk");
        return raceusecases.get_race_with_foreignkey_faction(factionPK);
    }
    
    private Object search_race(Race_usecases raceusecases) throws CustomException {
        IRacesearch search = (IRacesearch)parser.getJavaObject("search");
        return raceusecases.search_race(search);
    }
    
    private Object search_race_count(Race_usecases raceusecases) throws CustomException {
        IRacesearch racesearch = (IRacesearch)parser.getJavaObject("search");
        return raceusecases.search_race_count(racesearch);
    }

    @Override
    public String getServletInfo() {
        return "race_select";
    }

}


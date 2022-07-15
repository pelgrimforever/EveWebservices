/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.corporation;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ICorporation;
import eve.interfaces.servlet.ICorporationOperation;
import eve.interfaces.searchentity.ICorporationsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Corporation_usecases;
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
@WebServlet(name="Corporation_select", urlPatterns={"/eve.Corporation_select"})
public class Corporation_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Corporation_usecases corporationusecases = new Corporation_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ICorporationOperation.SELECT_ALL:
                    dataobject = corporationusecases.get_all();
                    break;
                case ICorporationOperation.SELECT_CORPORATION:
                    dataobject = get_corporation_with_primarykey(corporationusecases);
                    break;
                case ICorporationOperation.SELECT_Station:
                    dataobject = get_corporation_with_foreignkey_station(corporationusecases);
                    break;
                case ICorporationOperation.SELECT_Faction:
                    dataobject = get_corporation_with_foreignkey_faction(corporationusecases);
                    break;
                case ICorporationOperation.SELECT_Alliance:
                    dataobject = get_corporation_with_foreignkey_alliance(corporationusecases);
                    break;
                case ICorporationOperation.SELECT_SEARCH:
                    dataobject = search_corporation(corporationusecases);
                    break;
                case ICorporationOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_corporation_count(corporationusecases);
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

    private Object get_corporation_with_primarykey(Corporation_usecases corporationusecases) throws DBException {
        ICorporationPK corporationPK = (ICorporationPK)parser.getJavaObject("corporationpk");
        return corporationusecases.get_corporation_by_primarykey(corporationPK);
    }

    private Object get_corporation_with_foreignkey_station(Corporation_usecases corporationusecases) throws CustomException {
        IStationPK stationPK = (IStationPK)parser.getJavaObject("stationpk");
        return corporationusecases.get_corporation_with_foreignkey_station(stationPK);
    }
    
    private Object get_corporation_with_foreignkey_faction(Corporation_usecases corporationusecases) throws CustomException {
        IFactionPK factionPK = (IFactionPK)parser.getJavaObject("factionpk");
        return corporationusecases.get_corporation_with_foreignkey_faction(factionPK);
    }
    
    private Object get_corporation_with_foreignkey_alliance(Corporation_usecases corporationusecases) throws CustomException {
        IAlliancePK alliancePK = (IAlliancePK)parser.getJavaObject("alliancepk");
        return corporationusecases.get_corporation_with_foreignkey_alliance(alliancePK);
    }
    
    private Object search_corporation(Corporation_usecases corporationusecases) throws CustomException {
        ICorporationsearch search = (ICorporationsearch)parser.getJavaObject("search");
        return corporationusecases.search_corporation(search);
    }
    
    private Object search_corporation_count(Corporation_usecases corporationusecases) throws CustomException {
        ICorporationsearch corporationsearch = (ICorporationsearch)parser.getJavaObject("search");
        return corporationusecases.search_corporation_count(corporationsearch);
    }

    @Override
    public String getServletInfo() {
        return "corporation_select";
    }

}


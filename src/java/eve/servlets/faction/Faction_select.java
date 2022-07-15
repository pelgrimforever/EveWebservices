/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.faction;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IFaction;
import eve.interfaces.servlet.IFactionOperation;
import eve.interfaces.searchentity.IFactionsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Faction_usecases;
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
@WebServlet(name="Faction_select", urlPatterns={"/eve.Faction_select"})
public class Faction_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Faction_usecases factionusecases = new Faction_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IFactionOperation.SELECT_ALL:
                    dataobject = factionusecases.get_all();
                    break;
                case IFactionOperation.SELECT_FACTION:
                    dataobject = get_faction_with_primarykey(factionusecases);
                    break;
                case IFactionOperation.SELECT_System:
                    dataobject = get_faction_with_foreignkey_system(factionusecases);
                    break;
                case IFactionOperation.SELECT_SEARCH:
                    dataobject = search_faction(factionusecases);
                    break;
                case IFactionOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_faction_count(factionusecases);
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

    private Object get_faction_with_primarykey(Faction_usecases factionusecases) throws DBException {
        IFactionPK factionPK = (IFactionPK)parser.getJavaObject("factionpk");
        return factionusecases.get_faction_by_primarykey(factionPK);
    }

    private Object get_faction_with_foreignkey_system(Faction_usecases factionusecases) throws CustomException {
        ISystemPK systemPK = (ISystemPK)parser.getJavaObject("systempk");
        return factionusecases.get_faction_with_foreignkey_system(systemPK);
    }
    
    private Object search_faction(Faction_usecases factionusecases) throws CustomException {
        IFactionsearch search = (IFactionsearch)parser.getJavaObject("search");
        return factionusecases.search_faction(search);
    }
    
    private Object search_faction_count(Faction_usecases factionusecases) throws CustomException {
        IFactionsearch factionsearch = (IFactionsearch)parser.getJavaObject("search");
        return factionusecases.search_faction_count(factionsearch);
    }

    @Override
    public String getServletInfo() {
        return "faction_select";
    }

}


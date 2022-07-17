/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.system;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ISystem;
import eve.interfaces.servlet.ISystemOperation;
import eve.interfaces.searchentity.ISystemsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.System_usecases;
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
@WebServlet(name="System_select", urlPatterns={"/eve.System_select"})
public class System_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        System_usecases systemusecases = new System_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ISystemOperation.SELECT_ALL:
                    dataobject = systemusecases.get_all();
                    break;
                case ISystemOperation.SELECT_SYSTEM:
                    dataobject = get_system_with_primarykey(systemusecases);
                    break;
                case ISystemOperation.SELECT_Security_island:
                    dataobject = get_system_with_foreignkey_security_island(systemusecases);
                    break;
                case ISystemOperation.SELECT_Constellation:
                    dataobject = get_system_with_foreignkey_constellation(systemusecases);
                    break;
                case ISystemOperation.SELECT_Systemjumpssystem_end:
                    dataobject = get_system_with_externalforeignkey_systemjumpsSystem_end(systemusecases);
                    break;
                case ISystemOperation.SELECT_Systemjumpssystem_start:
                    dataobject = get_system_with_externalforeignkey_systemjumpsSystem_start(systemusecases);
                    break;
                case ISystemOperation.SELECT_Tradecombinedbuy_system:
                    dataobject = get_system_with_externalforeignkey_tradecombinedBuy_system(systemusecases);
                    break;
                case ISystemOperation.SELECT_Tradecombinedsell_system:
                    dataobject = get_system_with_externalforeignkey_tradecombinedSell_system(systemusecases);
                    break;
                case ISystemOperation.SELECT_SEARCH:
                    dataobject = search_system(systemusecases);
                    break;
                case ISystemOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_system_count(systemusecases);
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

    private Object get_system_with_primarykey(System_usecases systemusecases) throws DBException {
        ISystemPK systemPK = (ISystemPK)parser.getJavaObject("systempk");
        return systemusecases.get_system_by_primarykey(systemPK);
    }

    private Object get_system_with_foreignkey_security_island(System_usecases systemusecases) throws CustomException {
        ISecurity_islandPK security_islandPK = (ISecurity_islandPK)parser.getJavaObject("security_islandpk");
        return systemusecases.get_system_with_foreignkey_security_island(security_islandPK);
    }
    
    private Object get_system_with_foreignkey_constellation(System_usecases systemusecases) throws CustomException {
        IConstellationPK constellationPK = (IConstellationPK)parser.getJavaObject("constellationpk");
        return systemusecases.get_system_with_foreignkey_constellation(constellationPK);
    }
    
    private Object get_system_with_externalforeignkey_systemjumpsSystem_end(System_usecases systemusecases) throws CustomException {
        ISystemjumpsPK systemjumpsSystem_endPK = (ISystemjumpsPK)parser.getJavaObject("systemjumpspk");
        return systemusecases.get_system_with_externalforeignkey_systemjumpsSystem_end(systemjumpsSystem_endPK);
    }
    
    private Object get_system_with_externalforeignkey_systemjumpsSystem_start(System_usecases systemusecases) throws CustomException {
        ISystemjumpsPK systemjumpsSystem_startPK = (ISystemjumpsPK)parser.getJavaObject("systemjumpspk");
        return systemusecases.get_system_with_externalforeignkey_systemjumpsSystem_start(systemjumpsSystem_startPK);
    }
    
    private Object get_system_with_externalforeignkey_tradecombinedBuy_system(System_usecases systemusecases) throws CustomException {
        ITradecombinedPK tradecombinedBuy_systemPK = (ITradecombinedPK)parser.getJavaObject("tradecombinedpk");
        return systemusecases.get_system_with_externalforeignkey_tradecombinedBuy_system(tradecombinedBuy_systemPK);
    }
    
    private Object get_system_with_externalforeignkey_tradecombinedSell_system(System_usecases systemusecases) throws CustomException {
        ITradecombinedPK tradecombinedSell_systemPK = (ITradecombinedPK)parser.getJavaObject("tradecombinedpk");
        return systemusecases.get_system_with_externalforeignkey_tradecombinedSell_system(tradecombinedSell_systemPK);
    }
    
    private Object search_system(System_usecases systemusecases) throws CustomException {
        ISystemsearch search = (ISystemsearch)parser.getJavaObject("search");
        return systemusecases.search_system(search);
    }
    
    private Object search_system_count(System_usecases systemusecases) throws CustomException {
        ISystemsearch systemsearch = (ISystemsearch)parser.getJavaObject("search");
        return systemusecases.search_system_count(systemsearch);
    }

    @Override
    public String getServletInfo() {
        return "system_select";
    }

}


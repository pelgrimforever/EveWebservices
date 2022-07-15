/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.alliance;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IAlliance;
import eve.interfaces.servlet.IAllianceOperation;
import eve.interfaces.searchentity.IAlliancesearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Alliance_usecases;
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
@WebServlet(name="Alliance_select", urlPatterns={"/eve.Alliance_select"})
public class Alliance_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Alliance_usecases allianceusecases = new Alliance_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IAllianceOperation.SELECT_ALL:
                    dataobject = allianceusecases.get_all();
                    break;
                case IAllianceOperation.SELECT_ALLIANCE:
                    dataobject = get_alliance_with_primarykey(allianceusecases);
                    break;
                case IAllianceOperation.SELECT_Corporationcreator_corporation:
                    dataobject = get_alliance_with_foreignkey_corporationCreator_corporation(allianceusecases);
                    break;
                case IAllianceOperation.SELECT_Corporationexecutor_corporation:
                    dataobject = get_alliance_with_foreignkey_corporationExecutor_corporation(allianceusecases);
                    break;
                case IAllianceOperation.SELECT_SEARCH:
                    dataobject = search_alliance(allianceusecases);
                    break;
                case IAllianceOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_alliance_count(allianceusecases);
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

    private Object get_alliance_with_primarykey(Alliance_usecases allianceusecases) throws DBException {
        IAlliancePK alliancePK = (IAlliancePK)parser.getJavaObject("alliancepk");
        return allianceusecases.get_alliance_by_primarykey(alliancePK);
    }

    private Object get_alliance_with_foreignkey_corporationCreator_corporation(Alliance_usecases allianceusecases) throws CustomException {
        ICorporationPK corporationCreator_corporationPK = (ICorporationPK)parser.getJavaObject("corporationpk");
        return allianceusecases.get_alliance_with_foreignkey_corporationCreator_corporation(corporationCreator_corporationPK);
    }
    
    private Object get_alliance_with_foreignkey_corporationExecutor_corporation(Alliance_usecases allianceusecases) throws CustomException {
        ICorporationPK corporationExecutor_corporationPK = (ICorporationPK)parser.getJavaObject("corporationpk");
        return allianceusecases.get_alliance_with_foreignkey_corporationExecutor_corporation(corporationExecutor_corporationPK);
    }
    
    private Object search_alliance(Alliance_usecases allianceusecases) throws CustomException {
        IAlliancesearch search = (IAlliancesearch)parser.getJavaObject("search");
        return allianceusecases.search_alliance(search);
    }
    
    private Object search_alliance_count(Alliance_usecases allianceusecases) throws CustomException {
        IAlliancesearch alliancesearch = (IAlliancesearch)parser.getJavaObject("search");
        return allianceusecases.search_alliance_count(alliancesearch);
    }

    @Override
    public String getServletInfo() {
        return "alliance_select";
    }

}


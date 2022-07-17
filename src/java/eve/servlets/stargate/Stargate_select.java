/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.stargate;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IStargate;
import eve.interfaces.servlet.IStargateOperation;
import eve.interfaces.searchentity.IStargatesearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Stargate_usecases;
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
@WebServlet(name="Stargate_select", urlPatterns={"/eve.Stargate_select"})
public class Stargate_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Stargate_usecases stargateusecases = new Stargate_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IStargateOperation.SELECT_ALL:
                    dataobject = stargateusecases.get_all();
                    break;
                case IStargateOperation.SELECT_STARGATE:
                    dataobject = get_stargate_with_primarykey(stargateusecases);
                    break;
                case IStargateOperation.SELECT_Systemsystem:
                    dataobject = get_stargate_with_foreignkey_systemSystem(stargateusecases);
                    break;
                case IStargateOperation.SELECT_Systemto_system:
                    dataobject = get_stargate_with_foreignkey_systemTo_system(stargateusecases);
                    break;
                case IStargateOperation.SELECT_SEARCH:
                    dataobject = search_stargate(stargateusecases);
                    break;
                case IStargateOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_stargate_count(stargateusecases);
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

    private Object get_stargate_with_primarykey(Stargate_usecases stargateusecases) throws DBException {
        IStargatePK stargatePK = (IStargatePK)parser.getJavaObject("stargatepk");
        return stargateusecases.get_stargate_by_primarykey(stargatePK);
    }

    private Object get_stargate_with_foreignkey_systemSystem(Stargate_usecases stargateusecases) throws CustomException {
        ISystemPK systemSystemPK = (ISystemPK)parser.getJavaObject("systempk");
        return stargateusecases.get_stargate_with_foreignkey_systemSystem(systemSystemPK);
    }
    
    private Object get_stargate_with_foreignkey_systemTo_system(Stargate_usecases stargateusecases) throws CustomException {
        ISystemPK systemTo_systemPK = (ISystemPK)parser.getJavaObject("systempk");
        return stargateusecases.get_stargate_with_foreignkey_systemTo_system(systemTo_systemPK);
    }
    
    private Object search_stargate(Stargate_usecases stargateusecases) throws CustomException {
        IStargatesearch search = (IStargatesearch)parser.getJavaObject("search");
        return stargateusecases.search_stargate(search);
    }
    
    private Object search_stargate_count(Stargate_usecases stargateusecases) throws CustomException {
        IStargatesearch stargatesearch = (IStargatesearch)parser.getJavaObject("search");
        return stargateusecases.search_stargate_count(stargatesearch);
    }

    @Override
    public String getServletInfo() {
        return "stargate_select";
    }

}


/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.allnodes_stargate;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IAllnodes_stargate;
import eve.interfaces.servlet.IAllnodes_stargateOperation;
import eve.interfaces.searchentity.IAllnodes_stargatesearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Allnodes_stargate_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Allnodes_stargate_select", urlPatterns={"/eve.Allnodes_stargate_select"})
public class Allnodes_stargate_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Allnodes_stargate_usecases allnodes_stargateusecases = new Allnodes_stargate_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IAllnodes_stargateOperation.SELECT_ALL:
                    dataobject = allnodes_stargateusecases.get_all();
                    break;
                case IAllnodes_stargateOperation.SELECT_ALLNODES_STARGATE:
                    dataobject = get_allnodes_stargate_with_primarykey(allnodes_stargateusecases);
                    break;
                case IAllnodes_stargateOperation.SELECT_SEARCH:
                    dataobject = search_allnodes_stargate(allnodes_stargateusecases);
                    break;
                case IAllnodes_stargateOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_allnodes_stargate_count(allnodes_stargateusecases);
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

    private Object get_allnodes_stargate_with_primarykey(Allnodes_stargate_usecases allnodes_stargateusecases) throws DBException {
        IAllnodes_stargatePK allnodes_stargatePK = (IAllnodes_stargatePK)parser.getJavaObject("allnodes_stargatepk");
        return allnodes_stargateusecases.get_allnodes_stargate_by_primarykey(allnodes_stargatePK);
    }

    private Object search_allnodes_stargate(Allnodes_stargate_usecases allnodes_stargateusecases) throws CustomException {
        IAllnodes_stargatesearch search = (IAllnodes_stargatesearch)parser.getJavaObject("search");
        return allnodes_stargateusecases.search_allnodes_stargate(search);
    }
    
    private Object search_allnodes_stargate_count(Allnodes_stargate_usecases allnodes_stargateusecases) throws CustomException {
        IAllnodes_stargatesearch allnodes_stargatesearch = (IAllnodes_stargatesearch)parser.getJavaObject("search");
        return allnodes_stargateusecases.search_allnodes_stargate_count(allnodes_stargatesearch);
    }

    @Override
    public String getServletInfo() {
        return "allnodes_stargate_select";
    }

}


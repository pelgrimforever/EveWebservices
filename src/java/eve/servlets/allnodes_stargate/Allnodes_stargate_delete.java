/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.allnodes_stargate;

import general.exception.CustomException;
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

/**
 * @author Franky Laseure
 */
@WebServlet(name="Allnodes_stargate_delete", urlPatterns={"/eve.Allnodes_stargate_delete"})
public class Allnodes_stargate_delete extends SecurityDataServlet {
   
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
                case IAllnodes_stargateOperation.DELETE_ALLNODES_STARGATE:
                    delete_allnodes_stargate(allnodes_stargateusecases);
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

    private void delete_allnodes_stargate(Allnodes_stargate_usecases allnodes_stargateusecases) throws CustomException {
        IAllnodes_stargate allnodes_stargate = (IAllnodes_stargate)parser.getJavaObject("allnodes_stargate");
        allnodes_stargateusecases.deleteAllnodes_stargate(allnodes_stargate);
    }
    
    @Override
    public String getServletInfo() {
        return "allnodes_stargate_insert";
    }

}


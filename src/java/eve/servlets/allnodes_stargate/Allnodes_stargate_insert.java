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

@WebServlet(name="Allnodes_stargate_insert", urlPatterns={"/eve.Allnodes_stargate_insert"})
public class Allnodes_stargate_insert extends SecurityDataServlet {
   
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
                case IAllnodes_stargateOperation.INSERT_ALLNODES_STARGATE:
                    insert_allnodes_stargate(allnodes_stargateusecases);
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

    private void insert_allnodes_stargate(Allnodes_stargate_usecases allnodes_stargateusecases) throws CustomException {
        IAllnodes_stargate allnodes_stargate = (IAllnodes_stargate)parser.getJavaObject("allnodes_stargate");
        allnodes_stargateusecases.insertAllnodes_stargate(allnodes_stargate);
    }
    
    @Override
    public String getServletInfo() {
        return "allnodes_stargate_insert";
    }

}


/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.stargate;

import general.exception.CustomException;
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
@WebServlet(name="Stargate_delete", urlPatterns={"/eve.Stargate_delete"})
public class Stargate_delete extends SecurityDataServlet {
   
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
                case IStargateOperation.DELETE_STARGATE:
                    delete_stargate(stargateusecases);
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

    private void delete_stargate(Stargate_usecases stargateusecases) throws CustomException {
        IStargate stargate = (IStargate)parser.getJavaObject("stargate");
        stargateusecases.deleteStargate(stargate);
    }
    
    @Override
    public String getServletInfo() {
        return "stargate_insert";
    }

}


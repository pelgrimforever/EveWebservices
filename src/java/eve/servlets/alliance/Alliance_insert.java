/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.alliance;

import general.exception.CustomException;
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
@WebServlet(name="Alliance_insert", urlPatterns={"/eve.Alliance_insert"})
public class Alliance_insert extends SecurityDataServlet {
   
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
                case IAllianceOperation.INSERT_ALLIANCE:
                    insert_alliance(allianceusecases);
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

    private void insert_alliance(Alliance_usecases allianceusecases) throws CustomException {
        IAlliance alliance = (IAlliance)parser.getJavaObject("alliance");
        allianceusecases.secureinsertAlliance(alliance);
    }
    
    @Override
    public String getServletInfo() {
        return "alliance_insert";
    }

}


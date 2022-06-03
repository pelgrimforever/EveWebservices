/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.syssettings;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ISyssettings;
import eve.interfaces.servlet.ISyssettingsOperation;
import eve.interfaces.searchentity.ISyssettingssearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Syssettings_usecases;
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
@WebServlet(name="Syssettings_select", urlPatterns={"/eve.Syssettings_select"})
public class Syssettings_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Syssettings_usecases syssettingsusecases = new Syssettings_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ISyssettingsOperation.SELECT_ALL:
                    dataobject = syssettingsusecases.get_all();
                    break;
                case ISyssettingsOperation.SELECT_SYSSETTINGS:
                    dataobject = get_syssettings_with_primarykey(syssettingsusecases);
                    break;
                case ISyssettingsOperation.SELECT_SEARCH:
                    dataobject = search_syssettings(syssettingsusecases);
                    break;
                case ISyssettingsOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_syssettings_count(syssettingsusecases);
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

    private Object get_syssettings_with_primarykey(Syssettings_usecases syssettingsusecases) throws DBException {
        ISyssettingsPK syssettingsPK = (ISyssettingsPK)parser.getJavaObject("syssettingspk");
        return syssettingsusecases.get_syssettings_by_primarykey(syssettingsPK);
    }

    private Object search_syssettings(Syssettings_usecases syssettingsusecases) throws CustomException {
        ISyssettingssearch search = (ISyssettingssearch)parser.getJavaObject("search");
        return syssettingsusecases.search_syssettings(search);
    }
    
    private Object search_syssettings_count(Syssettings_usecases syssettingsusecases) throws CustomException {
        ISyssettingssearch syssettingssearch = (ISyssettingssearch)parser.getJavaObject("search");
        return syssettingsusecases.search_syssettings_count(syssettingssearch);
    }

    @Override
    public String getServletInfo() {
        return "syssettings_select";
    }

}


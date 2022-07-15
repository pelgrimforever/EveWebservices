/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.usersettings;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IUsersettings;
import eve.interfaces.servlet.IUsersettingsOperation;
import eve.interfaces.searchentity.IUsersettingssearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Usersettings_usecases;
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
@WebServlet(name="Usersettings_select", urlPatterns={"/eve.Usersettings_select"})
public class Usersettings_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Usersettings_usecases usersettingsusecases = new Usersettings_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IUsersettingsOperation.SELECT_ALL:
                    dataobject = usersettingsusecases.get_all();
                    break;
                case IUsersettingsOperation.SELECT_USERSETTINGS:
                    dataobject = get_usersettings_with_primarykey(usersettingsusecases);
                    break;
                case IUsersettingsOperation.SELECT_Settings:
                    dataobject = get_usersettings_with_foreignkey_settings(usersettingsusecases);
                    break;
                case IUsersettingsOperation.SELECT_SEARCH:
                    dataobject = search_usersettings(usersettingsusecases);
                    break;
                case IUsersettingsOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_usersettings_count(usersettingsusecases);
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

    private Object get_usersettings_with_primarykey(Usersettings_usecases usersettingsusecases) throws DBException {
        IUsersettingsPK usersettingsPK = (IUsersettingsPK)parser.getJavaObject("usersettingspk");
        return usersettingsusecases.get_usersettings_by_primarykey(usersettingsPK);
    }

    private Object get_usersettings_with_foreignkey_settings(Usersettings_usecases usersettingsusecases) throws CustomException {
        ISettingsPK settingsPK = (ISettingsPK)parser.getJavaObject("settingspk");
        return usersettingsusecases.get_usersettings_with_foreignkey_settings(settingsPK);
    }
    
    private Object search_usersettings(Usersettings_usecases usersettingsusecases) throws CustomException {
        IUsersettingssearch search = (IUsersettingssearch)parser.getJavaObject("search");
        return usersettingsusecases.search_usersettings(search);
    }
    
    private Object search_usersettings_count(Usersettings_usecases usersettingsusecases) throws CustomException {
        IUsersettingssearch usersettingssearch = (IUsersettingssearch)parser.getJavaObject("search");
        return usersettingsusecases.search_usersettings_count(usersettingssearch);
    }

    @Override
    public String getServletInfo() {
        return "usersettings_select";
    }

}


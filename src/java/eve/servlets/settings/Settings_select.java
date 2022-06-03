/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.settings;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ISettings;
import eve.interfaces.servlet.ISettingsOperation;
import eve.interfaces.searchentity.ISettingssearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Settings_usecases;
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
@WebServlet(name="Settings_select", urlPatterns={"/eve.Settings_select"})
public class Settings_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Settings_usecases settingsusecases = new Settings_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ISettingsOperation.SELECT_ALL:
                    dataobject = settingsusecases.get_all();
                    break;
                case ISettingsOperation.SELECT_SETTINGS:
                    dataobject = get_settings_with_primarykey(settingsusecases);
                    break;
                case ISettingsOperation.SELECT_Usersettings:
                    dataobject = get_settings_with_externalforeignkey_usersettings(settingsusecases);
                    break;
                case ISettingsOperation.SELECT_SEARCH:
                    dataobject = search_settings(settingsusecases);
                    break;
                case ISettingsOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_settings_count(settingsusecases);
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

    private Object get_settings_with_primarykey(Settings_usecases settingsusecases) throws DBException {
        ISettingsPK settingsPK = (ISettingsPK)parser.getJavaObject("settingspk");
        return settingsusecases.get_settings_by_primarykey(settingsPK);
    }

    private Object get_settings_with_externalforeignkey_usersettings(Settings_usecases settingsusecases) throws CustomException {
        IUsersettingsPK usersettingsPK = (IUsersettingsPK)parser.getJavaObject("usersettingspk");
        return settingsusecases.get_settings_with_externalforeignkey_usersettings(usersettingsPK);
    }
    
    private Object search_settings(Settings_usecases settingsusecases) throws CustomException {
        ISettingssearch search = (ISettingssearch)parser.getJavaObject("search");
        return settingsusecases.search_settings(search);
    }
    
    private Object search_settings_count(Settings_usecases settingsusecases) throws CustomException {
        ISettingssearch settingssearch = (ISettingssearch)parser.getJavaObject("search");
        return settingsusecases.search_settings_count(settingssearch);
    }

    @Override
    public String getServletInfo() {
        return "settings_select";
    }

}


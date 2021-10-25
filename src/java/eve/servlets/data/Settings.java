/*
 * Settings.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 25.9.2021 15:16
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ISettings;
import eve.interfaces.servlet.ISettingsOperation;
import eve.interfaces.searchentity.ISettingssearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Franky Laseure
 */
@WebServlet(name="Settings", urlPatterns={"/eve.Settings"})
public class Settings extends SecurityDataServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLsettings blsettings = new BLsettings();
        blsettings.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ISettingsPK settingsPK;
                    ISettings settings;
                    switch(this.operation) {
                        case ISettingsOperation.SELECT_ALL:
                            dataobject = blsettings.getSettingss();
                            break;
                        case ISettingsOperation.SELECT_SETTINGS:
                            settingsPK = (ISettingsPK)parser.getJavaObject("settingspk");
                            dataobject = blsettings.getSettings(settingsPK);
                            break;
                        case ISettingsOperation.SELECT_Usersettings:
                            IUsersettingsPK usersettingsPK = (IUsersettingsPK)parser.getJavaObject("usersettingspk");
                            dataobject = blsettings.getUsersettings(usersettingsPK);
                            break;
                        case ISettingsOperation.SELECT_SEARCH:
                            ISettingssearch search = (ISettingssearch)parser.getJavaObject("search");
                            dataobject = blsettings.search(search);
                            break;
                        case ISettingsOperation.SELECT_SEARCHCOUNT:
                            ISettingssearch settingssearch = (ISettingssearch)parser.getJavaObject("search");
                            dataobject = blsettings.searchcount(settingssearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ISettingsOperation.INSERT_SETTINGS:
                            settings = (ISettings)parser.getJavaObject("settings");
                            blsettings.insertSettings(settings);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ISettingsOperation.UPDATE_SETTINGS:
                            settings = (ISettings)parser.getJavaObject("settings");
                            blsettings.updateSettings(settings);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ISettingsOperation.DELETE_SETTINGS:
                            settings = (ISettings)parser.getJavaObject("settings");
                            blsettings.deleteSettings(settings);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_BACKUP:
                    switch(this.operation) {
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line
                    }
                    break;
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "settings";
    }

}


/*
 * Usersettings.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 16.11.2021 15:46
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IUsersettings;
import eve.interfaces.servlet.IUsersettingsOperation;
import eve.interfaces.searchentity.IUsersettingssearch;
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
@WebServlet(name="Usersettings", urlPatterns={"/eve.Usersettings"})
public class Usersettings extends SecurityDataServlet {
   
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
        BLusersettings blusersettings = new BLusersettings();
        blusersettings.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IUsersettingsPK usersettingsPK;
                    IUsersettings usersettings;
                    switch(this.operation) {
                        case IUsersettingsOperation.SELECT_ALL:
                            dataobject = blusersettings.getUsersettingss();
                            break;
                        case IUsersettingsOperation.SELECT_USERSETTINGS:
                            usersettingsPK = (IUsersettingsPK)parser.getJavaObject("usersettingspk");
                            dataobject = blusersettings.getUsersettings(usersettingsPK);
                            break;
                        case IUsersettingsOperation.SELECT_Settings:
                            ISettingsPK settingsPK = (ISettingsPK)parser.getJavaObject("settingspk");
                            dataobject = blusersettings.getUsersettingss4settings(settingsPK);
                            break;
                        case IUsersettingsOperation.SELECT_SEARCH:
                            IUsersettingssearch search = (IUsersettingssearch)parser.getJavaObject("search");
                            dataobject = blusersettings.search(search);
                            break;
                        case IUsersettingsOperation.SELECT_SEARCHCOUNT:
                            IUsersettingssearch usersettingssearch = (IUsersettingssearch)parser.getJavaObject("search");
                            dataobject = blusersettings.searchcount(usersettingssearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IUsersettingsOperation.INSERT_USERSETTINGS:
                            usersettings = (IUsersettings)parser.getJavaObject("usersettings");
                            blusersettings.insertUsersettings(usersettings);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IUsersettingsOperation.UPDATE_USERSETTINGS:
                            usersettings = (IUsersettings)parser.getJavaObject("usersettings");
                            blusersettings.updateUsersettings(usersettings);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IUsersettingsOperation.DELETE_USERSETTINGS:
                            usersettings = (IUsersettings)parser.getJavaObject("usersettings");
                            blusersettings.deleteUsersettings(usersettings);
                            break;
                        case IUsersettingsOperation.DELETE_Settings:
                            ISettingsPK settingsPK = (ISettingsPK)parser.getJavaObject("settingspk");
                            blusersettings.delete4settings(settingsPK);
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
        return "usersettings";
    }

}


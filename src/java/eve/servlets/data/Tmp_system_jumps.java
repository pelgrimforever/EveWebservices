/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 30.5.2021 15:39
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ITmp_system_jumps;
import eve.interfaces.servlet.ITmp_system_jumpsOperation;
import eve.interfaces.searchentity.ITmp_system_jumpssearch;
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
@WebServlet(name="Tmp_system_jumps", urlPatterns={"/eve.Tmp_system_jumps"})
public class Tmp_system_jumps extends SecurityDataServlet {
   
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
        BLtmp_system_jumps bltmp_system_jumps = new BLtmp_system_jumps();
        bltmp_system_jumps.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ITmp_system_jumpsPK tmp_system_jumpsPK;
                    ITmp_system_jumps tmp_system_jumps;
                    switch(this.operation) {
                        case ITmp_system_jumpsOperation.SELECT_ALL:
                            dataobject = bltmp_system_jumps.getTmp_system_jumpss();
                            break;
                        case ITmp_system_jumpsOperation.SELECT_TMP_SYSTEM_JUMPS:
                            tmp_system_jumpsPK = (ITmp_system_jumpsPK)parser.getJavaObject("tmp_system_jumpspk");
                            dataobject = bltmp_system_jumps.getTmp_system_jumps(tmp_system_jumpsPK);
                            break;
                        case ITmp_system_jumpsOperation.SELECT_SEARCH:
                            ITmp_system_jumpssearch search = (ITmp_system_jumpssearch)parser.getJavaObject("search");
                            dataobject = bltmp_system_jumps.search(search);
                            break;
                        case ITmp_system_jumpsOperation.SELECT_SEARCHCOUNT:
                            ITmp_system_jumpssearch tmp_system_jumpssearch = (ITmp_system_jumpssearch)parser.getJavaObject("search");
                            dataobject = bltmp_system_jumps.searchcount(tmp_system_jumpssearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ITmp_system_jumpsOperation.INSERT_TMP_SYSTEM_JUMPS:
                            tmp_system_jumps = (ITmp_system_jumps)parser.getJavaObject("tmp_system_jumps");
                            bltmp_system_jumps.insertTmp_system_jumps(tmp_system_jumps);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ITmp_system_jumpsOperation.UPDATE_TMP_SYSTEM_JUMPS:
                            tmp_system_jumps = (ITmp_system_jumps)parser.getJavaObject("tmp_system_jumps");
                            bltmp_system_jumps.updateTmp_system_jumps(tmp_system_jumps);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ITmp_system_jumpsOperation.DELETE_TMP_SYSTEM_JUMPS:
                            tmp_system_jumps = (ITmp_system_jumps)parser.getJavaObject("tmp_system_jumps");
                            bltmp_system_jumps.deleteTmp_system_jumps(tmp_system_jumps);
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
        return "tmp_system_jumps";
    }

}


/*
 * Materialinput.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 11.4.2022 9:13
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IMaterialinput;
import eve.interfaces.servlet.IMaterialinputOperation;
import eve.interfaces.searchentity.IMaterialinputsearch;
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
@WebServlet(name="Materialinput", urlPatterns={"/eve.Materialinput"})
public class Materialinput extends SecurityDataServlet {
   
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
        BLmaterialinput blmaterialinput = new BLmaterialinput();
        blmaterialinput.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.SELECT:
                    IMaterialinputPK materialinputPK;
                    IMaterialinput materialinput;
                    switch(this.operation) {
                        case IMaterialinputOperation.SELECT_ALL:
                            dataobject = blmaterialinput.getMaterialinputs();
                            break;
                        case IMaterialinputOperation.SELECT_MATERIALINPUT:
                            materialinputPK = (IMaterialinputPK)parser.getJavaObject("materialinputpk");
                            dataobject = blmaterialinput.getMaterialinput(materialinputPK);
                            break;
                        case IMaterialinputOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            dataobject = blmaterialinput.getMaterialinputs4evetype(evetypePK);
                            break;
                        case IMaterialinputOperation.SELECT_SEARCH:
                            IMaterialinputsearch search = (IMaterialinputsearch)parser.getJavaObject("search");
                            dataobject = blmaterialinput.search(search);
                            break;
                        case IMaterialinputOperation.SELECT_SEARCHCOUNT:
                            IMaterialinputsearch materialinputsearch = (IMaterialinputsearch)parser.getJavaObject("search");
                            dataobject = blmaterialinput.searchcount(materialinputsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.INSERT:
                    switch(this.operation) {
                        case IMaterialinputOperation.INSERT_MATERIALINPUT:
                            materialinput = (IMaterialinput)parser.getJavaObject("materialinput");
                            blmaterialinput.insertMaterialinput(materialinput);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.UPDATE:
                    switch(this.operation) {
                        case IMaterialinputOperation.UPDATE_MATERIALINPUT:
                            materialinput = (IMaterialinput)parser.getJavaObject("materialinput");
                            blmaterialinput.updateMaterialinput(materialinput);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.DELETE:
                    switch(this.operation) {
                        case IMaterialinputOperation.DELETE_MATERIALINPUT:
                            materialinput = (IMaterialinput)parser.getJavaObject("materialinput");
                            blmaterialinput.deleteMaterialinput(materialinput);
                            break;
                        case IMaterialinputOperation.DELETE_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            blmaterialinput.delete4evetype(evetypePK);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.BACKUP:
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
        return "materialinput";
    }

}


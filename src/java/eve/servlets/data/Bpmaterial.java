/*
 * Bpmaterial.java
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
import eve.interfaces.logicentity.IBpmaterial;
import eve.interfaces.servlet.IBpmaterialOperation;
import eve.interfaces.searchentity.IBpmaterialsearch;
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
@WebServlet(name="Bpmaterial", urlPatterns={"/eve.Bpmaterial"})
public class Bpmaterial extends SecurityDataServlet {
   
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
        BLbpmaterial blbpmaterial = new BLbpmaterial();
        blbpmaterial.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.SELECT:
                    IBpmaterialPK bpmaterialPK;
                    IBpmaterial bpmaterial;
                    switch(this.operation) {
                        case IBpmaterialOperation.SELECT_ALL:
                            dataobject = blbpmaterial.getBpmaterials();
                            break;
                        case IBpmaterialOperation.SELECT_BPMATERIAL:
                            bpmaterialPK = (IBpmaterialPK)parser.getJavaObject("bpmaterialpk");
                            dataobject = blbpmaterial.getBpmaterial(bpmaterialPK);
                            break;
                        case IBpmaterialOperation.SELECT_Evetypebp:
                            IEvetypePK evetypeBpPK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            dataobject = blbpmaterial.getBpmaterials4evetypeBp(evetypeBpPK);
                            break;
                        case IBpmaterialOperation.SELECT_Evetypematerial:
                            IEvetypePK evetypeMaterialPK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            dataobject = blbpmaterial.getBpmaterials4evetypeMaterial(evetypeMaterialPK);
                            break;
                        case IBpmaterialOperation.SELECT_SEARCH:
                            IBpmaterialsearch search = (IBpmaterialsearch)parser.getJavaObject("search");
                            dataobject = blbpmaterial.search(search);
                            break;
                        case IBpmaterialOperation.SELECT_SEARCHCOUNT:
                            IBpmaterialsearch bpmaterialsearch = (IBpmaterialsearch)parser.getJavaObject("search");
                            dataobject = blbpmaterial.searchcount(bpmaterialsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.INSERT:
                    switch(this.operation) {
                        case IBpmaterialOperation.INSERT_BPMATERIAL:
                            bpmaterial = (IBpmaterial)parser.getJavaObject("bpmaterial");
                            blbpmaterial.insertBpmaterial(bpmaterial);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.UPDATE:
                    switch(this.operation) {
                        case IBpmaterialOperation.UPDATE_BPMATERIAL:
                            bpmaterial = (IBpmaterial)parser.getJavaObject("bpmaterial");
                            blbpmaterial.updateBpmaterial(bpmaterial);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.DELETE:
                    switch(this.operation) {
                        case IBpmaterialOperation.DELETE_BPMATERIAL:
                            bpmaterial = (IBpmaterial)parser.getJavaObject("bpmaterial");
                            blbpmaterial.deleteBpmaterial(bpmaterial);
                            break;
                        case IBpmaterialOperation.DELETE_Evetypebp:
                            IEvetypePK evetypeBpPK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            blbpmaterial.delete4evetypeBp(evetypeBpPK);
                            break;
                        case IBpmaterialOperation.DELETE_Evetypematerial:
                            IEvetypePK evetypeMaterialPK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            blbpmaterial.delete4evetypeMaterial(evetypeMaterialPK);
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
        return "bpmaterial";
    }

}


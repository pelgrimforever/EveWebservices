/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.bpmaterial;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IBpmaterial;
import eve.interfaces.servlet.IBpmaterialOperation;
import eve.interfaces.searchentity.IBpmaterialsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Bpmaterial_usecases;
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
@WebServlet(name="Bpmaterial_delete", urlPatterns={"/eve.Bpmaterial_delete"})
public class Bpmaterial_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Bpmaterial_usecases bpmaterialusecases = new Bpmaterial_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IBpmaterialOperation.DELETE_BPMATERIAL:
                    delete_bpmaterial(bpmaterialusecases);
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

    private void delete_bpmaterial(Bpmaterial_usecases bpmaterialusecases) throws CustomException {
        IBpmaterial bpmaterial = (IBpmaterial)parser.getJavaObject("bpmaterial");
        bpmaterialusecases.securedeleteBpmaterial(bpmaterial);
    }
    
    @Override
    public String getServletInfo() {
        return "bpmaterial_insert";
    }

}


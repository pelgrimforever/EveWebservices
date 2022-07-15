/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
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
@WebServlet(name="Bpmaterial_insert", urlPatterns={"/eve.Bpmaterial_insert"})
public class Bpmaterial_insert extends SecurityDataServlet {
   
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
                case IBpmaterialOperation.INSERT_BPMATERIAL:
                    insert_bpmaterial(bpmaterialusecases);
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

    private void insert_bpmaterial(Bpmaterial_usecases bpmaterialusecases) throws CustomException {
        IBpmaterial bpmaterial = (IBpmaterial)parser.getJavaObject("bpmaterial");
        bpmaterialusecases.insertBpmaterial(bpmaterial);
    }
    
    @Override
    public String getServletInfo() {
        return "bpmaterial_insert";
    }

}


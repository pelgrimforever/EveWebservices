/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.corporation;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ICorporation;
import eve.interfaces.servlet.ICorporationOperation;
import eve.interfaces.searchentity.ICorporationsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Corporation_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Corporation_delete", urlPatterns={"/eve.Corporation_delete"})
public class Corporation_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Corporation_usecases corporationusecases = new Corporation_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ICorporationOperation.DELETE_CORPORATION:
                    delete_corporation(corporationusecases);
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

    private void delete_corporation(Corporation_usecases corporationusecases) throws CustomException {
        ICorporation corporation = (ICorporation)parser.getJavaObject("corporation");
        corporationusecases.deleteCorporation(corporation);
    }
    
    @Override
    public String getServletInfo() {
        return "corporation_insert";
    }

}


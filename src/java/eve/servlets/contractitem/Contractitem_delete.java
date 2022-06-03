/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.contractitem;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IContractitem;
import eve.interfaces.servlet.IContractitemOperation;
import eve.interfaces.searchentity.IContractitemsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Contractitem_usecases;
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
@WebServlet(name="Contractitem_delete", urlPatterns={"/eve.Contractitem_delete"})
public class Contractitem_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Contractitem_usecases contractitemusecases = new Contractitem_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IContractitemOperation.DELETE_CONTRACTITEM:
                    delete_contractitem(contractitemusecases);
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

    private void delete_contractitem(Contractitem_usecases contractitemusecases) throws CustomException {
        IContractitem contractitem = (IContractitem)parser.getJavaObject("contractitem");
        contractitemusecases.securedeleteContractitem(contractitem);
    }
    
    @Override
    public String getServletInfo() {
        return "contractitem_insert";
    }

}


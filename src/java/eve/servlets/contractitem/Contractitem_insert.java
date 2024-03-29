/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.contractitem;

import general.exception.*;
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

@WebServlet(name="Contractitem_insert", urlPatterns={"/eve.Contractitem_insert"})
public class Contractitem_insert extends SecurityDataServlet {
   
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
                case IContractitemOperation.INSERT_CONTRACTITEM:
                    insert_contractitem(contractitemusecases);
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

    private void insert_contractitem(Contractitem_usecases contractitemusecases) throws CustomException {
        IContractitem contractitem = (IContractitem)parser.getJavaObject("contractitem");
        contractitemusecases.insertContractitem(contractitem);
    }
    
    @Override
    public String getServletInfo() {
        return "contractitem_insert";
    }

}


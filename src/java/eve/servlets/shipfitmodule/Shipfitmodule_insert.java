/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.shipfitmodule;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IShipfitmodule;
import eve.interfaces.servlet.IShipfitmoduleOperation;
import eve.interfaces.searchentity.IShipfitmodulesearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Shipfitmodule_usecases;
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
@WebServlet(name="Shipfitmodule_insert", urlPatterns={"/eve.Shipfitmodule_insert"})
public class Shipfitmodule_insert extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Shipfitmodule_usecases shipfitmoduleusecases = new Shipfitmodule_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IShipfitmoduleOperation.INSERT_SHIPFITMODULE:
                    insert_shipfitmodule(shipfitmoduleusecases);
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

    private void insert_shipfitmodule(Shipfitmodule_usecases shipfitmoduleusecases) throws CustomException {
        IShipfitmodule shipfitmodule = (IShipfitmodule)parser.getJavaObject("shipfitmodule");
        shipfitmoduleusecases.insertShipfitmodule(shipfitmodule);
    }
    
    @Override
    public String getServletInfo() {
        return "shipfitmodule_insert";
    }

}


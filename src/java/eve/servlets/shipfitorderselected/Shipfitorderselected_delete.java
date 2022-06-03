/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.shipfitorderselected;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IShipfitorderselected;
import eve.interfaces.servlet.IShipfitorderselectedOperation;
import eve.interfaces.searchentity.IShipfitorderselectedsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Shipfitorderselected_usecases;
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
@WebServlet(name="Shipfitorderselected_delete", urlPatterns={"/eve.Shipfitorderselected_delete"})
public class Shipfitorderselected_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Shipfitorderselected_usecases shipfitorderselectedusecases = new Shipfitorderselected_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IShipfitorderselectedOperation.DELETE_SHIPFITORDERSELECTED:
                    delete_shipfitorderselected(shipfitorderselectedusecases);
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

    private void delete_shipfitorderselected(Shipfitorderselected_usecases shipfitorderselectedusecases) throws CustomException {
        IShipfitorderselected shipfitorderselected = (IShipfitorderselected)parser.getJavaObject("shipfitorderselected");
        shipfitorderselectedusecases.securedeleteShipfitorderselected(shipfitorderselected);
    }
    
    @Override
    public String getServletInfo() {
        return "shipfitorderselected_insert";
    }

}


/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.shipfit;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IShipfit;
import eve.interfaces.servlet.IShipfitOperation;
import eve.interfaces.searchentity.IShipfitsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Shipfit_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Shipfit_insert", urlPatterns={"/eve.Shipfit_insert"})
public class Shipfit_insert extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Shipfit_usecases shipfitusecases = new Shipfit_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IShipfitOperation.INSERT_SHIPFIT:
                    insert_shipfit(shipfitusecases);
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

    private void insert_shipfit(Shipfit_usecases shipfitusecases) throws CustomException {
        IShipfit shipfit = (IShipfit)parser.getJavaObject("shipfit");
        shipfitusecases.insertShipfit(shipfit);
    }
    
    @Override
    public String getServletInfo() {
        return "shipfit_insert";
    }

}


/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.shipfitorder;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IShipfitorder;
import eve.interfaces.servlet.IShipfitorderOperation;
import eve.interfaces.searchentity.IShipfitordersearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Shipfitorder_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Shipfitorder_insert", urlPatterns={"/eve.Shipfitorder_insert"})
public class Shipfitorder_insert extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Shipfitorder_usecases shipfitorderusecases = new Shipfitorder_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IShipfitorderOperation.INSERT_SHIPFITORDER:
                    insert_shipfitorder(shipfitorderusecases);
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

    private void insert_shipfitorder(Shipfitorder_usecases shipfitorderusecases) throws CustomException {
        IShipfitorder shipfitorder = (IShipfitorder)parser.getJavaObject("shipfitorder");
        shipfitorderusecases.insertShipfitorder(shipfitorder);
    }
    
    @Override
    public String getServletInfo() {
        return "shipfitorder_insert";
    }

}


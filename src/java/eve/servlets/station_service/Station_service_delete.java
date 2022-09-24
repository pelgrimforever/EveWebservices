/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.station_service;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IStation_service;
import eve.interfaces.servlet.IStation_serviceOperation;
import eve.interfaces.searchentity.IStation_servicesearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Station_service_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Station_service_delete", urlPatterns={"/eve.Station_service_delete"})
public class Station_service_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Station_service_usecases station_serviceusecases = new Station_service_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IStation_serviceOperation.DELETE_STATION_SERVICE:
                    delete_station_service(station_serviceusecases);
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

    private void delete_station_service(Station_service_usecases station_serviceusecases) throws CustomException {
        IStation_service station_service = (IStation_service)parser.getJavaObject("station_service");
        station_serviceusecases.deleteStation_service(station_service);
    }
    
    @Override
    public String getServletInfo() {
        return "station_service_insert";
    }

}


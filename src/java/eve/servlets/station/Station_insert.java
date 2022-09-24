/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.station;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IStation;
import eve.interfaces.servlet.IStationOperation;
import eve.interfaces.searchentity.IStationsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Station_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Station_insert", urlPatterns={"/eve.Station_insert"})
public class Station_insert extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Station_usecases stationusecases = new Station_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IStationOperation.INSERT_STATION:
                    insert_station(stationusecases);
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

    private void insert_station(Station_usecases stationusecases) throws CustomException {
        IStation station = (IStation)parser.getJavaObject("station");
        stationusecases.insertStation(station);
    }
    
    @Override
    public String getServletInfo() {
        return "station_insert";
    }

}


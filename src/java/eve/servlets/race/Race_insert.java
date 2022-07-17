/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.race;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IRace;
import eve.interfaces.servlet.IRaceOperation;
import eve.interfaces.searchentity.IRacesearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Race_usecases;
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
@WebServlet(name="Race_insert", urlPatterns={"/eve.Race_insert"})
public class Race_insert extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Race_usecases raceusecases = new Race_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IRaceOperation.INSERT_RACE:
                    insert_race(raceusecases);
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

    private void insert_race(Race_usecases raceusecases) throws CustomException {
        IRace race = (IRace)parser.getJavaObject("race");
        raceusecases.insertRace(race);
    }
    
    @Override
    public String getServletInfo() {
        return "race_insert";
    }

}


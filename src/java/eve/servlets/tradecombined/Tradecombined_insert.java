/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.tradecombined;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ITradecombined;
import eve.interfaces.servlet.ITradecombinedOperation;
import eve.interfaces.searchentity.ITradecombinedsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Tradecombined_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Tradecombined_insert", urlPatterns={"/eve.Tradecombined_insert"})
public class Tradecombined_insert extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Tradecombined_usecases tradecombinedusecases = new Tradecombined_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ITradecombinedOperation.INSERT_TRADECOMBINED:
                    insert_tradecombined(tradecombinedusecases);
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

    private void insert_tradecombined(Tradecombined_usecases tradecombinedusecases) throws CustomException {
        ITradecombined tradecombined = (ITradecombined)parser.getJavaObject("tradecombined");
        tradecombinedusecases.insertTradecombined(tradecombined);
    }
    
    @Override
    public String getServletInfo() {
        return "tradecombined_insert";
    }

}


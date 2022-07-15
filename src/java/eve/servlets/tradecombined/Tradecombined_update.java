/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.tradecombined;

import general.exception.CustomException;
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

/**
 * @author Franky Laseure
 */
@WebServlet(name="Tradecombined_update", urlPatterns={"/eve.Tradecombined_update"})
public class Tradecombined_update extends SecurityDataServlet {
   
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
                case ITradecombinedOperation.UPDATE_TRADECOMBINED:
                    update_tradecombined(tradecombinedusecases);
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

    private void update_tradecombined(Tradecombined_usecases tradecombinedusecases) throws CustomException {
        ITradecombined tradecombined = (ITradecombined)parser.getJavaObject("tradecombined");
        tradecombinedusecases.updateTradecombined(tradecombined);
    }
    
    @Override
    public String getServletInfo() {
        return "tradecombined_insert";
    }

}


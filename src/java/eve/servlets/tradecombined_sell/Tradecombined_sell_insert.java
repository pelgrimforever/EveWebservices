/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.tradecombined_sell;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ITradecombined_sell;
import eve.interfaces.servlet.ITradecombined_sellOperation;
import eve.interfaces.searchentity.ITradecombined_sellsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Tradecombined_sell_usecases;
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
@WebServlet(name="Tradecombined_sell_insert", urlPatterns={"/eve.Tradecombined_sell_insert"})
public class Tradecombined_sell_insert extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Tradecombined_sell_usecases tradecombined_sellusecases = new Tradecombined_sell_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ITradecombined_sellOperation.INSERT_TRADECOMBINED_SELL:
                    insert_tradecombined_sell(tradecombined_sellusecases);
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

    private void insert_tradecombined_sell(Tradecombined_sell_usecases tradecombined_sellusecases) throws CustomException {
        ITradecombined_sell tradecombined_sell = (ITradecombined_sell)parser.getJavaObject("tradecombined_sell");
        tradecombined_sellusecases.insertTradecombined_sell(tradecombined_sell);
    }
    
    @Override
    public String getServletInfo() {
        return "tradecombined_sell_insert";
    }

}


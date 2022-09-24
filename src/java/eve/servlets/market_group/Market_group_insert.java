/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.market_group;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IMarket_group;
import eve.interfaces.servlet.IMarket_groupOperation;
import eve.interfaces.searchentity.IMarket_groupsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Market_group_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Market_group_insert", urlPatterns={"/eve.Market_group_insert"})
public class Market_group_insert extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Market_group_usecases market_groupusecases = new Market_group_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IMarket_groupOperation.INSERT_MARKET_GROUP:
                    insert_market_group(market_groupusecases);
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

    private void insert_market_group(Market_group_usecases market_groupusecases) throws CustomException {
        IMarket_group market_group = (IMarket_group)parser.getJavaObject("market_group");
        market_groupusecases.insertMarket_group(market_group);
    }
    
    @Override
    public String getServletInfo() {
        return "market_group_insert";
    }

}


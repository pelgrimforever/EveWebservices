/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.market_group;

import general.exception.CustomException;
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

/**
 * @author Franky Laseure
 */
@WebServlet(name="Market_group_delete", urlPatterns={"/eve.Market_group_delete"})
public class Market_group_delete extends SecurityDataServlet {
   
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
                case IMarket_groupOperation.DELETE_MARKET_GROUP:
                    delete_market_group(market_groupusecases);
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

    private void delete_market_group(Market_group_usecases market_groupusecases) throws CustomException {
        IMarket_group market_group = (IMarket_group)parser.getJavaObject("market_group");
        market_groupusecases.deleteMarket_group(market_group);
    }
    
    @Override
    public String getServletInfo() {
        return "market_group_insert";
    }

}


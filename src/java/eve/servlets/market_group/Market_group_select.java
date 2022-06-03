/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
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

/**
 * @author Franky Laseure
 */
@WebServlet(name="Market_group_select", urlPatterns={"/eve.Market_group_select"})
public class Market_group_select extends SecurityDataServlet {
   
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
                case IMarket_groupOperation.SELECT_ALL:
                    dataobject = market_groupusecases.get_all();
                    break;
                case IMarket_groupOperation.SELECT_MARKET_GROUP:
                    dataobject = get_market_group_with_primarykey(market_groupusecases);
                    break;
                case IMarket_groupOperation.SELECT_Market_groupparent_id:
                    dataobject = get_market_group_with_foreignkey_market_groupParent_id(market_groupusecases);
                    break;
                case IMarket_groupOperation.SELECT_SEARCH:
                    dataobject = search_market_group(market_groupusecases);
                    break;
                case IMarket_groupOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_market_group_count(market_groupusecases);
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

    private Object get_market_group_with_primarykey(Market_group_usecases market_groupusecases) throws DBException {
        IMarket_groupPK market_groupPK = (IMarket_groupPK)parser.getJavaObject("market_grouppk");
        return market_groupusecases.get_market_group_by_primarykey(market_groupPK);
    }

    private Object get_market_group_with_foreignkey_market_groupParent_id(Market_group_usecases market_groupusecases) throws CustomException {
        IMarket_groupPK market_groupParent_idPK = (IMarket_groupPK)parser.getJavaObject("market_grouppk");
        return market_groupusecases.get_market_group_with_foreignkey_market_groupParent_id(market_groupParent_idPK);
    }
    
    private Object search_market_group(Market_group_usecases market_groupusecases) throws CustomException {
        IMarket_groupsearch search = (IMarket_groupsearch)parser.getJavaObject("search");
        return market_groupusecases.search_market_group(search);
    }
    
    private Object search_market_group_count(Market_group_usecases market_groupusecases) throws CustomException {
        IMarket_groupsearch market_groupsearch = (IMarket_groupsearch)parser.getJavaObject("search");
        return market_groupusecases.search_market_group_count(market_groupsearch);
    }

    @Override
    public String getServletInfo() {
        return "market_group_select";
    }

}


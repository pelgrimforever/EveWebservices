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

@WebServlet(name="Tradecombined_select", urlPatterns={"/eve.Tradecombined_select"})
public class Tradecombined_select extends SecurityDataServlet {
   
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
                case ITradecombinedOperation.SELECT_ALL:
                    dataobject = tradecombinedusecases.get_all();
                    break;
                case ITradecombinedOperation.SELECT_TRADECOMBINED:
                    dataobject = get_tradecombined_with_primarykey(tradecombinedusecases);
                    break;
                case ITradecombinedOperation.SELECT_Evetype:
                    dataobject = get_tradecombined_with_foreignkey_evetype(tradecombinedusecases);
                    break;
                case ITradecombinedOperation.SELECT_Systembuy_system:
                    dataobject = get_tradecombined_with_foreignkey_systemBuy_system(tradecombinedusecases);
                    break;
                case ITradecombinedOperation.SELECT_Systemsell_system:
                    dataobject = get_tradecombined_with_foreignkey_systemSell_system(tradecombinedusecases);
                    break;
                case ITradecombinedOperation.SELECT_Tradecombined_sell:
                    dataobject = get_tradecombined_with_externalforeignkey_tradecombined_sell(tradecombinedusecases);
                    break;
                case ITradecombinedOperation.SELECT_SEARCH:
                    dataobject = search_tradecombined(tradecombinedusecases);
                    break;
                case ITradecombinedOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_tradecombined_count(tradecombinedusecases);
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

    private Object get_tradecombined_with_primarykey(Tradecombined_usecases tradecombinedusecases) throws DBException {
        ITradecombinedPK tradecombinedPK = (ITradecombinedPK)parser.getJavaObject("tradecombinedpk");
        return tradecombinedusecases.get_tradecombined_by_primarykey(tradecombinedPK);
    }

    private Object get_tradecombined_with_foreignkey_evetype(Tradecombined_usecases tradecombinedusecases) throws CustomException {
        IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
        return tradecombinedusecases.get_tradecombined_with_foreignkey_evetype(evetypePK);
    }
    
    private Object get_tradecombined_with_foreignkey_systemBuy_system(Tradecombined_usecases tradecombinedusecases) throws CustomException {
        ISystemPK systemBuy_systemPK = (ISystemPK)parser.getJavaObject("systempk");
        return tradecombinedusecases.get_tradecombined_with_foreignkey_systemBuy_system(systemBuy_systemPK);
    }
    
    private Object get_tradecombined_with_foreignkey_systemSell_system(Tradecombined_usecases tradecombinedusecases) throws CustomException {
        ISystemPK systemSell_systemPK = (ISystemPK)parser.getJavaObject("systempk");
        return tradecombinedusecases.get_tradecombined_with_foreignkey_systemSell_system(systemSell_systemPK);
    }
    
    private Object get_tradecombined_with_externalforeignkey_tradecombined_sell(Tradecombined_usecases tradecombinedusecases) throws CustomException {
        ITradecombined_sellPK tradecombined_sellPK = (ITradecombined_sellPK)parser.getJavaObject("tradecombined_sellpk");
        return tradecombinedusecases.get_tradecombined_with_externalforeignkey_tradecombined_sell(tradecombined_sellPK);
    }
    
    private Object search_tradecombined(Tradecombined_usecases tradecombinedusecases) throws CustomException {
        ITradecombinedsearch search = (ITradecombinedsearch)parser.getJavaObject("search");
        return tradecombinedusecases.search_tradecombined(search);
    }
    
    private Object search_tradecombined_count(Tradecombined_usecases tradecombinedusecases) throws CustomException {
        ITradecombinedsearch tradecombinedsearch = (ITradecombinedsearch)parser.getJavaObject("search");
        return tradecombinedusecases.search_tradecombined_count(tradecombinedsearch);
    }

    @Override
    public String getServletInfo() {
        return "tradecombined_select";
    }

}


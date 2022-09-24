/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.contractitem;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IContractitem;
import eve.interfaces.servlet.IContractitemOperation;
import eve.interfaces.searchentity.IContractitemsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Contractitem_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Contractitem_select", urlPatterns={"/eve.Contractitem_select"})
public class Contractitem_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Contractitem_usecases contractitemusecases = new Contractitem_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IContractitemOperation.SELECT_ALL:
                    dataobject = contractitemusecases.get_all();
                    break;
                case IContractitemOperation.SELECT_CONTRACTITEM:
                    dataobject = get_contractitem_with_primarykey(contractitemusecases);
                    break;
                case IContractitemOperation.SELECT_Evetype:
                    dataobject = get_contractitem_with_foreignkey_evetype(contractitemusecases);
                    break;
                case IContractitemOperation.SELECT_Contract:
                    dataobject = get_contractitem_with_foreignkey_contract(contractitemusecases);
                    break;
                case IContractitemOperation.SELECT_SEARCH:
                    dataobject = search_contractitem(contractitemusecases);
                    break;
                case IContractitemOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_contractitem_count(contractitemusecases);
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

    private Object get_contractitem_with_primarykey(Contractitem_usecases contractitemusecases) throws DBException {
        IContractitemPK contractitemPK = (IContractitemPK)parser.getJavaObject("contractitempk");
        return contractitemusecases.get_contractitem_by_primarykey(contractitemPK);
    }

    private Object get_contractitem_with_foreignkey_evetype(Contractitem_usecases contractitemusecases) throws CustomException {
        IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
        return contractitemusecases.get_contractitem_with_foreignkey_evetype(evetypePK);
    }
    
    private Object get_contractitem_with_foreignkey_contract(Contractitem_usecases contractitemusecases) throws CustomException {
        IContractPK contractPK = (IContractPK)parser.getJavaObject("contractpk");
        return contractitemusecases.get_contractitem_with_foreignkey_contract(contractPK);
    }
    
    private Object search_contractitem(Contractitem_usecases contractitemusecases) throws CustomException {
        IContractitemsearch search = (IContractitemsearch)parser.getJavaObject("search");
        return contractitemusecases.search_contractitem(search);
    }
    
    private Object search_contractitem_count(Contractitem_usecases contractitemusecases) throws CustomException {
        IContractitemsearch contractitemsearch = (IContractitemsearch)parser.getJavaObject("search");
        return contractitemusecases.search_contractitem_count(contractitemsearch);
    }

    @Override
    public String getServletInfo() {
        return "contractitem_select";
    }

}


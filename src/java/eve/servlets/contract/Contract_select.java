/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.contract;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IContract;
import eve.interfaces.servlet.IContractOperation;
import eve.interfaces.searchentity.IContractsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Contract_usecases;
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
@WebServlet(name="Contract_select", urlPatterns={"/eve.Contract_select"})
public class Contract_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Contract_usecases contractusecases = new Contract_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IContractOperation.SELECT_ALL:
                    dataobject = contractusecases.get_all();
                    break;
                case IContractOperation.SELECT_CONTRACT:
                    dataobject = get_contract_with_primarykey(contractusecases);
                    break;
                case IContractOperation.SELECT_SEARCH:
                    dataobject = search_contract(contractusecases);
                    break;
                case IContractOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_contract_count(contractusecases);
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

    private Object get_contract_with_primarykey(Contract_usecases contractusecases) throws DBException {
        IContractPK contractPK = (IContractPK)parser.getJavaObject("contractpk");
        return contractusecases.get_contract_by_primarykey(contractPK);
    }

    private Object search_contract(Contract_usecases contractusecases) throws CustomException {
        IContractsearch search = (IContractsearch)parser.getJavaObject("search");
        return contractusecases.search_contract(search);
    }
    
    private Object search_contract_count(Contract_usecases contractusecases) throws CustomException {
        IContractsearch contractsearch = (IContractsearch)parser.getJavaObject("search");
        return contractusecases.search_contract_count(contractsearch);
    }

    @Override
    public String getServletInfo() {
        return "contract_select";
    }

}


/*
 * Contract.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 11.4.2022 9:13
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IContract;
import eve.interfaces.servlet.IContractOperation;
import eve.interfaces.searchentity.IContractsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Franky Laseure
 */
@WebServlet(name="Contract", urlPatterns={"/eve.Contract"})
public class Contract extends SecurityDataServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLcontract blcontract = new BLcontract();
        blcontract.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.SELECT:
                    IContractPK contractPK;
                    IContract contract;
                    switch(this.operation) {
                        case IContractOperation.SELECT_ALL:
                            dataobject = blcontract.getContracts();
                            break;
                        case IContractOperation.SELECT_CONTRACT:
                            contractPK = (IContractPK)parser.getJavaObject("contractpk");
                            dataobject = blcontract.getContract(contractPK);
                            break;
                        case IContractOperation.SELECT_SEARCH:
                            IContractsearch search = (IContractsearch)parser.getJavaObject("search");
                            dataobject = blcontract.search(search);
                            break;
                        case IContractOperation.SELECT_SEARCHCOUNT:
                            IContractsearch contractsearch = (IContractsearch)parser.getJavaObject("search");
                            dataobject = blcontract.searchcount(contractsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.INSERT:
                    switch(this.operation) {
                        case IContractOperation.INSERT_CONTRACT:
                            contract = (IContract)parser.getJavaObject("contract");
                            blcontract.insertContract(contract);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.UPDATE:
                    switch(this.operation) {
                        case IContractOperation.UPDATE_CONTRACT:
                            contract = (IContract)parser.getJavaObject("contract");
                            blcontract.updateContract(contract);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.DELETE:
                    switch(this.operation) {
                        case IContractOperation.DELETE_CONTRACT:
                            contract = (IContract)parser.getJavaObject("contract");
                            blcontract.deleteContract(contract);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.BACKUP:
                    switch(this.operation) {
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line
                    }
                    break;
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "contract";
    }

}


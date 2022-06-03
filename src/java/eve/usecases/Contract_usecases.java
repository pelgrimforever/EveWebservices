/*
 * Generated on 20.4.2022 10:3
 */

package eve.usecases;

import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Contract;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Contract_usecases {

    private boolean loggedin = false;
    private BLcontract blcontract = new BLcontract();
    
    public Contract_usecases() {
        this(false);
    }
    
    public Contract_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blcontract.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blcontract.count();
    }
    
    public ArrayList<Contract> get_all() throws DBException {
        return blcontract.getContracts();
    }
    
    public boolean getContractExists(IContractPK contractPK) throws DBException {
        return blcontract.getEntityExists(contractPK);
    }
    
    public Contract get_contract_by_primarykey(IContractPK contractPK) throws DBException {
        return blcontract.getContract(contractPK);
    }

    public ArrayList<Contract> search_contract(IContractsearch contractsearch) throws CustomException {
        return blcontract.search(contractsearch);
    }
    
    public long search_contract_count(IContractsearch contractsearch) throws CustomException {
        return blcontract.searchcount(contractsearch);
    }

    public void secureinsertContract(IContract contract) throws DBException, DataException {
        blcontract.secureinsertContract(contract);
    }

    public void secureupdateContract(IContract contract) throws DBException, DataException {
        blcontract.secureupdateContract(contract);
    }

    public void securedeleteContract(IContract contract) throws DBException, DataException {
        blcontract.securedeleteContract(contract);
    }
}


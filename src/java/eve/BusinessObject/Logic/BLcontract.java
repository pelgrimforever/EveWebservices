/*
 * BLcontract.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 2.0.2022 18:23
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLparameters;
import general.exception.DBException;
import eve.interfaces.logicentity.IContract;
import eve.logicentity.Contract;
import eve.BusinessObject.table.Bcontract;
import eve.conversion.entity.EMcontract;
import eve.conversion.entity.EMcontractitem;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLcontract
 *
 * Class for manipulating data- and database objects
 * for Entity Contract and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLcontract extends Bcontract {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Contract as default Entity
     */
    public BLcontract() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Contract as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLcontract(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    public ArrayList getItem_exchanges() throws DBException {
        Object[][] parameters = {{ "type", "item_exchange" }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return this.getEntities(EMcontract.SQLcontracts4type, sqlparameters);
    }
    
    public void deletecontracts() throws DBException {
        this.addStatement(EMcontract.SQLtruncate);
        this.Commit2DB();
    }
    
    public void deactivatecontracts() throws DBException {
        this.addStatement(EMcontract.SQLdeactivate);
        this.Commit2DB();
    }
    
    public void deletedeactivatedcontracts() throws DBException {
        this.addStatement(EMcontractitem.SQLdeletedeactivateditems);
        this.addStatement(EMcontract.SQLdeletedeactivatedcontacts);
        this.Commit2DB();
    }
    
    /**
     * try to insert Contract object in database
     * commit transaction
     * @param contract: Contract Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertContract(IContract contract) throws DBException, DataException {
        trans_insertContract(contract);
        super.Commit2DB();
    }
    
    /**
     * try to insert Contract object in database
     * an alternative to insertContract, which can be made an empty function
     * commit transaction
     * @param contract: Contract Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertContract(IContract contract) throws DBException, DataException {
        trans_insertContract(contract);
        super.Commit2DB();
    }
    
    /**
     * try to update Contract object in database
     * commit transaction
     * @param contract: Contract Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateContract(IContract contract) throws DBException, DataException {
        trans_updateContract(contract);
        super.Commit2DB();
    }
    
    /**
     * try to update Contract object in database
     * an alternative to updateContract, which can be made an empty function
     * commit transaction
     * @param contract: Contract Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateContract(IContract contract) throws DBException, DataException {
        trans_updateContract(contract);
        super.Commit2DB();
    }
    
    /**
     * try to delete Contract object in database
     * commit transaction
     * @param contract: Contract Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteContract(IContract contract) throws DBException {
        trans_deleteContract(contract);
        super.Commit2DB();
    }

    /**
     * try to delete Contract object in database
     * an alternative to deleteContract, which can be made an empty function
     * commit transaction
     * @param contract: Contract Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteContract(IContract contract) throws DBException {
        trans_deleteContract(contract);
        super.Commit2DB();
    }

    /**
     * try to insert Contract object in database
     * do not commit transaction
     * @param contract: Contract Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertContract(IContract contract) throws DBException, DataException {
        super.checkDATA(contract);
        super.insertContract((Contract)contract);
    }
    
    /**
     * try to update Contract object in database
     * do not commit transaction
     * @param contract: Contract Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateContract(IContract contract) throws DBException, DataException {
        super.checkDATA(contract);
        super.updateContract((Contract)contract);
    }
    
    /**
     * try to delete Contract object in database
     * do not commit transaction
     * @param contract: Contract Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteContract(IContract contract) throws DBException {
        super.deleteContract((Contract)contract);
    }
}

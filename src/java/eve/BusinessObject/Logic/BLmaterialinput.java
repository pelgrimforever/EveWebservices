/*
 * BLmaterialinput.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.0.2022 13:37
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLparameters;
import general.exception.DBException;
import eve.interfaces.logicentity.IMaterialinput;
import eve.logicentity.Materialinput;
import eve.BusinessObject.table.Bmaterialinput;
import eve.conversion.entity.EMmaterialinput;
import eve.entity.pk.EvetypePK;
import general.exception.DataException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLmaterialinput
 *
 * Class for manipulating data- and database objects
 * for Entity Materialinput and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLmaterialinput extends Bmaterialinput {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Materialinput as default Entity
     */
    public BLmaterialinput() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Materialinput as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLmaterialinput(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * update used amount in materialinput stock
     * use oldest lines first
     * @param username User name
     * @param evetypepk material type
     * @param amount used amount
     * @throws DBException
     * @throws DataException 
     */
    public void useMaterial(String username, EvetypePK evetypepk, long amount) throws DBException, DataException {
        //get all material in stock for username / evetype
        Object[][] parameters = {{ "username", username }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        sqlparameters.add(evetypepk.getSQLprimarykey());
        ArrayList<Materialinput> stock = this.getEntities(EMmaterialinput.SQLSelect4usage, sqlparameters);
        long amountremaining = amount;
        long stock_usadamount;
        for(Materialinput materialinput: stock) {
            stock_usadamount = Math.min(materialinput.getAmount()-materialinput.getUsedamount(), amountremaining);
            materialinput.setUsedamount(materialinput.getUsedamount() + stock_usadamount);
            amountremaining -= stock_usadamount;
            this.updateMaterialinput(materialinput);
            if(amountremaining==0) {
                break;
            }
        }
    }
    
    /**
     * try to insert Materialinput object in database
     * commit transaction
     * @param materialinput: Materialinput Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertMaterialinput(IMaterialinput materialinput) throws DBException, DataException {
        materialinput.getPrimaryKey().setAddtimestamp(new Timestamp(System.currentTimeMillis()));
        trans_insertMaterialinput(materialinput);
        super.Commit2DB();
    }
    
    /**
     * try to insert Materialinput object in database
     * an alternative to insertMaterialinput, which can be made an empty function
     * commit transaction
     * @param materialinput: Materialinput Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertMaterialinput(IMaterialinput materialinput) throws DBException, DataException {
        trans_insertMaterialinput(materialinput);
        super.Commit2DB();
    }
    
    /**
     * try to update Materialinput object in database
     * commit transaction
     * @param materialinput: Materialinput Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateMaterialinput(IMaterialinput materialinput) throws DBException, DataException {
        trans_updateMaterialinput(materialinput);
        super.Commit2DB();
    }
    
    /**
     * try to update Materialinput object in database
     * an alternative to updateMaterialinput, which can be made an empty function
     * commit transaction
     * @param materialinput: Materialinput Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateMaterialinput(IMaterialinput materialinput) throws DBException, DataException {
        trans_updateMaterialinput(materialinput);
        super.Commit2DB();
    }
    
    /**
     * try to delete Materialinput object in database
     * commit transaction
     * @param materialinput: Materialinput Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteMaterialinput(IMaterialinput materialinput) throws DBException {
        trans_deleteMaterialinput(materialinput);
        super.Commit2DB();
    }

    /**
     * try to delete Materialinput object in database
     * an alternative to deleteMaterialinput, which can be made an empty function
     * commit transaction
     * @param materialinput: Materialinput Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteMaterialinput(IMaterialinput materialinput) throws DBException {
        trans_deleteMaterialinput(materialinput);
        super.Commit2DB();
    }

    /**
     * try to insert Materialinput object in database
     * do not commit transaction
     * @param materialinput: Materialinput Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertMaterialinput(IMaterialinput materialinput) throws DBException, DataException {
        super.checkDATA(materialinput);
        super.insertMaterialinput((Materialinput)materialinput);
    }
    
    /**
     * try to update Materialinput object in database
     * do not commit transaction
     * @param materialinput: Materialinput Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateMaterialinput(IMaterialinput materialinput) throws DBException, DataException {
        super.checkDATA(materialinput);
        super.updateMaterialinput((Materialinput)materialinput);
    }
    
    /**
     * try to delete Materialinput object in database
     * do not commit transaction
     * @param materialinput: Materialinput Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteMaterialinput(IMaterialinput materialinput) throws DBException {
        super.deleteMaterialinput((Materialinput)materialinput);
    }
}

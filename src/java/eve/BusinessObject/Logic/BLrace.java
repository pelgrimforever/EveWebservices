/*
 * BLrace.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 7.4.2021 18:56
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.IRace;
import eve.logicentity.Race;
import BusinessObject.GeneralEntityObject;
import data.conversion.JSONConversion;
import eve.BusinessObject.table.Brace;
import eve.entity.pk.FactionPK;
import general.exception.DataException;
import eve.interfaces.BusinessObject.IBLrace;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.simple.JSONObject;

/**
 * Business Logic Entity class BLrace
 *
 * Class for manipulating data- and database objects
 * for Entity Race and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLrace extends Brace implements IBLrace {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Race as default Entity
     */
    public BLrace() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Race as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLrace(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity race) throws SQLException {
        
    }
    
    public void updateRace(JSONObject jsonracedetails) throws DBException, DataException {
        Race race = new Race(JSONConversion.getLong(jsonracedetails, "race_id"));
        race.setName(JSONConversion.getString(jsonracedetails, "name"));
        race.setDescription(JSONConversion.getString(jsonracedetails, "description"));
        race.setFactionPK(new FactionPK(JSONConversion.getLong(jsonracedetails, "alliance_id")));
        this.insertupdateRace(race);
    }

    /**
     * try to insert Race object in database
     * commit transaction
     * @param race: Race Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertRace(IRace race) throws DBException, DataException {
        trans_insertRace(race);
        super.Commit2DB();
    }
    
    /**
     * try to insert Race object in database
     * an alternative to insertRace, which can be made an empty function
     * commit transaction
     * @param race: Race Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertRace(IRace race) throws DBException, DataException {
        trans_insertRace(race);
        super.Commit2DB();
    }
    
    /**
     * try to update Race object in database
     * commit transaction
     * @param race: Race Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateRace(IRace race) throws DBException, DataException {
        trans_updateRace(race);
        super.Commit2DB();
    }
    
    /**
     * try to update Race object in database
     * an alternative to updateRace, which can be made an empty function
     * commit transaction
     * @param race: Race Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateRace(IRace race) throws DBException, DataException {
        trans_updateRace(race);
        super.Commit2DB();
    }
    
    /**
     * try to delete Race object in database
     * commit transaction
     * @param race: Race Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteRace(IRace race) throws DBException {
        trans_deleteRace(race);
        super.Commit2DB();
    }

    /**
     * try to delete Race object in database
     * an alternative to deleteRace, which can be made an empty function
     * commit transaction
     * @param race: Race Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteRace(IRace race) throws DBException {
        trans_deleteRace(race);
        super.Commit2DB();
    }

    /**
     * try to insert Race object in database
     * do not commit transaction
     * @param race: Race Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertRace(IRace race) throws DBException, DataException {
        super.checkDATA(race);
        super.insertRace((Race)race);
    }
    
    /**
     * try to update Race object in database
     * do not commit transaction
     * @param race: Race Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateRace(IRace race) throws DBException, DataException {
        super.checkDATA(race);
        super.updateRace((Race)race);
    }
    
    /**
     * try to delete Race object in database
     * do not commit transaction
     * @param race: Race Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteRace(IRace race) throws DBException {
        super.deleteRace((Race)race);
    }
}

/*
 * BLregion.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 3.4.2021 17:22
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.IRegion;
import eve.logicentity.Region;
import BusinessObject.GeneralEntityObject;
import data.conversion.JSONConversion;
import eve.BusinessObject.table.Bregion;
import general.exception.DataException;
import eve.interfaces.BusinessObject.IBLregion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Business Logic Entity class BLregion
 *
 * Class for manipulating data- and database objects
 * for Entity Region and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLregion extends Bregion implements IBLregion {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Region as default Entity
     */
    public BLregion() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Region as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLregion(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity region) throws SQLException {
        
    }
    
    /**
     * save all regions from Swagger into database
     * @param jsonregionnames; JSONArray with region data
     * @throws DBException
     * @throws DataException 
     */
    public void updateRegions(JSONArray jsonregionnames) throws DBException, DataException {
        Iterator<JSONObject> regionsI = jsonregionnames.iterator();
        JSONObject jsonregion;
        Region region;
        while(regionsI.hasNext()) {
            jsonregion = (JSONObject)regionsI.next();
            region = new Region(JSONConversion.getLong(jsonregion, "id"));
            region.setName(JSONConversion.getString(jsonregion, "name"));
            insertupdateRegion(region);
        }
        Commit2DB();
    }
    
    /**
     * try to insert Region object in database
     * commit transaction
     * @param region: Region Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertRegion(IRegion region) throws DBException, DataException {
        trans_insertRegion(region);
        super.Commit2DB();
    }
    
    /**
     * try to insert Region object in database
     * an alternative to insertRegion, which can be made an empty function
     * commit transaction
     * @param region: Region Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertRegion(IRegion region) throws DBException, DataException {
        trans_insertRegion(region);
        super.Commit2DB();
    }
    
    /**
     * try to update Region object in database
     * commit transaction
     * @param region: Region Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateRegion(IRegion region) throws DBException, DataException {
        trans_updateRegion(region);
        super.Commit2DB();
    }
    
    /**
     * try to update Region object in database
     * an alternative to updateRegion, which can be made an empty function
     * commit transaction
     * @param region: Region Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateRegion(IRegion region) throws DBException, DataException {
        trans_updateRegion(region);
        super.Commit2DB();
    }
    
    /**
     * try to delete Region object in database
     * commit transaction
     * @param region: Region Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteRegion(IRegion region) throws DBException {
        trans_deleteRegion(region);
        super.Commit2DB();
    }

    /**
     * try to delete Region object in database
     * an alternative to deleteRegion, which can be made an empty function
     * commit transaction
     * @param region: Region Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteRegion(IRegion region) throws DBException {
        trans_deleteRegion(region);
        super.Commit2DB();
    }

    /**
     * try to insert Region object in database
     * do not commit transaction
     * @param region: Region Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertRegion(IRegion region) throws DBException, DataException {
        super.checkDATA(region);
        super.insertRegion((Region)region);
    }
    
    /**
     * try to update Region object in database
     * do not commit transaction
     * @param region: Region Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateRegion(IRegion region) throws DBException, DataException {
        super.checkDATA(region);
        super.updateRegion((Region)region);
    }
    
    /**
     * try to delete Region object in database
     * do not commit transaction
     * @param region: Region Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteRegion(IRegion region) throws DBException {
        super.deleteRegion((Region)region);
    }
}

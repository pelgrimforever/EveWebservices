/*
 * BLconstellation.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.4.2021 14:28
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IConstellation;
import eve.logicentity.Constellation;
import BusinessObject.BLtable;
import data.conversion.JSONConversion;
import eve.BusinessObject.table.Bconstellation;
import eve.conversion.entity.EMconstellation;
import eve.entity.pk.RegionPK;
import general.exception.DataException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Business Logic Entity class BLconstellation
 *
 * Class for manipulating data- and database objects
 * for Entity Constellation and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLconstellation extends Bconstellation {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Constellation as default Entity
     */
    public BLconstellation() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Constellation as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLconstellation(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    public void updateConstellation(JSONObject jsonconstellationdetails) throws DBException, DataException {
        Constellation constellation = new Constellation(JSONConversion.getLong(jsonconstellationdetails, "constellation_id"));
        constellation.setName(JSONConversion.getString(jsonconstellationdetails, "name"));
        constellation.setRegionPK(new RegionPK(JSONConversion.getLong(jsonconstellationdetails, "region_id")));
        this.insertupdateConstellation(constellation);
    }
    
    /**
     * save all constellations from Swagger into database
     * @param jsonconstellationnames; JSONArray with region data
     * @throws DBException
     * @throws DataException 
     */
    public void updateConstellations(JSONArray jsonconstellationnames) throws DBException, DataException {
        Iterator<JSONObject> constellationsI = jsonconstellationnames.iterator();
        JSONObject jsonconstellation;
        Constellation constellation;
        while(constellationsI.hasNext()) {
            jsonconstellation = (JSONObject)constellationsI.next();
            constellation = new Constellation(JSONConversion.getLong(jsonconstellation, "id"));
            constellation.setName(JSONConversion.getString(jsonconstellation, "name"));
            insertupdateConstellation(constellation);
        }
        Commit2DB();
    }
    
    /**
     * post process downloaded constellation data
     * set noaccess to true for all constellations that have no accessible systems
     * set noaccess to false for all systems that have at least one accesible system
     * @throws DBException
     * @throws DataException 
     */
    public void postprocess() throws DBException, DataException {
        Object[][] parameter1 = {{ "noaccess", true }, { "systemnoaccess", false }};
        this.addStatement(sqlmapper.insertParameters(EMconstellation.updateNoaccess1, parameter1));
        Object[][] parameter2 = {{ "noaccess", false }, { "systemnoaccess", false }};
        this.addStatement(sqlmapper.insertParameters(EMconstellation.updateNoaccess2, parameter2));
        this.Commit2DB();
    }
    
    /**
     * try to insert Constellation object in database
     * commit transaction
     * @param constellation: Constellation Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertConstellation(IConstellation constellation) throws DBException, DataException {
        trans_insertConstellation(constellation);
        super.Commit2DB();
    }
    
    /**
     * try to insert Constellation object in database
     * an alternative to insertConstellation, which can be made an empty function
     * commit transaction
     * @param constellation: Constellation Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertConstellation(IConstellation constellation) throws DBException, DataException {
        trans_insertConstellation(constellation);
        super.Commit2DB();
    }
    
    /**
     * try to update Constellation object in database
     * commit transaction
     * @param constellation: Constellation Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateConstellation(IConstellation constellation) throws DBException, DataException {
        trans_updateConstellation(constellation);
        super.Commit2DB();
    }
    
    /**
     * try to update Constellation object in database
     * an alternative to updateConstellation, which can be made an empty function
     * commit transaction
     * @param constellation: Constellation Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateConstellation(IConstellation constellation) throws DBException, DataException {
        trans_updateConstellation(constellation);
        super.Commit2DB();
    }
    
    /**
     * try to delete Constellation object in database
     * commit transaction
     * @param constellation: Constellation Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteConstellation(IConstellation constellation) throws DBException {
        trans_deleteConstellation(constellation);
        super.Commit2DB();
    }

    /**
     * try to delete Constellation object in database
     * an alternative to deleteConstellation, which can be made an empty function
     * commit transaction
     * @param constellation: Constellation Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteConstellation(IConstellation constellation) throws DBException {
        trans_deleteConstellation(constellation);
        super.Commit2DB();
    }

    /**
     * try to insert Constellation object in database
     * do not commit transaction
     * @param constellation: Constellation Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertConstellation(IConstellation constellation) throws DBException, DataException {
        super.checkDATA(constellation);
        super.insertConstellation((Constellation)constellation);
    }
    
    /**
     * try to update Constellation object in database
     * do not commit transaction
     * @param constellation: Constellation Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateConstellation(IConstellation constellation) throws DBException, DataException {
        super.checkDATA(constellation);
        super.updateConstellation((Constellation)constellation);
    }
    
    /**
     * try to delete Constellation object in database
     * do not commit transaction
     * @param constellation: Constellation Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteConstellation(IConstellation constellation) throws DBException {
        super.deleteConstellation((Constellation)constellation);
    }
}

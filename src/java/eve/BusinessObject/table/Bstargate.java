/*
 * Bstargate.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.10.2021 7:21
 *
 */

package eve.BusinessObject.table;

import BusinessObject.BLtable;
import general.exception.*;
import java.util.ArrayList;
import db.SQLMapperFactory;
import db.SQLparameters;
import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.JSONStargate;
import eve.conversion.entity.EMstargate;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IStargatesearch;
import eve.logicentity.Stargate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bstargate
 *
 * Superclass for manipulating data- and database objects
 * for Entity Stargate and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bstargate extends BLtable {

    /**
     * Constructor, sets Stargate as default Entity
     */
    public Bstargate() {
        super(new Stargate(), new EMstargate());
    }

    /**
     * Constructor, sets Stargate as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bstargate(BLtable transactionobject) {
        super(transactionobject, new Stargate(), new EMstargate());
    }

    /**
     * create new empty Stargate object
     * @return empty IStargate
     */
    public IStargate newStargate() {
    	return new Stargate();
    }
    
    /**
     * create new empty Stargate object
     * create new primary key with given parameters
     * @param id primary key field
     * @return IStargate with primary key
     */
    public IStargate newStargate(long id) {
        return new Stargate(id);
    }

    /**
     * create new empty Stargate object with given primary key
     * @param stargatePK: primary key for Stargate
     * @return IStargate with primary key
     */
    public IStargate newStargate(IStargatePK stargatePK) {
        return new Stargate((StargatePK)stargatePK);
    }

    /**
     * create new empty primary key
     * @return empty StargatePK
     */
    public IStargatePK newStargatePK() {
        return new StargatePK();
    }

    /**
     * create new primary key with given parameters
     * @param id primary key field
     * @return new IStargatePK
     */
    public IStargatePK newStargatePK(long id) {
        return new StargatePK(id);
    }

    /**
     * get all Stargate objects from database
     * @return ArrayList of Stargate objects
     * @throws DBException
     */
    public ArrayList<Stargate> getStargates() throws DBException {
        return (ArrayList<Stargate>)super.getEntities(EMstargate.SQLSelectAll);
    }

    /**
     * search Stargate for primary key
     * @param stargatePK: Stargate primary key
     * @return Stargate object
     * @throws DBException
     */
    public Stargate getStargate(IStargatePK stargatePK) throws DBException {
        return (Stargate)super.getEntity((StargatePK)stargatePK);
    }

    /**
     * search stargate with IStargatesearch parameters
     * @param search IStargatesearch
     * @return ArrayList of Stargate
     * @throws DBException 
     */
    public ArrayList<Stargate> searchstargates(IStargatesearch search) throws DBException {
        return (ArrayList<Stargate>)this.search(search);
    }

    /**
     * search stargate with IStargatesearch parameters, order by orderby sql clause
     * @param search IStargatesearch
     * @param orderby sql order by string
     * @return ArrayList of Stargate
     * @throws DBException 
     */
    public ArrayList<Stargate> searchstargates(IStargatesearch search, String orderby) throws DBException {
        return (ArrayList<Stargate>)this.search(search, orderby);
    }

    /**
     * Search stargate in database for stargatePK:
     * @param stargatePK: Stargate Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getStargateExists(IStargatePK stargatePK) throws DBException {
        return super.getEntityExists((StargatePK)stargatePK);
    }

    /**
     * try to insert Stargate in database
     * @param stargate Stargate object
     * @throws DBException
     * @throws DataException
     */
    public void insertStargate(IStargate stargate) throws DBException, DataException {
        super.insertEntity(stargate);
    }

    /**
     * check if StargatePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param stargate Stargate object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateStargate(IStargate stargate) throws DBException, DataException {
        if(this.getStargateExists(stargate.getPrimaryKey())) {
            super.updateEntity(stargate);
        } else {
            super.insertEntity(stargate);
        }
    }

    /**
     * try to update Stargate in database
     * @param stargate Stargate object
     * @throws DBException
     * @throws DataException
     */
    public void updateStargate(IStargate stargate) throws DBException, DataException {
        super.updateEntity(stargate);
    }

    /**
     * try to delete Stargate in database
     * @param stargate Stargate object
     * @throws DBException
     */
    public void deleteStargate(IStargate stargate) throws DBException {
        cascadedeleteStargate(stargate.getPrimaryKey());
        super.deleteEntity(stargate);
    }

    /**
     * check data rules in Stargate, throw DataException with customized message if rules do not apply
     * @param stargate Stargate object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IStargate stargate) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(stargate.getName()!=null && stargate.getName().length()>IStargate.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IStargate.SIZE_NAME).append("\n");
        }
        if(stargate.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where stargatePK is used in a primary key
     * @param stargatePK: Stargate primary key
     */
    public void cascadedeleteStargate(IStargatePK stargatePK) {
    }

    /**
     * @param systemPK: foreign key for System
     * @delete all Stargate Entity objects for System in database
     */
    public void delete4systemSystem(ISystemPK systemPK) {
        super.addStatement(EMstargate.SQLDelete4systemSystem, systemPK.getSQLprimarykey());
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Stargate Entity objects for System
     * @throws CustomException
     */
    public ArrayList<Stargate> getStargates4systemSystem(ISystemPK systemPK) throws CustomException {
        return super.getEntities(EMstargate.SQLSelect4systemSystem, systemPK.getSQLprimarykey());
    }
    /**
     * @param systemPK: foreign key for System
     * @delete all Stargate Entity objects for System in database
     */
    public void delete4systemTo_system(ISystemPK systemPK) {
        super.addStatement(EMstargate.SQLDelete4systemTo_system, systemPK.getSQLprimarykey());
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Stargate Entity objects for System
     * @throws CustomException
     */
    public ArrayList<Stargate> getStargates4systemTo_system(ISystemPK systemPK) throws CustomException {
        return super.getEntities(EMstargate.SQLSelect4systemTo_system, systemPK.getSQLprimarykey());
    }

    /**
     * get all Stargate objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Stargate objects
     * @throws DBException
     */
    public ArrayList<Stargate> getStargates(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMstargate.SQLSelect);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        if(sortlist.length()>0) {
            sql.append(" order by ").append(sortlist).append(" ").append(sortoperator);
        }
        return (ArrayList<Stargate>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Stargate objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delStargate(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Stargate.table);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        this.addStatement(sql.toString(), sqlparameters);
    }


}

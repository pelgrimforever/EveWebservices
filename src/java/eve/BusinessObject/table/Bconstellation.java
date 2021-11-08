/*
 * Bconstellation.java
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
import eve.conversion.json.JSONConstellation;
import eve.conversion.entity.EMconstellation;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IConstellationsearch;
import eve.logicentity.Constellation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bconstellation
 *
 * Superclass for manipulating data- and database objects
 * for Entity Constellation and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bconstellation extends BLtable {

    /**
     * Constructor, sets Constellation as default Entity
     */
    public Bconstellation() {
        super(new Constellation(), new EMconstellation());
    }

    /**
     * Constructor, sets Constellation as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bconstellation(BLtable transactionobject) {
        super(transactionobject, new Constellation(), new EMconstellation());
    }

    /**
     * create new empty Constellation object
     * @return empty IConstellation
     */
    public IConstellation newConstellation() {
    	return new Constellation();
    }
    
    /**
     * create new empty Constellation object
     * create new primary key with given parameters
     * @param id primary key field
     * @return IConstellation with primary key
     */
    public IConstellation newConstellation(long id) {
        return new Constellation(id);
    }

    /**
     * create new empty Constellation object with given primary key
     * @param constellationPK: primary key for Constellation
     * @return IConstellation with primary key
     */
    public IConstellation newConstellation(IConstellationPK constellationPK) {
        return new Constellation((ConstellationPK)constellationPK);
    }

    /**
     * create new empty primary key
     * @return empty ConstellationPK
     */
    public IConstellationPK newConstellationPK() {
        return new ConstellationPK();
    }

    /**
     * create new primary key with given parameters
     * @param id primary key field
     * @return new IConstellationPK
     */
    public IConstellationPK newConstellationPK(long id) {
        return new ConstellationPK(id);
    }

    /**
     * get all Constellation objects from database
     * @return ArrayList of Constellation objects
     * @throws DBException
     */
    public ArrayList<Constellation> getConstellations() throws DBException {
        return (ArrayList<Constellation>)super.getEntities(EMconstellation.SQLSelectAll);
    }

    /**
     * search Constellation for primary key
     * @param constellationPK: Constellation primary key
     * @return Constellation object
     * @throws DBException
     */
    public Constellation getConstellation(IConstellationPK constellationPK) throws DBException {
        return (Constellation)super.getEntity((ConstellationPK)constellationPK);
    }

    /**
     * search constellation with IConstellationsearch parameters
     * @param search IConstellationsearch
     * @return ArrayList of Constellation
     * @throws DBException 
     */
    public ArrayList<Constellation> searchconstellations(IConstellationsearch search) throws DBException {
        return (ArrayList<Constellation>)this.search(search);
    }

    /**
     * search constellation with IConstellationsearch parameters, order by orderby sql clause
     * @param search IConstellationsearch
     * @param orderby sql order by string
     * @return ArrayList of Constellation
     * @throws DBException 
     */
    public ArrayList<Constellation> searchconstellations(IConstellationsearch search, String orderby) throws DBException {
        return (ArrayList<Constellation>)this.search(search, orderby);
    }

    /**
     * Search constellation in database for constellationPK:
     * @param constellationPK: Constellation Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getConstellationExists(IConstellationPK constellationPK) throws DBException {
        return super.getEntityExists((ConstellationPK)constellationPK);
    }

    /**
     * try to insert Constellation in database
     * @param constellation Constellation object
     * @throws DBException
     * @throws DataException
     */
    public void insertConstellation(IConstellation constellation) throws DBException, DataException {
        super.insertEntity(constellation);
    }

    /**
     * check if ConstellationPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param constellation Constellation object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateConstellation(IConstellation constellation) throws DBException, DataException {
        if(this.getConstellationExists(constellation.getPrimaryKey())) {
            super.updateEntity(constellation);
        } else {
            super.insertEntity(constellation);
        }
    }

    /**
     * try to update Constellation in database
     * @param constellation Constellation object
     * @throws DBException
     * @throws DataException
     */
    public void updateConstellation(IConstellation constellation) throws DBException, DataException {
        super.updateEntity(constellation);
    }

    /**
     * try to delete Constellation in database
     * @param constellation Constellation object
     * @throws DBException
     */
    public void deleteConstellation(IConstellation constellation) throws DBException {
        cascadedeleteConstellation(constellation.getPrimaryKey());
        super.deleteEntity(constellation);
    }

    /**
     * check data rules in Constellation, throw DataException with customized message if rules do not apply
     * @param constellation Constellation object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IConstellation constellation) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(constellation.getName()!=null && constellation.getName().length()>IConstellation.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IConstellation.SIZE_NAME).append("\n");
        }
        if(constellation.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where constellationPK is used in a primary key
     * @param constellationPK: Constellation primary key
     */
    public void cascadedeleteConstellation(IConstellationPK constellationPK) {
        BLconstellation_neighbour blconstellation_neighbourNeighbour = new BLconstellation_neighbour(this);
        blconstellation_neighbourNeighbour.delete4constellationNeighbour(constellationPK);
        BLconstellation_neighbour blconstellation_neighbourConstellation = new BLconstellation_neighbour(this);
        blconstellation_neighbourConstellation.delete4constellationConstellation(constellationPK);
    }

    /**
     * @param regionPK: foreign key for Region
     * @delete all Constellation Entity objects for Region in database
     */
    public void delete4region(IRegionPK regionPK) {
        super.addStatement(EMconstellation.SQLDelete4region, regionPK.getSQLprimarykey());
    }

    /**
     * @param regionPK: foreign key for Region
     * @return all Constellation Entity objects for Region
     * @throws CustomException
     */
    public ArrayList<Constellation> getConstellations4region(IRegionPK regionPK) throws CustomException {
        return super.getEntities(EMconstellation.SQLSelect4region, regionPK.getSQLprimarykey());
    }
    /**
     * @param constellation_neighbourPK: parent Constellation_neighbour for child object Constellation Entity
     * @return child Constellation Entity object
     * @throws CustomException
     */
    public Constellation getConstellation_neighbourneighbour(IConstellation_neighbourPK constellation_neighbourPK) throws CustomException {
        ConstellationPK constellationPK = new ConstellationPK(constellation_neighbourPK.getNeighbour());
        return this.getConstellation(constellationPK);
    }

    /**
     * @param constellation_neighbourPK: parent Constellation_neighbour for child object Constellation Entity
     * @return child Constellation Entity object
     * @throws CustomException
     */
    public Constellation getConstellation_neighbourconstellation(IConstellation_neighbourPK constellation_neighbourPK) throws CustomException {
        ConstellationPK constellationPK = new ConstellationPK(constellation_neighbourPK.getConstellation());
        return this.getConstellation(constellationPK);
    }


    /**
     * get all Constellation objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Constellation objects
     * @throws DBException
     */
    public ArrayList<Constellation> getConstellations(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMconstellation.SQLSelect);
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
        return (ArrayList<Constellation>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Constellation objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delConstellation(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Constellation.table);
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

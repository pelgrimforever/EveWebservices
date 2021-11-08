/*
 * Bconstellation_neighbour.java
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
import eve.conversion.json.JSONConstellation_neighbour;
import eve.conversion.entity.EMconstellation_neighbour;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IConstellation_neighboursearch;
import eve.logicentity.Constellation_neighbour;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bconstellation_neighbour
 *
 * Superclass for manipulating data- and database objects
 * for Entity Constellation_neighbour and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bconstellation_neighbour extends BLtable {

    /**
     * Constructor, sets Constellation_neighbour as default Entity
     */
    public Bconstellation_neighbour() {
        super(new Constellation_neighbour(), new EMconstellation_neighbour());
    }

    /**
     * Constructor, sets Constellation_neighbour as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bconstellation_neighbour(BLtable transactionobject) {
        super(transactionobject, new Constellation_neighbour(), new EMconstellation_neighbour());
    }

    /**
     * create new empty Constellation_neighbour object
     * @return empty IConstellation_neighbour
     */
    public IConstellation_neighbour newConstellation_neighbour() {
    	return new Constellation_neighbour();
    }
    
    /**
     * create new empty Constellation_neighbour object
     * create new primary key with given parameters
     * @param constellation primary key field
     * @param neighbour primary key field
     * @return IConstellation_neighbour with primary key
     */
    public IConstellation_neighbour newConstellation_neighbour(long constellation, long neighbour) {
        return new Constellation_neighbour(constellation, neighbour);
    }

    /**
     * create new empty Constellation_neighbour object with given primary key
     * @param constellation_neighbourPK: primary key for Constellation_neighbour
     * @return IConstellation_neighbour with primary key
     */
    public IConstellation_neighbour newConstellation_neighbour(IConstellation_neighbourPK constellation_neighbourPK) {
        return new Constellation_neighbour((Constellation_neighbourPK)constellation_neighbourPK);
    }

    /**
     * create new empty primary key
     * @return empty Constellation_neighbourPK
     */
    public IConstellation_neighbourPK newConstellation_neighbourPK() {
        return new Constellation_neighbourPK();
    }

    /**
     * create new primary key with given parameters
     * @param constellation primary key field
     * @param neighbour primary key field
     * @return new IConstellation_neighbourPK
     */
    public IConstellation_neighbourPK newConstellation_neighbourPK(long constellation, long neighbour) {
        return new Constellation_neighbourPK(constellation, neighbour);
    }

    /**
     * get all Constellation_neighbour objects from database
     * @return ArrayList of Constellation_neighbour objects
     * @throws DBException
     */
    public ArrayList<Constellation_neighbour> getConstellation_neighbours() throws DBException {
        return (ArrayList<Constellation_neighbour>)super.getEntities(EMconstellation_neighbour.SQLSelectAll);
    }

    /**
     * search Constellation_neighbour for primary key
     * @param constellation_neighbourPK: Constellation_neighbour primary key
     * @return Constellation_neighbour object
     * @throws DBException
     */
    public Constellation_neighbour getConstellation_neighbour(IConstellation_neighbourPK constellation_neighbourPK) throws DBException {
        return (Constellation_neighbour)super.getEntity((Constellation_neighbourPK)constellation_neighbourPK);
    }

    /**
     * search constellation_neighbour with IConstellation_neighboursearch parameters
     * @param search IConstellation_neighboursearch
     * @return ArrayList of Constellation_neighbour
     * @throws DBException 
     */
    public ArrayList<Constellation_neighbour> searchconstellation_neighbours(IConstellation_neighboursearch search) throws DBException {
        return (ArrayList<Constellation_neighbour>)this.search(search);
    }

    /**
     * search constellation_neighbour with IConstellation_neighboursearch parameters, order by orderby sql clause
     * @param search IConstellation_neighboursearch
     * @param orderby sql order by string
     * @return ArrayList of Constellation_neighbour
     * @throws DBException 
     */
    public ArrayList<Constellation_neighbour> searchconstellation_neighbours(IConstellation_neighboursearch search, String orderby) throws DBException {
        return (ArrayList<Constellation_neighbour>)this.search(search, orderby);
    }

    /**
     * Search constellation_neighbour in database for constellation_neighbourPK:
     * @param constellation_neighbourPK: Constellation_neighbour Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getConstellation_neighbourExists(IConstellation_neighbourPK constellation_neighbourPK) throws DBException {
        return super.getEntityExists((Constellation_neighbourPK)constellation_neighbourPK);
    }

    /**
     * try to insert Constellation_neighbour in database
     * @param constellation_neighbour Constellation_neighbour object
     * @throws DBException
     * @throws DataException
     */
    public void insertConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        super.insertEntity(constellation_neighbour);
    }

    /**
     * check if Constellation_neighbourPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param constellation_neighbour Constellation_neighbour object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        if(this.getConstellation_neighbourExists(constellation_neighbour.getPrimaryKey())) {
            super.updateEntity(constellation_neighbour);
        } else {
            super.insertEntity(constellation_neighbour);
        }
    }

    /**
     * try to update Constellation_neighbour in database
     * @param constellation_neighbour Constellation_neighbour object
     * @throws DBException
     * @throws DataException
     */
    public void updateConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        super.updateEntity(constellation_neighbour);
    }

    /**
     * try to delete Constellation_neighbour in database
     * @param constellation_neighbour Constellation_neighbour object
     * @throws DBException
     */
    public void deleteConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException {
        cascadedeleteConstellation_neighbour(constellation_neighbour.getPrimaryKey());
        super.deleteEntity(constellation_neighbour);
    }

    /**
     * check data rules in Constellation_neighbour, throw DataException with customized message if rules do not apply
     * @param constellation_neighbour Constellation_neighbour object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IConstellation_neighbour constellation_neighbour) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Constellation_neighbour.Constellation - Constellation.Id
        //foreign key Constellation_neighbour.Neighbour - Constellation.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where constellation_neighbourPK is used in a primary key
     * @param constellation_neighbourPK: Constellation_neighbour primary key
     */
    public void cascadedeleteConstellation_neighbour(IConstellation_neighbourPK constellation_neighbourPK) {
    }

    /**
     * @param constellationPK: foreign key for Constellation
     * @delete all Constellation_neighbour Entity objects for Constellation in database
     */
    public void delete4constellationNeighbour(IConstellationPK constellationPK) {
        super.addStatement(EMconstellation_neighbour.SQLDelete4constellationNeighbour, constellationPK.getSQLprimarykey());
    }

    /**
     * @param constellationPK: foreign key for Constellation
     * @return all Constellation_neighbour Entity objects for Constellation
     * @throws CustomException
     */
    public ArrayList<Constellation_neighbour> getConstellation_neighbours4constellationNeighbour(IConstellationPK constellationPK) throws CustomException {
        return super.getEntities(EMconstellation_neighbour.SQLSelect4constellationNeighbour, constellationPK.getSQLprimarykey());
    }
    /**
     * @param constellationPK: foreign key for Constellation
     * @delete all Constellation_neighbour Entity objects for Constellation in database
     */
    public void delete4constellationConstellation(IConstellationPK constellationPK) {
        super.addStatement(EMconstellation_neighbour.SQLDelete4constellationConstellation, constellationPK.getSQLprimarykey());
    }

    /**
     * @param constellationPK: foreign key for Constellation
     * @return all Constellation_neighbour Entity objects for Constellation
     * @throws CustomException
     */
    public ArrayList<Constellation_neighbour> getConstellation_neighbours4constellationConstellation(IConstellationPK constellationPK) throws CustomException {
        return super.getEntities(EMconstellation_neighbour.SQLSelect4constellationConstellation, constellationPK.getSQLprimarykey());
    }

    /**
     * get all Constellation_neighbour objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Constellation_neighbour objects
     * @throws DBException
     */
    public ArrayList<Constellation_neighbour> getConstellation_neighbours(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMconstellation_neighbour.SQLSelect);
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
        return (ArrayList<Constellation_neighbour>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Constellation_neighbour objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delConstellation_neighbour(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Constellation_neighbour.table);
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

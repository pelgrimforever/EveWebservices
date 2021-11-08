/*
 * Broutetype.java
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
import eve.conversion.json.JSONRoutetype;
import eve.conversion.entity.EMroutetype;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IRoutetypesearch;
import eve.logicentity.Routetype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Broutetype
 *
 * Superclass for manipulating data- and database objects
 * for Entity Routetype and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Broutetype extends BLtable {

    /**
     * Constructor, sets Routetype as default Entity
     */
    public Broutetype() {
        super(new Routetype(), new EMroutetype());
    }

    /**
     * Constructor, sets Routetype as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Broutetype(BLtable transactionobject) {
        super(transactionobject, new Routetype(), new EMroutetype());
    }

    /**
     * create new empty Routetype object
     * @return empty IRoutetype
     */
    public IRoutetype newRoutetype() {
    	return new Routetype();
    }
    
    /**
     * create new empty Routetype object
     * create new primary key with given parameters
     * @param id primary key field
     * @return IRoutetype with primary key
     */
    public IRoutetype newRoutetype(long id) {
        return new Routetype(id);
    }

    /**
     * create new empty Routetype object with given primary key
     * @param routetypePK: primary key for Routetype
     * @return IRoutetype with primary key
     */
    public IRoutetype newRoutetype(IRoutetypePK routetypePK) {
        return new Routetype((RoutetypePK)routetypePK);
    }

    /**
     * create new empty primary key
     * @return empty RoutetypePK
     */
    public IRoutetypePK newRoutetypePK() {
        return new RoutetypePK();
    }

    /**
     * create new primary key with given parameters
     * @param id primary key field
     * @return new IRoutetypePK
     */
    public IRoutetypePK newRoutetypePK(long id) {
        return new RoutetypePK(id);
    }

    /**
     * get all Routetype objects from database
     * @return ArrayList of Routetype objects
     * @throws DBException
     */
    public ArrayList<Routetype> getRoutetypes() throws DBException {
        return (ArrayList<Routetype>)super.getEntities(EMroutetype.SQLSelectAll);
    }

    /**
     * search Routetype for primary key
     * @param routetypePK: Routetype primary key
     * @return Routetype object
     * @throws DBException
     */
    public Routetype getRoutetype(IRoutetypePK routetypePK) throws DBException {
        return (Routetype)super.getEntity((RoutetypePK)routetypePK);
    }

    /**
     * search routetype with IRoutetypesearch parameters
     * @param search IRoutetypesearch
     * @return ArrayList of Routetype
     * @throws DBException 
     */
    public ArrayList<Routetype> searchroutetypes(IRoutetypesearch search) throws DBException {
        return (ArrayList<Routetype>)this.search(search);
    }

    /**
     * search routetype with IRoutetypesearch parameters, order by orderby sql clause
     * @param search IRoutetypesearch
     * @param orderby sql order by string
     * @return ArrayList of Routetype
     * @throws DBException 
     */
    public ArrayList<Routetype> searchroutetypes(IRoutetypesearch search, String orderby) throws DBException {
        return (ArrayList<Routetype>)this.search(search, orderby);
    }

    /**
     * Search routetype in database for routetypePK:
     * @param routetypePK: Routetype Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getRoutetypeExists(IRoutetypePK routetypePK) throws DBException {
        return super.getEntityExists((RoutetypePK)routetypePK);
    }

    /**
     * try to insert Routetype in database
     * @param routetype Routetype object
     * @throws DBException
     * @throws DataException
     */
    public void insertRoutetype(IRoutetype routetype) throws DBException, DataException {
        super.insertEntity(routetype);
    }

    /**
     * check if RoutetypePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param routetype Routetype object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateRoutetype(IRoutetype routetype) throws DBException, DataException {
        if(this.getRoutetypeExists(routetype.getPrimaryKey())) {
            super.updateEntity(routetype);
        } else {
            super.insertEntity(routetype);
        }
    }

    /**
     * try to update Routetype in database
     * @param routetype Routetype object
     * @throws DBException
     * @throws DataException
     */
    public void updateRoutetype(IRoutetype routetype) throws DBException, DataException {
        super.updateEntity(routetype);
    }

    /**
     * try to delete Routetype in database
     * @param routetype Routetype object
     * @throws DBException
     */
    public void deleteRoutetype(IRoutetype routetype) throws DBException {
        cascadedeleteRoutetype(routetype.getPrimaryKey());
        super.deleteEntity(routetype);
    }

    /**
     * check data rules in Routetype, throw DataException with customized message if rules do not apply
     * @param routetype Routetype object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IRoutetype routetype) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(routetype.getName()!=null && routetype.getName().length()>IRoutetype.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IRoutetype.SIZE_NAME).append("\n");
        }
        if(routetype.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where routetypePK is used in a primary key
     * @param routetypePK: Routetype primary key
     */
    public void cascadedeleteRoutetype(IRoutetypePK routetypePK) {
        BLroute blroute = new BLroute(this);
        blroute.delete4routetype(routetypePK);
    }

    /**
     * @param security_islandPK: foreign key for Security_island
     * @delete all Routetype Entity objects for Security_island in database
     */
    public void delete4security_island(ISecurity_islandPK security_islandPK) {
        super.addStatement(EMroutetype.SQLDelete4security_island, security_islandPK.getSQLprimarykey());
    }

    /**
     * @param security_islandPK: foreign key for Security_island
     * @return all Routetype Entity objects for Security_island
     * @throws CustomException
     */
    public ArrayList<Routetype> getRoutetypes4security_island(ISecurity_islandPK security_islandPK) throws CustomException {
        return super.getEntities(EMroutetype.SQLSelect4security_island, security_islandPK.getSQLprimarykey());
    }
    /**
     * @param routePK: parent Route for child object Routetype Entity
     * @return child Routetype Entity object
     * @throws CustomException
     */
    public Routetype getRoute(IRoutePK routePK) throws CustomException {
        RoutetypePK routetypePK = new RoutetypePK(routePK.getRoutetype());
        return this.getRoutetype(routetypePK);
    }


    /**
     * get all Routetype objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Routetype objects
     * @throws DBException
     */
    public ArrayList<Routetype> getRoutetypes(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMroutetype.SQLSelect);
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
        return (ArrayList<Routetype>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Routetype objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delRoutetype(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Routetype.table);
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

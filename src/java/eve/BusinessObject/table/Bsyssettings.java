/*
 * Bsyssettings.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 11.4.2022 9:13
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
import eve.conversion.json.JSONSyssettings;
import eve.conversion.entity.EMsyssettings;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ISyssettingssearch;
import eve.logicentity.Syssettings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bsyssettings
 *
 * Superclass for manipulating data- and database objects
 * for Entity Syssettings and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bsyssettings extends BLtable {

    /**
     * Constructor, sets Syssettings as default Entity
     */
    public Bsyssettings() {
        super(new Syssettings(), new EMsyssettings());
    }

    /**
     * Constructor, sets Syssettings as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsyssettings(BLtable transactionobject) {
        super(transactionobject, new Syssettings(), new EMsyssettings());
    }

    /**
     * create new empty Syssettings object
     * @return empty ISyssettings
     */
    public ISyssettings newSyssettings() {
    	return new Syssettings();
    }
    
    /**
     * create new empty Syssettings object
     * create new primary key with given parameters
     * @param name primary key field
     * @return ISyssettings with primary key
     */
    public ISyssettings newSyssettings(java.lang.String name) {
        return new Syssettings(name);
    }

    /**
     * create new empty Syssettings object with given primary key
     * @param syssettingsPK: primary key for Syssettings
     * @return ISyssettings with primary key
     */
    public ISyssettings newSyssettings(ISyssettingsPK syssettingsPK) {
        return new Syssettings((SyssettingsPK)syssettingsPK);
    }

    /**
     * create new empty primary key
     * @return empty SyssettingsPK
     */
    public ISyssettingsPK newSyssettingsPK() {
        return new SyssettingsPK();
    }

    /**
     * create new primary key with given parameters
     * @param name primary key field
     * @return new ISyssettingsPK
     */
    public ISyssettingsPK newSyssettingsPK(java.lang.String name) {
        return new SyssettingsPK(name);
    }

    /**
     * get all Syssettings objects from database
     * @return ArrayList of Syssettings objects
     * @throws DBException
     */
    public ArrayList<Syssettings> getSyssettingss() throws DBException {
        return (ArrayList<Syssettings>)super.getEntities(EMsyssettings.SQLSelectAll);
    }

    /**
     * search Syssettings for primary key
     * @param syssettingsPK: Syssettings primary key
     * @return Syssettings object
     * @throws DBException
     */
    public Syssettings getSyssettings(ISyssettingsPK syssettingsPK) throws DBException {
        return (Syssettings)super.getEntity((SyssettingsPK)syssettingsPK);
    }

    /**
     * search syssettings with ISyssettingssearch parameters
     * @param search ISyssettingssearch
     * @return ArrayList of Syssettings
     * @throws DBException 
     */
    public ArrayList<Syssettings> searchsyssettingss(ISyssettingssearch search) throws DBException {
        return (ArrayList<Syssettings>)this.search(search);
    }

    /**
     * search syssettings with ISyssettingssearch parameters, order by orderby sql clause
     * @param search ISyssettingssearch
     * @param orderby sql order by string
     * @return ArrayList of Syssettings
     * @throws DBException 
     */
    public ArrayList<Syssettings> searchsyssettingss(ISyssettingssearch search, String orderby) throws DBException {
        return (ArrayList<Syssettings>)this.search(search, orderby);
    }

    /**
     * Search syssettings in database for syssettingsPK:
     * @param syssettingsPK: Syssettings Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSyssettingsExists(ISyssettingsPK syssettingsPK) throws DBException {
        return super.getEntityExists((SyssettingsPK)syssettingsPK);
    }

    /**
     * try to insert Syssettings in database
     * @param syssettings Syssettings object
     * @throws DBException
     * @throws DataException
     */
    public void insertSyssettings(ISyssettings syssettings) throws DBException, DataException {
        super.insertEntity(syssettings);
    }

    /**
     * check if SyssettingsPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param syssettings Syssettings object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateSyssettings(ISyssettings syssettings) throws DBException, DataException {
        if(this.getSyssettingsExists(syssettings.getPrimaryKey())) {
            super.updateEntity(syssettings);
        } else {
            super.insertEntity(syssettings);
        }
    }

    /**
     * try to update Syssettings in database
     * @param syssettings Syssettings object
     * @throws DBException
     * @throws DataException
     */
    public void updateSyssettings(ISyssettings syssettings) throws DBException, DataException {
        super.updateEntity(syssettings);
    }

    /**
     * try to delete Syssettings in database
     * @param syssettings Syssettings object
     * @throws DBException
     */
    public void deleteSyssettings(ISyssettings syssettings) throws DBException {
        cascadedeleteSyssettings(syssettings.getPrimaryKey());
        super.deleteEntity(syssettings);
    }

    /**
     * check data rules in Syssettings, throw DataException with customized message if rules do not apply
     * @param syssettings Syssettings object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISyssettings syssettings) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(syssettings.getValue()!=null && syssettings.getValue().length()>ISyssettings.SIZE_VALUE) {
            message.append("Value is langer dan toegestaan. Max aantal karakters: ").append(ISyssettings.SIZE_VALUE).append("\n");
        }
        if(syssettings.getValue()==null) {
            message.append("Value mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where syssettingsPK is used in a primary key
     * @param syssettingsPK: Syssettings primary key
     */
    public void cascadedeleteSyssettings(ISyssettingsPK syssettingsPK) {
    }


    /**
     * get all Syssettings objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Syssettings objects
     * @throws DBException
     */
    public ArrayList<Syssettings> getSyssettingss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsyssettings.SQLSelect);
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
        return (ArrayList<Syssettings>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Syssettings objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delSyssettings(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Syssettings.table);
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

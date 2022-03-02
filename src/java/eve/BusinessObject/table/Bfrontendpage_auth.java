/*
 * Bfrontendpage_auth.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 19.1.2022 9:42
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
import eve.conversion.json.JSONFrontendpage_auth;
import eve.conversion.entity.EMfrontendpage_auth;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IFrontendpage_authsearch;
import eve.logicentity.Frontendpage_auth;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bfrontendpage_auth
 *
 * Superclass for manipulating data- and database objects
 * for Entity Frontendpage_auth and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bfrontendpage_auth extends BLtable {

    /**
     * Constructor, sets Frontendpage_auth as default Entity
     */
    public Bfrontendpage_auth() {
        super(new Frontendpage_auth(), new EMfrontendpage_auth());
    }

    /**
     * Constructor, sets Frontendpage_auth as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bfrontendpage_auth(BLtable transactionobject) {
        super(transactionobject, new Frontendpage_auth(), new EMfrontendpage_auth());
    }

    /**
     * create new empty Frontendpage_auth object
     * @return empty IFrontendpage_auth
     */
    public IFrontendpage_auth newFrontendpage_auth() {
    	return new Frontendpage_auth();
    }
    
    /**
     * create new empty Frontendpage_auth object
     * create new primary key with given parameters
     * @param username primary key field
     * @param frontendpage primary key field
     * @return IFrontendpage_auth with primary key
     */
    public IFrontendpage_auth newFrontendpage_auth(java.lang.String username, java.lang.String frontendpage) {
        return new Frontendpage_auth(username, frontendpage);
    }

    /**
     * create new empty Frontendpage_auth object with given primary key
     * @param frontendpage_authPK: primary key for Frontendpage_auth
     * @return IFrontendpage_auth with primary key
     */
    public IFrontendpage_auth newFrontendpage_auth(IFrontendpage_authPK frontendpage_authPK) {
        return new Frontendpage_auth((Frontendpage_authPK)frontendpage_authPK);
    }

    /**
     * create new empty primary key
     * @return empty Frontendpage_authPK
     */
    public IFrontendpage_authPK newFrontendpage_authPK() {
        return new Frontendpage_authPK();
    }

    /**
     * create new primary key with given parameters
     * @param username primary key field
     * @param frontendpage primary key field
     * @return new IFrontendpage_authPK
     */
    public IFrontendpage_authPK newFrontendpage_authPK(java.lang.String username, java.lang.String frontendpage) {
        return new Frontendpage_authPK(username, frontendpage);
    }

    /**
     * get all Frontendpage_auth objects from database
     * @return ArrayList of Frontendpage_auth objects
     * @throws DBException
     */
    public ArrayList<Frontendpage_auth> getFrontendpage_auths() throws DBException {
        return (ArrayList<Frontendpage_auth>)super.getEntities(EMfrontendpage_auth.SQLSelectAll);
    }

    /**
     * search Frontendpage_auth for primary key
     * @param frontendpage_authPK: Frontendpage_auth primary key
     * @return Frontendpage_auth object
     * @throws DBException
     */
    public Frontendpage_auth getFrontendpage_auth(IFrontendpage_authPK frontendpage_authPK) throws DBException {
        return (Frontendpage_auth)super.getEntity((Frontendpage_authPK)frontendpage_authPK);
    }

    /**
     * search frontendpage_auth with IFrontendpage_authsearch parameters
     * @param search IFrontendpage_authsearch
     * @return ArrayList of Frontendpage_auth
     * @throws DBException 
     */
    public ArrayList<Frontendpage_auth> searchfrontendpage_auths(IFrontendpage_authsearch search) throws DBException {
        return (ArrayList<Frontendpage_auth>)this.search(search);
    }

    /**
     * search frontendpage_auth with IFrontendpage_authsearch parameters, order by orderby sql clause
     * @param search IFrontendpage_authsearch
     * @param orderby sql order by string
     * @return ArrayList of Frontendpage_auth
     * @throws DBException 
     */
    public ArrayList<Frontendpage_auth> searchfrontendpage_auths(IFrontendpage_authsearch search, String orderby) throws DBException {
        return (ArrayList<Frontendpage_auth>)this.search(search, orderby);
    }

    /**
     * Search frontendpage_auth in database for frontendpage_authPK:
     * @param frontendpage_authPK: Frontendpage_auth Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getFrontendpage_authExists(IFrontendpage_authPK frontendpage_authPK) throws DBException {
        return super.getEntityExists((Frontendpage_authPK)frontendpage_authPK);
    }

    /**
     * try to insert Frontendpage_auth in database
     * @param frontendpage_auth Frontendpage_auth object
     * @throws DBException
     * @throws DataException
     */
    public void insertFrontendpage_auth(IFrontendpage_auth frontendpage_auth) throws DBException, DataException {
        super.insertEntity(frontendpage_auth);
    }

    /**
     * check if Frontendpage_authPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param frontendpage_auth Frontendpage_auth object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateFrontendpage_auth(IFrontendpage_auth frontendpage_auth) throws DBException, DataException {
        if(this.getFrontendpage_authExists(frontendpage_auth.getPrimaryKey())) {
            super.updateEntity(frontendpage_auth);
        } else {
            super.insertEntity(frontendpage_auth);
        }
    }

    /**
     * try to update Frontendpage_auth in database
     * @param frontendpage_auth Frontendpage_auth object
     * @throws DBException
     * @throws DataException
     */
    public void updateFrontendpage_auth(IFrontendpage_auth frontendpage_auth) throws DBException, DataException {
        super.updateEntity(frontendpage_auth);
    }

    /**
     * try to delete Frontendpage_auth in database
     * @param frontendpage_auth Frontendpage_auth object
     * @throws DBException
     */
    public void deleteFrontendpage_auth(IFrontendpage_auth frontendpage_auth) throws DBException {
        cascadedeleteFrontendpage_auth(frontendpage_auth.getPrimaryKey());
        super.deleteEntity(frontendpage_auth);
    }

    /**
     * check data rules in Frontendpage_auth, throw DataException with customized message if rules do not apply
     * @param frontendpage_auth Frontendpage_auth object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IFrontendpage_auth frontendpage_auth) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Frontendpage_auth.Username - Eveuser.Username
        //foreign key Frontendpage_auth.Frontendpage - Frontendpage.Name
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where frontendpage_authPK is used in a primary key
     * @param frontendpage_authPK: Frontendpage_auth primary key
     */
    public void cascadedeleteFrontendpage_auth(IFrontendpage_authPK frontendpage_authPK) {
    }

    /**
     * @param frontendpagePK: foreign key for Frontendpage
     * @delete all Frontendpage_auth Entity objects for Frontendpage in database
     */
    public void delete4frontendpage(IFrontendpagePK frontendpagePK) {
        super.addStatement(EMfrontendpage_auth.SQLDelete4frontendpage, frontendpagePK.getSQLprimarykey());
    }

    /**
     * @param frontendpagePK: foreign key for Frontendpage
     * @return all Frontendpage_auth Entity objects for Frontendpage
     * @throws CustomException
     */
    public ArrayList<Frontendpage_auth> getFrontendpage_auths4frontendpage(IFrontendpagePK frontendpagePK) throws CustomException {
        return super.getEntities(EMfrontendpage_auth.SQLSelect4frontendpage, frontendpagePK.getSQLprimarykey());
    }
    /**
     * @param eveuserPK: foreign key for Eveuser
     * @delete all Frontendpage_auth Entity objects for Eveuser in database
     */
    public void delete4eveuser(IEveuserPK eveuserPK) {
        super.addStatement(EMfrontendpage_auth.SQLDelete4eveuser, eveuserPK.getSQLprimarykey());
    }

    /**
     * @param eveuserPK: foreign key for Eveuser
     * @return all Frontendpage_auth Entity objects for Eveuser
     * @throws CustomException
     */
    public ArrayList<Frontendpage_auth> getFrontendpage_auths4eveuser(IEveuserPK eveuserPK) throws CustomException {
        return super.getEntities(EMfrontendpage_auth.SQLSelect4eveuser, eveuserPK.getSQLprimarykey());
    }

    /**
     * get all Frontendpage_auth objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Frontendpage_auth objects
     * @throws DBException
     */
    public ArrayList<Frontendpage_auth> getFrontendpage_auths(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMfrontendpage_auth.SQLSelect);
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
        return (ArrayList<Frontendpage_auth>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Frontendpage_auth objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delFrontendpage_auth(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Frontendpage_auth.table);
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

/*
 * Bfrontendpage.java
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
import eve.conversion.json.JSONFrontendpage;
import eve.conversion.entity.EMfrontendpage;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IFrontendpagesearch;
import eve.logicentity.Frontendpage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bfrontendpage
 *
 * Superclass for manipulating data- and database objects
 * for Entity Frontendpage and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bfrontendpage extends BLtable {

    /**
     * Constructor, sets Frontendpage as default Entity
     */
    public Bfrontendpage() {
        super(new Frontendpage(), new EMfrontendpage());
    }

    /**
     * Constructor, sets Frontendpage as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bfrontendpage(BLtable transactionobject) {
        super(transactionobject, new Frontendpage(), new EMfrontendpage());
    }

    /**
     * create new empty Frontendpage object
     * @return empty IFrontendpage
     */
    public IFrontendpage newFrontendpage() {
    	return new Frontendpage();
    }
    
    /**
     * create new empty Frontendpage object
     * create new primary key with given parameters
     * @param name primary key field
     * @return IFrontendpage with primary key
     */
    public IFrontendpage newFrontendpage(java.lang.String name) {
        return new Frontendpage(name);
    }

    /**
     * create new empty Frontendpage object with given primary key
     * @param frontendpagePK: primary key for Frontendpage
     * @return IFrontendpage with primary key
     */
    public IFrontendpage newFrontendpage(IFrontendpagePK frontendpagePK) {
        return new Frontendpage((FrontendpagePK)frontendpagePK);
    }

    /**
     * create new empty primary key
     * @return empty FrontendpagePK
     */
    public IFrontendpagePK newFrontendpagePK() {
        return new FrontendpagePK();
    }

    /**
     * create new primary key with given parameters
     * @param name primary key field
     * @return new IFrontendpagePK
     */
    public IFrontendpagePK newFrontendpagePK(java.lang.String name) {
        return new FrontendpagePK(name);
    }

    /**
     * get all Frontendpage objects from database
     * @return ArrayList of Frontendpage objects
     * @throws DBException
     */
    public ArrayList<Frontendpage> getFrontendpages() throws DBException {
        return (ArrayList<Frontendpage>)super.getEntities(EMfrontendpage.SQLSelectAll);
    }

    /**
     * search Frontendpage for primary key
     * @param frontendpagePK: Frontendpage primary key
     * @return Frontendpage object
     * @throws DBException
     */
    public Frontendpage getFrontendpage(IFrontendpagePK frontendpagePK) throws DBException {
        return (Frontendpage)super.getEntity((FrontendpagePK)frontendpagePK);
    }

    /**
     * search frontendpage with IFrontendpagesearch parameters
     * @param search IFrontendpagesearch
     * @return ArrayList of Frontendpage
     * @throws DBException 
     */
    public ArrayList<Frontendpage> searchfrontendpages(IFrontendpagesearch search) throws DBException {
        return (ArrayList<Frontendpage>)this.search(search);
    }

    /**
     * search frontendpage with IFrontendpagesearch parameters, order by orderby sql clause
     * @param search IFrontendpagesearch
     * @param orderby sql order by string
     * @return ArrayList of Frontendpage
     * @throws DBException 
     */
    public ArrayList<Frontendpage> searchfrontendpages(IFrontendpagesearch search, String orderby) throws DBException {
        return (ArrayList<Frontendpage>)this.search(search, orderby);
    }

    /**
     * Search frontendpage in database for frontendpagePK:
     * @param frontendpagePK: Frontendpage Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getFrontendpageExists(IFrontendpagePK frontendpagePK) throws DBException {
        return super.getEntityExists((FrontendpagePK)frontendpagePK);
    }

    /**
     * try to insert Frontendpage in database
     * @param frontendpage Frontendpage object
     * @throws DBException
     * @throws DataException
     */
    public void insertFrontendpage(IFrontendpage frontendpage) throws DBException, DataException {
        super.insertEntity(frontendpage);
    }

    /**
     * check if FrontendpagePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param frontendpage Frontendpage object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateFrontendpage(IFrontendpage frontendpage) throws DBException, DataException {
        if(this.getFrontendpageExists(frontendpage.getPrimaryKey())) {
            super.updateEntity(frontendpage);
        } else {
            super.insertEntity(frontendpage);
        }
    }

    /**
     * try to update Frontendpage in database
     * @param frontendpage Frontendpage object
     * @throws DBException
     * @throws DataException
     */
    public void updateFrontendpage(IFrontendpage frontendpage) throws DBException, DataException {
        super.updateEntity(frontendpage);
    }

    /**
     * try to delete Frontendpage in database
     * @param frontendpage Frontendpage object
     * @throws DBException
     */
    public void deleteFrontendpage(IFrontendpage frontendpage) throws DBException {
        cascadedeleteFrontendpage(frontendpage.getPrimaryKey());
        super.deleteEntity(frontendpage);
    }

    /**
     * check data rules in Frontendpage, throw DataException with customized message if rules do not apply
     * @param frontendpage Frontendpage object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IFrontendpage frontendpage) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where frontendpagePK is used in a primary key
     * @param frontendpagePK: Frontendpage primary key
     */
    public void cascadedeleteFrontendpage(IFrontendpagePK frontendpagePK) {
        BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth(this);
        blfrontendpage_auth.delete4frontendpage(frontendpagePK);
    }

    /**
     * @param frontendpage_authPK: parent Frontendpage_auth for child object Frontendpage Entity
     * @return child Frontendpage Entity object
     * @throws CustomException
     */
    public Frontendpage getFrontendpage_auth(IFrontendpage_authPK frontendpage_authPK) throws CustomException {
        FrontendpagePK frontendpagePK = new FrontendpagePK(frontendpage_authPK.getFrontendpage());
        return this.getFrontendpage(frontendpagePK);
    }


    /**
     * get all Frontendpage objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Frontendpage objects
     * @throws DBException
     */
    public ArrayList<Frontendpage> getFrontendpages(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMfrontendpage.SQLSelect);
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
        return (ArrayList<Frontendpage>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Frontendpage objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delFrontendpage(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Frontendpage.table);
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

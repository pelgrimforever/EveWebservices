/*
 * Btypegroup.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.8.2021 11:31
 *
 */

package eve.BusinessObject.table;

import BusinessObject.GeneralEntityInterface;
import BusinessObject.GeneralEntityObject;
import general.exception.*;
import java.util.ArrayList;

import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.JSONTypegroup;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ITypegroupsearch;
import eve.logicentity.Typegroup;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Btypegroup
 *
 * Superclass for manipulating data- and database objects
 * for Entity Typegroup and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Btypegroup extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Typegroup as default Entity
     */
    public Btypegroup() {
        super(new SQLMapper_pgsql(connectionpool, "Typegroup"), new Typegroup());
    }

    /**
     * Constructor, sets Typegroup as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Btypegroup(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Typegroup());
    }

    /**
     * Map ResultSet Field values to Typegroup
     * @param dbresult: Database ResultSet
     */
    public Typegroup mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        TypegroupPK typegroupPK = null;
        Typegroup typegroup;
        if(dbresult==null) {
            typegroup = new Typegroup(typegroupPK);
        } else {
            try {
                typegroupPK = new TypegroupPK(dbresult.getLong("id"));
                typegroup = new Typegroup(typegroupPK);
                typegroup.initCategoryPK(new CategoryPK(dbresult.getLong("category")));
                if(dbresult.wasNull()) typegroup.setCategoryPK(null);                
                typegroup.initName(dbresult.getString("name"));
                typegroup.initPublished(dbresult.getBoolean("published"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, typegroup);
        return typegroup;
    }

    /**
     * create new empty Typegroup object
     * @return empty ITypegroup
     */
    public ITypegroup newTypegroup() {
    	return new Typegroup();
    }
    
    /**
     * create new empty Typegroup object
     * create new primary key with given parameters
     * @return ITypegroup with primary key
     */
    public ITypegroup newTypegroup(long id) {
        return new Typegroup(id);
    }

    /**
     * create new empty Typegroup object with given primary key
     * @param typegroupPK: primary key for Typegroup
     * @return ITypegroup with primary key
     */
    public ITypegroup newTypegroup(ITypegroupPK typegroupPK) {
        return new Typegroup((TypegroupPK)typegroupPK);
    }

    /**
     * create new empty primary key
     * @return empty TypegroupPK
     */
    public ITypegroupPK newTypegroupPK() {
        return new TypegroupPK();
    }

    /**
     * create new primary key with given parameters
     * @return new ITypegroupPK
     */
    public ITypegroupPK newTypegroupPK(long id) {
        return new TypegroupPK(id);
    }

    /**
     * get all Typegroup objects from database
     * @return ArrayList of Typegroup objects
     * @throws DBException
     */
    public ArrayList getTypegroups() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Typegroup.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Typegroup for primary key
     * @param typegroupPK: Typegroup primary key
     * @return Typegroup object
     * @throws DBException
     */
    public Typegroup getTypegroup(ITypegroupPK typegroupPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Typegroup)super.getEntity((TypegroupPK)typegroupPK);
        } else return null;
    }

    public ArrayList searchtypegroups(ITypegroupsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchtypegroups(ITypegroupsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search typegroup in database for typegroupPK:
     * @param typegroupPK: Typegroup Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getTypegroupExists(ITypegroupPK typegroupPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((TypegroupPK)typegroupPK);
        } else return false;
    }

    /**
     * try to insert Typegroup in database
     * @param film: Typegroup object
     * @throws DBException
     */
    public void insertTypegroup(ITypegroup typegroup) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(typegroup);
        }
    }

    /**
     * check if TypegroupPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Typegroup object
     * @throws DBException
     */
    public void insertupdateTypegroup(ITypegroup typegroup) throws DBException, DataException {
        if(this.getTypegroupExists(typegroup.getPrimaryKey())) {
            super.updateEntity(typegroup);
        } else {
            super.insertEntity(typegroup);
        }
    }

    /**
     * try to update Typegroup in database
     * @param film: Typegroup object
     * @throws DBException
     */
    public void updateTypegroup(ITypegroup typegroup) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(typegroup);
        }
    }

    /**
     * try to delete Typegroup in database
     * @param film: Typegroup object
     * @throws DBException
     */
    public void deleteTypegroup(ITypegroup typegroup) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteTypegroup(typegroup.getOwnerobject(), typegroup.getPrimaryKey());
            super.deleteEntity(typegroup);
        }
    }

    /**
     * check data rules in Typegroup, throw DataException with customized message if rules do not apply
     * @param film: Typegroup object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ITypegroup typegroup) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key

        if(typegroup.getName()!=null && typegroup.getName().length()>ITypegroup.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + ITypegroup.SIZE_NAME + "\n");
        }
        if(typegroup.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where typegroupPK is used in a primary key
     * @param typegroupPK: Typegroup primary key
     */
    public void cascadedeleteTypegroup(String senderobject, ITypegroupPK typegroupPK) {
    }

    /**
     * @param categoryPK: foreign key for Category
     * @delete all Typegroup Entity objects for Category in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4category(String senderobject, ICategoryPK categoryPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Typegroup.SQLDelete4category, categoryPK.getKeyFields());
        }
    }

    /**
     * @param categoryPK: foreign key for Category
     * @return all Typegroup Entity objects for Category
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getTypegroups4category(ICategoryPK categoryPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Typegroup.SQLSelect4category, categoryPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Typegroup objects for sqlparameters
     * @return ArrayList of Typegroup objects
     * @throws DBException
     */
    public ArrayList getTypegroups(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Typegroup.SQLSelect;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        if(sortlist.length()>0) {
            sql += " order by " + sortlist + " " + sortoperator;
        }
        return getMapper().loadEntityVector(this, sql, sqlparameters);
    }

    /**
     * delete all Typegroup objects for sqlparameters
     * @throws DBException
     */
    public void delTypegroup(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Typegroup.table;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        this.addStatement(senderobject, sql, sqlparameters);
    }


}

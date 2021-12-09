/*
 * Btypegroup.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 9.11.2021 14:30
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
import eve.conversion.json.JSONTypegroup;
import eve.conversion.entity.EMtypegroup;
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
public abstract class Btypegroup extends BLtable {

    /**
     * Constructor, sets Typegroup as default Entity
     */
    public Btypegroup() {
        super(new Typegroup(), new EMtypegroup());
    }

    /**
     * Constructor, sets Typegroup as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Btypegroup(BLtable transactionobject) {
        super(transactionobject, new Typegroup(), new EMtypegroup());
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
     * @param id primary key field
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
     * @param id primary key field
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
    public ArrayList<Typegroup> getTypegroups() throws DBException {
        return (ArrayList<Typegroup>)super.getEntities(EMtypegroup.SQLSelectAll);
    }

    /**
     * search Typegroup for primary key
     * @param typegroupPK: Typegroup primary key
     * @return Typegroup object
     * @throws DBException
     */
    public Typegroup getTypegroup(ITypegroupPK typegroupPK) throws DBException {
        return (Typegroup)super.getEntity((TypegroupPK)typegroupPK);
    }

    /**
     * search typegroup with ITypegroupsearch parameters
     * @param search ITypegroupsearch
     * @return ArrayList of Typegroup
     * @throws DBException 
     */
    public ArrayList<Typegroup> searchtypegroups(ITypegroupsearch search) throws DBException {
        return (ArrayList<Typegroup>)this.search(search);
    }

    /**
     * search typegroup with ITypegroupsearch parameters, order by orderby sql clause
     * @param search ITypegroupsearch
     * @param orderby sql order by string
     * @return ArrayList of Typegroup
     * @throws DBException 
     */
    public ArrayList<Typegroup> searchtypegroups(ITypegroupsearch search, String orderby) throws DBException {
        return (ArrayList<Typegroup>)this.search(search, orderby);
    }

    /**
     * Search typegroup in database for typegroupPK:
     * @param typegroupPK: Typegroup Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getTypegroupExists(ITypegroupPK typegroupPK) throws DBException {
        return super.getEntityExists((TypegroupPK)typegroupPK);
    }

    /**
     * try to insert Typegroup in database
     * @param typegroup Typegroup object
     * @throws DBException
     * @throws DataException
     */
    public void insertTypegroup(ITypegroup typegroup) throws DBException, DataException {
        super.insertEntity(typegroup);
    }

    /**
     * check if TypegroupPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param typegroup Typegroup object
     * @throws DBException
     * @throws DataException
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
     * @param typegroup Typegroup object
     * @throws DBException
     * @throws DataException
     */
    public void updateTypegroup(ITypegroup typegroup) throws DBException, DataException {
        super.updateEntity(typegroup);
    }

    /**
     * try to delete Typegroup in database
     * @param typegroup Typegroup object
     * @throws DBException
     */
    public void deleteTypegroup(ITypegroup typegroup) throws DBException {
        cascadedeleteTypegroup(typegroup.getPrimaryKey());
        super.deleteEntity(typegroup);
    }

    /**
     * check data rules in Typegroup, throw DataException with customized message if rules do not apply
     * @param typegroup Typegroup object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ITypegroup typegroup) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(typegroup.getName()!=null && typegroup.getName().length()>ITypegroup.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(ITypegroup.SIZE_NAME).append("\n");
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
    public void cascadedeleteTypegroup(ITypegroupPK typegroupPK) {
    }

    /**
     * @param categoryPK: foreign key for Category
     * @delete all Typegroup Entity objects for Category in database
     */
    public void delete4category(ICategoryPK categoryPK) {
        super.addStatement(EMtypegroup.SQLDelete4category, categoryPK.getSQLprimarykey());
    }

    /**
     * @param categoryPK: foreign key for Category
     * @return all Typegroup Entity objects for Category
     * @throws CustomException
     */
    public ArrayList<Typegroup> getTypegroups4category(ICategoryPK categoryPK) throws CustomException {
        return super.getEntities(EMtypegroup.SQLSelect4category, categoryPK.getSQLprimarykey());
    }

    /**
     * get all Typegroup objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Typegroup objects
     * @throws DBException
     */
    public ArrayList<Typegroup> getTypegroups(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMtypegroup.SQLSelect);
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
        return (ArrayList<Typegroup>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Typegroup objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delTypegroup(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Typegroup.table);
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

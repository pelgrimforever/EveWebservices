/*
 * Bbpmaterial.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.0.2022 16:47
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
import eve.conversion.json.JSONBpmaterial;
import eve.conversion.entity.EMbpmaterial;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IBpmaterialsearch;
import eve.logicentity.Bpmaterial;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bbpmaterial
 *
 * Superclass for manipulating data- and database objects
 * for Entity Bpmaterial and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bbpmaterial extends BLtable {

    /**
     * Constructor, sets Bpmaterial as default Entity
     */
    public Bbpmaterial() {
        super(new Bpmaterial(), new EMbpmaterial());
    }

    /**
     * Constructor, sets Bpmaterial as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bbpmaterial(BLtable transactionobject) {
        super(transactionobject, new Bpmaterial(), new EMbpmaterial());
    }

    /**
     * create new empty Bpmaterial object
     * @return empty IBpmaterial
     */
    public IBpmaterial newBpmaterial() {
    	return new Bpmaterial();
    }
    
    /**
     * create new empty Bpmaterial object
     * create new primary key with given parameters
     * @param bp primary key field
     * @param material primary key field
     * @return IBpmaterial with primary key
     */
    public IBpmaterial newBpmaterial(long bp, long material) {
        return new Bpmaterial(bp, material);
    }

    /**
     * create new empty Bpmaterial object with given primary key
     * @param bpmaterialPK: primary key for Bpmaterial
     * @return IBpmaterial with primary key
     */
    public IBpmaterial newBpmaterial(IBpmaterialPK bpmaterialPK) {
        return new Bpmaterial((BpmaterialPK)bpmaterialPK);
    }

    /**
     * create new empty primary key
     * @return empty BpmaterialPK
     */
    public IBpmaterialPK newBpmaterialPK() {
        return new BpmaterialPK();
    }

    /**
     * create new primary key with given parameters
     * @param bp primary key field
     * @param material primary key field
     * @return new IBpmaterialPK
     */
    public IBpmaterialPK newBpmaterialPK(long bp, long material) {
        return new BpmaterialPK(bp, material);
    }

    /**
     * get all Bpmaterial objects from database
     * @return ArrayList of Bpmaterial objects
     * @throws DBException
     */
    public ArrayList<Bpmaterial> getBpmaterials() throws DBException {
        return (ArrayList<Bpmaterial>)super.getEntities(EMbpmaterial.SQLSelectAll);
    }

    /**
     * search Bpmaterial for primary key
     * @param bpmaterialPK: Bpmaterial primary key
     * @return Bpmaterial object
     * @throws DBException
     */
    public Bpmaterial getBpmaterial(IBpmaterialPK bpmaterialPK) throws DBException {
        return (Bpmaterial)super.getEntity((BpmaterialPK)bpmaterialPK);
    }

    /**
     * search bpmaterial with IBpmaterialsearch parameters
     * @param search IBpmaterialsearch
     * @return ArrayList of Bpmaterial
     * @throws DBException 
     */
    public ArrayList<Bpmaterial> searchbpmaterials(IBpmaterialsearch search) throws DBException {
        return (ArrayList<Bpmaterial>)this.search(search);
    }

    /**
     * search bpmaterial with IBpmaterialsearch parameters, order by orderby sql clause
     * @param search IBpmaterialsearch
     * @param orderby sql order by string
     * @return ArrayList of Bpmaterial
     * @throws DBException 
     */
    public ArrayList<Bpmaterial> searchbpmaterials(IBpmaterialsearch search, String orderby) throws DBException {
        return (ArrayList<Bpmaterial>)this.search(search, orderby);
    }

    /**
     * Search bpmaterial in database for bpmaterialPK:
     * @param bpmaterialPK: Bpmaterial Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getBpmaterialExists(IBpmaterialPK bpmaterialPK) throws DBException {
        return super.getEntityExists((BpmaterialPK)bpmaterialPK);
    }

    /**
     * try to insert Bpmaterial in database
     * @param bpmaterial Bpmaterial object
     * @throws DBException
     * @throws DataException
     */
    public void insertBpmaterial(IBpmaterial bpmaterial) throws DBException, DataException {
        super.insertEntity(bpmaterial);
    }

    /**
     * check if BpmaterialPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param bpmaterial Bpmaterial object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateBpmaterial(IBpmaterial bpmaterial) throws DBException, DataException {
        if(this.getBpmaterialExists(bpmaterial.getPrimaryKey())) {
            super.updateEntity(bpmaterial);
        } else {
            super.insertEntity(bpmaterial);
        }
    }

    /**
     * try to update Bpmaterial in database
     * @param bpmaterial Bpmaterial object
     * @throws DBException
     * @throws DataException
     */
    public void updateBpmaterial(IBpmaterial bpmaterial) throws DBException, DataException {
        super.updateEntity(bpmaterial);
    }

    /**
     * try to delete Bpmaterial in database
     * @param bpmaterial Bpmaterial object
     * @throws DBException
     */
    public void deleteBpmaterial(IBpmaterial bpmaterial) throws DBException {
        cascadedeleteBpmaterial(bpmaterial.getPrimaryKey());
        super.deleteEntity(bpmaterial);
    }

    /**
     * check data rules in Bpmaterial, throw DataException with customized message if rules do not apply
     * @param bpmaterial Bpmaterial object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IBpmaterial bpmaterial) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Bpmaterial.Bp - Evetype.Id
        //foreign key Bpmaterial.Material - Evetype.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where bpmaterialPK is used in a primary key
     * @param bpmaterialPK: Bpmaterial primary key
     */
    public void cascadedeleteBpmaterial(IBpmaterialPK bpmaterialPK) {
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Bpmaterial Entity objects for Evetype in database
     */
    public void delete4evetypeBp(IEvetypePK evetypePK) {
        super.addStatement(EMbpmaterial.SQLDelete4evetypeBp, evetypePK.getSQLprimarykey());
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Bpmaterial Entity objects for Evetype
     * @throws CustomException
     */
    public ArrayList<Bpmaterial> getBpmaterials4evetypeBp(IEvetypePK evetypePK) throws CustomException {
        return super.getEntities(EMbpmaterial.SQLSelect4evetypeBp, evetypePK.getSQLprimarykey());
    }
    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Bpmaterial Entity objects for Evetype in database
     */
    public void delete4evetypeMaterial(IEvetypePK evetypePK) {
        super.addStatement(EMbpmaterial.SQLDelete4evetypeMaterial, evetypePK.getSQLprimarykey());
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Bpmaterial Entity objects for Evetype
     * @throws CustomException
     */
    public ArrayList<Bpmaterial> getBpmaterials4evetypeMaterial(IEvetypePK evetypePK) throws CustomException {
        return super.getEntities(EMbpmaterial.SQLSelect4evetypeMaterial, evetypePK.getSQLprimarykey());
    }

    /**
     * get all Bpmaterial objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Bpmaterial objects
     * @throws DBException
     */
    public ArrayList<Bpmaterial> getBpmaterials(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMbpmaterial.SQLSelect);
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
        return (ArrayList<Bpmaterial>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Bpmaterial objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delBpmaterial(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Bpmaterial.table);
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

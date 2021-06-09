/*
 * Bevetype.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.5.2021 19:33
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
import eve.conversion.json.JSONEvetype;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IEvetypesearch;
import eve.logicentity.Evetype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bevetype
 *
 * Superclass for manipulating data- and database objects
 * for Entity Evetype and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bevetype extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Evetype as default Entity
     */
    public Bevetype() {
        super(new SQLMapper_pgsql(connectionpool, "Evetype"), new Evetype());
    }

    /**
     * Constructor, sets Evetype as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bevetype(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Evetype());
    }

    /**
     * Map ResultSet Field values to Evetype
     * @param dbresult: Database ResultSet
     */
    public Evetype mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        EvetypePK evetypePK = null;
        Evetype evetype;
        if(dbresult==null) {
            evetype = new Evetype(evetypePK);
        } else {
            try {
                evetypePK = new EvetypePK(dbresult.getLong("id"));
                evetype = new Evetype(evetypePK);
                evetype.initMarket_groupPK(new Market_groupPK(dbresult.getLong("market_group")));
                if(dbresult.wasNull()) evetype.setMarket_groupPK(null);                
                evetype.initTypegroupPK(new TypegroupPK(dbresult.getLong("typegroup")));
                if(dbresult.wasNull()) evetype.setTypegroupPK(null);                
                evetype.initGraphicPK(new GraphicPK(dbresult.getLong("graphic")));
                if(dbresult.wasNull()) evetype.setGraphicPK(null);                
                evetype.initName(dbresult.getString("name"));
                evetype.initPublished(dbresult.getBoolean("published"));
                evetype.initDescription(dbresult.getString("description"));
                evetype.initCapacity(dbresult.getDouble("capacity"));
                evetype.initIcon(dbresult.getLong("icon"));
                evetype.initMass(dbresult.getDouble("mass"));
                evetype.initPackaged_volume(dbresult.getDouble("packaged_volume"));
                evetype.initPortion_size(dbresult.getInt("portion_size"));
                evetype.initRadius(dbresult.getDouble("radius"));
                evetype.initVolume(dbresult.getDouble("volume"));
                evetype.initAvg_buyorder(dbresult.getDouble("avg_buyorder"));
                evetype.initAvg_sellorder(dbresult.getDouble("avg_sellorder"));
                evetype.initMin_buyorder(dbresult.getDouble("min_buyorder"));
                evetype.initMax_buyorder(dbresult.getDouble("max_buyorder"));
                evetype.initMin_selorder(dbresult.getDouble("min_selorder"));
                evetype.initMax_selorder(dbresult.getDouble("max_selorder"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, evetype);
        return evetype;
    }

    /**
     * create new empty Evetype object
     * @return empty IEvetype
     */
    public IEvetype newEvetype() {
    	return new Evetype();
    }
    
    /**
     * create new empty Evetype object
     * create new primary key with given parameters
     * @return IEvetype with primary key
     */
    public IEvetype newEvetype(long id) {
        return new Evetype(id);
    }

    /**
     * create new empty Evetype object with given primary key
     * @param evetypePK: primary key for Evetype
     * @return IEvetype with primary key
     */
    public IEvetype newEvetype(IEvetypePK evetypePK) {
        return new Evetype((EvetypePK)evetypePK);
    }

    /**
     * create new empty primary key
     * @return empty EvetypePK
     */
    public IEvetypePK newEvetypePK() {
        return new EvetypePK();
    }

    /**
     * create new primary key with given parameters
     * @return new IEvetypePK
     */
    public IEvetypePK newEvetypePK(long id) {
        return new EvetypePK(id);
    }

    /**
     * get all Evetype objects from database
     * @return ArrayList of Evetype objects
     * @throws DBException
     */
    public ArrayList getEvetypes() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Evetype.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Evetype for primary key
     * @param evetypePK: Evetype primary key
     * @return Evetype object
     * @throws DBException
     */
    public Evetype getEvetype(IEvetypePK evetypePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Evetype)super.getEntity((EvetypePK)evetypePK);
        } else return null;
    }

    public ArrayList searchevetypes(IEvetypesearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchevetypes(IEvetypesearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search evetype in database for evetypePK:
     * @param evetypePK: Evetype Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getEvetypeExists(IEvetypePK evetypePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((EvetypePK)evetypePK);
        } else return false;
    }

    /**
     * try to insert Evetype in database
     * @param film: Evetype object
     * @throws DBException
     */
    public void insertEvetype(IEvetype evetype) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(evetype);
        }
    }

    /**
     * check if EvetypePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Evetype object
     * @throws DBException
     */
    public void insertupdateEvetype(IEvetype evetype) throws DBException, DataException {
        if(this.getEvetypeExists(evetype.getPrimaryKey())) {
            super.updateEntity(evetype);
        } else {
            super.insertEntity(evetype);
        }
    }

    /**
     * try to update Evetype in database
     * @param film: Evetype object
     * @throws DBException
     */
    public void updateEvetype(IEvetype evetype) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(evetype);
        }
    }

    /**
     * try to delete Evetype in database
     * @param film: Evetype object
     * @throws DBException
     */
    public void deleteEvetype(IEvetype evetype) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteEvetype(evetype.getOwnerobject(), evetype.getPrimaryKey());
            super.deleteEntity(evetype);
        }
    }

    /**
     * check data rules in Evetype, throw DataException with customized message if rules do not apply
     * @param film: Evetype object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IEvetype evetype) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key



        if(evetype.getName()!=null && evetype.getName().length()>IEvetype.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + IEvetype.SIZE_NAME + "\n");
        }
        if(evetype.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(evetype.getDescription()!=null && evetype.getDescription().length()>IEvetype.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: " + IEvetype.SIZE_DESCRIPTION + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where evetypePK is used in a primary key
     * @param evetypePK: Evetype primary key
     */
    public void cascadedeleteEvetype(String senderobject, IEvetypePK evetypePK) {
        BLorder_history blorder_history = new BLorder_history(this);
        blorder_history.delete4evetype(senderobject, evetypePK);
    }

    /**
     * @param market_groupPK: foreign key for Market_group
     * @delete all Evetype Entity objects for Market_group in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4market_group(String senderobject, IMarket_groupPK market_groupPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Evetype.SQLDelete4market_group, market_groupPK.getKeyFields());
        }
    }

    /**
     * @param market_groupPK: foreign key for Market_group
     * @return all Evetype Entity objects for Market_group
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getEvetypes4market_group(IMarket_groupPK market_groupPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Evetype.SQLSelect4market_group, market_groupPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param typegroupPK: foreign key for Typegroup
     * @delete all Evetype Entity objects for Typegroup in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4typegroup(String senderobject, ITypegroupPK typegroupPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Evetype.SQLDelete4typegroup, typegroupPK.getKeyFields());
        }
    }

    /**
     * @param typegroupPK: foreign key for Typegroup
     * @return all Evetype Entity objects for Typegroup
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getEvetypes4typegroup(ITypegroupPK typegroupPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Evetype.SQLSelect4typegroup, typegroupPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param graphicPK: foreign key for Graphic
     * @delete all Evetype Entity objects for Graphic in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4graphic(String senderobject, IGraphicPK graphicPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Evetype.SQLDelete4graphic, graphicPK.getKeyFields());
        }
    }

    /**
     * @param graphicPK: foreign key for Graphic
     * @return all Evetype Entity objects for Graphic
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getEvetypes4graphic(IGraphicPK graphicPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Evetype.SQLSelect4graphic, graphicPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param order_historyPK: parent Order_history for child object Evetype Entity
     * @return child Evetype Entity object
     * @throws eve.general.exception.CustomException
     */
    public IEvetype getOrder_history(IOrder_historyPK order_historyPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            EvetypePK evetypePK = new EvetypePK(order_historyPK.getEvetype());
            return this.getEvetype(evetypePK);
        } else return null;
    }


    /**
     * get all Evetype objects for sqlparameters
     * @return ArrayList of Evetype objects
     * @throws DBException
     */
    public ArrayList getEvetypes(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Evetype.SQLSelect;
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
     * delete all Evetype objects for sqlparameters
     * @throws DBException
     */
    public void delEvetype(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Evetype.table;
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

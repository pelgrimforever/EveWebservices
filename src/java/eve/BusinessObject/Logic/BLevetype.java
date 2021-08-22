/*
 * BLevetype.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.4.2021 15:56
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLRecordcount;
import general.exception.DBException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.IEvetype;
import eve.logicentity.Evetype;
import BusinessObject.GeneralEntityObject;
import data.conversion.JSONConversion;
import data.interfaces.db.Recordcount;
import db.AbstractSQLMapper;
import db.ViewMapper;
import eve.BusinessObject.table.Bevetype;
import eve.entity.pk.GraphicPK;
import eve.entity.pk.Market_groupPK;
import eve.entity.pk.TypegroupPK;
import general.exception.DataException;
import eve.interfaces.BusinessObject.IBLevetype;
import eve.interfaces.entity.pk.ITypegroupPK;
import eve.logicentity.Orders;
import eve.logicentity.Station;
import eve.logicentity.Typegroup;
import general.exception.CustomException;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.simple.JSONObject;

/**
 * Business Logic Entity class BLevetype
 *
 * Class for manipulating data- and database objects
 * for Entity Evetype and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLevetype extends Bevetype implements IBLevetype {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Evetype as default Entity
     */
    public BLevetype() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Evetype as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLevetype(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity evetype) throws SQLException {
        
    }
    
    public void updateEvetype(JSONObject jsontypedetails) throws DBException, DataException {
        Evetype evetype = new Evetype(JSONConversion.getLong(jsontypedetails, "type_id"));
        evetype.setName(JSONConversion.getString(jsontypedetails, "name"));
        evetype.setDescription(JSONConversion.getString(jsontypedetails, "description"));
        evetype.setTypegroupPK(new TypegroupPK(JSONConversion.getLong(jsontypedetails, "group_id")));
        evetype.setPublished(JSONConversion.getboolean(jsontypedetails, "published"));
        if(jsontypedetails.containsKey("market_group_id")) evetype.setMarket_groupPK(new Market_groupPK(JSONConversion.getLong(jsontypedetails, "market_group_id")));
        if(jsontypedetails.containsKey("capacity")) evetype.setCapacity(JSONConversion.getDouble(jsontypedetails, "capacity"));
        if(jsontypedetails.containsKey("graphic_id")) evetype.setGraphicPK(new GraphicPK(JSONConversion.getLong(jsontypedetails, "graphic_id")));
        if(jsontypedetails.containsKey("icon_id")) evetype.setIcon(JSONConversion.getLong(jsontypedetails, "icon_id"));
        if(jsontypedetails.containsKey("mass")) evetype.setMass(JSONConversion.getDouble(jsontypedetails, "mass"));
        if(jsontypedetails.containsKey("packaged_volume")) evetype.setPackaged_volume(JSONConversion.getDouble(jsontypedetails, "packaged_volume"));
        if(jsontypedetails.containsKey("portion_size")) evetype.setPortion_size(JSONConversion.getint(jsontypedetails, "portion_size"));
        if(jsontypedetails.containsKey("radius")) evetype.setRadius(JSONConversion.getDouble(jsontypedetails, "radius"));
        if(jsontypedetails.containsKey("volume")) evetype.setVolume(JSONConversion.getDouble(jsontypedetails, "volume"));
        this.insertupdateEvetype(evetype);
    }

    /**
     * @param typegroupPK: foreign key for typegroup
     * @return count of all evetypes linked to typegroup
     * @throws eve.general.exception.CustomException
     */
    public long getEvetypes4typegroupcount(ITypegroupPK typegroupPK) throws CustomException {
        AbstractSQLMapper sqlmapper = entitymapper.resetSQLMapper("");
        BLRecordcount blrecordcount = new BLRecordcount(sqlmapper);
        ViewMapper viewmapper = new ViewMapper(sqlmapper);
        Recordcount recordcount = (Recordcount)viewmapper.loadView(blrecordcount, Evetype.SQLSelect4typegroupCount, typegroupPK.getKeyFields());
        return recordcount.getCount();
    }

    /**
     * update average buy and sell prices of all found evetypes in orders
     * @throws DBException
     * @throws DataException 
     */
    public void updateaverageprices() throws DBException, DataException {
        this.transactionqueue.addStatement(this.getClass().getSimpleName(), Evetype.SQLUpdateBuyprices, null);
        this.Commit2DB();
        this.transactionqueue.addStatement(this.getClass().getSimpleName(), Evetype.SQLUpdateSellprices, null);
        this.Commit2DB();
    }

    /**
     * try to insert Evetype object in database
     * commit transaction
     * @param evetype: Evetype Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertEvetype(IEvetype evetype) throws DBException, DataException {
        trans_insertEvetype(evetype);
        super.Commit2DB();
    }
    
    /**
     * try to insert Evetype object in database
     * an alternative to insertEvetype, which can be made an empty function
     * commit transaction
     * @param evetype: Evetype Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertEvetype(IEvetype evetype) throws DBException, DataException {
        trans_insertEvetype(evetype);
        super.Commit2DB();
    }
    
    /**
     * try to update Evetype object in database
     * commit transaction
     * @param evetype: Evetype Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateEvetype(IEvetype evetype) throws DBException, DataException {
        trans_updateEvetype(evetype);
        super.Commit2DB();
    }
    
    /**
     * try to update Evetype object in database
     * an alternative to updateEvetype, which can be made an empty function
     * commit transaction
     * @param evetype: Evetype Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateEvetype(IEvetype evetype) throws DBException, DataException {
        trans_updateEvetype(evetype);
        super.Commit2DB();
    }
    
    /**
     * try to delete Evetype object in database
     * commit transaction
     * @param evetype: Evetype Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteEvetype(IEvetype evetype) throws DBException {
        trans_deleteEvetype(evetype);
        super.Commit2DB();
    }

    /**
     * try to delete Evetype object in database
     * an alternative to deleteEvetype, which can be made an empty function
     * commit transaction
     * @param evetype: Evetype Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteEvetype(IEvetype evetype) throws DBException {
        trans_deleteEvetype(evetype);
        super.Commit2DB();
    }

    /**
     * try to insert Evetype object in database
     * do not commit transaction
     * @param evetype: Evetype Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertEvetype(IEvetype evetype) throws DBException, DataException {
        super.checkDATA(evetype);
        super.insertEvetype((Evetype)evetype);
    }
    
    /**
     * try to update Evetype object in database
     * do not commit transaction
     * @param evetype: Evetype Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateEvetype(IEvetype evetype) throws DBException, DataException {
        super.checkDATA(evetype);
        super.updateEvetype((Evetype)evetype);
    }
    
    /**
     * try to delete Evetype object in database
     * do not commit transaction
     * @param evetype: Evetype Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteEvetype(IEvetype evetype) throws DBException {
        super.deleteEvetype((Evetype)evetype);
    }
}

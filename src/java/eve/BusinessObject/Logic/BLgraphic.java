/*
 * BLgraphic.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.4.2021 15:56
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IGraphic;
import eve.logicentity.Graphic;
import BusinessObject.BLtable;
import data.conversion.JSONConversion;
import eve.BusinessObject.table.Bgraphic;
import general.exception.DataException;
import org.json.simple.JSONObject;

/**
 * Business Logic Entity class BLgraphic
 *
 * Class for manipulating data- and database objects
 * for Entity Graphic and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLgraphic extends Bgraphic {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Graphic as default Entity
     */
    public BLgraphic() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Graphic as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLgraphic(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    public Graphic updateGraphic(JSONObject jsongraphicdetails) throws DBException, DataException {
        Graphic graphic = new Graphic(JSONConversion.getLong(jsongraphicdetails, "graphic_id"));
        if(jsongraphicdetails.containsKey("collision_file")) graphic.setCollision_file(JSONConversion.getString(jsongraphicdetails, "collision_file"));
        if(jsongraphicdetails.containsKey("graphic_file")) graphic.setCollision_file(JSONConversion.getString(jsongraphicdetails, "graphic_file"));
        if(jsongraphicdetails.containsKey("icon_folder")) graphic.setCollision_file(JSONConversion.getString(jsongraphicdetails, "icon_folder"));
        if(jsongraphicdetails.containsKey("sof_dna")) graphic.setCollision_file(JSONConversion.getString(jsongraphicdetails, "sof_dna"));
        if(jsongraphicdetails.containsKey("sof_fation_name")) graphic.setCollision_file(JSONConversion.getString(jsongraphicdetails, "sof_fation_name"));
        if(jsongraphicdetails.containsKey("sof_hull_name")) graphic.setCollision_file(JSONConversion.getString(jsongraphicdetails, "sof_hull_name"));
        if(jsongraphicdetails.containsKey("sof_race_name")) graphic.setCollision_file(JSONConversion.getString(jsongraphicdetails, "sof_race_name"));
        this.insertupdateGraphic(graphic);
        return graphic;
    }

    /**
     * try to insert Graphic object in database
     * commit transaction
     * @param graphic: Graphic Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertGraphic(IGraphic graphic) throws DBException, DataException {
        trans_insertGraphic(graphic);
        super.Commit2DB();
    }
    
    /**
     * try to insert Graphic object in database
     * an alternative to insertGraphic, which can be made an empty function
     * commit transaction
     * @param graphic: Graphic Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertGraphic(IGraphic graphic) throws DBException, DataException {
        trans_insertGraphic(graphic);
        super.Commit2DB();
    }
    
    /**
     * try to update Graphic object in database
     * commit transaction
     * @param graphic: Graphic Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateGraphic(IGraphic graphic) throws DBException, DataException {
        trans_updateGraphic(graphic);
        super.Commit2DB();
    }
    
    /**
     * try to update Graphic object in database
     * an alternative to updateGraphic, which can be made an empty function
     * commit transaction
     * @param graphic: Graphic Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateGraphic(IGraphic graphic) throws DBException, DataException {
        trans_updateGraphic(graphic);
        super.Commit2DB();
    }
    
    /**
     * try to delete Graphic object in database
     * commit transaction
     * @param graphic: Graphic Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteGraphic(IGraphic graphic) throws DBException {
        trans_deleteGraphic(graphic);
        super.Commit2DB();
    }

    /**
     * try to delete Graphic object in database
     * an alternative to deleteGraphic, which can be made an empty function
     * commit transaction
     * @param graphic: Graphic Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteGraphic(IGraphic graphic) throws DBException {
        trans_deleteGraphic(graphic);
        super.Commit2DB();
    }

    /**
     * try to insert Graphic object in database
     * do not commit transaction
     * @param graphic: Graphic Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertGraphic(IGraphic graphic) throws DBException, DataException {
        super.checkDATA(graphic);
        super.insertGraphic((Graphic)graphic);
    }
    
    /**
     * try to update Graphic object in database
     * do not commit transaction
     * @param graphic: Graphic Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateGraphic(IGraphic graphic) throws DBException, DataException {
        super.checkDATA(graphic);
        super.updateGraphic((Graphic)graphic);
    }
    
    /**
     * try to delete Graphic object in database
     * do not commit transaction
     * @param graphic: Graphic Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteGraphic(IGraphic graphic) throws DBException {
        super.deleteGraphic((Graphic)graphic);
    }
}

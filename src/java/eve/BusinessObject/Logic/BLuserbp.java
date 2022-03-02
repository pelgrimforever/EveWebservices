/*
 * BLuserbp.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 28.0.2022 15:59
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLparameters;
import general.exception.DBException;
import eve.interfaces.logicentity.IUserbp;
import eve.logicentity.Userbp;
import eve.BusinessObject.table.Buserbp;
import eve.conversion.entity.EMuserbp;
import eve.entity.pk.EvetypePK;
import eve.entity.pk.UserbpPK;
import eve.logicentity.Bpmaterial;
import eve.logicentity.Materialinput;
import eve.logicview.View_userbp;
import eve.logicview.View_userbpmaterial;
import general.exception.CustomException;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLuserbp
 *
 * Class for manipulating data- and database objects
 * for Entity Userbp and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLuserbp extends Buserbp {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Userbp as default Entity
     */
    public BLuserbp() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Userbp as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLuserbp(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * calculate production price with material average market prices
     * @param view_userbp: View_userbp
     * @param view_userbpmaterials: ArrayList<View_userbpmaterials>
     * @return total price
     * @throws DBException 
     */
    public double calculateproductionprice_market(View_userbp view_userbp, ArrayList<View_userbpmaterial> view_userbpmaterials) throws DBException {
        double totalprice = view_userbp.getStationfee();
        int me = view_userbp.getMaterialefficiency();
        for(View_userbpmaterial mat: view_userbpmaterials) {
            //put division last to avoid rounding errors, all numbers are type long
            totalprice += mat.getMarketaverage() * Math.ceil(mat.getAmount() * (100-me) / 100);
        }
        return totalprice;
    }
    
    /**
     * calculate production price with material prices from average materialinput prices
     * if no materialinputprices are available for a material, market prices are used
     * @param view_userbp: View_userbp
     * @param view_userbpmaterials: ArrayList<View_userbpmaterials>
     * @return total price
     * @throws DBException 
     */
    public double calculateproductionprice4user(View_userbp view_userbp, ArrayList<View_userbpmaterial> view_userbpmaterials) throws DBException {
        double totalprice = view_userbp.getStationfee();
        int me = view_userbp.getMaterialefficiency();
        double matprice = 0;
        for(View_userbpmaterial mat: view_userbpmaterials) {
            if(mat.getMaterialinputaverage()==0) {
                matprice = mat.getMarketaverage();
            } else {
                matprice = mat.getMaterialinputaverage();
            }
            //put division last to avoid rounding errors, all numbers are type long
            totalprice += matprice * Math.ceil(mat.getAmount() * (100-me) / 100);
        }
        return totalprice;
    }
    
    /**
     * try to insert Userbp object in database
     * commit transaction
     * @param userbp: Userbp Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertUserbp(IUserbp userbp) throws DBException, DataException {
        trans_insertUserbp(userbp);
        super.Commit2DB();
    }
    
    /**
     * add a new blueprint to the userbp list
     * @param evetypepk blueprint primary key
     * @throws DBException
     * @throws DataException 
     */
    public void insertNewbp(IUserbp newuserbp) throws DBException, DataException {
        //check existing blueprints of this type for this user
        Object[][] parameters = {{ "username", newuserbp.getPrimaryKey().getUsername()}};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        sqlparameters.add(newuserbp.getPrimaryKey().getEvetypePK().getSQLprimarykey());
        Userbp userbp = (Userbp)this.getEntity(EMuserbp.SQLSelectMaxserial4Evetype, sqlparameters);
        int serialnumber = 0;
        if(userbp!=null) {
            serialnumber = userbp.getPrimaryKey().getSerialnumber() + 1;
        }
        //create new blueprint
        newuserbp.getPrimaryKey().setSerialnumber(serialnumber);
        newuserbp.setAmountproduced(0);
        newuserbp.setMaterialefficiency(0);
        this.insertUserbp(newuserbp);
    }
    
    public void runbp(UserbpPK userbpPK, int amount) throws DBException, DataException, CustomException {
        BLbpmaterial blbpmaterial = new BLbpmaterial(this);
        BLmaterialinput blmaterialinput = new BLmaterialinput(this);
        Userbp userbp = this.getUserbp(userbpPK);
        ArrayList<Bpmaterial> bpmaterials = blbpmaterial.getBpmaterials4evetypeBp(userbpPK.getEvetypePK());
        ArrayList<Materialinput> materialinputlist;
        Materialinput materialinput;
        long totamount;
        //update material usage in bpmaterial
        for(Bpmaterial bpmaterial: bpmaterials) {
            //put division last to avoid rounding errors, all numbers are type long
            totamount = Double.valueOf(Math.ceil(bpmaterial.getAmount() * amount * (100-userbp.getMaterialefficiency()) / 100)).longValue();
            blmaterialinput.useMaterial(userbpPK.getUsername(), (EvetypePK)bpmaterial.getPrimaryKey().getEvetypematerialPK(), totamount);
        }
        //update amount produced in userbp
        userbp.setAmountproduced(userbp.getAmountproduced() + amount);
        this.trans_updateUserbp(userbp);
        this.Commit2DB();
    }
    
    /**
     * try to insert Userbp object in database
     * an alternative to insertUserbp, which can be made an empty function
     * commit transaction
     * @param userbp: Userbp Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertUserbp(IUserbp userbp) throws DBException, DataException {
        trans_insertUserbp(userbp);
        super.Commit2DB();
    }
    
    /**
     * try to update Userbp object in database
     * commit transaction
     * @param userbp: Userbp Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateUserbp(IUserbp userbp) throws DBException, DataException {
        trans_updateUserbp(userbp);
        super.Commit2DB();
    }
    
    /**
     * update efficiency and producedamount for a userbp
     * @param userbp updated userbp
     * @throws DBException
     * @throws DataException 
     */
    public void updateProperties(IUserbp userbp) throws DBException, DataException {
        Userbp original = this.getUserbp(userbp.getPrimaryKey());
        original.setBpprice(userbp.getBpprice());
        original.setAmountproduced(userbp.getAmountproduced());
        original.setMaterialefficiency(userbp.getMaterialefficiency());
        original.setResearchcost(userbp.getResearchcost());
        this.updateEntity(original);
        super.Commit2DB();
    }
    
    /**
     * try to update Userbp object in database
     * an alternative to updateUserbp, which can be made an empty function
     * commit transaction
     * @param userbp: Userbp Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateUserbp(IUserbp userbp) throws DBException, DataException {
        trans_updateUserbp(userbp);
        super.Commit2DB();
    }
    
    /**
     * try to delete Userbp object in database
     * commit transaction
     * @param userbp: Userbp Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteUserbp(IUserbp userbp) throws DBException {
        trans_deleteUserbp(userbp);
        super.Commit2DB();
    }

    /**
     * try to delete Userbp object in database
     * an alternative to deleteUserbp, which can be made an empty function
     * commit transaction
     * @param userbp: Userbp Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteUserbp(IUserbp userbp) throws DBException {
        trans_deleteUserbp(userbp);
        super.Commit2DB();
    }

    /**
     * try to insert Userbp object in database
     * do not commit transaction
     * @param userbp: Userbp Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertUserbp(IUserbp userbp) throws DBException, DataException {
        super.checkDATA(userbp);
        super.insertUserbp((Userbp)userbp);
    }
    
    /**
     * try to update Userbp object in database
     * do not commit transaction
     * @param userbp: Userbp Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateUserbp(IUserbp userbp) throws DBException, DataException {
        super.checkDATA(userbp);
        super.updateUserbp((Userbp)userbp);
    }
    
    /**
     * try to delete Userbp object in database
     * do not commit transaction
     * @param userbp: Userbp Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteUserbp(IUserbp userbp) throws DBException {
        super.deleteUserbp((Userbp)userbp);
    }
}

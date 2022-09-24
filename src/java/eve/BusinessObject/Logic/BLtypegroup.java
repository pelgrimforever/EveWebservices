/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.4.2021 17:46
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.logicentity.Typegroup;
import db.*;
import data.conversion.JSONConversion;
import db.SQLTqueue;
import db.SQLreader;
import eve.BusinessObject.table.Btypegroup;
import eve.conversion.entity.EMtypegroup;
import eve.entity.pk.CategoryPK;
import general.exception.DataException;
import eve.interfaces.entity.pk.ICategoryPK;
import general.exception.CustomException;
import org.json.simple.JSONObject;

public class BLtypegroup extends Btypegroup {
//Metacoder: NO AUTHOMATIC UPDATE

    //typegroups
    public static final long MINERALS = 18;
    public static final long SALVAGEDMATERIAL = 754;

    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLtypegroup(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLtypegroup(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }


    public Typegroup updateTypegroup(SQLTqueue transactionqueue, JSONObject jsongroupdetails) throws DBException, DataException {
        Typegroup typegroup = new Typegroup(JSONConversion.getLong(jsongroupdetails, "group_id"));
        typegroup.setName(JSONConversion.getString(jsongroupdetails, "name"));
        typegroup.setCategoryPK(new CategoryPK(JSONConversion.getLong(jsongroupdetails, "category_id")));
        typegroup.setPublished(JSONConversion.getboolean(jsongroupdetails, "published"));
        insertupdateTypegroup(transactionqueue, typegroup);
        return typegroup;
    }

    public long getTypegroup4categorycount(ICategoryPK categoryPK) throws CustomException {
        return count(EMtypegroup.SQLSelect4categoryCount, categoryPK.getSQLprimarykey());
    }

}

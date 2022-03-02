/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 22.1.2022 10:54
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Contractitem;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMcontractitem_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMcontractitem_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :contractitem.id:";
    public static final String SQLSelect1 = "select contractitem.* from contractitem where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from contractitem where " + SQLWhere1;
    public static final String SQLSelectAll = "select contractitem.* from contractitem";

    public static final String SQLSelect = "select contractitem.* from contractitem";
    public static final String SQLWhereevetype = "evetype = :evetype.id:";
    public static final String SQLWherecontract = "contract = :contract.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line

    public static final String SQLSelect4evetype = "select * from contractitem where " + SQLWhereevetype + OrderBy;
    public static final String SQLDelete4evetype = "delete from contractitem where " + SQLWhereevetype;
    public static final String SQLSelect4contract = "select * from contractitem where " + SQLWherecontract + OrderBy;
    public static final String SQLDelete4contract = "delete from contractitem where " + SQLWherecontract;

    /**
     * 
     * @return SQL where clause for one Contractitem (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Contractitem (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Contractitems
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Contractitem
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        ContractitemPK contractitemPK = null;
        Contractitem contractitem;
        if(dbresult==null) {
            contractitem = new Contractitem(contractitemPK);
        } else {
            try {
                contractitemPK = new ContractitemPK(dbresult.getLong("id"));
                contractitem = new Contractitem(contractitemPK);
                contractitem.initEvetypePK(new EvetypePK(dbresult.getLong("evetype")));
                if(dbresult.wasNull()) contractitem.setEvetypePK(null);                
                contractitem.initContractPK(new ContractPK(dbresult.getLong("contract")));
                if(dbresult.wasNull()) contractitem.setContractPK(null);                
                contractitem.initBlueprint_copy(dbresult.getBoolean("blueprint_copy"));
                contractitem.initIncluded(dbresult.getBoolean("included"));
                contractitem.initQuantity(dbresult.getLong("quantity"));
                contractitem.initMaterial_efficiency(dbresult.getInt("material_efficiency"));
                contractitem.initRuns(dbresult.getInt("runs"));
                contractitem.initTime_efficiency(dbresult.getInt("time_efficiency"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return contractitem;
    }

}


/*
 * Created on Okt 8, 2021
 * Generated on 2.0.2022 18:23
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMcontract_default;
import eve.logicentity.Contract;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMcontract extends EMcontract_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    public static final String SQLSelect4Region = SQLSelect + " left join station ON station.id = contract.start_location_id " +
        "left join system on system.id = station.system_id " +
        "left join constellation on constellation.id = system.constellation " +
        "where constellation.region = :region.id: or constellation.region is null";
    public static final String SQLtruncate = "truncate contractitem, contract";
    public static final String SQLdeactivate = "update contract set active = false";
    public static final String SQLactivatecontract = "update contract set active = true where " + SQLWhere1;
    public static final String SQLdeletedeactivatedcontacts = "delete from contract where not active";
    
    public static final String SQLcontracts4type = SQLSelect + " where type = :type:";

    /**
     * Map ResultSet Field values to Contract
     * @param dbresult: Database ResultSet
     * @return Contract
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Contract contract = (Contract)super.mapResultSet2Entity(dbresult);
        return contract;
    }    
    
}


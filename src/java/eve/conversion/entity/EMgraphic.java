/*
 * EMgraphic.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMgraphic_default;
import eve.logicentity.Graphic;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMgraphic
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMgraphic extends EMgraphic_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Graphic
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Graphic graphic = (Graphic)super.mapResultSet2Entity(dbresult);
        return graphic;
    }    
    
}


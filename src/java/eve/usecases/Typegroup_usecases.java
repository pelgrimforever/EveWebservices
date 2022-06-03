/*
 * Generated on 20.4.2022 10:3
 */

package eve.usecases;

import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Typegroup;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Typegroup_usecases {

    private boolean loggedin = false;
    private BLtypegroup bltypegroup = new BLtypegroup();
    
    public Typegroup_usecases() {
        this(false);
    }
    
    public Typegroup_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        bltypegroup.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return bltypegroup.count();
    }
    
    public ArrayList<Typegroup> get_all() throws DBException {
        return bltypegroup.getTypegroups();
    }
    
    public boolean getTypegroupExists(ITypegroupPK typegroupPK) throws DBException {
        return bltypegroup.getEntityExists(typegroupPK);
    }
    
    public Typegroup get_typegroup_by_primarykey(ITypegroupPK typegroupPK) throws DBException {
        return bltypegroup.getTypegroup(typegroupPK);
    }

    public ArrayList<Typegroup> get_typegroup_with_foreignkey_category(ICategoryPK categoryPK) throws CustomException {
        return bltypegroup.getTypegroups4category(categoryPK);
    }
    
    public ArrayList<Typegroup> search_typegroup(ITypegroupsearch typegroupsearch) throws CustomException {
        return bltypegroup.search(typegroupsearch);
    }
    
    public long search_typegroup_count(ITypegroupsearch typegroupsearch) throws CustomException {
        return bltypegroup.searchcount(typegroupsearch);
    }

    public void secureinsertTypegroup(ITypegroup typegroup) throws DBException, DataException {
        bltypegroup.secureinsertTypegroup(typegroup);
    }

    public void secureupdateTypegroup(ITypegroup typegroup) throws DBException, DataException {
        bltypegroup.secureupdateTypegroup(typegroup);
    }

    public void securedeleteTypegroup(ITypegroup typegroup) throws DBException, DataException {
        bltypegroup.securedeleteTypegroup(typegroup);
    }
}


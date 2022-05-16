package eve.usecases;

import eve.BusinessObject.Logic.BLalliance;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;
import org.mockito.plugins.MockMaker;

/**
 *
 * @author pelgrim
 */
public class Alliance_usecasesTest {
    
    public Alliance_usecasesTest() {
        MockMaker m;
    }

    @InjectMocks
    private BLalliance blalliance;
    private Alliance_usecases instance;
    
    @BeforeEach
    void initService() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testCount() throws Exception {
        //FieldSetter.setField(instance, "blalliance", blalliance);
        doReturn(0l).when(blalliance).count();
        long count = instance.count();
        Assert.assertEquals(0, count);
    }

    @Test
    public void testGet_all() throws Exception {
    }

    @Test
    public void testGetAllianceExists() throws Exception {
    }

    @Test
    public void testGet_alliance_by_primarykey() throws Exception {
    }

    @Test
    public void testGet_alliance_with_foreignkey_corporationCreator_corporation() throws Exception {
    }

    @Test
    public void testGet_alliance_with_foreignkey_corporationExecutor_corporation() throws Exception {
    }

    @Test
    public void testSearch_alliance() throws Exception {
    }

    @Test
    public void testSearch_alliance_count() throws Exception {
    }

    @Test
    public void testSecureinsertAlliance() throws Exception {
    }

    @Test
    public void testSecureupdateAlliance() throws Exception {
    }

    @Test
    public void testSecuredeleteAlliance() throws Exception {
    }
    
}

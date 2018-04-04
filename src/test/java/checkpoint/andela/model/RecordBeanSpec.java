package checkpoint.andela.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RecordBeanSpec {
    private RecordBean bean;
    private final String UNIQUEID = "412312";
    private final String COMMONNAME = "aadd lerqe";
    private final String TYPES ="34fsaaf";
    private final String CREDIT = "34weq";
    private final String ECNUMBER ="34134";
    private final String ENZYMATICREACTION ="efdf2er2";
    private final String INPATHWAY ="23erqf34";
    private final String SYSTEMATICNAME="wdt24r2";
    private String LEFT="wereqreqa";
    private final String RIGHT="wefwr2233";

    @Before
    public void before(){
        bean = new RecordBean(UNIQUEID, COMMONNAME,
                CREDIT, TYPES, ECNUMBER,
                ENZYMATICREACTION,INPATHWAY,
                SYSTEMATICNAME,LEFT,RIGHT);
    }

    @Test
    public void whenInstantiatedThenUniqueIdIsStored(){
        assertEquals(UNIQUEID, bean.getUNIQUEID());
    }

    public void whenInstantiatedThenCommonNameIsStored(){
        assertEquals(COMMONNAME, bean.getCOMMONNAME());
    }

    public void whenInstantiatedThenCreditIsStored(){
        assertEquals(CREDIT, bean.getCREDIT());
    }

    public void whenInstantiatedThenTypesIsStored(){
        assertEquals(TYPES, bean.getTYPES());
    }

    public void whenInstantiatedThenECNumberIsStored(){
        assertEquals(ECNUMBER, bean.getECNUMBER());
    }

    public void whenInstantiatedThenEnzymaticReactionIsStored(){
        assertEquals(ENZYMATICREACTION, bean.getENZYMATICREACTION());
    }

    public void whenInstantiatedThenInPathwayIsStored(){
        assertEquals(INPATHWAY, bean.getINPATHWAY());
    }

    public void whenInstantiatedThenSystematicNameIsStored(){
        assertEquals(SYSTEMATICNAME, bean.getSYSTEMATICNAME());
    }

    public void whenInstantiatedThenLeftIsStored(){
        assertEquals(LEFT, bean.getLEFT());
    }

    public void whenInstantiatedThenRighttIsStored() {
        assertEquals(RIGHT, bean.getRIGHT());
    }

    }

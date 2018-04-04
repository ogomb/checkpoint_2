package checkpoint.andela.model;

public class RecordBean {
    private String UNIQUEID;
    private String COMMONNAME;
    private String TYPES;
    private String CREDIT;
    private String ECNUMBER;
    private String ENZYMATICREACTION;
    private String INPATHWAY;
    private String SYSTEMATICNAME;
    private String LEFT;
    private String RIGHT;

    public RecordBean(String UNIQUEID, String COMMONNAME,
                 String TYPES, String CREDIT,
                 String ECNUMBER, String ENZYMATICREACTION,
                 String INPATHWAY, String SYSTEMATICNAME,
                 String LEFT, String RIGHT) {

        this.UNIQUEID = UNIQUEID;
        this.COMMONNAME = COMMONNAME;
        this.TYPES = TYPES;
        this.CREDIT = CREDIT;
        this.ECNUMBER = ECNUMBER;
        this.ENZYMATICREACTION = ENZYMATICREACTION;
        this.INPATHWAY = INPATHWAY;
        this.SYSTEMATICNAME = SYSTEMATICNAME;
        this.LEFT = LEFT;
        this.RIGHT = RIGHT;
    }

    public String getUNIQUEID() {
        return UNIQUEID;
    }

    public void setUNIQUEID(String UNIQUEID) {
        this.UNIQUEID = UNIQUEID;
    }

    public String getCOMMONNAME() {
        return COMMONNAME;
    }

    public void setCOMMONNAME(String COMMONNAME) {
        this.COMMONNAME = COMMONNAME;
    }

    public String getTYPES() {
        return TYPES;
    }

    public void setTYPES(String TYPES) {
        this.TYPES = TYPES;
    }

    public String getCREDIT() {
        return CREDIT;
    }

    public void setCREDIT(String CREDIT) {
        this.CREDIT = CREDIT;
    }

    public String getECNUMBER() {
        return ECNUMBER;
    }

    public void setECNUMBER(String ECNUMBER) {
        this.ECNUMBER = ECNUMBER;
    }

    public String getENZYMATICREACTION() {
        return ENZYMATICREACTION;
    }

    public void setENZYMATICREACTION(String ENZYMATICREACTION) {
        this.ENZYMATICREACTION = ENZYMATICREACTION;
    }

    public String getINPATHWAY() {
        return INPATHWAY;
    }

    public void setINPATHWAY(String INPATHWAY) {
        this.INPATHWAY = INPATHWAY;
    }

    public String getSYSTEMATICNAME() {
        return SYSTEMATICNAME;
    }

    public void setSYSTEMATICNAME(String SYSTEMATICNAME) {
        this.SYSTEMATICNAME = SYSTEMATICNAME;
    }

    public String getLEFT() {
        return LEFT;
    }

    public void setLEFT(String LEFT) {
        this.LEFT = LEFT;
    }

    public String getRIGHT() {
        return RIGHT;
    }

    public void setRIGHT(String RIGHT) {
        this.RIGHT = RIGHT;
    }

}

package CrossCutting;

public class StubExtensionMgr implements IExtensionMgr {
    private static logFileStatus=null;
    public void StubExtensionMgr(String value) {
        logFileStatus=value;
    }
    public String ReadLogFileToGetStatus(String fileName) {
        return logFileStatus;
    }
}

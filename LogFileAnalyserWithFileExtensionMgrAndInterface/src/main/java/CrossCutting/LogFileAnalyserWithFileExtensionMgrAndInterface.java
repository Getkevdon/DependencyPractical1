package CrossCutting;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.filechooser.FileSystemView;
public class LogFileAnalyserWithFileExtensionMgrAndInterface {
    private Boolean lastLogFileStatus = null;
    public IExtensionMgr theMgr;

    public LogFileAnalyserWithFileExtensionMgrAndInterface(IExtensionMgr theExtensionMgr) {
        theMgr = theExtensionMgr;
    }

    public Boolean AnalyseLogFile(String fileName) {
// First piece of business logic is to check that the Logfile has a valid extension. Unit tests need to test this.
        if (!fileName.endsWith(".log")) {
            return false; //LogFile extension is invalid
        }
// Next open the Log file and read the log status
        String status = theMgr.ReadLogFileToGetStatus(fileName);
        if (status == "Normal Log") {
            lastLogFileStatus = true;
            return true;
        } else
            if (status == "Monitored system crshed"){
                return false;
            }
            else
                return false;
    }
}
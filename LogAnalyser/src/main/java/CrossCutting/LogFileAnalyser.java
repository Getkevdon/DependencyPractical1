package CrossCutting;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.filechooser.FileSystemView;
public class LogFileAnalyser
{
    private Boolean lastLogFileStatus=null;
    private String path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+ "\\Logs\\";
    public Boolean AnalyseLogFile(String fileName)
    {
// First piece of business logic is to check that the Logfile has a valid extension. Unit tests need to test this.
        if(!fileName.endsWith(".log"))
        {
            return false; //LogFile extension is invalid
        }
// Next open the Log file and read the log status
        String readMeText;
        String status = null;
        try
        {
            System.out.println("Reading actual log file on disk --> You should not be seeing this from Unit tests");
            File file = new File(path+fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            readMeText = br.readLine();
            if (readMeText.contains("Exception"))
            {
                status= "Monitored system crashed"; //As the word Exception was in the log file
            }
            else //anything else in the log is a normal log
            {
                status= "Normal Log";
            }
            br.close();
            file.delete(); // Delete the log file as I don't want to process it again
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("You must pick Option 1. or Option 2 before you pick Option 3. Run the Simulator again!\n");
// System.exit(0);
        }
// The status is read from the logFile. Next is the business logic which is to be tested by unit tests
        if(status=="Normal Log") // This is business logic which is to be tested by unit tests
        {
            lastLogFileStatus=true;
            return true;
        }
        else
        if(status=="Monitored system crashed") // This is business logic which is to be tested by unit tests
        {
            lastLogFileStatus=false;
            return false;
        }
        else
            return false; //Anything else in the Log file indicates a problem
    }
}
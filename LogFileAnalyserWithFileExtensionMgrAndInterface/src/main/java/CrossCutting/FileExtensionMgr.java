package CrossCutting;

import javax.swing.filechooser.FileSystemView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileExtensionMgr implements IExtensionMgr {
    private String path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"\\Logs\\";
    @Override
    public String ReadLogFileToGetStatus(String fileName) {
        System.out.println("Reading actual log file on disk --> You should not be seeing this from Unit tests");
        String readMeText;
        String status = null;
        try {
            File file = new File(path+fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            readMeText = br.readLine();
            if(readMeText.contains("Exception")){
                status = "Monitored system crashed";
            }
            else {
                status = "Normal Log";
            }
            br.close();
            file.delete();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("You must pick Option1. or Option2. before you pick Option3. Run the Simulator again!\n");
            System.exit(0);
        }
        return status;
    }
}

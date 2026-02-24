package CrossCutting;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class LogFileAnalyserTest {
    @Test
    public void AnalyseLogFile_ValidNormalLog_ReturnsTrue() {
// Arrange
        System.out.println("isValidLogFileName");
        String fileName = "LogFile.log";
        LogFileAnalyser instance = new LogFileAnalyser();
        Boolean expResult = true;
// Act
        Boolean result = instance.AnalyseLogFile(fileName);
// Assert
        assertEquals(expResult, result);
    }
    @Test
    public void AnalyseLogFile_ValidNormalLog_CrashTest() {
// Arrange
        System.out.println("isValidLogFileName");
        String fileName = "LogFile.log";
        LogFileAnalyser instance = new LogFileAnalyser();
        Boolean expResult = false;
// Act
        Boolean result = instance.AnalyseLogFile(fileName);
// Assert
        assertEquals(expResult, result);
    }
    @Test
    public void AnalyseLogFile_ValidNormalLog_FileExtension() {
// Arrange
        System.out.println("isValidLogFileName");
        String fileName = "LogFile.txt";
        LogFileAnalyser instance = new LogFileAnalyser();
        Boolean expResult = false;
// Act
        Boolean result = instance.AnalyseLogFile(fileName);
// Assert
        assertEquals(expResult, result);
    }
}
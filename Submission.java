import java.io.File;
import java.io.FileNotFoundException;

/**
 * Submission.java
 *
 * @author Michelle Melton
 * @author Kara Beason
 * @author Cydney Caldwell
 */

/**
 * Class for a Scratch submission.
 *
 * @author Michelle Melton
 * @author Kara Beason
 * @author Cydney Caldwell
 * @version Mar 2017
 */
public class Submission
{
    private File sb2;
    private File zipsDir;
    private File unzipsDir;
    private File json;
    
    /**
     * Submission constructor.
     *
     * @param sb2  
     */
    public Submission(File sb2)
    {
        this.sb2 = sb2;
        zipsDir = new File("zips");
        unzipsDir = new File("unzips");
    }

    /**
     * Get filename of submission.
     *
     * @return filename
     */
    public String getName()
    {
        return sb2.getName();
    }

    /**
     * Check if valid .sb2.
     *
     * @return true if valid .sb2
     */
    public boolean isValid()
    {
        String sb2Name = sb2.getName();
        int len = sb2Name.length();
        String ext = sb2Name.substring(len - 4);
        return ext.equals(".sb2") && sb2.isFile();
    }

    /**
     * Convert .sb2 to .zip.
     * Handles valid .sb2 test internally.
     */
    public void convertToZip()
    {
        if (isValid())
        {
            FileUtils.convertToZip(zipsDir, sb2);
        }
    }

    /**
     * Unzip file. 
     * Handles valid .sb2 test internally.
     */
    public void unZip()
    {
        if (isValid())
        {
            FileUtils.unZip(zipsDir, unzipsDir, sb2);
        }
    }

    /**
     * Parse JSON file.
     *
     * @param filepath path to JSON file.
     * @return name
     * @throws FileNotFoundException
     */
    /*
    public String parseJSONFile(String filePath)
        throws FileNotFoundException
    {
        String returned = "";
        try
        {
            returned = FileUtils.parseJSONFile(filePath);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return returned;
    }*/
}

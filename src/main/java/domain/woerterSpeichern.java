package domain;

import java.io.*;
import java.util.Date;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.Date;
import java.util.Properties;

public class woerterSpeichern {

/**
 * handling the user file in the home directory
 */


    private static final Logger LOG = LogManager.getLogger(woerterSpeichern.class);
    private final String propFileName = "Woerter";
    private final String appName = "woerterDatenBank";
    private final String appFolder;
    private final String propFileNameUserHomePath;

    public woerterSpeichern() {
        appFolder = System.getProperty("user.dir") + File.separator + appName;
        propFileNameUserHomePath  = appFolder + File.separator + propFileName;
    }

    /**
     * Write properties to the user home file. If the properties exist - nothing will be done.
     * If they are not existing - then create the file and write the initial properties
     * @param prop the initial properties to write
     * @throws IOException in case of file errors
     */
    public void writePropertyFileToUserHome(Properties prop) throws IOException {
        createUserHomeFolder();
        if (new File(propFileNameUserHomePath).isFile()) {
            LOG.info(propFileNameUserHomePath + " already present, will not change the property file!");
        } else {
            LOG.info(propFileNameUserHomePath + " property file NOT present, we will initialize the file with the properties from the resources");
            saveProperties(prop);
        }
    }

    /**
     * Read the properties from the resource folder
     * @return the properties
     * @throws IOException In case the properties are not present
     */
    public Properties getPropValuesFromResource() throws IOException {
        Properties prop = new Properties();
        try (InputStream inputStream = getClass().getResourceAsStream(propFileName)) {

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            // get the property value and print it out
            String user = prop.getProperty("user");
            String company1 = prop.getProperty("company1");
            String company2 = prop.getProperty("company2");
            String company3 = prop.getProperty("company3");

            String result = "Company List = " + company1 + ", " + company2 + ", " + company3;
            LOG.info(result + "\nProgram Ran on " + time + " by user=" + user);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return prop;
    }

    /**
     * Save the properties to the user home folder
     * @param prop the properties to save
     * @throws IOException in case of problems with the file
     */
    public void saveProperties(Properties prop) throws IOException {

        try (FileOutputStream outputStream = new FileOutputStream(propFileNameUserHomePath)) {
            prop.store(outputStream, "Properties");
            LOG.info("Properties: " + prop + " saved to " + propFileNameUserHomePath);
        }
    }

    private void createUserHomeFolder() throws IOException {

        File f=new File(appFolder);
        if(!f.exists()) {
            boolean success = f.mkdir();
            if (!success) {
                throw new IOException("cannot create " + appFolder);
            } else {
                LOG.info(appFolder + " created");
            }
        }
        else {
            LOG.info(appFolder + " already present!");
        }

    }
}

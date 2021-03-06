package scidir;

import java.io.File;


public class Scidir
{

    private static final File metadatadir = new File(System.getProperty("user.home")+File.separator + "SciSort" + File.separator + "metadata");
    private static final File papersdir = new File(System.getProperty("user.home")+File.separator + "SciSort" + File.separator + "papers");

    public static File MetadataDIR()
    {
	return metadatadir;
    }
    public static File PapersDIR()
    {
	return papersdir;
    }
    
    public static boolean canAccess()
    {
	boolean metaAccess;
	boolean paperAccess;
	
	if(metadatadir.exists())
	    metaAccess=true;
	else
	    {
		//Try to create the main directories if they don't exist
		metaAccess = metadatadir.mkdirs();			
	    }

	if(papersdir.exists())
	    paperAccess=true;
	else
	    {
		//Try to create the main directories if they don't exist
		paperAccess = papersdir.mkdirs();			
	    }

	if(metaAccess && paperAccess)
	    return true;
	else
	    return false; 
	
    }
}

package scipaper;

import exceptions.DateException;
import java.io.File;

public class Scipaper
{

    public Scipaper()
    {
	;
    }
    public Scipaper(String filename)
	throws Exception
    {
	File metadatadir = new File(System.getProperty("user.home")+File.separator + "SciSort" + File.separator + "metadata");
	File papersdir = new File(System.getProperty("user.home")+File.separator + "SciSort" + File.separator + "papers");

	File paperfile = new File(System.getProperty("user.dir") + File.separator + filename+".pdf");
	
	if(!metadatadir.exists() && !papersdir.exists())
	    {
		if(metadatadir.mkdirs())
		    System.out.println("Created the metadata directory.");
		else
		    System.out.println("Cannot create the metadata directory.");
		if(papersdir.mkdirs())
		    System.out.println("Created the papers directory.");
		else
		    System.out.println("Cannot create the papers directory.");
				
	    }

	if(paperfile.exists() && paperfile.isFile() && paperfile.canRead())
	    {		
		this.filename=filename;
	    }
	else
	    throw new Exception();
	
    }

    private String nickname;
    private String filename;
    private String sciname;
    
    private String author;
    private String institution;

    private int year;
    private int month;
    private int day;

    private String journal;
    private String field;
    private String subfield;
    private String subsubfield;

    private boolean pdfexists=false; // Assume it doesn't exist
    private boolean metaexists=false; // Assume it doesn't exist


    public void setNickname(String nickname)
    {
	this.nickname=nickname;
    }
    public void setFilename(String filename)
    {
	this.filename=filename;
    }
    public void setSciname(String sciname)
    {
	this.sciname=sciname;
    }
    
    public void setAuthor(String author)
    {
	this.author=author;
    }
    public void setInstitution(String institution)
    {
	this.institution=institution;
    }

    public void setYear(String year)
	throws DateException
    {
	this.year=Integer.parseInt(year);
    }
    public void setMonth(String month)
	throws DateException
    {
	this.month=Integer.parseInt(month);
    }
    public void setDay(String day)
	throws DateException
    {
	this.day=Integer.parseInt(day);
    }

    





    
}

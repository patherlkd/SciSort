package scipaper;

import colorx.*;
import exceptions.date.*;
import java.io.File;
import java.util.Calendar;
import scidir.Scidir;

public class Scipaper
{

    public Scipaper()
    {
	;
    }
    public Scipaper(String filename) // For writing a newfile
	throws Exception
    {
	origfile = new File(System.getProperty("user.dir") + File.separator + filename); // original pdf
	// Check if the main metadata and papers directories exist.. other wise the whole thing is pointless.
    	if(Scidir.canAccess());
	else
	    throw new Exception("Cannot access metadata or papers directories.");
	
	if(origfile.exists() && origfile.isFile() && origfile.canRead())
	    {		
		this.filename=filename;
	    }
	else
	    throw new Exception();	
    }

    public String toString()
    {
	String scipaperprint;
	
	if(sciname != null)
	    scipaperprint = Colorx.GREEN("\n\nSci_filename: ")+sciname;
	else
	    return null;
	scipaperprint+="\n";
	scipaperprint+="___________________________________________________\n";
	if(nickname != null)
	    scipaperprint += Colorx.BLUE("nickname: ")+nickname;
	scipaperprint+="\n";
	if(author != null)
	    scipaperprint += Colorx.BLUE("author: ")+author;
	scipaperprint+="\n";
	if(year != 0)
	    scipaperprint += Colorx.PURPLE("year: ")+year;
	scipaperprint+="\n";
	if(month != 0)
	    scipaperprint += Colorx.PURPLE("month: ")+month;
	scipaperprint+="\n";
	if(day != 0)
	    scipaperprint += Colorx.PURPLE("day: ")+day;
	scipaperprint+="\n";
	if(institution != null)
	    scipaperprint += Colorx.YELLOW("institution: ")+institution;
	scipaperprint+="\n";
	if(journal != null)
	    scipaperprint += Colorx.YELLOW("journal: ")+journal;
	scipaperprint+="\n";
	if(field != null)
	    scipaperprint += Colorx.RED("\nfields:\n\n")+field;
	if(subfield != null){
	    scipaperprint += Colorx.RED("\n|\n");
	    scipaperprint += Colorx.RED("--->")+subfield;}
	if(subsubfield != null){
	    scipaperprint += Colorx.RED("\n    |\n");
	    scipaperprint += Colorx.RED("    ------>")+subsubfield;}
	if(subsubsubfield != null){
	    scipaperprint += Colorx.RED("\n       |\n");
	    scipaperprint += Colorx.RED("       -----------> ")+subsubsubfield;}
	scipaperprint+="\n_________________________________________________|\n";
	
	return scipaperprint;	
    }

    public void setDIRs()
	throws Exception
    {
	metadatumPlace = new File(Scidir.MetadataDIR(),"fill in later");
	paperPlace = new File(Scidir.PapersDIR(), "fill in later");
    }
    
    private File origfile;
    private File metadatumPlace; // specific directory for metadata for this file
    private File paperPlace; // specific directory for the paper for this file
    private String paperExt =".pdf"; // e.g. '.pdf' or w.e.  for now we use .pdf
    private final String metaExt = ".md"; //generic metadata extension for SciSort command utilities

    
    private Calendar cal = Calendar.getInstance();
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
    private String subsubsubfield;
    
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
    public void setSciname()
    {
	this.sciname=this.nickname+"+"+this.author;
	this.sciname+="+"+this.year+"+"+this.field;
	this.sciname+=paperExt;
    }
    
    public void setAuthor(String author)
    {
	this.author=author;
    }
    public void setInstitution(String institution)
    {
	this.institution=institution;
    }
    public void setJournal(String journal)
    {
	this.journal=journal;
    }

    public void setYear(String Year)
	throws DateException
    {
	int y = Integer.parseInt(Year);
	if(y < cal.get(Calendar.YEAR))
	    this.year=y;
	else
	    throw new DateException("Year entry not valid: Cannot have a paper published ahead in time. What is this FUTURAMA?!.");
    }
    public void setMonth(String month)
	throws DateException
    {
	int m = Integer.parseInt(month);
	if(m <= 12 && m > 0)
	    this.month= m;
	else
	    throw new DateException("Month entry not valid: There are only 12 months in a year.");
    }
    public void setDay(String day)
	throws DateException
    {
	int d = Integer.parseInt(day);
	if(d <= 31 && d > 0)
	    this.day=d;
	else
	    throw new DateException("Day entry not valid: Must be 1 - 31. Really!?  Yes really -_- .");
    }

    public void setField(String field)
    {
	this.field=field;
    }
    public void setsubField(String subfield)
    {
	this.subfield=subfield;
    }
    public void setsubsubField(String subsubfield)
    {
	this.subsubfield=subsubfield;
    }
    public void setsubsubsubField(String subsubsubfield)
    {
	this.subsubsubfield=subsubsubfield;
    }

    public String getNickname()
    {
	return this.nickname;
    }
    public String getFilename()
    {
	return this.filename;
    }
    public String getSciname()
    {
	return this.sciname;
    }
    
    public String getAuthor()
    {
	return this.author;
    }
    public String getInstitution()
    {
	return this.institution;
    }
    public String getJournal()
    {
	return this.journal;
    }

    public int getYear()	
    {
	return this.year;
    }
    public int getMonth()
    {
	return this.month;
    }
    public int getDay()
    {
	return this.day;
    }

    public String getfield()
    {
	return	this.field;
    }
    public String getsubfield()
    {
	return this.subfield;
    }
    public String getsubsubfield()
    {
	return	this.subsubfield;
    }
    public String getsubsubsubfield()
    {
	return	this.subsubsubfield;
    }
}

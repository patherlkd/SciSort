import scipaper.*;
import commandline.*;
import exceptions.date.*;
import exceptions.emptyfield.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import colorx.*;

public class SciAdd
{    

    public static void main(String[] args)
    {// sciAdd runs this
	
	List<Option> optionlist = new ArrayList<Option>();
        Scipaper paper = new Scipaper();
	
	docommandline(args,optionlist,paper);
	applyoptions(optionlist, paper);
	System.out.println(Colorx.GREEN("\n\t Added: \n")+paper);
	
    }
    

    // ==================================   METHODS AND VARS =======================================
    private static void help()
    {
	System.out.println(Flagtypes.help());
	System.exit(0);
    }

    private static void applyoptions(
				     List<Option> optionlist,
				     Scipaper paper)
    {// Parse command line arguments to the Scipaper class.
	checkoptions(optionlist);
	if(verbose)
	    System.out.println("Attempting to apply specified options to a Scipaper class.");
	
	for(int o=0; o<optionlist.size();++o)
	    {
		if(verbose)
		    System.out.println(optionlist.get(o));
		switch(optionlist.get(o).flag)
		    {
		    case Flagtypes.nickFlag:
			paper.setNickname(optionlist.get(o).option);
			break;
			
		    case Flagtypes.authFlag:
			paper.setAuthor(optionlist.get(o).option);
			break;
			
		    case Flagtypes.instiFlag:
			paper.setInstitution(optionlist.get(o).option);
			break;
			
		    case Flagtypes.journFlag:
			paper.setJournal(optionlist.get(o).option);
			break;
			
		    case Flagtypes.yearFlag:
			try
			    {
				paper.setYear(optionlist.get(o).option);
			    }
			catch(DateException de)
			    {
				System.out.println(de);
				System.exit(0);
			    }
			break;
			
		    case Flagtypes.monthFlag:
			try
			    {
				paper.setMonth(optionlist.get(o).option);
			    }
			catch(DateException de)
			    {
				System.out.println(de);
				System.exit(0);
			    }
		
			break;
			
		    case Flagtypes.dayFlag:
			try
			    {
				paper.setDay(optionlist.get(o).option);
			    }
			catch(DateException de)
			    {
				System.out.println(de);
				System.exit(0);
			    }
			break;
			
		    case Flagtypes.fieldFlag:
			paper.setField(optionlist.get(o).option);
			break;
			
		    case Flagtypes.subfieldFlag:
			paper.setsubField(optionlist.get(o).option);
			break;
			
		    case Flagtypes.subsubfieldFlag:
			paper.setsubsubField(optionlist.get(o).option);
			break;
			
		    case Flagtypes.subsubsubfieldFlag:
			paper.setsubsubsubField(optionlist.get(o).option);
			break;
			
		    default:
			break;
		    }
			    

	    }
	paper.setSciname();
	if(verbose)
	    System.out.println("\nGreat. Your paper has the correct information for SciSort!");

	
    }

    
    private static void checkoptions(List<Option> optionlist)
    {// User must supply -n, -a, -y and -f for SciAdd and hence SciSort to be useful at all
	//Also looks for faulty options
	boolean hasnick=false;
	boolean hasauth=false;
	boolean hasyear=false;
	boolean hasfield=false;

	try
	    {
		if(verbose)
		    System.out.println("Checking for any flags not supported by the sciAdd utility.");
		Flagtypes.checkbadflags(optionlist);
		
	    }
	catch(IllegalArgumentException iae)
	    {
		if(verbose)
		    System.out.println("Well.. you parsed flags which I don't know how to handle. Screw this, I'm off for a pint.");
		System.out.println(iae);
		System.exit(0);
	    }	
	
	if(verbose)
	    System.out.println("Ensuring user has supplied -n <nickname> -a <author> -d <date> and -f <some_field>.");
	try
	    {
		for(int i=0; i<optionlist.size();++i)
		    {
			switch(optionlist.get(i).flag)
			    {
			    case Flagtypes.nickFlag:
				hasnick=true;
				break;
			    case Flagtypes.authFlag:
				hasauth=true;
				break;
			    case Flagtypes.yearFlag:
				hasyear=true;
				break;
			    case Flagtypes.fieldFlag:
				hasfield=true;
				break;
			    default:
				break;
			    }
		    }
		if(verbose)
		    {
			System.out.println("Parsed nickname? : "+hasnick+"\n"+"Parsed author? : "+hasauth+"\n"+"Parsed year? : "+hasyear+"\n"+"Parsed Sci-field? : "+hasfield+"\n");
		    }
		if(!hasnick || !hasauth || !hasyear || !hasfield)
		    throw new IllegalArgumentException("You must supply a nickname for your paper, the first author, the year yyyy and at least the relevant scientific field."); 
	    }
	catch(IllegalArgumentException ae)
	    {
		System.out.println(ae);
		System.exit(0);
	    }

	
	
    }



    private static void docommandline(
				 String[] args,
				 List<Option> optionlist,
				 Scipaper paper)
    {
	String versionFile = System.getProperty("user.home")+File.separator+"SciSort"+File.separator+"SciSort"+File.separator+"VERSION.md";
	
	if(args.length==0)
	    {
		System.out.println("You need to pass command line arguments.");
		System.exit(0);
	    }
       

	if(args[0].equals(Flagtypes.helpFlag) || args[0].equals(Flagtypes.longhelpFlag))
	    help();
	else if(args[0].equals(Flagtypes.versFlag))
	    {
		try (BufferedReader br = new BufferedReader(new FileReader(versionFile)))
		    {
			String line;
			while(( line = br.readLine()) != null)
			    {
				System.out.println(line);
			    }
			
			
		    }
		catch(IOException ioe)
		    {
			ioe.printStackTrace();
		    }
		finally
		    {
			System.exit(0);
		    }
	    }
	
	try
	    {
		
		Scipaper paper1 = new Scipaper(args[0]);
		paper=paper1;
	    }
	catch(Exception e)
	    {
		System.out.println("Uh oh problem locating the file "+args[0]);
		System.exit(0);
	    }
	// filename should ALWAYS be first
	
	try
	    {
		for(int argc=1; argc < args.length; ++argc)
		    {
			switch (args[argc].charAt(0))
			    {
			    case '-':
				if(Flagtypes.checkflagexists(args[argc]))
				    {
					if(args[argc].equals(Flagtypes.verbFlag))
					    {
						verbose=true;
						optionlist.add(new Option(args[argc],"verbose_option"));
						System.out.println("Verbosity turned on. I will tell you what I'm doing.");
						break;
					    }
					else
					    {
						try
						    {
							optionlist.add(new Option(args[argc],args[argc+1]));
						    }
						catch(ArrayIndexOutOfBoundsException aobe)
						    {
							System.out.println("Using flags one must place an option e.g.  -a <option>.");
							System.exit(0);
						    }
					    }
				    }
				else
				    {
					throw new IllegalArgumentException("\n Incorrect command line argument(s). Type sciAdd -h or --help for help.\n ");
				    }
				
				break;
			    default:
				break;
			    }
			
		    }
		
	    }
	catch(IllegalArgumentException ae)
	    {
		System.out.println(ae);
		System.exit(0);
	    }
	
}

    // PRIVATE VARS
    private static boolean verbose=false;
    
     
}

import scipaper.*;
import commandline.*;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SciAdd
{    

   
    private static boolean verbose;

    private static void help()
    {
	System.out.println(Flagtypes.help());
	System.exit(0);
    }


    private static void checkoptions(List<Option> optionlist)
    {// User must supply -n, -a, -d and -f for SciSort to be useful at all
	boolean hasnick=false;
	boolean hasauth=false;
	boolean hasdate=false;
	boolean hasfield=false;

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
			    case Flagtypes.dateFlag:
				hasdate=true;
				break;
			    case Flagtypes.fieldFlag:
				hasfield=true;
				break;
			    default:
				break;
			    }
		    }
		if(!hasnick || !hasauth || !hasdate || !hasfield)
		    throw new IllegalArgumentException("You must supply a nickname for your paper, the first author, the date ddmonthyyyy e.g. 26sep2017 and at least the relevant scientific field."); 
	    }
	catch(IllegalArgumentException ae)
	    {
		System.out.println(ae);
		System.exit(0);
	    }
    }
    
    public static void main(String[] args)
    {
	List<Option> optionlist = new ArrayList<Option>();
        Scipaper paper;

	if(args.length==0)
	    {
		System.out.println("You need to pass command line arguments.");
		System.exit(0);
	    }
       

	if(args[0].equals(Flagtypes.helpFlag) || args[0].equals(Flagtypes.longhelpFlag))
	    help();
	
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
				if(args[argc].length() == 2)
				    {
					if(args[argc].equals(Flagtypes.verbFlag))
					    {
						verbose=true;
						System.out.println("Verbosity turned on. I will tell you what I'm doing.");
						break;
					    }
					
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
				else
				    {
					throw new IllegalArgumentException("\nUsing flags one must place a flag key. e.g. -a not solely - . Type sciAdd <file_name_without_extension> -h for help. ");
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
	
	/*for(int i = 0; i< optionlist.size(); i++)
	  {
	  if(optionlist.get(i).flag.equals(Flagtypes.verbFlag))
	  {
	  verbose=true;
	  System.out.println("Verbosity turned on. I will tell you what I'm doing.");
	  }
	  }*/
	checkoptions(optionlist);
	
    }
   
}

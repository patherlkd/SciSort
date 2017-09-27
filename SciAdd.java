import scipaper.*;
import commandline.*;
import java.util.List;
import java.util.ArrayList;

public class SciAdd
{    

    private static Flagtypes Flags = new Flagtypes();
    private static boolean verbose;

    private static void help()
    {
	System.out.println(Flags);
	System.exit(0);
    }


    
    
    public static void main(String[] args)
    {
	List<Option> optionlist = new ArrayList<Option>();
        Scipaper paper;

	if(args.length==0)
	    {
		System.out.println("You need to pass command line arguments.");
	    }
	else
	    {

		if(args[0].equals(Flags.helpFlag) || args[0].equals(Flags.longhelpFlag))
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

		for(int i = 0; i< optionlist.size(); i++)
		    {
			if(optionlist.get(i).flag.equals("-v"))
			    {
				verbose=true;
				System.out.println("Verbosity turned on. I will tell you what I'm doing.");
			    }
		    }
		
	    }
    }
   
}

package commandline;

import colorx.*;
import java.util.*;
import commandline.Option;

public final class Flagtypes
{
    public static String help()
    {
	return Colorx.GREEN("Usage:\n\n")+"sciAdd <filename> [Command flags..]\n"+
	    "sciAdd [Help flags..]\n"+
	    Colorx.CYAN("\nHelp flags :\n\n")+"[ Help: "+helpFlag+" "+longhelpFlag+" ]\n" +
	    "[ Version:\t\t\t\t\t"+versFlag+" ]\n" +
	    Colorx.BLUE("\nCommand flags :\n\n") +
	    "[ Verbose:\t\t\t\t\t"+verbFlag+" ]\n" +
	    "[ Nickname:\t\t\t\t\t"+nickFlag+" <nickname>]\n" +
	    "[ Author(1st):\t\t\t\t\t"+authFlag+" <author>]\n" +
	    "[ Institution of author(1st):\t\t\t\t\t"+instiFlag+" <institution>]\n" +
	    "[ Journal:\t\t\t\t\t"+journFlag+" <journal>]\n" +
	    "[ Year of publication:\t\t\t\t\t"+yearFlag+" <year>]\n" +
	    "[ Month of publication:\t\t\t\t\t"+monthFlag+" <month>]\n" +
	    "[ Day of publication:\t\t\t\t\t"+dayFlag+" <day>]\n" +
	   
	    "[ Main scientific field of paper:\t\t\t\t\t"+fieldFlag+" <sci-field>]\n" +
	    "[ Sub-field:\t\t\t\t\t"+subfieldFlag+" <sci-sub-field>]\n" +
	    "[ Sub-sub-field:\t\t\t\t\t"+subsubfieldFlag+" <sci-sub-sub-field>]\n" +
	    "[ Sub-sub-sub-field:\t\t\t\t\t"+subsubsubfieldFlag+" <sci-sub-sub-sub-field]"+'\n';
    }

    public static boolean checkflagexists(String flag)
    {
	for(int i=0;i<allflags.length;++i)
	    {
		if(flag.equals(allflags[i]))
		    return true;
	    }
	return false;
    }
    
    public static final void checkbadflags(List<Option> options)
	throws IllegalArgumentException
    {

	IllegalArgumentException repeatflag = new IllegalArgumentException("You cannot repeat flags. It's just confusing.");
	
	boolean h=false;
	boolean lh=false;
	boolean vb=false;
	boolean vs=false;
	
	boolean n=false;
	boolean a=false;
	boolean i=false;
	boolean j=false;
	
	boolean y=false;
	boolean m=false;
	boolean d=false;

	boolean f=false;
	boolean sf=false;
	boolean ssf=false;
	boolean sssf=false;
	
	for(int o=0; o<options.size();++o)
	    {
		if(options.get(o).option.charAt(0)=='-')
		    throw new IllegalArgumentException("A flag cannot be an option, nor an option a flag (I'm literary I know).");
		switch(options.get(o).flag)
		    {
		    case helpFlag:
			if(h)
			    throw repeatflag;
			else
			    h=true;
			break;
			
		    case longhelpFlag:
			if(lh)
			    throw repeatflag;
			else
			    lh=true;
			break;
			
		    case verbFlag:
			if(vb)
			    throw repeatflag;
			else
			    vb=true;
			break;
			
		    case versFlag:
			if(vs)
			    throw repeatflag;
			else
			    vs=true;
			break;
			
		    case nickFlag:
			if(n)
			    throw repeatflag;
			else
			    n=true;
			break;
			
		    case authFlag:
			if(a)
			    throw repeatflag;
			else
			    a=true;
			break;
			
		    case instiFlag:
			if(i)
			    throw repeatflag;
			else
			    i=true;
			break;
			
		    case journFlag:
			if(j)
			    throw repeatflag;
			else
			    j=true;
			break;
			
		    case yearFlag:
			if(y)
			    throw repeatflag;
			else
			    y=true;
			break;
			
		    case monthFlag:
			if(m)
			    throw repeatflag;
			else
			    m=true;
			break;
			
		    case dayFlag:
			if(d)
			    throw repeatflag;
			else
			    d=true;
			break;
			
		    case fieldFlag:
			if(f)
			    throw repeatflag;
			else
			    f=true;
			break;
			
		    case subfieldFlag:
			if(sf)
			    throw repeatflag;
			else
			    sf=true;
			break;
			
		    case subsubfieldFlag:
			if(ssf)
			    throw repeatflag;
			else
			    ssf=true;
			break;
			
		    case subsubsubfieldFlag:
			if(sssf)
			    throw repeatflag;
			else
			    sssf=true;
			break;
			
		    default:
			throw new IllegalArgumentException(" Flag ["+options.get(o).flag+"] that you entered is not supported. Use sciAdd -h or --help for help.");
		    }
			    

	    }


	 if(sf)
	     if(f);
	     else
		 throw new IllegalArgumentException("That's odd. Checkoptions should have picked this up already");
	 else;
	 
	
	 if(ssf)
	     if(sf);
	     else
		 throw new IllegalArgumentException("A sub-sub-field must have a parent sub-field.");
	 else;

	 if(sssf)
	     if(ssf);
	     else
		 throw new IllegalArgumentException("A sub-sub-sub-field must have a parent sub-sub-field.");
	 else;
		 
		
	     
			
	    
	
    }
    
    public static final String helpFlag = "-h";
    public static final String longhelpFlag = "--help";
    public static final String verbFlag = "-v";
    public static final String versFlag = "--version";
    public static final String nickFlag = "-n";
    public static final String authFlag = "-a";
    public static final String instiFlag = "-i";
    public static final String journFlag = "-j";
    public static final String yearFlag = "-y";
        public static final String monthFlag = "-m";
        public static final String dayFlag = "-d";
    public static final String fieldFlag = "-f";
    public static final String subfieldFlag = "-sf";
    public static final String subsubfieldFlag = "-ssf";
    public static final String subsubsubfieldFlag = "-sssf";

    public static final String[] allflags = {helpFlag
					     ,longhelpFlag
					     ,verbFlag
					     ,versFlag
					     ,nickFlag
					     ,authFlag
					     ,instiFlag
					     ,journFlag
					     ,yearFlag
					     ,monthFlag
					     ,dayFlag
					     ,fieldFlag
					     ,subfieldFlag
					     ,subsubfieldFlag
					     ,subsubsubfieldFlag};
}

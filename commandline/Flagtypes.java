package commandline;


public final class Flagtypes
{
    public static String help()
    {
	return "The paper must be pdf! So e.g. <paper>.pdf will be passed as the first command line argument as sciAdd <paper> -> Then insert flags following:\n   \t\t*** [: Flags to use :] ***\n\n[ Help: "+helpFlag+" "+longhelpFlag+" ]\n" +
	    "[ Version: "+versFlag+" ]\n" +
	    "[ Verbose: "+verbFlag+" ]\n" +
	    "[ Nickname: "+nickFlag+" ]\n" +
	    "[ Author(1st): "+authFlag+" ]\n" +
	    "[ Institution of author(1st): "+instiFlag+" ]\n" +
	    "[ Journal: "+journFlag+" ]\n" +
	    "[ Date of publication ddmonthyyyy e.g. 11jul2011: "+dateFlag+" ]\n" +
	    "[ Main scientific field of paper: "+fieldFlag+" ]\n" +
	    "[ subfield: "+subfieldFlag+" ]\n" +
	    "[ sub-subfield: "+subsubfieldFlag+" ]\n" +
	    "[ sub-sub-subfield: "+subsubsubfieldFlag+" ]"+'\n';
    }
    
    public static final String helpFlag = "-h";
    public static final String longhelpFlag = "--help";
    public static final String verbFlag = "-v";
    public static final String versFlag = "--version";
    public static final String nickFlag = "-n";
    public static final String authFlag = "-a";
    public static final String instiFlag = "-i";
    public static final String journFlag = "-j";
    public static final String dateFlag = "-d";
    public static final String fieldFlag = "-f";
    public static final String subfieldFlag = "-sf";
    public static final String subsubfieldFlag = "-ssf";
    public static final String subsubsubfieldFlag = "-sssf";
}

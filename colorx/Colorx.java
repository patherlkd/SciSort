package colorx;

public class Colorx
{

    public static String BLACK(String txt)
    {
	return ANSI_BLACK+txt+ANSI_RESET;
    }
    public static String RED(String txt)
    {
	return ANSI_RED+txt+ANSI_RESET;
    }
    public static String GREEN(String txt)
    {
	return ANSI_GREEN+txt+ANSI_RESET;
    }
    public static String YELLOW(String txt)
    {
	return ANSI_YELLOW+txt+ANSI_RESET;
    }
    public static String BLUE(String txt)
    {
	return ANSI_BLUE+txt+ANSI_RESET;
    }
    public static String PURPLE(String txt)
    {
	return ANSI_PURPLE+txt+ANSI_RESET;
    }
    public static String CYAN(String txt)
    {
	return ANSI_CYAN+txt+ANSI_RESET;
    }
    public static String WHITE(String txt)
    {
	return ANSI_WHITE+txt+ANSI_RESET;
    }
    
    
    private final static String ANSI_RESET = "\u001B[0m";
    private final static String ANSI_BLACK = "\u001B[30m";
    private final static String ANSI_RED = "\u001B[31m";
    private final static String ANSI_GREEN = "\u001B[32m";
    private final static String ANSI_YELLOW = "\u001B[33m";
    private final static String ANSI_BLUE = "\u001B[34m";
    private final static String ANSI_PURPLE = "\u001B[35m";
    private final static String ANSI_CYAN = "\u001B[36m";
    private final static String ANSI_WHITE = "\u001B[37m";
}

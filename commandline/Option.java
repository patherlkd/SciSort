package commandline;

public class Option
{
    public String flag, option;
    public Option(
		  String flag,
		  String option)
    {
	this.flag= flag;
	this.option= option;
    }

    public String toString()
    {
	return flag+" "+option;
    }
}

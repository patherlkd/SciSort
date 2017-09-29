package exceptions.emptyfield;


public class EmptyFieldException extends Exception
{

    public EmptyFieldException()
    {
	super("Trying to access a metadata field which does not exist.");
    }

}

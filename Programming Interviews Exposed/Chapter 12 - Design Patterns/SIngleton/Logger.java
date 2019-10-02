// Implements a simple logging class using a singleton.
public class Logger {
    // Create and store the singleton.
    private static final Logger instance = new Logger();

    // Prevent anyone else from creating this class.
    private Logger(){
    }

    // Return the singleton instance.
    public static Logger getInstance() { return instance; }

    // Log a string to the console.
    //
    // example: Logger.getInstance().log(“this is a test”);
    //
    public void log( String msg ){
        System.out.println( System.currentTimeMillis() + ": " + msg );
    }
}
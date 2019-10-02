// Implements a simple logging class using a singleton.
public class Logger {
    // Inner class initializes instance on load, won’t be loaded
    // until referenced by getInstance()
    private static class LoggerHolder {
        public static final Logger instance = new Logger();
    }
    // Return the singleton instance.
    public static Logger getInstance() { return LoggerHolder.instance; }

    // Log a string to the console.
    //
    // example: Logger.getInstance().log(“this is a test”);
    //
    public void log( String msg ){
        System.out.println( System.currentTimeMillis() + ": " + msg );
    }
}
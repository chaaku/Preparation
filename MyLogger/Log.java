package MyLogger;

/**
 * A log service to allow application log different level of messages.
 * 
 * <p>
 * We will capture message data in a POJO instead of direct parameters like many
 * other logger implementation. This might seems verbose at first, but it
 * provide many benefits because a Message may have many optional data to be
 * logged. This design can keep this interface clean. You may use Message.msg()
 * factory method to shorten the code.
 * 
 * @author chandank
 */
public interface Log {
	public void error(Message message);

	public void warn(Message message);

	public void info(Message message);

	public void debug(Message message);

	public void trace(Message message);
}

/*
Trace - Only when I would be "tracing" the code and trying to find one part of a function specifically.
Debug - Information that is diagnostically helpful to people more than just developers (IT, sysadmins, etc.).
Info - Generally useful information to log (service start/stop, configuration assumptions, etc). 
		Info I want to always have available but usually don't care about under normal circumstances. 
		This is my out-of-the-box config level.
Warn - Anything that can potentially cause application oddities, but for which I am automatically recovering. (Such as switching from a primary to backup server, retrying an operation, missing secondary data, etc.)

Error - Any error which is fatal to the operation, but not the service or application (can't open a required file, missing data, etc.). These errors will force user (administrator, or direct user) intervention. These are usually reserved (in my apps) for incorrect connection strings, missing services, etc.

Fatal - Any error that is forcing a shutdown of the service or application to prevent data loss (or further data loss). I reserve these only for the most heinous errors and situations where there is guaranteed to have been data corruption or loss.

*/
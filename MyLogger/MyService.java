package MyLogger;

class MyService extends Thread {

	static Log LOG = LogFactory.createLog(MyService.class);

	@Override
	public void run() {
		LOG.info(Message.msg("%s service is running now.", this));
	}

}
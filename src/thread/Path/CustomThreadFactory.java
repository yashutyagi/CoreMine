package thread.Path;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread myThread = new Thread(r);
		return myThread;
	}

}

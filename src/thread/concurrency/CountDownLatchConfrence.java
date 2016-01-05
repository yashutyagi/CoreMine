package thread.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class Videoconference implements Runnable{
	private CountDownLatch controller;
	public Videoconference(int number) {
		controller = new CountDownLatch(number);
	}

	public void arrive(String name){
		try {
			if("Participant 2".equals(name)){
				throw new BrokenBarrierException();
			}
			controller.countDown();
			System.out.printf("%s has arrived.",name);
			System.out.printf("VideoConference: Waiting for %d participants.\n",controller.getCount());
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		System.out.printf("VideoConference: Initialization: %d participants.\n",controller.getCount());
		try {
			controller.await();
			System.out.printf("VideoConference: All the participants have come\n");
			System.out.printf("VideoConference: Let's start...\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Participant implements Runnable {
	private Videoconference conference;
	private String name;

	public Participant(Videoconference conference, String name) {
		this.conference=conference;
		this.name=name;
	}
	@Override
	public void run() {
		long duration=(long)(Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		conference.arrive(name);

	}
}

public class CountDownLatchConfrence{
	public static void main(String[] args) {
		Videoconference conference=new Videoconference(10);
		Thread threadConference=new Thread(conference);
		threadConference.start();
		for (int i=0; i<10; i++){
			Participant p=new Participant(conference, "Participant "+i);
			Thread t=new Thread(p);
			t.start();
		}
	}
}
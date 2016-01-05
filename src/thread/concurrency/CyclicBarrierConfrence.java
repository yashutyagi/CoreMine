package thread.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

class VideoconferenceBarrier implements Runnable{
	private CyclicBarrier controller;
	public VideoconferenceBarrier(int number) {
		controller = new CyclicBarrier(number,this);
	}

	public void arrive(String name){
		System.out.printf("\n %s has arrived.",name);
		try {
			controller.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.printf("VideoConference: Waiting for %d participants.\n",controller.getNumberWaiting());
	}
	public void run() {
		System.out.printf("VideoConference: Initialization: %d participants.\n",controller.getNumberWaiting());
		System.out.printf("VideoConference: All the participants have come\n");
		System.out.printf("VideoConference: Let's start...\n");
	}
}

class ParticipantBarrier implements Runnable {
	private VideoconferenceBarrier conference;
	private String name;

	public ParticipantBarrier(VideoconferenceBarrier conference, String name) {
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

public class CyclicBarrierConfrence{
	public static void main(String[] args) {
		VideoconferenceBarrier conference=new VideoconferenceBarrier(10);
		/*Thread threadConference=new Thread(conference);
		threadConference.start();*/
		for (int i=0; i<10; i++){
			ParticipantBarrier p=new ParticipantBarrier(conference, "Participant "+i);
			Thread t=new Thread(p);
			t.start();
		}
	}
}
package util;


public class Time {	
	private long timer;
	private long deltaTimer;
	
	public Time(){
		timer = 0;
		deltaTimer = 0;
	}
	
	public void start(){
		timer = System.currentTimeMillis();
	}
	
	public void stop(){
		deltaTimer = System.currentTimeMillis()-timer; 
	}
	
	public long elapsed(){
		return deltaTimer;
	}
	
	public void print(){
		System.out.println((deltaTimer/1000.0f) + " seconds");
	}

}

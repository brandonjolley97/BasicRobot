package bot.model;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;



public class EV3Bot 
{
	private String botMessage;
	private int xPosition;
	private int yPosition;
	private long waitTime;
	private MovePilot botPilot;
	private EV3UltrasonicSensor distanceSensor;
	//private EV3TouchSensor backTouch;
	
	private float [] ultrasonicSamples;
	//private float [] touchSamples;
	
	public EV3Bot()
	{
		this.botMessage = "Brandon codes BrandonBot";
		this.xPosition = 50;
		this.yPosition = 50;
		this.waitTime = 4000;
		
		distanceSensor = new EV3UltrasonicSensor(LocalEV3.get().getPort("S1"));
		setupPilot();
	}
	
	private void setupPilot()
	{
		Wheel leftWheel = WheeledChassis.modelWheel(Motor.A, 43.3).offset(-72);
		Wheel rightWheel = WheeledChassis.modelWheel(Motor.A, 43.3).offset(72);
		WheeledChassis chassis = new WheeledChassis(new Wheel[]{leftWheel, rightWheel}, WheeledChassis.TYPE_DIFFERENTIAL);
		botPilot = new MovePilot(chassis);
		
		
		
	}
	
	public void driveRoom()
	{
		//call private helper method here
		
		ultrasonicSamples = new float [distanceSensor.sampleSize()];
		distanceSensor.fetchSample(ultrasonicSamples, 0);
		if(ultrasonicSamples[0] < 20)
		{
			driveLong();
		}
		else
		{
			driveShort();
		}
		
		displayMessage("driveRoom");
	}
	
	public void driveShort()
	{
		botPilot.travel(1048);
		botPilot.rotate(60);
		botPilot.travel(3048);
		botPilot.rotate(-60);
		botPilot.travel(5588);
		botPilot.rotate(60);
		botPilot.travel(3810);
	}
	
	public void driveLong()
	{
		botPilot.travel(3810);
		botPilot.rotate(-60);
		botPilot.travel(5588);
		botPilot.rotate(60);
		botPilot.travel(3048);
		botPilot.rotate(-60);
		botPilot.travel(1048);
	}
	
	private void dislayMessage()
	{
		LCD.drawString(botMessage, xPosition, yPosition);
		Delay.msDelay(waitTime);
		
		
	}
	
	private void displayMessage(String message)
	{
		LCD.drawString(message, xPosition, yPosition);
		Delay.msDelay(waitTime);
	}
	
}

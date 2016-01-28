package bot.model;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.port;
import lejos.hardware.chassis.Wheel;
import lejos.hardware.chassis.WheelChassis;
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
	private EV3TouchSensor backTouch;
	
	public EV3Bot()
	{
		this.botMessage = "Brandon codes BrandonBot";
		this.xPosition = 50;
		this.yPosition = 50;
		this.waitTime = 4000;
		
		distanceSensor = 
	}
	
	private void setupPilot()
	{
		//
		//
		//
		//
		
		
	}
	
	public void driveRoom()
	{
		//call private helper method here
		displayMessage("driveRoom");
	}
	
	private void dislayMessage()
	{
		LCD.drawString(botMessage, xPosition, yPosition);
		Delay.msDelay(waitTime);
		
		
	}
	
	private void displayMessage(String message)
	{
		LCD.drawString(message, xPosition, yPosition);
		LCD.msDelay(waitTime);
	}
	
}

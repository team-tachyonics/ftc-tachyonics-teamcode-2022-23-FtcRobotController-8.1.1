
 package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

 /**
 * This file illustrates the concept of driving up to a line and then stopping.
 * The code is structured as a LinearOpMode
 *
 * The Sensor used here can be a REV Color Sensor V2 or V3.  Make sure the white LED is turned on.
 * The sensor can be plugged into any I2C port, and must be named "sensor_color" in the active configuration.
 *
 *   Depending on the height of your color sensor, you may want to set the sensor "gain".
 *   The higher the gain, the greater the reflected light reading will be.
 *   Use the SensorColor sample in this folder to determine the minimum gain value that provides an
 *   "Alpha" reading of 1.0 when you are on top of the white line.  In this sample, we use a gain of 15
 *   which works well with a Rev V2 color sensor
 *
 *   Setting the correct WHITE_THRESHOLD value is key to stopping correctly.
 *   This should be set halfway between the bare-tile, and white-line "Alpha" values.
 *   The reflected light value can be read on the screen once the OpMode has been INIT, but before it is STARTED.
 *   Move the sensor on and off the white line and note the min and max readings.
 *   Edit this code to make WHITE_THRESHOLD halfway between the min and max.
 *
 *   Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 *   Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
*/

@Autonomous(name="(Don't use)Right", group = "Linear OpMode")
public class Right extends LinearOpMode {

     Robot robot = new Robot(this);
     //static final double     FORWARD_SPEED = 0.35;
     private ElapsedTime runtime = new ElapsedTime();

     @Override
     public void runOpMode() {
         robot.init();
         // Wait for the game to start (driver presses PLAY)
         waitForStart();

         sleep(1000);

         //Close the claw
         robot.closeClaw();
         sleep(500);

         //Make the elevator go up
         robot.linearSlidePower(-0.5);
         sleep(7000);
         robot.stopSlides();

         //Drive forward
         robot.driveForward();
         sleep(1950);
         robot.stopWheels();

         //turn left
         robot.turnleft();
         sleep(290);
         robot.stopWheels();

         //move up
         robot.linearSlidePower(-0.5);
         sleep(275);

         //go forward
         robot.driveForward();
         sleep(1000);
         robot.stopRobot();
         sleep(1000);

         //open the claw
         robot.openClaw();
         robot.stopWheels();
         sleep(400);

         //go back
         robot.driveBackward();
         sleep(400);
         robot.stopRobot();

         //turn right
         robot.turnRight();
         sleep(400);

         //stop robot
         robot.stopRobot();
         sleep(20000);



         robot.stopRobot();




     }
 }
package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class Robot {

    /* Declare OpMode members. */
    private LinearOpMode myOpMode = null;   // gain access to methods in the calling OpMode.

    /* Declare OpMode members.*/
    private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;
    private Servo leftHand = null;
    private Servo   rightHand = null;
    private DcMotor LinearSlide = null;


    static final double     FORWARD_SPEED = 0.35;

    // Define a constructor that allows the OpMode to pass a reference to itself.
    public Robot (LinearOpMode OpMode) {
        myOpMode = OpMode;
    }

    public void init () {
        // Initialize the drive system variables.
        // Initialize the hardware variables. Note that the strings used here must correspond
        // to the names assigned during the robot configuration step on the DS or RC devices.
        leftFrontDrive = myOpMode.hardwareMap.get(DcMotor.class, "fl");
        leftBackDrive = myOpMode.hardwareMap.get(DcMotor.class, "bl");
        rightFrontDrive = myOpMode.hardwareMap.get(DcMotor.class, "fr");
        rightBackDrive = myOpMode.hardwareMap.get(DcMotor.class, "br");
        LinearSlide = myOpMode.hardwareMap.get(DcMotor.class, "elevator");

        // Define and initialize ALL installed servos.
        leftHand = myOpMode.hardwareMap.get(Servo.class, "left_hand");
        rightHand = myOpMode.hardwareMap.get(Servo.class, "right_hand");

        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // When run, this OpMode should start both motors driving forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);

        // If there are encoders connected, switch to RUN_USING_ENCODER mode for greater accuracy
        leftFrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBackDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBackDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        LinearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBackDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBackDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //set hand position
        leftHand.setPosition(0.45);
        rightHand.setPosition(0.55);
        // Wait for the game to start (driver presses PLAY)
        myOpMode.telemetry.addData("Status", "Initialized");
        myOpMode.telemetry.update();

    }
    public void setDrivePower(double leftFront, double rightFront, double leftBack, double rightBack) {
        // Output the values to the motor drives.
        leftFrontDrive.setPower(leftFront);
        rightFrontDrive.setPower(rightFront);
        leftBackDrive.setPower(leftBack);
        rightBackDrive.setPower(rightBack);
    }
    // 0 is right limit
    public void closeClaw() {
        leftHand.setPosition(0);
        rightHand.setPosition(1.0);
    }

    public void openClaw() {
        leftHand.setPosition(0.45);
        rightHand.setPosition(0.55);
    }

    public void linearSlidePower(double power){
        LinearSlide.setPower(power);
    }

    public void driveForward(){
        setDrivePower(FORWARD_SPEED, FORWARD_SPEED, FORWARD_SPEED, FORWARD_SPEED);
    }
    public void driveBackward(){
        setDrivePower(-FORWARD_SPEED, -FORWARD_SPEED, -FORWARD_SPEED, -FORWARD_SPEED);
    }

    public void turnRight(){
        setDrivePower(FORWARD_SPEED, -FORWARD_SPEED, FORWARD_SPEED, -FORWARD_SPEED);
    }

    public void turnleft(){
        setDrivePower(-FORWARD_SPEED, FORWARD_SPEED, -FORWARD_SPEED, FORWARD_SPEED);
    }
    public void stopRobot(){
        setDrivePower(0, 0, 0, 0);
        stopSlides();
    }


    public void stopWheels(){setDrivePower(0, 0, 0, 0);}

    public void stopSlides(){linearSlidePower(0);}

    public void strafeLeft(){setDrivePower(-FORWARD_SPEED, FORWARD_SPEED, FORWARD_SPEED, -FORWARD_SPEED);}

    public void strafeRight(){setDrivePower(FORWARD_SPEED, -FORWARD_SPEED, -FORWARD_SPEED, FORWARD_SPEED);}
}



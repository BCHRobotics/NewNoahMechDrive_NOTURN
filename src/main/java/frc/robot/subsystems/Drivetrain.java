package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain extends Subsystem{

    CANSparkMax SPARKLEFTFRONT = new CANSparkMax(RobotMap.SPARKLEFTFRONT, MotorType.kBrushless);
    CANSparkMax SPARKLEFTBACK = new CANSparkMax(RobotMap.SPARKLEFTBACK,MotorType.kBrushless);

    CANSparkMax SPARKRIGHTFRONT = new CANSparkMax(RobotMap.SPARKRIGHTFRONT, MotorType.kBrushless);
    CANSparkMax SPARKRIGHTBACK = new CANSparkMax(RobotMap.SPARKRIGHTBACK, MotorType.kBrushless);
    
    MecanumDrive mDrive = null;

    public Drivetrain(){

        mDrive = new MecanumDrive(SPARKLEFTFRONT, SPARKLEFTBACK, SPARKRIGHTFRONT, SPARKRIGHTBACK);

        
        SPARKRIGHTBACK.setInverted(false);
        SPARKRIGHTFRONT.setInverted(true);

        SPARKLEFTBACK.setInverted(true);
        SPARKLEFTFRONT.setInverted(false);
        

    }

    public void mecanumDrive(double moveX, double moveY, double moveRot, double angle){

        mDrive.driveCartesian(-moveY, moveX, moveRot, angle);


    }

    @Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		//setDefaultCommand(new DriveArcade());
	}

}
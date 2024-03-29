package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Components.Utilities.OpenCVDetection.OpenCVDetection;
import org.firstinspires.ftc.teamcode.teamcode.Components.OpenCVDetection.OpenCVDetection;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

//New changes :::))))))
@Autonomous(name="auto")
public class AutoCV extends LinearOpMode {
    OpenCvCamera webcam;


    DcMotor motor;
    int cameraMonitorViewId;
    int width;
    int height;
    OpenCVDetection detector;

    Telemetry t;


    @Override
    public void runOpMode() {
        motor = hardwareMap.get(DcMotor.class, "motor");
        cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "cam"), cameraMonitorViewId);


        width = 640;
        height = 480;


        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                detector = new OpenCVDetection();
                webcam.setPipeline(detector);
                webcam.startStreaming(width, height, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {}
        });

        waitForStart();

        while(opModeIsActive()) {
            telemetry.addData("Location", detector.getLocation());
        }
    }

}
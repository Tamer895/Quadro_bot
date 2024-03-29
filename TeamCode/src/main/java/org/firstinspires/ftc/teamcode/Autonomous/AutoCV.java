package org.firstinspires.ftc.teamcode.Autonomous;

<<<<<<< HEAD
import android.graphics.Path;

import com.acmerobotics.dashboard.FtcDashboard;
=======
>>>>>>> 7eae2633aec3f08b77255a6b1dd1ab48d7642513
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Components.Utilities.OpenCVDetection.OpenCVDetection;
<<<<<<< HEAD
=======
import org.firstinspires.ftc.teamcode.teamcode.Components.OpenCVDetection.OpenCVDetection;
>>>>>>> 7eae2633aec3f08b77255a6b1dd1ab48d7642513
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

//New changes :::))))))
@Autonomous(name="auto")
public class AutoCV extends LinearOpMode {
    OpenCvCamera webcam;


<<<<<<< HEAD
    int width;
    int height;
=======
    DcMotor motor;
    int cameraMonitorViewId;
    int width;
    int height;
    OpenCVDetection detector;
>>>>>>> 7eae2633aec3f08b77255a6b1dd1ab48d7642513

    Telemetry t;


    @Override
    public void runOpMode() {
<<<<<<< HEAD
//        motor = hardwareMap.get(DcMotor.class, "motor");
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        OpenCVDetection detector = new OpenCVDetection(telemetry);
        webcam.setPipeline(detector);
=======
        motor = hardwareMap.get(DcMotor.class, "motor");
        cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "cam"), cameraMonitorViewId);


        width = 640;
        height = 480;
>>>>>>> 7eae2633aec3f08b77255a6b1dd1ab48d7642513


        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
<<<<<<< HEAD
                webcam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
=======
                detector = new OpenCVDetection();
                webcam.setPipeline(detector);
                webcam.startStreaming(width, height, OpenCvCameraRotation.UPRIGHT);
>>>>>>> 7eae2633aec3f08b77255a6b1dd1ab48d7642513
            }

            @Override
            public void onError(int errorCode) {}
        });

<<<<<<< HEAD
        FtcDashboard.getInstance().startCameraStream(webcam, 0);

        waitForStart();

        while(opModeIsActive()) {
            switch (detector.getLocation()) {
                case Left:
                    telemetry.addData("Loccc", "Left");
                    telemetry.update();
                case Middle:
                    telemetry.addData("Loccc", "Center");
                    telemetry.update();
                case Right:
                    telemetry.addData("Loccc", "Right");
                    telemetry.update();
                case Unknown:
                    telemetry.addData("Loccc", "Unknown");
                    telemetry.update();
            }
        }
        webcam.stopStreaming();
=======
        waitForStart();

        while(opModeIsActive()) {
            telemetry.addData("Location", detector.getLocation());
        }
>>>>>>> 7eae2633aec3f08b77255a6b1dd1ab48d7642513
    }

}
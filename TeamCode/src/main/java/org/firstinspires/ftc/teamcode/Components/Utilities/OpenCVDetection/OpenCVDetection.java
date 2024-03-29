package org.firstinspires.ftc.teamcode.Components.Utilities.OpenCVDetection;

<<<<<<< HEAD
import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.robotcore.external.Telemetry;
=======
>>>>>>> 7eae2633aec3f08b77255a6b1dd1ab48d7642513
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

<<<<<<< HEAD
@Config
public class OpenCVDetection extends OpenCvPipeline {

    Telemetry telemetry;
    Mat mat = new Mat();
    public Location location;

    public enum Location {
        Left,
        Right,
        Middle,
        Unknown,
    }

    public OpenCVDetection(Telemetry t) {
        this.telemetry = t;
    }
=======
public class OpenCVDetection extends OpenCvPipeline {

//    Telemetry telemetry;
    Mat mat = new Mat();
    public Location location;


    public enum Location {
        Left,
        Right,
        Middle
    }

//    public OpenCVDetection(Telemetry t) {
//        this.telemetry = t;
//    }
>>>>>>> 7eae2633aec3f08b77255a6b1dd1ab48d7642513



    public static boolean DETECT_RED = true;
    public static double MINIMUM_VALUES = 100;
    public static double MAXIMUM_VALUES = 255;
    public static double MINIMUM_BLUE_HUE = 100;
    public static double MAXIMUM_BLUE_HUE = 255;
    public static double MINIMUM_RED_LOW_HUE = 100;
    public static double MAXIMUM_RED_LOW_HUE = 255;
    public static double MINIMUM_RED_HIGH_HUE = 100;
    public static double MAXIMUM_RED_HIGH_HUE = 255;

    // ROI (Region of Interest)
    static final Rect Left_ROI = Rectangle.rect(105, 200);
    static final Rect Middle_ROI = Rectangle.rect(215, 200);
    static final Rect Right_ROI = Rectangle.rect(315, 200);

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2HSV);

        // Blue Color
        Scalar MINIMUM_BLUE = new Scalar(MINIMUM_BLUE_HUE, MINIMUM_VALUES, MINIMUM_VALUES);
        Scalar MAXIMUM_BLUE = new Scalar(MAXIMUM_BLUE_HUE, MAXIMUM_VALUES, MAXIMUM_VALUES);

        // Red Color
        Scalar MINIMUM_RED_LOW = new Scalar(MINIMUM_RED_LOW_HUE, MINIMUM_VALUES, MINIMUM_VALUES);
        Scalar MAXIMUM_RED_LOW = new Scalar(MAXIMUM_RED_LOW_HUE, MAXIMUM_VALUES, MAXIMUM_VALUES);
        Scalar MINIMUM_RED_HIGH = new Scalar(MINIMUM_RED_HIGH_HUE, MINIMUM_VALUES, MINIMUM_VALUES);
        Scalar MAXIMUM_RED_HIGH = new Scalar(MAXIMUM_RED_HIGH_HUE, MAXIMUM_VALUES, MAXIMUM_VALUES);

        if (!DETECT_RED) {
            Core.inRange(mat, MINIMUM_BLUE, MAXIMUM_BLUE, mat);
        } else {
            Mat mat1 = mat.clone();
            Mat mat2 = mat.clone();
            Core.inRange(mat1, MINIMUM_RED_LOW, MAXIMUM_RED_LOW, mat1);
            Core.inRange(mat2, MINIMUM_RED_HIGH, MAXIMUM_RED_HIGH, mat2);
            Core.bitwise_or(mat1, mat2, mat);
        }

        // Matrix for each position
        Mat left = mat.submat(Left_ROI);
        Mat right = mat.submat(Right_ROI);
        Mat middle = mat.submat(Middle_ROI);

        double leftValue = Core.sumElems(left).val[0];
        double rightValue = Core.sumElems(right).val[0];
        double middleValue = Core.sumElems(middle).val[0];

//        telemetry.addData("Left Raw Value:", leftValue);
//        telemetry.addData("Right Raw Value:", rightValue);
//        telemetry.addData("Middle Raw Value: ", middleValue);

        left.release();
        right.release();
        middle.release();

        if (leftValue >= rightValue && leftValue >= middleValue) {
<<<<<<< HEAD
            this.location = Location.Left;
            telemetry.addData("Prop location:", "Right");
        } else if (rightValue >= middleValue) {
            this.location = Location.Right;
            telemetry.addData("Prop location:", "Left");
        } else {
            this.location = Location.Middle;
            telemetry.addData("Prop location:", "Middle");
=======
            location = Location.Left;
//            telemetry.addData("Prop location:", "Right");
        } else if (rightValue >= middleValue) {
            location = Location.Right;
//            telemetry.addData("Prop location:", "Left");
        } else {
            location = Location.Middle;
//            telemetry.addData("Prop location:", "Middle");
>>>>>>> 7eae2633aec3f08b77255a6b1dd1ab48d7642513
        }

//        telemetry.update();

        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_GRAY2RGB);

        Scalar pixelColor = new Scalar(255, 255, 255);
        Scalar propColor = new Scalar(0, 0, 255);

<<<<<<< HEAD
        Imgproc.rectangle(mat, Left_ROI, this.location == Location.Left ? pixelColor : propColor);
        Imgproc.rectangle(mat, Middle_ROI, this.location == Location.Middle ? pixelColor : propColor);
        Imgproc.rectangle(mat, Right_ROI, this.location == Location.Right ? pixelColor : propColor);

        return mat;
    }

    public Location getLocation() {
        if(location == null) {
            return Location.Unknown;
        }
        else {
            return location;
        }
    }

=======
        Imgproc.rectangle(mat, Left_ROI, location == Location.Left ? pixelColor : propColor);
        Imgproc.rectangle(mat, Middle_ROI, location == Location.Middle ? pixelColor : propColor);
        Imgproc.rectangle(mat, Right_ROI, location == Location.Right ? pixelColor : propColor);

        return mat;
    }
    public Location getLocation() {

        return location;
    }


>>>>>>> 7eae2633aec3f08b77255a6b1dd1ab48d7642513
}
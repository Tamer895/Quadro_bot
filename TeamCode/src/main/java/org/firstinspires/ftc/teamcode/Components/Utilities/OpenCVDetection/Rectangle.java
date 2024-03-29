<<<<<<< HEAD
package org.firstinspires.ftc.teamcode.Components.Utilities.OpenCVDetection;

import org.opencv.core.Point;
import org.opencv.core.Rect;

public class Rectangle {
    double x;
    double y;

    public static Rect rect(double x, double y) {
        return new Rect(new Point(x-95, y-100), new Point(x, y));
    }
}
=======
package org.firstinspires.ftc.teamcode.Components.Utilities.OpenCVDetection;

import org.opencv.core.Point;
import org.opencv.core.Rect;

public class Rectangle {
    double x;
    double y;

    public static Rect rect(double x, double y) {
        return new Rect(new Point(x-95, y-100), new Point(x, y));
    }
}
>>>>>>> 7eae2633aec3f08b77255a6b1dd1ab48d7642513

package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class TouchSensor{

    private TouchSensor touchSensor;

    public TouchSensor(TouchSensor x) {
        touchSensor = x;
    }

    public boolean isPressed(){

        return touchSensor.isPressed();
    }

    public TouchSensor getTouchSensor() {
        return touchSensor;
    }
}

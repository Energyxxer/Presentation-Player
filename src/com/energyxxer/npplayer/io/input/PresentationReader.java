package com.energyxxer.npplayer.io.input;

/**
 * Created by User on 3/27/2017.
 */
public class PresentationReader {
    /*
    * short:1: screen width
    * short:1: screen height
    * short:1: number of breakpoints (b)
    * int:b: breakpoints
    * short:1: number of OBJECTs (o)
    * -:o: OBJECTs
    *
    * OBJECT:
    * byte:1: type of object (0 for rectangle, 1 for oval, 2 for text, 3 for image... Based on object implementation)
    * int:1: start keyframe
    * int:1: object length
    * -:1: default STATE
    * short:1: number of TRANSITIONs (t)
    * -:c: TRANSITIONs
    * Further reading of object is provided in the object type's implementation.
    *
    *
    * TRANSITION: (29 bytes)
    * short:1:frame
    * byte:1:easing (0 for linear, 1 for ease-in-out)
    * -:1: STATE
    *
    * STATE: (26 bytes)
    * short:1:x
    * short:1:y
    * short:1:width
    * short:1:height
    * double:1:rotation angle
    * byte:1:rotation locked (last bit, 0: unlocked, 1: locked)
    * short:1:x origin. unused if locked
    * short:1:y origin. unused if locked
    * byte:1:color r (r - 128)
    * byte:1:color g (g - 128)
    * byte:1:color b (b - 128)
    * byte:1:color a (a - 128)
    * byte:1:opacity (opacity - 128)
    *
    * */
        // Byte.MAX_VALUE = 127                             8 bits, 1 byte
        // Short.MAX_VALUE = 32767                          16 bits, 2 bytes
        // Character.MAX_VALUE = 65535                      16 bits, 2 bytes (unsigned)
        // Integer.MAX_VALUE = 2147483647                   32 bits, 4 bytes
        // Long.MAX_VALUE = 9223372036854775807
        // Double                                           64        8 bytes

    public static void main(String[] args) {
        System.out.println((int) Character.MAX_VALUE);
    }
}

package com.energyxxer.npplayer;

import com.energyxxer.npplayer.objects.VisualObject;

import java.awt.Dimension;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 3/26/2017.
 */
public class Presentation {
    public ArrayList<VisualObject> objects = new ArrayList<>();
    public ArrayList<Integer> breakpoints = new ArrayList<>();
    public Dimension dimensions = new Dimension();

    public void writeToFile() {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("C:\\Users\\User\\Desktop\\out.npp")))) {
            //Screen Dimensions
            dos.writeShort(dimensions.width);
            dos.writeShort(dimensions.height);

            //Breakpoint count
            dos.writeShort(breakpoints.size());
            //Breakpoint list
            for(Integer breakpoint : breakpoints) {
                dos.writeInt(breakpoint);
            }

            for(VisualObject object : objects) {
                object.writeToFile(dos);
            }
        } catch(IOException x) {
            x.printStackTrace();
        }
    }
}

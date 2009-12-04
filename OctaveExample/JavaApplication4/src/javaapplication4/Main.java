/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//needs to have the javaoctave and commons logging api attached
package javaapplication4;
import dk.ange.octave.*;
import java.io.*;


/**
 *
 * @author Adrian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("BEGIN");
        final OctaveEngine octave = new OctaveEngineFactory().getScriptEngine();


        StringWriter octaveWriter = new StringWriter();
        octave.setWriter(octaveWriter);

        //any commands can be done here!!!!!
        octave.eval("a=23");
        octave.eval("b = zeros(a,a)");
        octave.eval("a = a +1");

        System.out.println(octaveWriter.toString());
        octaveWriter.flush();
        System.out.println(octaveWriter.toString());

        octave.destroy();
        System.out.println("END.");
    }

}

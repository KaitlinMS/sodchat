/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//needs to have the javaoctave and commons logging api attached
package javaapplication4;
import dk.ange.octave.*;


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

        //any commands can be done here!!!!!
        octave.eval("a=23");
        octave.eval("b = zeros(a,a)");
        octave.eval("a = a +1");
        
        octave.destroy();
        System.out.println("END.");
    }

}
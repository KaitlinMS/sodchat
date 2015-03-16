#Introduces the java - octave communication needed

# Introduction #
With the javaoctave package, we can now communicate with octave. We can run arbitrary code in octave and display the results in the default IO stream -- I'm sure we can manage to put it in the chat window box.

Example of redirection: http://www.java-tips.org/java-se-tips/java.lang/redirect-standard-output-to-a-file.html


# Details #
The JavaOctave package has two **requirements**:
  1. The Commons Logging Api JAR library --this is a dependency
  1. The User needs to have octave and set the path variable to include the Octave bin directory if in windows

---

so the user needs to be able to do the following command at the command line: octave

---

**To use javaoctave in netbeans:** Under Libraries, click add, click the two JAR files included in the Example code.


Links to the two libraries:

[JavaOctave](http://kenai.com/projects/javaoctave/pages/Home)

[Commons Logging](http://commons.apache.org/logging/)

Example that works(you may have to redo library adding(see above)):
http://code.google.com/p/sodchat/source/browse/#svn/trunk/OctaveExample


Happy interfacing!
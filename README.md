# SwingJSDemo
Code for Bioinformatics short workshop, University of Dundee, 31st May 2019

#### Goals
*   To give a flavour of cross-compilation of Java Swing to Javascript in action 

#### Pre-requisites
*   Eclipse for Java, version 4.8 or later
*   Java 8 or later 

### Instructions
To run as Java:
1.  Clone this repository `(https://github.com/gmungoc/SwingJSDemo.git)`
2.  Import into Eclipse (Import from Git) as a Java project
3.  Run class `HelloWorld.java` as a Java application and explore its (very simple) functionality

To translate ('transpile') from Swing to Javascript:
1.  Right-click on `build-site.xml` and 'Run as Ant Build' - this unzips `swingjs/SwingJS-site.zip` to `/site`
2.  Refresh the workspace - you should now see a new folder `site` 
3.  Copy file `swingjs\net.sf.j2s.core.jar` to the `dropins` subfolder of your Eclipse installation
4.  Restart Eclipse to pick up the 'Compiler Participant' plugin
    * if this doesn't work first time, you may need to restart Eclipse with the `-clean` flag (once only)
5.  Select `Project | Clean...` to recompile the code
    * notice file `.j2s` - this is needed to enable JavaToScript 'transpilation'
6.  Refresh project: you should now see a file `site/swing_demo_HelloWorld.html`
    * the transpiler generates an html launch page for each Java class with a `main` method
7.  Open this file in a browser (e.g. browse to file, double-click, or right-click and Open With | System Editor)
    * ABC - Anything But Chrome (as Chrome by default doesn't allow local file access)
8.  You should now see the code running as Javascript
9.  Try making a change to the Java code; it should recompile (as Java) and transpile (to HelloWorld.js)
10. Reload the web page to see the changes
11. Add a main method to `HelloWorld2`, consisting of `new HelloWorld2().display()`, and run it
    * tip: type ma then Ctrl-space for the main method template
    * experiment with dragging the mouse, with or without the Shift key pressed
12. A second `.html` file should have been generated, for `HelloWorld2`. Try this in the browser. This demonstrates drawing on a SwingJS Graphics context.
13. Transpilation is not just for GUI applications!
    * run PrimeNumberFinder (as Java)
    * run PrimeNumberFinder (as html/Javascript)
    * to fix the error (pass in an argument): add `args: "100",` to the `Info` block of the html

SwingJS is currently maintained at [https://github.com/BobHanson/java2script](https://github.com/BobHanson/java2script), a fork of [https://github.com/java2script/java2script](https://github.com/java2script/java2script).

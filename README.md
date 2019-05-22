# SwingJSDemo
Code for Bioinformatics short workshop, Dundee 31st May 2019

#### Goals
*   To give a flavour of cross-compilation of Java Swing to Javascript in action 

#### Pre-requisites
*   Eclipse for Java, version 4.8 or later 

### Instructions
Run as Java:
1.  clone this repository `(https://github.com/gmungoc/SwingJSDemo.git)`
2.  import into Eclipse as a Java project
3.  Configure to run with JRE 1.8 or later
4.  run class `HelloWorld.java` as a Java application and explore its (very simple) functionality

Translate ('transpile') from Swing to Javascript:
1.  run `build-site.xml` as an Ant task - this unzips `swingjs/SwingJS-site.zip` to `/site`
2.  refresh the workspace - you should now see a new folder `site` 
3.  copy file `swingjs\net.sf.j2s.core.jar` to the Eclipse dropins installation folder
    * Windows: tbc
    * OSX: /Applications/Eclipse.app/Contents/Eclipse/dropins
    * Linux: tbc
4.  Restart Eclipse to pick up the plugin Compiler Participant
5.  Select `Project | Clean...` to recompile the code
    * notice file .j2s - this is needed to enable JavaToScript 'transpilation'
6.  Refresh project: you should now see a file `site/swing_demo_HelloWorld.html`
    * the transpiler generates an html launch page for each runnable Java class
7.  Open this file in a browser (e.g. browse to file, double-click, or right-click and Open With | System Editor)
8.  You should now be able to see the code running as Javascript
9.  Try making a change to the Java code; it should recompile (as Java) and transpile (to HelloWorld.js)
10. Reload the web page to see the changes
11. Add a main method to `HelloWorld2`, consisting of `new HelloWorld2().display()`, and run it
    * tip: type ma then Ctrl-space for the main method template
    * experiment with dragging the mouse, with or without the Shift key pressed
12. A second `.html` file should have been generated, for `HelloWorld2`. Try this in the browser. This demonstrates drawing on a SwingJS Graphics context.

SwingJS is currently maintained at [https://github.com/BobHanson/java2script](https://github.com/BobHanson/java2script), a fork of [https://github.com/java2script/java2script](https://github.com/java2script/java2script).
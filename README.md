# SwingJSDemo
Code for Bioinformatics short workshop, Dundee 31st May 2019

#### Goals
*   To give a flavour of cross-compilation of Java Swing to Javascript in action 

#### Pre-requisites
*   Eclipse for Java, version 4.8 or later 

### Instructions
To run as Java:
1.  clone this repository `(https://github.com/gmungoc/SwingJSDemo.git)`
2.  import into Eclipse as a Java project
3.  Configure to run with JRE 1.8 or later
4.  run class `HelloWorldSwing.java` as a Java application and explore it

To translate from Swing to Javascript:
1.  run `build-site.xml` as an Ant task - this unzips `swingjs/SwingJS-site.zip` to `/site`
2.  refresh the workspace - you should now see a new folder `site` 
3.  copy file `swingjs\net.sf.j2s.core.jar` to the Eclipse dropins installation folder
    * Windows: tbc
    * OSX: /Applications/Eclipse.app/Contents/Eclipse/dropins
    * Linux: tbc
4.  Restart Eclipse to pick up the plugin Compiler Participant
5.  Select `Project | Clean...` to recompile the code
    * note file .j2s is needed to enable JavaToScript 'transpilation'
6.  Refresh project: you should now see a file `site/swing_demo_HelloWorldSwing.html`
7.  Open this file in a browser (e.g. double-click, or right-click Open With | System Editor)
8.  You should now be able to see the 'application' running as Javascript
9.  Experiment with changes to the Java code; they should recompile and transpile, reload the web page to see the changes 
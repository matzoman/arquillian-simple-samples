# What you need to understand and try these samples:

- an IDE
- Websphere Liberty [about page](https://developer.ibm.com/wasdev/websphere-liberty/)
- Java JDK 1.8 [Oracle Java downloads](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

# What I used:

- eclipse (I used "Eclipse IDE for Java EE Developers", Mars.1)
- in eclipse I installed the WDT (Websphere Developer Tools) 
	- via marketplace (search for "IBM WebSphere Application Server Liberty Developer Tools") 
    - or use this link: [marketplace-link](http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=1778478) 
    - [source of marketplace link](https://developer.ibm.com/wasdev/getstarted/)
    - [marketplace web link](http://marketplace.eclipse.org/content/ibm-websphere-application-server-liberty-developer-tools)
- to prepare the eclipse / workspace you should add a liberty server
	- File -> New -> Server -> server type "Websphere Application Server Liberty" -> Next 
    	-> choose "Install from an archive or a repository" -> Next
        -> enter a path where you want the server to be installed & choose "Download and instal..." and there the "WAS Liberty V8.5.5.8 with Java EE 7 Full Platform" (yeah, it's a very long name...) -> Next
        -> (No Additional Content needed) -> Next
        -> Accept license -> Finish
- start the server (in the Server-Tab), and you must add a keystore password. (for these example not important. it adds a line to the server.xml)      

# Just to have a look a the projects:

- Import the projects from the repository into your workspace
- Define a run configuration for each project
	- for the 'HelloEJBSample' set "install" as the goal
    - for the 'HelloWorld' & 'HelloEJBSampleTest' set "clean test" as the goal
- run the 'HelloEJBSample' first to install the artefact for the 'HelloEJBSampleTest'-project
- stop the liberty server
- run the tests

# How I built each project

'HelloWorld'
- create new simple maven project
- writing some code that is to be tested (I used the example from this tutorial: https://developer.ibm.com/wasdev/docs/getting-started-liberty-arquillian/)
- now the class "HelloWorldServlet" and the spring bean "SpringBean.xml" exists

[to be continued]
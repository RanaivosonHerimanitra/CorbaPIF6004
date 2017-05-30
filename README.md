# CorbaPIF6004
Let's get old with CORBA for distributed application.
 * Clone the app on multiple machines.
 * change  hostname to your IPv4 address

## Goal:

Build a CRUD distributed application using Corba, Java and Swing

## Requirements:
 * Corba installed from eclipse( http://eclipsecorba.sourceforge.net/#Installation )
 
 * jdk1.8 or below
 
## Generate stub:

on the cli, go to source directory(src) of the project then:

`$ idlj -fall PersonnelAPP.idl`



## Starting the server:

Go to the bin folder of your `jdk` installation then (you may use any port number ):

 `$ start orbd -ORBInitialPort 1000`
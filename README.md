# CorbaPIF6004
Let's get old with CORBA for distributed application.
 * Clone the app on multiple machines.
 * change  hostname to your IPv4 address

## Goal:

Build a CRUD distributed application using Corba, Java and Swing

## Generate stub:

on the cli, go to source directory(src) of the project then:

`$ idlj -fall PersonnelAPP.idl`



## Start server using (you may use any port number ) :

Go to the bin folder of your jdk  then:

 `$ start orbd -ORBInitialPort 1000`
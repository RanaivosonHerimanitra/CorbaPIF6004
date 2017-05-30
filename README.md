# CorbaPIF6004
Let's get old with CORBA for distributed application.
 * Clone the app on multiple machines.
 * change  hostname to your IPv4 address


## Generate stub:

on the cli, go to src then:

`$ idlj -fall PersonnelAPP.idl`



## Start server using (you may use any port you want) :

 `$ start orbd -ORBInitialPort 1000`
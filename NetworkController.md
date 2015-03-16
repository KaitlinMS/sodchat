#Initial details of network controller

# Introduction #
Here is the email I sent everyone detailing what I'm doing with the network controller


# Details #

Also, I want to know what you think about having a NetworkController class. It will monitor a port for incoming network activity and route the messages to the right spot. In addition it would be able to establish new connections with other contacts more easily. Here's what it does:

Listen to a port for network activity and if it detects any then read in the first line which will contain a string that looks something like:
msg,invite,Matthew

That message would indicate that it needs to be routed to the messagecontroller. So it would pass the string and socket onto SODApp then go back to listening to the port for more messages. SODApp would have a method that determines what messagecontroller function needs to be called and calls it with the proper arguments. Then the message controller deals with it appropriately.

Our networking would be more flexible that way. I already have the backbone for the NetworkController coded too. All that needs to be finishes in the Send method (which is easy, lol). The send method would be used for sending encoded messages to other clients network controller.

Interface Details (In progress)

Public Methods:

**Send(String Message, String ip) -> Socket** throws Exception

-Sends the message to the indicated ip address

-The message should be in the format:

-->controller,method,param1,param2,.....,paramn,n

--controller can be **con** for contact, **ftr** for file transfer, **col** for collaboration, **msg** for message, and net for network....con, ftr, col, msg, net

--method must be exactly three characters long - this makes parsing easier and shorter. May reconsider this restriction if a compelling case presents itself

--Note that there are no spaces

-Returns the Socket used to send the message for follow up responses

Private Method:

**Listen()**

-Listens to port 44533 for incomming network connections

-When a network connection is established it reads the first line and routes to to an appropriate netEvent handler in SODApp. They correspond to conNetEvent, colNetEvent, msgNetEvent, ftrNetEvent, netNetEvent.

-It passes the established socket and a String in the form of:

-->method,param1,param2,....

It is then the responsibility of the NetEvent handler to determine what needs to be done with that information and call the appropriate controllers or other methods.
Detailed description of the network fixes (and new feature) I implemented

# Introduction #

Alright, I was working on a network problem that if you tried interacting with anyone not online at all then your program would crash. (Sucked, I know lol) I fixed it and added a pretty awesome feature where any request to someone offline will be received the next time they are online as long as you're online when they come on.


# Details #
So basically the problem with the networking before was when you sent anything to someone then the networking would connect to them and then send it. This seemed to work because I only tested it for when I was actually online. I accidentally did it when I was offline and the shit basically hit the fan so I looked into it and decided the send call needed it's own thread.

So basically right now it's pretty awesome. Since it's in it's own thread, that thread is going to wait until the other person is online and able to receive a network request before it sends it's message and that all happens in the background. So...if you add someone to your list when they are offline then when they eventually pop online they will automatically have you and you will have them.

Or if you send a chat request while they're offline then the next time they come online they will be greeted with a collaboration request.

Pretty awesome in my opinion. But it needs some testing. Some problems I can see amybe being an issue:

-Adding someone before they fill out their name for the first time
-Adding someone that is offline, then adding someone else who is offline...hard to explain why this might not work....


Keep and eye on funny things that happen and report them to me!
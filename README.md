## Data Structures and Algorithms in Java

Data structures and algorithms are essential to computer science, which is the study of data, 
its representation in memory, and its transformation from one form to another. In programming, 
we use datastructures to store and organize data, and we use algorithms to manipulate the data
in those structures. The more you understand about datastructures and algorithms, 
the more efficient your Java programs will be.

### Encapsulation, Interface and Polymorphism

Does anyone here know how a soda machine works? (Cue confused glances about why we'd even
talk about this.) No? Let me tell you.

You drop in your change, and inside the machine is a little monkey who counts all your 
change to make sure you put in enough money. When you press the button for your soda, 
a little light comes on telling the monkey which button you pressed, and if you entered 
the right amount of change, he grabs your choice and throws it into the little hole for you to grab your soda.

This is the concept of encapsulation. We hide the implementation of the soda machine.
Unless it's got one of those fancy, clear windows to let you see the inside, you honestly 
have no idea how it really works. All you know is that you put in some cash, you press a button,
and if you put in enough, you get your drink.

To add to that, you know how to use a soda machine's interface, so therefore
as long as the machine's interface follows the usual soda machine interface, you can use it. 
This is called the interface contract. The machine can be bringing the drinks from Antarctica 
on a conveyor belt for all you care, as long as you get your drink, it's cold, and you get change back.

Polymorphism is the idea that when you use the soda machine interface, it could be doing 
different things. This is why encapsulation and polymorphism are closely related.
In polymorphism, all you know is that you're using a SodaMachine implementation, 
which can be changed, and as a result, different things can be done behind the scenes.
This leads to the driving concept of polymorphism, which is the ability of one object,
the SodaMachine, to actually act as both a MonkeySodaMachine 
and a ConveyorSodaMachine depending on the machine actually behind the interface.
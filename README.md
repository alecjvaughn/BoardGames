# cs471-monopoly
This repository will contain all the data for the CS471 Monopoly project.

Project Due: 4:00PM 12/5/2017

Chris Rogers became a collaborator.
Babita Kurmi became a collaborator.

Problem Description
Suppose two new requirements are added to the Monopoly Game studied in the class.
1. Load/store a game simulation. Simulations are stored in an external data storage system. The storage system could be a local storage, an online storage, or any other mechanisms, and each of them may have different interfaces for data access, but should be easily switched from one to another. The only required operations are load and store. When a game starts the user has the option to start a new game as described in the textbook or to load a game. When a game is over the game in stored automatically.
2. Update the information of each turn in the simulation to objects that want to observe the game play.
Your task is to design and implement an OO solution with design patterns for LoadGame, StoreGame, and Update in the requirement described above. At the minimum, you need to consider: how to deal with variations of the external storage interface, the creation of class/object, which class should have only one instance, how updates are sent to other objects, etc. The grade is based on the design’s quality and implementation’s correctness.

Development Requirements
1. Implement the Monopoly Game studied in the class, including at least the code for
iteration 1 (available on pages 380-384) and a driver/client class as the base system.
2. The design patterns used for this project should include at least Adaptor, Factory,
Singleton, and Observer. You are encouraged to use additional design patterns.
3. Design interfaces for the external storage systems. At least two different ones need to
be designed and implemented.
4. At least two observers are required in the implementation, where one is text-based and
the other GUI based.
5. Use Java’s Observable and Observer to implement the observer pattern.

The deliverable submitted to D2L Dropbox should include
1. The design class diagrams, the interaction diagrams, and any other useful diagrams;
2. A working implementation in Java mapped from the design;
3. A report that documents the use of design patterns (which, where, why, etc.) and the
detailed responsibilities of each team member.

Demonstration
Each group needs schedule with the instructor to give a 15-minute demonstration during the final week. (This is our “final exam”!) The demonstration includes a live demo of running your project, your design, and the implementation (i.e., code).


# Chat-Messela-Blockchain-Messenger

A Blockchain implementation of Chat Messaging in Java

<br>![Image](https://github.com/kevalmorabia97/Chat-Messela-Blockchain-Messenger/blob/master/gui.PNG)<br>

The Gui is made using Java Fx (requires Oracle JDK)
```
$ sudo add-apt-repository ppa:webupd8team/java
$ sudo apt-get update
$ sudo apt-get install oracle-java8-installer
```

**Running The Program from _Chat-Messela-Blockchain-Messenger_ folder**
```
$ javac Main.java Controller.java
$ java Main
```

<hr>

- **2 Modes:**
1. _Miner Mode_
 <br>Updates blockchain of all users whenever a new Messages is created
 <br>Updates public keys of all users whenver a new user joins
 <br>Note: First a miner should be running then only any user can join
 <br>To run as a miner: In Main.java, uncomment Miner lines i.e. _Miner pro = new Miner("pro",1111); pro.start();_  and comment out _launch(args); System.exit(0);_    
2. _User Mode_
 <br>Chat with other users
 <br>View Received Messages
 <br>When running as User, first enter your name and press _get keys_ which will generate your public and private keys and broadcast them. You will get a msg _USER CREATED!!! HAPPY CHATTING_. After that, enter your text in this text area and the receiver name below and press _Send_ button.

**NOTE:** All systems should be connected to same Wi-Fi network

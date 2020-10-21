
## Introduction
This exercise consists in verifying that a message is hidden in a larger text, such as a magazine. In order to accomplish this, four different algorithms have
been created. The main class is in the App.java file, in there, the Verify class is created using an Strategy Pattern to inject the algorithm that we would like to use at run time.
<br/>

## Puzzle challenge description
You are a spy in a conflict zone who must maintain daily communication with your partners. 
To verify the authenticity of the messages received, you know messages are generated from letters found on a popular magazine published daily. 
To speed up the process of validating the message ownership you write a function that takes two strings as arguments: first, containing all the
letters in the message you want to validate; and second, all the letters 
found in today's magazine.
The function should return true (your partner contacted you) or false 
(the enemy is at the gates) accordingly. 
Try to make your function efficient.  You must assume that the magazine can
be arbitrarily long while the message is normally very short.
Please use Big-O notation to explain how long it takes your function to run 
in terms of the length of your message (n) and the number of letters in the 
magazine (m).You may spend as much time as you like, but a couple of hours
should be sufficient.

## Big O Notation
m = length of the message
n = lenght of the magazine

The complexity for the VerifyByLettersOp1 is: O(m)*O(n)

<br/>

## Algorithms
* **VerifyByLetters**: 
    This algorithm generates a key, value Map for the msg and the magazine. Where the key is each letter of the
    txt and the value is the number of times it apears on that text.
    The algorithm will return true if all the entries from the msgDictionary are in the magazineDictionary and
    the values are equal or lower, meaning that there are enough letters in the magazine to generate that msg. 
    This algorithm is case sensitive, i.e. w != W.

* **VerifyByLettersOp1**: 
    This algorithm generates a key, value Map for the msg. Where the key is each letter of the
    txt and the value is the number of times it apears on that text.
    The algorithm loops through the magazine and everytime it finds a letter that is key to the msg
    dictionary it decreases the msg Dictionary value for that key. When the value is 0 the entry
    get removed from the dictionary and if the dictionary gets emptied before the loop ends it returns true.

* **VerifyByWordsBasic**: 
    * Normalizing text, removing punctuation marks and making it lowercase.

* **VerifyByWordsBasicMix**
    * Normalizing text, removing punctuation marks and making it lowercase.
    * Removing duplicates for the magazine text and sorting the result list.

* **VerifyByWordsCleanUp**
    * Normalizing text, removing punctuation marks and making it lowercase.
    * Removing duplicates for the magazine text and sorting the result list.
    * Removing duplicates for the msg text and sorting the result list.

* **VerifyByWordsCleanUpNoSort**
    * Normalizing text, removing punctuation marks and making it lowercase.
    * Removing duplicates for the magazine text.
    * Removing duplicates for the msg text.

<br/>
<br/>

## Build/Run Me
By default if no arguments passed it will get the files from the src/main/resources directory
* Build jar: mvn package
* Run jar: from the root directory **java -cp ./target/puzzle-1.0-SNAPSHOT.jar com.jorda.puzzle.App**

If you want to pass your own msg/magazine those need to be in the same directory than the .jar
* Run jar with args: from the root directory **java -cp ./target/puzzle-1.0-SNAPSHOT.jar com.jorda.puzzle.App /msg.txt /magazine.txt**

<br/>
<br/>

<br/>
<br/>
## BenchMark

### Test for the Verifying algorithms by letters

| Iteration  | VerifyByLetters | VerifyByLettersOp1
|------:|------:|------:|
| 0 | 215ms | 93ms |
| 1 | 115ms | 52ms |
| 2 | 115ms | 81ms |
| 3 | 94ms | 60ms |
| 4 | 70ms | 39ms |
| 5 | 132ms | 39ms |
| 6 | 124ms | 31ms |
| 7 | 134ms | 49ms |
| 8 | 87ms | 46ms |
| 9 | 148ms | 32ms |

<br><br>
![](test_letters.png)
<br/>

<br/>
<br/>
### Test standard use case scenario where msg is relatively short and magazine relatively long

##### For this test the msg comes from the msg.txt file and the magazine from the DON_QUIJOTE_DE_LA_MANCHA.txt

| Iteration  | VerifyByWordsCleanUp | VerifyByWordsCleanUpNoSort | VerifyByWordsBasic | VerifyByWordsBasicMix
|------:|------:|------:|------:|------:|
| 0 | 54ms | 42ms | 42ms | 55ms |
| 1 | 62ms | 61ms | 36ms | 63ms |
| 2 | 45ms | 44ms | 45ms | 51ms |
| 3 | 62ms | 61ms | 36ms | 53ms |
| 4 | 58ms | 51ms | 54ms | 50ms |
| 5 | 51ms | 41ms | 31ms | 48ms |
| 6 | 47ms | 54ms | 29ms | 49ms |
| 7 | 45ms | 39ms | 32ms | 48ms |
| 8 | 52ms | 47ms | 36ms | 51ms |
| 9 | 54ms | 44ms | 34ms | 43ms |

<br><br>
![](normal_use.png)
<br/>

<br/>
<br/>

### Test where msg and magazine are very long strings

For this test both msg and magazing have been taken from the file (DON_QUIJOTE_DE_LA_MANCHA.txt) The idea behind this test is to analise what would happen in the scenarios where the input msg is very long, in this case exactly as long as the magazine (DON_QUIJOTE_DE_LA_MANCHA.txt)

| Iteration   | VerifyByWordsCleanUp | VerifyByWordsCleanUpNoSort | VerifyByWordsBasic | VerifyByWordsBasicMix
|------:|------:|------:|------:|------:|
| 0 | 1317ms | 1075ms | 7577ms | 13468ms |
| 1 | 1504ms | 1111ms | 6246ms | 19490ms |
| 2 | 751ms | 682ms | 9754ms | 9699ms |
| 3 | 779ms | 668ms | 6461ms | 9510ms |
| 4 | 705ms | 665ms | 6576ms | 9345ms |
| 5 | 807ms | 679ms | 6562ms | 9124ms |
| 6 | 780ms | 655ms | 6684ms | 11211ms |
| 7 | 884ms | 873ms | 9922ms | 12025ms |
| 8 | 831ms | 690ms | 7233ms | 9867ms |
| 9 | 669ms | 611ms | 6595ms | 9278ms |

<br/>

![](large_use.png)

<br/>
<br/>

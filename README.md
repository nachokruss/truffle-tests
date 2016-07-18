# truffle-tests

## Prerequisites

Install [GraalVM](http://www.oracle.com/technetwork/oracle-labs/program-languages/downloads/index.html)

## Building

mvn clean install

## Running

### Hello World
Runs a script that prints 'Hello World' to standard output and another one that returns 'Hello World' in Ruby, Javascript and R
```bash
java -polyglot -cp target/classes/ com.truffle.tests.HelloWorldTest
```
### Bubble Sort
Bubble sorts 1000 arrays with 1000 elements each in Ruby, Javascript and R
```bash
java -polyglot -cp target/classes/ com.truffle.tests.AlgorithmTest
```
### Interop
Same as previous but call a java implementation of the algorithm from the scripting language
```bash
java -polyglot -cp target/classes/ com.truffle.tests.InteropTest
```

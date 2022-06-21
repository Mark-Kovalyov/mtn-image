#!/bin/bash -v

JAVA_HOME=/jdk/11
CLASSPATH=$JAVA_HOME/lib
PATH=$JAVA_HOME/bin:$PATH

mvn clean install
mvn source:jar install

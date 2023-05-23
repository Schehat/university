#!/bin/bash
source ../../../../1_set-environment.sh
echo $JAVA_HOME
echo $JORAM_CHAT_HOME
echo $JORAM_HOME
ant clean compile

#!/bin/bash
echo $1
if [ ! $1 ]; then
  echo "Usage: ./run.sh <filename> without .txt"
  exit 1
fi
if [ $1 = "clean"]; then
  find . -name "*.class" -delete
  rm source.txt
else
  find . -name "*.java" > source.txt
  javac @source.txt
  java src.object.main $PWD/ressource/$1.txt
fi

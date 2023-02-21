#!/bin/bash

OUTPUT_DIR=plugins

if [ ! -d "$OUTPUT_DIR" ]; then
  mkdir "$OUTPUT_DIR"
fi

for dir in */; do
  if [ -e "$dir/pom.xml" ]; then
    echo "Building Maven project in directory $dir"
    cd "$dir" && mvn clean package && cd ..
    cp "$dir/target/"*.jar "$OUTPUT_DIR/"
  fi
done

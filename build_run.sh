#!/bin/sh
./gradlew build && docker build -t mn-datainfo . && docker run -p 8080:8080 -v $PWD/testdata:/data mn-datainfo
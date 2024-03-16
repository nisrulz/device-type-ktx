#!/usr/bin/env bash

./gradlew assembleRelease 
./gradlew publishToMavenLocal --no-configuration-cache

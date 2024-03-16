#!/usr/bin/env bash

./gradlew assembleRelease 
./gradlew publishAllPublicationsToMavenCentral --no-configuration-cache

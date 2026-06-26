#!/bin/sh
# Gradle wrapper script for UNIX
APP_NAME="Gradle"
DIRNAME=$(cd "$(dirname "$0")" && pwd)
exec "$DIRNAME/gradle/wrapper/gradle-wrapper.jar" "$@"

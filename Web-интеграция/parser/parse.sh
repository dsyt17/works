#!/usr/bin/bash
phantomjs phantom.js $1
node parcer_v2.js $1

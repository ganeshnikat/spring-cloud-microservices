#!/bin/sh
echo "Starting consul........."
nohup ./consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=(your machine IP) -client 0.0.0.0 &

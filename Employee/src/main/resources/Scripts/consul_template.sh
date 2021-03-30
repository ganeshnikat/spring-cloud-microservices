#!/bin/sh
echo "Starting Consul-template"
nohup sudo ./consul-template -template="nginx.conf.ctmpl:/etc/nginx/nginx.conf:nginx -s reload"


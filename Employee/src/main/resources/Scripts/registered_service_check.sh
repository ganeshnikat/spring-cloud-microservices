#!/bin/sh
curl http://localhost:8500/v1/agent/checks | python -m json.tool

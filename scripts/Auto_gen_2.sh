#!/bin/bash
# Go to sg-members directory
cd /home/ubuntu/Downloads/sg-events
npm install
npm i node-github  
NODE_GITHUB_TOKEN=<Token> node index.js

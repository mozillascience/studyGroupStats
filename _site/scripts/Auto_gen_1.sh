#!/bin/bash
# Go to sg-events directory
cd /home/ubuntu/sg-events 
npm install
npm i node-github
export SHEET_ID='1vBP7CnFS7tl1lvSZtZ9X-Wy9UdfHOCjwKKHt-mf8Po0'; 
NODE_GITHUB_TOKEN=<token> node index.js

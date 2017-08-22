#!/bin/bash

cd .. 
curr_date=`date`
git add -A
git commit -m "Revised Data on $curr_date"
git push --set-upstream origin master


# Mozilla Study Group Dashboard

The [Mozilla Science Lab](https://science.mozilla.org/) is a part of the Mozilla Foundation devoted to supporting a global community of scientists who want to open source their research and their learning materials. The Study Group program is a part of that initiative, and centers around a simple website that leverages Jekyll blog software and Github issues to enable the creation of a website for peer-learning groups. These groups collaborate and come together for in-person workshops and events that teach scientific programming concepts, open science practice, and scripting languages. Study Group Leads fork the [Study Group Website Repository](https://github.com/mozillascience/studyGroup) and customize the attached website (gh-page) to run meetups [all over the world](https://science.mozilla.org/programs/studygroups). They organize regular events, skill shares, co-work and create community around open science.  

The [Dashboard](https://anamikad.github.io/) has visualizations about [Study Group](https://github.com/mozillascience/studyGroup) globally. The Event details have been added to the [Mozilla Study Group Event](https://mozillascience.github.io/studyGroupEvents/) so that members can participate in various events.

### What did I do?

There are various data of study group like events, members, location and lessons. These data are scattered. Hence, to know the study group activities, I have collected data from everywhere and converted them into JSON. This JSON format is used to display Visualisation on the Dashboard. Also, I have modified the UI and added event details to Mozilla Study Group Events. Previously, sg-event script fetched only in JSON format. With the help of our contributor Hassen, we can now publish on the excel sheet and the data are displayed on Study Group Events. I have also written a script to fetch member details in plain Text format. After fetching, we use JAVA code to simplify the data into JSON format. These JSON are used in Visualisation. For Automation, We have created scripts to run it once in a week.

### Work Flow
 
The fetching and publication of Data are done by running the [scripts](https://github.com/AnamikaD/AnamikaD.github.io/tree/master/scripts) once in a week with the help of cron job.

Add the script in sequence:
- [First script](https://github.com/AnamikaD/AnamikaD.github.io/blob/master/scripts/Auto_gen_1.sh) : To fetch study group events in JSON format.
- [Second script](https://github.com/AnamikaD/AnamikaD.github.io/blob/master/scripts/Auto_gen_2.sh) : To fetch study group members in Plain TEXT format.  
- [Third script](https://github.com/AnamikaD/AnamikaD.github.io/blob/master/scripts/Auto_json.sh) : To run the JAVA code to fetch location, number of events, lesson and number of members in a study group to JSON format.
- [Fourth script](https://github.com/AnamikaD/AnamikaD.github.io/blob/master/scripts/Auto_push.sh) : To push the data to the github. Due to ssh clone, this is passwordless login.

Manual running of scripts:
1) Fetch the Study Group Events and Members with the help of [sg-event](https://github.com/auremoser/sg-events) and [sg-members](https://github.com/AnamikaD/AnamikaD.github.io/tree/master/code/sg-members) scripts. For running these scripts, refer the [event README](https://github.com/auremoser/sg-events/blob/master/README.md) and [members README](https://github.com/AnamikaD/AnamikaD.github.io/blob/master/code/sg-members/Instructions.md).

2) The sg-event script will fetch the event details as well as publish the contents in excel sheet.
  - For publishing to excel sheet, type in terminal:
```
  export SHEET_ID="Excel Sheet ID"
```
  - The Event Details are published to [Mozilla Study Group Event](https://mozillascience.github.io/studyGroupEvents/) with the help of this excel sheet.

3) After fetching the [data](https://github.com/auremoser/sg-events/tree/master/data), [run](https://github.com/AnamikaD/AnamikaD.github.io/blob/master/scripts/Auto_json.sh) the [Java Codes](https://github.com/AnamikaD/AnamikaD.github.io/tree/master/code) to fetch various Data in JSON format.

4) The [JSON](https://github.com/AnamikaD/AnamikaD.github.io/tree/master/data) fetched by Javascript [file](https://github.com/AnamikaD/AnamikaD.github.io/tree/master/js) is displayed on the [Dashboard](https://anamikad.github.io/). (Visualisation : [c3.js](http://c3js.org/gettingstarted.html)) 

5) To run the Mozilla Study Group Dashboard or Mozilla Study Group Events locally:
```
$ git clone repository
$ jekyll build
$ jekyll serve
```
### Come Join Us!
I would like to thank [Aurelia](https://github.com/auremoser) for her guidance and support! Also, kudos to [Hassen](https://github.com/HassenPy) and [Rahul Krishna](https://github.com/rahulkrishnan98) for their contribution and feedback! For any issues, you can drop a message on [gitter](https://gitter.im/mozillascience/studyGroup) or contact [me](https://gitter.im/AnamikaD).

### Future Work
- We may migrate the repository on cloud.
- Merge scripts for better code development.
- Improved or additional features in Dashboard.
- UI improvement in Mozilla Study Group Events.
- Apply Machine Learning Techniques.

### Relevant Links

- [GSoC Devlog](https://mozillascience.github.io/studyGroup-GSOC/index.html) : Blog on GSoC 2017.
- [Etherpad GSoC](https://public.etherpad-mozilla.org/p/sg-gsoc-checkin) : Meeting details during GSoC 2017.
- [Study Group Dashboard](https://anamikad.github.io/) : Visualisation on Study Group Data.
- [Study Group Dashboard codebase](https://github.com/AnamikaD/AnamikaD.github.io) : Codebase of Study Group Dashboard.
- [Mozilla Study Group Events](https://mozillascience.github.io/studyGroupEvents/) : Displays the Study Group Event Details.
- [Mozilla Study Group Events codebase](https://github.com/mozillascience/studyGroupEvents) : Codebase of Mozilla Study Group Events.
- [Excel Sheet of Study Group Events](https://docs.google.com/spreadsheets/d/1vBP7CnFS7tl1lvSZtZ9X-Wy9UdfHOCjwKKHt-mf8Po0/pubhtml) : The sg-events script publishes the events in this Excel Sheet.  
- [sg-events script](https://github.com/auremoser/sg-events) : Fetches the study group event details in JSON format.
- [sg-members script](https://github.com/AnamikaD/AnamikaD.github.io/tree/master/code/sg-members) : Fetches the study group member details in Plain TEXT format.
- [Cront job scripts](https://github.com/AnamikaD/AnamikaD.github.io/tree/master/scripts) : Automate the fetching and pushing of data.
- [Code to fetch Data](https://github.com/AnamikaD/AnamikaD.github.io/tree/master/code) : These codes fetches data across Study Group.
- [GSoC github Repository](https://github.com/mozillascience/studyGroup-GSOC/) : Contains Roadmap and issues for GSoC 2017
- [Mozilla Study Group](https://github.com/mozillascience/studyGroup) : Repository to Create your own Study Group.

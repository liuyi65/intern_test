## Framework Front-end: React, Back-end: SpringBoot, Database: MongoDB

## frontend: cd src -> cd js -> npm install -> npm run

## backend: go to back_end -> src -> main -> java -> com.liu.mongodb -> run MongodbApplication

## database: MongoDB with the database named mongodb01, please create the database and you can add these two collections inside this database.
# userAccount.json.   person.json.

# I manually create two user name yiliu with password 123 and name yiliu2 with password 1234.

# All the label is saved inside person collection.


# oNe stOp check-iN Application (NONA)

This application is created for everybody and this software can cover our customers' daily recreation and routine needs by enabling customers to schedule appointments and check-ins, manage them, and view them all in a single application. Also, it provides a platform for any registered companies to offer such information. 

## Installing / Getting started

```shell
back to root directory, run "docker-compose up"
```

## Developing

If you are using Docker
```shell
docker-compose up
```
If you are not using Docker
In the nona_front folder, run the following command
```shell
npm install 
npm ci 
npm run build
npm start 
```

In the nona_back folder, run the following command
```shell
pip install -r requirements.txt
python3 app.py
```
## Deploy

For for web-side app, you can find our auto-deployed app at http://nona.magicspica.com. We use jenkins to auto-CICD and auto-test. Our test result can be found at http://test.magicspica.com with {username:JKQ, password:jkq123}. 

For the iOS side app, we use XCode Cloud for auto CI/CD. The auto-deployed app can be downloaded at TestFlight (https://apps.apple.com/us/app/testflight/id899247664) with a registered apple ID, and the test result can be found at https://appstoreconnect.apple.com. Please contact us if your apple ID is not registered for our app. 

## How to play

You can visit our app website directly and if you want to log in as a company user, you can use {username:kjiang1117@jhu.edu, password:jkqbye} because we want companies to register for API_KEY after contacting our support team. Therefore, not everyone can create company accounts. For more information, please read our user manual https://github.com/cs421sp23-homework/sp23-oose-project-team-04/wiki/User-Manual







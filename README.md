Planning Poker Sample
=====================

Sample planning poker application using WebSockets. Allows real-time chat and planning poker-style voting. Also includes multiple rooms and a synchronized iframe so that everyone in the room can be looking at the same webpages at the same time.

For more information about the sample, including a video demonstrating how to use the app, see (WebSocket sample application on WASdev.net)[https://developer.ibm.com/wasdev/blog/2014/12/17/websocket-sample-application/]

## Running in Eclipse

See (Building and running Liberty apps with Maven in Eclipse)[https://developer.ibm.com/wasdev/docs/building-liberty-apps-maven-in-eclipse/].


## Building

The sample can be built and run using [Apache Maven](http://maven.apache.org/).

```bash
mvn clean install liberty:start-server
```

## Deploying to Bluemix

Click the button below to deploy your own copy of this application to [Bluemix](https://bluemix.net). Once the application is deployed, visit *http://&lt;yourAppName&gt;.mybluemix.net/PlanningPoker* to access the application. 

[![Deploy to Bluemix](https://bluemix.net/deploy/button.png)](https://bluemix.net/deploy?repository=https://github.com/WASdev/sample.planningpoker.git)

# Notice

© Copyright IBM Corporation 2017.

# License

```text
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````

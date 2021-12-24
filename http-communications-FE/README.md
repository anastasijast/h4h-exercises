@h4h-edu/http-communication-example

## Prerequisites
* Visual Studio Code
* yarn 1.22.4

## How to start

Step #1: Go to the root path of the project

Step #2: Install dependencies
> yarn install

Step #3: Start the vuejs application 
> yarn start

Step #4: Open http://localhost:8080/ in browser

## Instructions
To get the response from the backend application, please start the http-communication-example application first.
The backend application runs on port 8081.

## Exercise
Some simple REST apis are added in this applications just as an example how you can call BE apis.
Based on this you can continue with the task.

* TEAM 1- HTTP Communication - RESTful APIs
Your task is to implement a simple RESTful APIs. Based on the exercise for Students from the presentations,
let's create simple model of User which is supposed to have id, username, firstName, lastName and email.
For sending request to the BE, on FE we use axios. You can read some introduction for axios here:
https://vuejs.org/v2/cookbook/using-axios-to-consume-apis.html
    - Create GET api which will list all users in UI
    - Create GET api which will return the specific user by id
    - Create POST api for adding users
    - Create PUT api for updating email
    - Create DELETE api for deleting user
    - Simulate throwing an exception from BE, and check the response which will be sent in FE
    - GET user by sending the username as RequestParam/PathVariable
    - Check the response when FE tries to access different port than 8081
    - Check the response when FE tries to access API that is not present on BE
    - Do a research of HTTP error codes and when they are used
    - Try to produce Internal server error, how does it happen?
    - Can all CRUD operation be handled with POST requests? Give an example

* TEAM 2- HTTP Communication - HTTP headers
Your task is to implement a simple RESTful API. Based on the presentations for creating APIs, let's
create simple POST method.
For sending request to the BE, on FE we use axios. You can read some introduction for axios here:
https://vuejs.org/v2/cookbook/using-axios-to-consume-apis.html
    - Create POST api which will receive some string
    - In HttpCommunication.vue, you can find example how to override headers through axios. Let's change the
    content-type to 'Content-Type': 'application/xml'. What is the response we get from BE? Why Response headers
    are important for us?
    - Change the Accept header to 'Accept': 'application/xml' and add produces = "application/xml" to the @PostMapping.
    What is the result of this call?
    - Create method which will send file to BE. Which header is needed to be changed?
    HELP: Use the following code for sending the file
        let formData = new FormData();
        formData.append("file", document.getElementById("myFile")); 
        

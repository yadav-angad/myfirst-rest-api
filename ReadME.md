##Steps to setup project
######Install Maven
      Mac: brew install mvn
      Windows: https://maven.apache.org/install.html

      Run command: mvn clean install -U
      This will download all the libraries and will clean build the project

#API List
1. Get Call
   1. http://localhost:8080/restapi/getString
#####
2. Post Call
   1. http://localhost:8080/restapi/saveCustomer
   #####Request Body:
      {
        "id": 1,
        "name": "Test",
        "age": 25,
        "address": "Moline"
      }
#####
3. Delete Call
   1. http://localhost:8080/restapi/deleteCustomerByID/1
#####
4. PUT Call
   1. http://localhost:8080/restapi/updateCustomerPut/1
   #####Request Body:
      {
        "name": "Test",
        "age": 25,
        "address": "Moline"
     }
#####
5. PATCH Call
      1. http://localhost:8080/restapi/updateCustomerPut/1
   ######Request Body:
      {
        "name": "Test",
        "age": 25,
        "address": "Moline"
      }
      
##### Adding another set of calls      

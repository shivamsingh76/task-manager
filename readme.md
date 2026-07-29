**Command to start Postgres container:**

`docker run --name task-manager-service --network task-manager-network -it -e DB_HOST=my-postgres-container-2 -e DB_NAME=task_manager -e DB_USER=root -e DB_PASSWORD=1234 -p 8080:8080 task-manager:v1.1`


**Command to run docker container of service:**

`docker run --name task-manager-service --network task-manager-network -it -e DB_HOST=my-postgres-container-2 -e DB_NAME=task_manager -e DB_USER=root -e DB_PASSWORD=1234 -p 8080:8080 task-manager:v1.1`

reference URL : https://codeopstrek.com/how-to-dockerize-a-spring-boot-application/
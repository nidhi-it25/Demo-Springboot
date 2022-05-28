# Demo-Springboot

### Prerequisites

#### Database 

* docker run --name mysql-docker -e MYSQL_ROOT_PASSWORD=123456 -d mysql 
* docker exec -it mysql-docker mysql -uroot -p123456

#### Backend

* Spring Initializer 


### Maintain Database 

To create databse in container with sql file

* docker cp <source file location eg.:.\DockerProject\PersonDB.sql>  mysql-docker: <desination file location e.g.:/file.sql>  //Copy sql file in container
* docker exec -it mysql-docker mysql -uroot -p123456  // Exec container with username password

In Mysql import sql file

* source /file.sql (file path)
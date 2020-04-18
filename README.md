# cubing-mty-ws

# README #

RESTful api web services project for Cubing MTY app.


## How do I get set up? 

* install lombok plugin in STS: https://projectlombok.org/download

* run following docker command to create docker network: 

```bash
sudo docker network create --driver bridge cubingmtynet
```

* run following docker command to create mysql db: 

```bash
sudo docker run -d -p 3306:3306 --name cubosdb --network cubingmtynet -e MYSQL_ROOT_PASSWORD=password orlandoloza/cubos-mysql
```

* import pom.xml located in cubing-mty-ws folder as maven project in STS.

* to run application in docker: 

```bash
sudo docker run -d --name cubingmty-api --network cubingmtynet -p 8080:8080 orlandoloza/cubing-mty-ws
```

* open following url: http://localhost:8080/swagger-ui.html

## Contribution guidelines 

##### Branch naming conventions 

** Feature **:
Feature branches are used for specific feature work or improvements. They generally branch from, and merge back into, the development branch, by means of pull requests. See Feature branch workflow.

feature/<branch_name>
* * *

** Release **:
Release branches are used for release task and long-term maintenance of software versions. Typically, they branch from, and fixes are merged back into, the development branch. Merging into an older release branch allows for automatic merging to newer release branches as well as the development branch.

release/<branch_name>
* * *

** Bugfix **:
Bugfix branches are typically used to fix release branches.  

bugfix/<branch_name>
* * *

** Hotfix **
Hotfix branches are used to quickly fix the production branch without interrupting changes in the development branch. In a Gitflow-based workflow, changes are usually merged into the production and development branches.

hotfix/<branch_name>


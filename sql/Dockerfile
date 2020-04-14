FROM mysql:5.7.29
# Add a database
ENV MYSQL_DATABASE cubingmty
# Add the content of the sql-scripts/ directory to your image
# All scripts in docker-entrypoint-initdb.d/ are automatically
# executed during container startup
COPY ./scripts/ /docker-entrypoint-initdb.d/
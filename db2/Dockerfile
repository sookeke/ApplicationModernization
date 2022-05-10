FROM ibmcom/db2:11.5.5.0

RUN mkdir /var/custom
COPY createOrderDB.sql /var/custom
COPY orderdb-data.sql /var/custom
COPY --chown=1001 populateDB.sh /var/custom
# add none root user app
#RUN groupadd --gid 1000 app && useradd --uid 1000 --gid 1000 -m app
# switch to non-root user
#USER app
RUN chmod +x /var/custom/populateDB.sh
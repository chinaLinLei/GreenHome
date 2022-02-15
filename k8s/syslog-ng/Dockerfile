FROM smartjoker/openresty:base

# set project name
ENV project_name=green_home

# set work dir
WORKDIR /smart_joker/project/${project_name}/

# copy file
COPY ./config/syslog-ng.conf /etc/syslog-ng/syslog-ng.conf
COPY ./docker-entrypoint.sh /smart_joker/project/${project_name}/
ADD ./src/syslog-ng-3.32.1.tar.gz /smart_joker/project/${project_name}/src/
COPY ./src/*.rpm /smart_joker/project/${project_name}/src/

RUN chmod -R +x /smart_joker/project/${project_name}/*
RUN chmod  +x /etc/syslog-ng/*

# enter sh file
ENTRYPOINT /smart_joker/project/${project_name}/docker-entrypoint.sh


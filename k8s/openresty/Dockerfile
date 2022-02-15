FROM smartjoker/centos:base

# set project name
ENV project_name=green_home

# set work dir
WORKDIR /smart_joker/project/${project_name}/

# copy file
COPY ./docker-entrypoint.sh /smart_joker/project/${project_name}/
COPY ./busybox/busybox-* /smart_joker/project/${project_name}/busybox/busybox

# add env for busybox
ENV PATH="${PATH}:/smart_joker/project/${project_name}/busybox/"

RUN chmod +x /smart_joker/project/${project_name}/*
RUN chmod +x /smart_joker/project/${project_name}/busybox/*

# enter sh file
ENTRYPOINT /smart_joker/project/${project_name}/docker-entrypoint.sh



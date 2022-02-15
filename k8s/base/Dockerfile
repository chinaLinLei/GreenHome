FROM centos

# set project name
ENV project_name=green_home

# set work dir
WORKDIR /smart_joker/project/${project_name}/

# copy file
COPY ./docker-entrypoint.sh /smart_joker/project/${project_name}/
RUN chmod +x /smart_joker/project/${project_name}/*

# enter sh file
ENTRYPOINT /smart_joker/project/${project_name}/docker-entrypoint.sh



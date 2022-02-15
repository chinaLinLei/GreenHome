FROM centos

WORKDIR /smart_joker/project/love/

RUN echo '<!DOCTYPE html><html><head><meta charset="utf-8"><title>html学习</title></head><body><h1>我的第一个标题</h1><p>我的第一个段落。</p></body></html>'  >  index.html
COPY ./gcc/* /smart_joker/project/love/gcc/
COPY  ./1.txt /smart_joker/project/love/
COPY ./docker-entrypoint.sh /smart_joker/project/love/
ADD ./openssl/openssl-1.1.1g.tar.gz /smart_joker/project/love/openssl/
ADD ./busybox/busybox-1.33.1.tar.bz2 /smart_joker/project/love/busybox/
RUN chmod +x /smart_joker/project/love/*
RUN chmod +x /smart_joker/project/love/*/*
ENTRYPOINT /smart_joker/project/love/docker-entrypoint.sh



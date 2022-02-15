
echo 'start isntall gcc'

busybox wget https://openresty.org/package/centos/openresty.repo
mv openresty.repo /etc/yum.repos.d/
yum check-update
yum install -y openresty
yum install -y openresty-resty

/bin/bash

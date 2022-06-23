
echo 'yum install gcc make and base soft'
yum -y install gcc automake autoconf libtool make
yum -y install gcc gcc-c++

echo 'yum install openssl'
yum install openssl
yum update openssl
yum install -y openssl-devel

echo 'OK!!!'
/bin/bash

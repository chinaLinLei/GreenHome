
echo 'start isntall gcc'
cd gcc

# install gcc
rpm -ivh libstdc++-devel-8.3.1-5.1.el8.x86_64.rpm
rpm -ivh libmpc-1.0.2-9.el8.x86_64.rpm
rpm -ivh glibc-2.28-127.el8.i686.rpm
rpm -ivh kernel-headers-4.18.0-240.22.1.el8_3.x86_64.rpm
rpm -ivh glibc-headers-2.28-127.el8.x86_64.rpm
rpm -ivh gmp-6.1.2-10.el8.x86_64.rpm 
rpm -ivh libgomp-8.3.1-5.1.el8.x86_64.rpm
rpm -ivh isl-0.16.1-6.el8.x86_64.rpm
rpm -ivh cpp-8.3.1-5.1.el8.x86_64.rpm
rpm -ivh libxcrypt-devel-4.1.1-4.el8.x86_64.rpm --nodeps --force
rpm -ivh glibc-devel-2.28-127.el8.x86_64.rpm
rpm -ivh gcc-8.3.1-5.1.el8.x86_64.rpm
rpm -ivh gcc-c++-8.3.1-5.1.el8.x86_64.rpm
gcc -v
g++ -v

/bin/bash

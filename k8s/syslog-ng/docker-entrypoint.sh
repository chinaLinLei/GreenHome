echo 'start restart syslog-ng'

# add group and user
groupadd  smart_joker
useradd -g smart_joker -d /smart_joker -m -s /bin/bash smart_joker
cd src/syslog*
yum install -y https://dl.fedoraproject.org/pub/epel/epel-release-latest-8.noarch.rpm
yum install -y syslog-ng

#run syslog-ng
syslog-ng  --no-caps
echo 'end start syslog-ng'
tail -f /dev/null

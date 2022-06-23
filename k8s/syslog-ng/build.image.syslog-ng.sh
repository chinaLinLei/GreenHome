#仓库地址
harbor_host=smartjoker

#tag版本
version_tag=`date +%Y.%m%d.%H%M`

#制作镜像
docker build -t ${harbor_host}/syslogng:${version_tag} -f Dockerfile .

#提交镜像
docker push ${harbor_host}/syslogng:${version_tag}

#输出镜像版本
echo ${harbor_host}/syslogng:${version_tag}



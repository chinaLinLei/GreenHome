minikube config set memory 5200
minikube config set cpus 4
minikube start --vm-driver=docker --image-mirror-country=cn --registry-mirror=https://b3uey254.mirror.aliyuncs.com

## **1. Ubuntu 安装docker**

### 1.1 安装最新版安装docker

```sbtshell
curl -s https://get.docker.com:sh
```

### 1.2 普通安装

```sbtshell
sudo apt-get install docker.io
```

## **2. 安装查看删除镜像**

### 2.1 安装镜像

```sbtshell
docker pull [OPTIONS] <IMAGE-NAME>[:TAG]
 -参数 -资源名:版本
```

## 2.2 查看本机已有镜像

```sbtshell
docker images [OPTIONS] [REPOSITORY][:TAG]
```

## 2.3 删除容器和镜像

#### 2.3.1 查看当前运行的镜像

```sbtshell
# -a 查看container id
docker ps -a
```

#### 2.3.2 删除container

```
# 删除指定container
docker rm <CONTAINER-ID>

# 删除所有container
docker rm $(docker ps -a -q)
```

### 2.3.3 删除镜像

```sbtshell
# 需要先删除使用改镜像的容器,
docker rmi <IMAGE-ID>
```

## **3. docker启动,重启,关闭**

### 3.1 运行docker

```sbtshell
docker run [OPTIONS] <IMAGE-NAME>[:TAG][COMMAND][ARG...]
```

### 3.2 重启docker

```sbtshell
docker restart <IMAGE-ID>
```

### 3.3 关闭docker

```sbtshell
docker stop <IMAGE-ID>
```

## **4. 进入退出docker**

### 4.1 进入docker

```sbtshell
docker exec  [OPTIONS] <IMAGE-ID> [COMMAND]
# bash指终端
docker exec -it <IMAGE-ID> bash
```

### 4.2 退出docker

```sbtshell
exit
```

## **5. Docker网络**

### 5.1 网络类型

```
Bridge 独立模式,虚拟网卡,独立IP(默认) 
Host 和主机公用网络 
None 无网络
```

### 5.2 docker指定网络映射启动docker

```sbtshell
docker run -d -p <本机端口>:<DOCKER端口> <IMAGE-NAME>
```

### 5.3 docker随机网络映射启动docker

```sbtshell
docker run -d -P <IMAGE-NAME>
# 运行后会返回一个<IMAGE-ID>
```

## **6. 查看镜像的资源占用**

```sbtshell
docker stats <IMAGE-ID>
```

## **7. 查看端口占用**

```sbtshell
netstat -an | grep <端口>
```


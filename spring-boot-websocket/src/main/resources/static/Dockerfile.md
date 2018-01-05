## 1. 制作自己的镜像

### 1.1 Dockerfile 制作镜像配置文件

```sbtshell
# Dockerfile
from Docker-NAME

# 所有者
MAINTAINER hhjian hhjian.top@qq.com

# 运行命令
RUN sed -i 'http://mirrors.aliyun.com/ubuntu' /etc/apt/sources.list
RUN apt-get update
RUN apt-get install -y vim

# 复制文件到docker
COPY XX.war /usr/local/tomcat/webapp

# 容器入口
ENTRYPOINT ["/usr/sbin/nginx","-g","daemon off;"]

# 暴露端口
EXPOSE 80

# WORKDIR 指定工作路径
# WORKDIR /usr/local/tomcat/bin

# CMD 容易运行时执行命令
# CMD ["sh","startup.sh"]

# ADD 添加文件　
# ADD ./file.war /usr/local/tomcat/webapps

# USER 指定用户


# VOLUME 数据盘挂载

# ENV Define environment variable
```

### 1.2 构建docker

```sbtshell
docker build -t [DOCKER-NAME] [Dockerfile-path]
```

### 2. 查看当前进程

```sbtshell
ps -ef
```

## 复制文件到docker
```sbtshell
docker cp <CONTAINER-ID><FILE-PATH>
```

## 提交修改镜像
```sbtshell
docker commit -m 'description' <IMAGE-ID>
# 提交修改镜像
# 生成一个新的镜像
```

## 数据盘挂载
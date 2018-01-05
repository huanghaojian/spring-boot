- 容器和镜像:容器是镜像的一个实例
- dokcer-compose.yml:一个项目(多个镜像)的配置文件,用于同时管理多个容器,包括它们之间的关系
- Dockerfile:一个镜像的配置文件,建立一个镜像


docker-compose.yml
```yaml
version: "3"
services:
  web:
    # replace username/repo:tag with your name and image details
    image: hhjian/repository:1.0
    deploy:
      # 5个实例
      replicas: 5
      resources:
        # 限制每个实例使用
        limits:
          # 最多使用10％的CPU(跨所有内核)
          cpus: "0.1"
          # 最多使用50MB的RAM 
          memory: 50M
      restart_policy:
        # 如果发生故障,立即重新所有启动容器
        codition: on-failure
    # 主机映射
    ports:
      - "8080:8080"
    networks:
      - webnet
      
networks:
  webnet: 

```
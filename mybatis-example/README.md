# mapper에서 작성한 쿼리를 DB에서 조회했을 때의 결과와 mapper에서 resultMap을 사용했을 때의 결과가 어떻게 다른지 확인해봅시다.

> DB 설정은 a-example과 동일하다 - 대충 알 것 같다하면 src.main.resource.test.sql을 실행한다.

## Postgresql 데이터 베이스 설정(with docker)

<br>

### docker 설치

```
# yum update -y
# yum -y install yum-utils device-mapper-persistent-data lvm2
# yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo 
# yum install -y docker-ce docker-ce-cli containerd.io
```

<br>

### docker-compose 설치
```
# curl -L "https://github.com/docker/compose/releases/download/1.25.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

# chmod +x /usr/local/bin/docker-compose
# docker-compose --version
```

<br>

### 방화벽 open(openstack 사용 시 보안그룹에서 postgresql 포트(5432)를 추가해준다.)
```
# firewall-cmd --permanent --zone=public --add-port=5432/tcp
# firewall-cmd --reload
# firewall-cmd --list-all
```

<br>

### docker-compose.yml 작성
```
# mkdir postgresql
# cd postgresql
# vi docker-compose.yml


version: "2"
services:
    db:
        image: postgres:latest
        container_name: postgres
        restart: always
        ports:
            - "5432:5432"
        environment:
            POSTGRES_USER: postgres
            POSTGRES_PASSWORD: "0000"
        volumes:
            - /home/postgres/data/:/var/lib/postgresql/data

```

<br>

### docker 실행

```
#  systemctl restart docker
```

<br>

### docker-compose 실행

```
(docker-compose.yml을 작성한 디렉토리(postgresql)에서 실행)
# docker-compose up -d
```

### pgadmin OR aqua 등 DB tool로 DB에 접속

<br>

# test.sql 실행

<br>
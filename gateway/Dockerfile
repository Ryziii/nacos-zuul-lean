FROM java:openjdk-8-jdk-alpine
VOLUME /tmp
ADD target/*.jar app-gateway.jar
  
  #设置alpine系统时区
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/${TZ} /etc/localtime && echo ${TZ} > /etc/timezone

EXPOSE 8001
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app-gateway.jar" ]
FROM java:openjdk-8-jdk-alpine
VOLUME /tmp
ADD target/*.jar app-core.jar
  
  #设置alpine系统时区
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/${TZ} /etc/localtime && echo ${TZ} > /etc/timezone

EXPOSE 8002
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app-core.jar" ]
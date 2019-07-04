FROM registry.cn-hangzhou.aliyuncs.com/circle-registry/aofc_ai:0.4.7

LABEL version=0.4.7

COPY target/admin.jar /app.jar
COPY pineapple-ui /pineapple-ui
EXPOSE 80
EXPOSE 20880

WORKDIR /
ENTRYPOINT ["java","-Djava.library.path=/usr/local/lib", "-jar","/app.jar"]

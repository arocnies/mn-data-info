#FROM openjdk:8u171-alpine3.7
#RUN apk --no-cache add curl
FROM quay.io/radiantsolutions/omar-ossim-base:latest
COPY build/libs/*-all.jar mn-data-info.jar
ENV OSSIM_DATA /data
VOLUME /data
EXPOSE 8080
CMD java ${JAVA_OPTS} -jar mn-data-info.jar
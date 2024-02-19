FROM alpine:3.18.3
RUN apk add --no-cache openjdk17
RUN apk add --no-cache tzdata
COPY build/libs/ms_article1-1.0.4f3a077.jar /app/
WORKDIR /app/
ENTRYPOINT ["java"]
CMD ["-jar", "/app/ms_article1-1.0.4f3a077.jar"]

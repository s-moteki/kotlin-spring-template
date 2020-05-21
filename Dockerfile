FROM adoptopenjdk/openjdk8:alpine-slim

# TODO コメントもろもろ書く
ENV JAVA_OPTS=""

ENV LANG ja_JP.UTF-8
ENV LC_ALL ja_JP.UTF-8
ENV LC_CTYPE ja_JP.UTF-8

# タイムゾーン設定
RUN set -x && \
    apk update && \
    apk --update add tzdata && \
    cp /usr/share/zoneinfo/Asia/Tokyo /etc/localtime && \
    echo "Asia/Tokyo" > /etc/timezone && \
    apk del tzdata

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=demo-0.0.1-SNAPSHOT.jar

ADD ./build/libs/${JAR_FILE} /demo.jar

ENTRYPOINT java $JAVA_OPTS -Dfile.encoding=UTF-8 -Djava.security.egd=file:/dev/./urandom -jar /demo.jar

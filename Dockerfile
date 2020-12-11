FROM openjdk:8-jdk-alpine
LABEL stage=builder
ENV DB_URL jdbc:h2:mem:testdb
ENV DATA_PATH /datapath/
VOLUME /var/run/docker.sock:/var/run/docker.sock
#COPY . /tadre-moelle

USER root
RUN mkdir /datapath/
#Add SSH (For deployment step)
#RUN apk add openssh

# Add git, ssh, docker
RUN apk --update add git less openssh docker && \
    rm -rf /var/lib/apt/lists/* && \
    rm /var/cache/apk/*

#Clone repo
RUN git clone https://github.com/RallerenP/tadre-m-lle.git tadre-moelle && \
    cd tadre-moelle && \
    git checkout rallerenp-dev && \
    git pull origin rallerenp-dev && \
    chmod +x mvnw

#Add root to docker group (maybe not necessary)
run addgroup root docker
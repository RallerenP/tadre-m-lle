FROM openjdk:8-jdk-alpine
LABEL stage=builder
ENV DB_URL jdbc:h2:mem:testdb
ENV DATA_PATH /datapath/
#COPY . /tadre-moelle

USER root
RUN mkdir /datapath/
#Add SSH (For deployment step)
#RUN apk add openssh

# Add Git
RUN apk --update add git less openssh && \
    rm -rf /var/lib/apt/lists/* && \
    rm /var/cache/apk/*

 Clone repo
RUN git clone https://github.com/RallerenP/tadre-m-lle.git tadre-moelle && \
    cd tadre-moelle && \
    git checkout rallerenp-dev && \
    chmod +x mvnw
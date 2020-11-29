FROM openjdk:8-jdk-alpine
ENV DB_URL jdbc:h2:mem:testdb 
USER root

# Add Git
RUN apk --update add git less openssh && \
    rm -rf /var/lib/apt/lists/* && \
    rm /var/cache/apk/*

# Clone repo
RUN git clone https://github.com/RallerenP/tadre-m-lle.git && \
    cd tadre-m-lle && \
    git checkout rallerenp-dev && \
    chmod +x mvnw && \
    ./mvnw clean package
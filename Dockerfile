# imagem base do OpenJDK para Java 17
FROM openjdk:17-jdk-alpine

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o JAR do seu projeto para o contêiner
COPY target/api-0.0.1-SNAPSHOT.jar /app/api-0.0.1-SNAPSHOT.jar

EXPOSE 8080
# Comando para executar o aplicativo Spring Boot quando o contêiner for iniciado
CMD ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]

# Usa una imagen base que incluya Maven y JDK
FROM maven:3.8.5-openjdk-17-slim as build
 
# Configura el directorio de trabajo dentro del contenedor
WORKDIR /app
 
# Copia el archivo pom.xml y las dependencias para descargarlas primero
COPY pom.xml ./
COPY src ./src
 
# Ejecuta el comando mvn clean package para construir la aplicación
RUN mvn clean package -DskipTests
 
# Usa una imagen base más ligera para el runtime
FROM openjdk:17-jdk-alpine
 
# Configura el directorio de trabajo dentro del contenedor
WORKDIR /app
 
# Copia el archivo JAR desde la fase de construcción
COPY --from=build /app/target/apimonedas-0.0.1-SNAPSHOT.jar app.jar
 
# Expone el puerto que utiliza la aplicación Spring Boot
EXPOSE 8080
 
# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
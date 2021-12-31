FROM adoptopenjdk:11-jre-hotspot-bionic
ADD target/product-0.0.1-SNAPSHOT.jar product.jar
EXPOSE 8100
ENTRYPOINT [ "java", "-jar" , "product.jar"]

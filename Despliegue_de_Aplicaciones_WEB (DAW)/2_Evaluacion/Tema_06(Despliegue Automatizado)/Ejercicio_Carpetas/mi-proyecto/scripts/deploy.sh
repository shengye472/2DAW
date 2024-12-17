mvn clean install

scp ./target/*.jar alumno@192.168.1.145:/home/alumno/sheng/

plink alumno@192.168.1.145 -pw alumno "java -jar /home/alumno/sheng/mi-proyecto-0.0.1-SNAPSHOT.jar"


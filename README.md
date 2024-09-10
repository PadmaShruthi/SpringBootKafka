Starting Kafka in Local
-> Start the zookeper service with the command "\bin\windows\zookeeper-server-start.bat ..\..\config\zookeeper.properties"
-> Start the server with the command "\bin\windows\kafka-server-start.bat ../../config/server.properties" (this starts in default localhost 9092)
To produce messages through  the terminal, use "kafka-console-producer.bat --topic topic-example --bootstrap-server localhost:9092"
To consume messages in the terminal, use "kafka-console-consumer.bat --topic tutTopicJson --from-beginning --bootstrap-server localhost:9092"

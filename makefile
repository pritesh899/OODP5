default: 
	javac -cp /home/pratnapp/public_html/OODP5/mysql-connector.jar *.java

registry: 
	rmiregistry 1128 &

runServer: 
	java -cp ".:/home/pratnapp/public_html/OODP5/mysql-connector.jar" -Djava.security.policy=policy MarketServer

runClient: 
	java -Djava.security.policy=policy MarketPlaceClient
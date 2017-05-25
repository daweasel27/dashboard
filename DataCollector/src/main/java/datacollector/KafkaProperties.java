
package datacollector;

public class KafkaProperties {
    public static final String KAFKA_SERVER_URL = "localhost"; //this must be changed accordingly
    public static final int KAFKA_SERVER_PORT = 9092;
    public static final int KAFKA_PRODUCER_BUFFER_SIZE = 64 * 1024;
    public static final int CONNECTION_TIMEOUT = 100000;
    public static final String TOPIC = "sensors"; //for sensors we have topic sensors -> who would have guessed ai?¿?
    public static final String CLIENT_ID = "SimpleConsumerDemoClient";

    private KafkaProperties() {}
}


package datacollector;

import kafka.utils.ShutdownableThread;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer; 
import javax.naming.*;  
import javax.jms.*;  
import java.util.Collections;
import java.util.Properties;

public class Consumer extends ShutdownableThread {
    private final KafkaConsumer<Integer, String> consumer;
    private final String topic;
    
    
    
  private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
   private static final String PROVIDER_URL = "http-remoting://127.0.0.1:8080";
   private static final String CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
   private static final String DESTINATION = "jms/queue/SensorMessageBeanQueue";
   private static final String USERNAME = "nando";
   private static final String PASSWORD = "tobias";

    

    public Consumer(String topic) {
        super("KafkaConsumerExample", false);
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaProperties.KAFKA_SERVER_URL + ":" + KafkaProperties.KAFKA_SERVER_PORT);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "DemoConsumer");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

        consumer = new KafkaConsumer<>(props);
        this.topic = topic;
    }

    @Override
    public void doWork() {
        consumer.subscribe(Collections.singletonList(this.topic));
        ConsumerRecords<Integer, String> records = consumer.poll(1000);
        
        
      
      Context namingContext = null;
      JMSContext context = null;

      try {
         final Properties env = new Properties();
         env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
         env.put(Context.PROVIDER_URL, PROVIDER_URL);
         env.put(Context.SECURITY_PRINCIPAL, USERNAME);
         env.put(Context.SECURITY_CREDENTIALS, PASSWORD);

         namingContext = new InitialContext(env);

         ConnectionFactory connectionFactory = (ConnectionFactory) namingContext.lookup(CONNECTION_FACTORY);

         Destination destination = (Destination) namingContext.lookup(DESTINATION);

         context = connectionFactory.createContext(USERNAME, PASSWORD);

         JMSProducer producer = context.createProducer();
         for (ConsumerRecord<Integer, String> record : records) {
            System.out.println("Received message: (" + record.key() + ", " + record.value() + ") at offset " + record.offset());
            producer.send(destination, record.value());
         }
         
      } catch (Exception e) {
          // print error messge
      } finally {
          if (namingContext != null) {
             try {
                namingContext.close();
             } catch (NamingException e) {
                // print error messge
             }
          }

          if (context != null) {
             context.close();
          }
      
        }
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public boolean isInterruptible() {
        return false;
    }
}

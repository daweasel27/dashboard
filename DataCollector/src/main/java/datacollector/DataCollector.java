
package datacollector;

import kafka.javaapi.message.ByteBufferMessageSet;
import kafka.message.MessageAndOffset;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.log4j.varia.NullAppender;

public class DataCollector {
    
    private static void printMessages(ByteBufferMessageSet messageSet) throws UnsupportedEncodingException {
        for (MessageAndOffset messageAndOffset : messageSet) {
            ByteBuffer payload = messageAndOffset.message().payload();
            byte[] bytes = new byte[payload.limit()];
            payload.get(bytes);
            System.out.println(new String(bytes, "UTF-8"));
        }
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("olaaaaaaa");        
        org.apache.log4j.BasicConfigurator.configure(new NullAppender());
        Consumer consumerThread = new Consumer(KafkaProperties.TOPIC);
        consumerThread.start();
    }
}

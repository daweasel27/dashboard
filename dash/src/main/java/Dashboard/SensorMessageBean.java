package Dashboard;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "SensorMessageBean", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jboss/exported/jms/queue/SensorMessageBeanQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class SensorMessageBean implements MessageListener {
    private DataSelecter ds = new DataSelecter();
    private final static Logger LOGGER = Logger.getLogger(SensorMessageBean.class.toString());
    //@Resource
    //private MessageDrivenContext mdc;
    /**
     * @param rcvMessage
     * @see MessageListener#onMessage(Message)
     */
    @Override
    public void onMessage(Message rcvMessage) {
        TextMessage msg;
        try {
            if (rcvMessage instanceof TextMessage) {
                msg = (TextMessage) rcvMessage;
                LOGGER.log(Level.INFO, "Received Message from queue: {0}", msg.getText());
                ds.dataSelect(msg.getText());
            } else {
                LOGGER.log(Level.WARNING, "Message of wrong type: {0}", rcvMessage.getClass().getName());
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}

#!/usr/bin/env python
import threading, logging, time,random

from kafka import  KafkaProducer


tempSensors = [['roomStudy:temp',17],['roomSleep1:temp',17],['roomSleep2:temp',17]]

binSensors = [['home:mailBox',0],['home:door',0],['kitchen:smoke',0]]

class Manual_Producer():

    def start(self):
        producer = KafkaProducer(bootstrap_servers='localhost:9092')

        while True:
            producer.send('sensors', 'kitchen:temp#'+raw_input('sensor value - Kitchen: '))

class Auto_Producer():

    def start(self):
        producer = KafkaProducer(bootstrap_servers='localhost:9092')
        while True:
            for t in tempSensors:
                t[1] += random.randint(-2,2)
                producer.send('sensors',t[0]+"#"+str(t[1]))
                time.sleep(2)
            for b in binSensors:
                b[1] = random.randint(0,1)  
                producer.send('sensors',b[0]+"#"+str(b[1]))
                print(b[0]+"#"+str(b[1]))
            	time.sleep(2)
            time.sleep(2)		
#Auto_Producer().start()
Manual_Producer().start()

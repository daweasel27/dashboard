#!/usr/bin/env python

from kafka import KafkaConsumer


class Consumer():

    def start(self):
        consumer = KafkaConsumer(bootstrap_servers='localhost:9092',
                                 auto_offset_reset='earliest')

        #while True:
        consumer.subscribe(['sensors'])

        for message in consumer:
            print (message)



Consumer().start()


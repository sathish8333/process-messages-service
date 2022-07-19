package com.sr.messages.service;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Properties;

public class ProcessMessageService {
    public void consumeAndProcessMessages(StreamsBuilder stb) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "app1234");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Integer().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        //Configurations
        StreamsBuilder builder = new StreamsBuilder();
        KStream<Integer,String> ks1 = builder.stream("sr_topic_01");

        //ks1.filter((key,value) -> value.contains("sr")).to("sr_topic_01");
        ks1.foreach((key,value) -> System.out.print(value));
        Topology topology  = builder.build();
        KafkaStreams kafkastreams  = new KafkaStreams(topology,props);
        kafkastreams.start();
    }
}

package br.edu.ifpb.gugawag.so.sockets;

import java.util.HashMap;

public class Repository {
	
	private static HashMap<String,Topic> topics = new HashMap<String,Topic>();

	public static HashMap<String, Topic> getTopics() {
		return Repository.topics;
	}

	public static void setTopics(HashMap<String, Topic> topicos) {
		Repository.topics = topicos;
	}
	
	public static Topic addTopic (String name) {
		Topic newTopic = new Topic (name);
		Repository.topics.put(name, newTopic);
		return newTopic;
	}
    
	public static String readTopics () {
		if (Repository.topics.isEmpty()) {
			return null;
		}
		return Repository.topics.keySet().toString();
	}
	
	public static Topic getTopic(String topic) {
		return Repository.topics.get(topic);
	}

}

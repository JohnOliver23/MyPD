package br.edu.ifpb.gugawag.so.sockets;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Topic {
	
	private String topic;
	private List<String> mensagens;
	private List<Socket> followers;
	
	public Topic(String topic) {
		this.topic = topic;
		this.mensagens = new ArrayList<String>();
		this.followers = new ArrayList<Socket>();
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<String> getMensagens() {
		return mensagens;
	}

	public void addMensagens(String mensagen) {
		this.mensagens.add(mensagen);
	}

	public List<Socket> getFollowers() {
		return followers;
	}

	public void addFollower(Socket seguidor) {
		this.followers.add(seguidor);
	}

	@Override
	public String toString() {
		return "Topico [topic=" + topic + "]";
	}
}

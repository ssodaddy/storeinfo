package elasticsearch;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import io.vertx.core.json.JsonObject;

public class ConnBean {
	
	TransportClient client = null;
	String clusterName = "";
	String ip = "";
	int port = 0;
		
	public ConnBean(String clusterName, String ip, int port){
		this.clusterName = clusterName;
		this.ip = ip;
		this.port = port;
	}
	 
	public boolean TryConnection(){		
		try {
			Settings settings = Settings.builder()
			        .put("cluster.name", this.clusterName).build();
			
			this.client = new PreBuiltTransportClient(settings)
			        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(this.ip), this.port));
			return true;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public Map<String, Object> getInfoFromId(String index, String type, String id){
		GetResponse response = client.prepareGet(index, type, id).get();
		return response.getSource();
	}
}

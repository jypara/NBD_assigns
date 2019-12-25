
package task8;
 
import java.io.IOException;
import com.basho.riak.client.IRiakClient;
import com.basho.riak.client.RiakException;
import com.basho.riak.client.RiakFactory;
import com.basho.riak.client.RiakRetryFailedException;
import com.basho.riak.client.bucket.Bucket;
 
public class Task8{
 
	public static void main(String[] args) throws IOException {
 
		IRiakClient client = null;
		try {
			client = RiakFactory.pbcClient("127.0.0.1", 8087);
		} catch (RiakException e) {
			e.printStackTrace();
		}
		
		Bucket myBucket = null;
		String bucketName = "s20086";
		try {
			myBucket = client.fetchBucket(bucketName).execute();
			if (myBucket == null) {
				myBucket = client.createBucket(bucketName).execute();
			}
		} catch (RiakRetryFailedException e) {
			e.printStackTrace();
		}
		
		String document= "task8";
		String key= "One";
		try {
			myBucket.store(key, document).execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		
		String fetchedDocument = "";
		try {
			fetchedDocument = myBucket.fetch(key, String.class).execute();
			System.out.println("retrieve and println: "+ fetchedDocument );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			fetchedDocument = myBucket.fetch(key, String.class).execute();
			fetchedDocument +=" abc";
			myBucket.store(key, fetchedDocument).execute();
			
			fetchedDocument = myBucket.fetch(key, String.class).execute();
			System.out.println("modify and retrieve and println: " + fetchedDocument );
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		try {
			myBucket.delete(key).execute();
			fetchedDocument = myBucket.fetch(key, String.class).execute();
			System.out.println("delete and retrieve and println: " + fetchedDocument );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		client.shutdown();
 
	}
 
}
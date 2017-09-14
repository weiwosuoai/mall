import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.allenmall.common.utils.FastDFSClient;

/**
 * fastdfs 文件上传
 * @author Allen
 *
 */
public class FastDFSTest {
	
	/**
	 * 原生的 fastdfs 上传图片测试
	 * @throws Exception
	 */
	@Test
	public void testUploadFile() throws Exception {
		ClientGlobal.init("C:/developer/allenmallgit/allen-manager-web/src/main/resources/client.conf");
		// 创建一个 TrackerClient 对象
		TrackerClient trackerClient = new TrackerClient();
		// 使用 trackerClient 对象创建连接，获取一个 trackerServer 对象
		TrackerServer trackerServer = trackerClient.getConnection();
		// 创建一个 storageServer 的引用，值为  null
		StorageServer storageServer = null;
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 使用 storageClient 对象上传图片 Note:拓展名不带 .
		String[] strs = storageClient.upload_file("C:/Users/Allen/Pictures/timg.jpg", "jpg", null);
		
		// 返回数组，包含组名和图片的路径
		for (String str : strs) {
			System.out.println(str);
		}
	}
	
	/**
	 * fastdfs 封装工具类测试
	 * @throws Exception
	 */
	@Test
	public void testFastDFSClient() throws Exception {
		FastDFSClient client = new FastDFSClient("C:/developer/allenmallgit/allen-manager-web/src/main/resources/client.conf");
		String file = client.uploadFile("C:/Users/Allen/Pictures/1.jpg");
		System.out.println(file);
		
	}

}

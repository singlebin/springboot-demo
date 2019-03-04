/*
package springboot.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FTPUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FTPUtil.class);

	*/
/**
	 * ftp client
	 *//*

	private FTPClient ftpClient;
	
	*/
/**
	 * ftp server name
	 *//*

	private String ftpServer ;//= "10.201.48.2";
	
	*/
/**
	 * ftp server port
	 *//*

	private int ftpPort = 21;
	
	*/
/**
	 * ftp server login name
	 *//*

	private String userName = "intelligent_cluster";
	
	*/
/**
	 * ftp server login password
	 *//*

	
	private String password;
	//private String password = "passw0rd";
	
	public void setFtpServer(String ftpServer) {
		this.ftpServer = ftpServer;
	}

	public void setFtpPort(int ftpPort) {
		this.ftpPort = ftpPort;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public FTPUtil(String ftpServer, int ftpPort, String userName, String password) {
		this.ftpServer = ftpServer;
		this.ftpPort = ftpPort;
		this.userName = userName;
		this.password = password;
	}
	
	*/
/**
	 * 连接ftp server，如果连接失败返回false，否则返回true
	 * 
	 * @return
	 *//*

	public boolean connectFTPServer() {
		if (isConnected()) {
			return true;
		}
		
		ftpClient = new FTPClient();
		
		try {
			ftpClient.connect(ftpServer, ftpPort);

			if (ftpClient.login(userName, password)) {
				LOGGER.debug("login ftp server success!");
			} else {
				LOGGER.debug("login ftp server failed!");
				
				disconnectFTPServer();
				
				return false;
			}

			// 设置二进制文件类型
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.setConnectTimeout(15000);
			// 设置被动模式，避免防火墙的影响
			ftpClient.enterLocalPassiveMode();

			return true;
		} catch (IOException e) {
			LOGGER.error("connect or login ftp server failed: {}", e.getMessage());
			
			disconnectFTPServer();
			
			return false;
		}
	}
	
	*/
/**
	 * 断开ftp server连接，释放资源
	 *//*

	public void disconnectFTPServer() {
		// 断开连接
		try {
			if (isConnected()) {
				ftpClient.logout();
				
				ftpClient.disconnect();
			}
		} catch (IOException e) {
			LOGGER.error("disconnect ftp server failed: {}", e.getMessage());
		}
	}
	
	*/
/**
	 * 根据传入的全路径名获取ftp文件
	 * 
	 * @param fullPath
	 * @return
	 * @throws IOException 
	 *//*

	public byte[] fTPFileBytes(String fullPath) throws IOException {
		InputStream is = fTPFileInputStream(fullPath);
		
		return IOUtils.toByteArray(is);
	}
	
	*/
/**
	 * 获取输入流
	 * 
	 * @param fullPath
	 * @return
	 * @throws IOException
	 *//*

	public InputStream fTPFileInputStream(String fullPath) throws IOException {
		return ftpClient.retrieveFileStream(fullPath);
	}
	
	*/
/**
	 * 文件列表
	 * 
	 * @param fullPath
	 * @return
	 * @throws IOException
	 *//*

	public FTPFile[] getFTPFileList(String fullPath) throws IOException {
		FTPFile[] files = ftpClient.listFiles(fullPath);
		
		return files;
	}
	
	*/
/**
	 * 文件列表
	 * 
	 * @return
	 * @throws IOException
	 *//*

	public FTPFile[] getFTPFileList() throws IOException {
		FTPFile[] files = ftpClient.listFiles();
		
		return files;
	}
	
	*/
/**
	 * if the ftp client has connected.
	 * 
	 * @return true/false
	 *//*

	private boolean isConnected() {
		if (ftpClient == null) {
			return false;
		}
		
		return ftpClient.isConnected();
	}

	*/
/**
	 * change to folder
	 * 
	 * @param fullPath
	 * @return
	 * @throws IOException
	 *//*

	public boolean changeDirectory(String fullPath) throws IOException {
		return ftpClient.changeWorkingDirectory(fullPath);
	}
	
	*/
/**
	 * change to parent folder
	 * 
	 * @return
	 * @throws IOException
	 *//*

	public boolean changeToParentDirectory() throws IOException {
		return ftpClient.changeToParentDirectory();
	}
	
	*/
/**
	 * retrive file
	 * 
	 * @param fileName
	 * @param bos
	 * @return
	 * @throws IOException
	 *//*

	public boolean retrieveFile(String fileName, OutputStream os) throws IOException {
		return ftpClient.retrieveFile(fileName, os);
	}
	
	*/
/**
	 * 通过文件流上传到服务器
	 * 
	 * @param is
	 * @param fullPath
	 * @throws IOException
	 *//*

	public void uploadFile(InputStream is, String fullPath) throws IOException {
		ftpClient.storeFile(fullPath, is);
	}
	
}
*/

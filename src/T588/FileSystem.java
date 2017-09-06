package T588;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSystem {

	private INode ROOT;

	public FileSystem() {
		ROOT = new DirNode("");
	}

	public List<String> ls(String path) {
		try {
			INode node = ROOT.findNodeByPath(path.substring(1));
			return node.ls();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			return new ArrayList<String>();
		}
	}
	
	public void mkdir(String path) {
		try {
			ROOT.createSubNodes(path.substring(1), false);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void addContentToFile(String filePath, String content) {
		try {
			FileNode fileNode = (FileNode) ROOT.createSubNodes(filePath.substring(1), true);
			fileNode.appendContent(content);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String readContentFromFile(String filePath) {
		try {
			FileNode fileNode = (FileNode) ROOT.findNodeByPath(filePath.substring(1));
			return fileNode.getContent();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return "";
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileSystem filesys = new FileSystem();
		filesys.mkdir("/usr/bin");
	}

}

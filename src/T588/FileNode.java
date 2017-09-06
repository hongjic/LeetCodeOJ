package T588;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileNode extends AbstractNode{

	static {
		type = "FileNode";
	}
	
	private StringBuffer buffer;
	
	public FileNode(String name) {
		super(name);
		isRoot = false;
		this.buffer = new StringBuffer();
	}
	
	public String getContent() {
		return this.buffer.toString();
	}
	
	public void appendContent(String text) {
		buffer.append(text);
	}

	@Override
	public List<String> ls() {
		return Arrays.asList(name);
	}

	@Override
	public INode findNodeByPath(String path) throws IOException {
		if (path.equals("")) return this;
		throw new IOException("File not found.");
	}
	
	@Override
	public INode createSubNodes(String path, boolean isFile) throws IOException{
		throw new IOException("Can not create sub nodes in a non-directory.");
	}

}

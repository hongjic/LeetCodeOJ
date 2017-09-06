package T588;

import java.io.IOException;
import java.util.List;

public interface INode { 
	
	public String getName();
	
	public String getType();
	
	public boolean isRoot();
	
	public List<String> ls();
	
	public INode findNodeByPath(String path) throws IOException;
	
	public INode createSubNodes(String path, boolean isFile) throws IOException;
}

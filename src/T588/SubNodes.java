package T588;

import java.io.IOException;
import java.util.List;

public interface SubNodes {
	
	// create a sub INode and return that new INode
	public INode createSubNode(String nodeName, boolean isFile) throws IOException;
			
	// find a sub INode in the current directory.
	public INode findSubNode(String nodeName) throws IOException;
			
	// list all sub nodes' names.
	public List<String> listAllSubNodeNames();

}

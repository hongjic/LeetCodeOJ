package T588;

import java.io.IOException;
import java.util.List;

public class DirNode extends AbstractNode{
	
	static {
		type = "DirNode";
	}
	
	private SubNodes subNodes;
	
	public DirNode(String name) {
		super(name);
		isRoot = name.equals("");
		// use a Trie implementation of SubNodes
		subNodes = new TrieSubNodes();
	}
	
	@Override
	public INode createSubNodes(String path, boolean isFile) throws IOException{
		String[] nodeNames = path.split("/");
		
		// if this is the last INode to create.
		if (nodeNames.length == 1) {
			return subNodes.createSubNode(nodeNames[0], isFile);
		}
		
		// if this is not the last INode. Call createSubNodes recursively.
		else {
			DirNode subNode = (DirNode)subNodes.createSubNode(nodeNames[0], false);
			String subPath = path.substring(nodeNames[0].length() + 1);
			return subNode.createSubNodes(subPath, isFile);
		}
	}

	@Override
	public List<String> ls() {
		return this.subNodes.listAllSubNodeNames();
	}

	@Override
	public INode findNodeByPath(String path) throws IOException{
		// INode found.
		if (path.equals("")) return this;
		
		// else continue searching recursively.
		String[] nodeNames = path.split("/");
		INode subNode = subNodes.findSubNode(nodeNames[0]);
		String subPath = path.substring(nodeNames[0].length() + 1);
		return subNode.findNodeByPath(subPath);
	}
}

package T588;

public abstract class AbstractNode implements INode{
	
	protected static String type;
	
	protected String name;
	protected boolean isRoot;
	
	public AbstractNode(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getType() {
		return type;
	}
	
	@Override
	public boolean isRoot() {
		return isRoot;
	}
	
}

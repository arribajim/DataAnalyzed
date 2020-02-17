package mx.gambit.bean;

public class BaseBean {
	protected String Name;
	protected String NodeId;
	protected String ParentNodeId;
	protected Integer Priority;
	/**
	 * @return the nodeId
	 */
	public String getNodeId() {
		return NodeId;
	}
	/**
	 * @param nodeId the nodeId to set
	 */
	public void setNodeId(String nodeId) {
		NodeId = nodeId;
	}
	/**
	 * @return the parentNodeId
	 */
	public String getParentNodeId() {
		return ParentNodeId;
	}
	/**
	 * @param parentNodeId the parentNodeId to set
	 */
	public void setParentNodeId(String parentNodeId) {
		ParentNodeId = parentNodeId;
	}
	/**
	 * @return the priority
	 */
	public Integer getPriority() {
		return Priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Integer priority) {
		Priority = priority;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	
	public String toString() {
		return NodeId +", "+ Name+", "+Priority+", "+ParentNodeId;
	}
	public String sqlInsert() {
		String sql =String.format
        		("insert into TABLE_XX values ( %s, \'%s\', \'%s\', %s);",
        				NodeId,Name,Priority,ParentNodeId);
		return sql;
	}
}

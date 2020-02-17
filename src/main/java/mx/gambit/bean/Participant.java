package mx.gambit.bean;

public class Participant extends BaseBean{
	private String shortName;

	
	public String toString() {
		return NodeId +", "+ Name+", "+shortName+", "+ParentNodeId;
	}
	public String sqlInsert() {
		String sql =String.format
        		("insert into participants values ( %s, \'%s\', \'%s\', %s);",
        				NodeId,Name,shortName,ParentNodeId);
		return sql;
	}
	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}
	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
}

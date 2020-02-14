package mx.gambit.bean;

public class Participant extends BaseBean{
	private String shortName;
	private Boolean isHome;
	
	public String toString() {
		return NodeId +", "+ Name+", "+isHome+", "+shortName+", "+ParentNodeId;
	}
	public String sqlInsert() {
		String sql =String.format
        		("insert into participants values ( %s, \'%s\', %s, %s);",
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
	/**
	 * @return the isHome
	 */
	public Boolean getIsHome() {
		return isHome;
	}
	/**
	 * @param isHome the isHome to set
	 */
	public void setIsHome(Boolean isHome) {
		this.isHome = isHome;
	}
}

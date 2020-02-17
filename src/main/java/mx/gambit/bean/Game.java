package mx.gambit.bean;

public class Game extends BaseBean{
	private String displayTypeName;
	private String gameType;
	private boolean smartMarketAvailable;	
	private String eventNodeTypeId;	
	private String sportHandle;
	private String childrenCount;
	private boolean Locked;
	private Result result[];
	
	public String toString() {
		return NodeId +", "+ Name+", "+Priority+", "+ParentNodeId
				+", "+Locked;
	}
	public String sqlInsert() {
		String sql =String.format
        		("insert into games values ( %s, \'%s\',%s, %s, %s);",
        				NodeId,Name,Priority,Locked,ParentNodeId);
		return sql;
	}
	/**
	 * @return the displayTypeName
	 */
	public String getDisplayTypeName() {
		return displayTypeName;
	}
	/**
	 * @param displayTypeName the displayTypeName to set
	 */
	public void setDisplayTypeName(String displayTypeName) {
		this.displayTypeName = displayTypeName;
	}
	/**
	 * @return the gameType
	 */
	public String getGameType() {
		return gameType;
	}
	/**
	 * @param gameType the gameType to set
	 */
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	/**
	 * @return the smartMarketAvailable
	 */
	public boolean isSmartMarketAvailable() {
		return smartMarketAvailable;
	}
	/**
	 * @param smartMarketAvailable the smartMarketAvailable to set
	 */
	public void setSmartMarketAvailable(boolean smartMarketAvailable) {
		this.smartMarketAvailable = smartMarketAvailable;
	}
	
	/**
	 * @return the eventNodeTypeId
	 */
	public String getEventNodeTypeId() {
		return eventNodeTypeId;
	}
	/**
	 * @param eventNodeTypeId the eventNodeTypeId to set
	 */
	public void setEventNodeTypeId(String eventNodeTypeId) {
		this.eventNodeTypeId = eventNodeTypeId;
	}
	
	/**
	 * @return the sportHandle
	 */
	public String getSportHandle() {
		return sportHandle;
	}
	/**
	 * @param sportHandle the sportHandle to set
	 */
	public void setSportHandle(String sportHandle) {
		this.sportHandle = sportHandle;
	}
	/**
	 * @return the childrenCount
	 */
	public String getChildrenCount() {
		return childrenCount;
	}
	/**
	 * @param childrenCount the childrenCount to set
	 */
	public void setChildrenCount(String childrenCount) {
		this.childrenCount = childrenCount;
	}
	/**
	 * @return the locked
	 */
	public boolean isLocked() {
		return Locked;
	}
	/**
	 * @param locked the locked to set
	 */
	public void setLocked(boolean locked) {
		this.Locked = locked;
	}
	/**
	 * @return the result
	 */
	public Result[] getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(Result[] result) {
		this.result = result;
	}
}

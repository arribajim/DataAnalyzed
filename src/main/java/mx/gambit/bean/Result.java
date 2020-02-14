package mx.gambit.bean;

public class Result extends BaseBean{
	private String odd;
	private String sortOrder;
	private boolean isLive;
	private boolean upOdd;
	private boolean downOdd;
	
	private String  eventNodeTypeId;
	
	private String sportHandle;
	private String childrenCount;
	private boolean locked;
	
	public String toString() {
		return NodeId +", "+ Name+", "+Priority+", "+ParentNodeId
				+", "+locked+", "+odd;
	}
	/**
	 * @return the odd
	 */
	
	public String getOdd() {
		return odd;
	}
	/**
	 * @param odd the odd to set
	 */
	public void setOdd(String odd) {
		this.odd = odd;
	}
	/**
	 * @return the sortOrder
	 */
	public String getSortOrder() {
		return sortOrder;
	}
	/**
	 * @param sortOrder the sortOrder to set
	 */
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	/**
	 * @return the isLive
	 */
	public boolean isLive() {
		return isLive;
	}
	/**
	 * @param isLive the isLive to set
	 */
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
	/**
	 * @return the upOdd
	 */
	public boolean isUpOdd() {
		return upOdd;
	}
	/**
	 * @param upOdd the upOdd to set
	 */
	public void setUpOdd(boolean upOdd) {
		this.upOdd = upOdd;
	}
	/**
	 * @return the downOdd
	 */
	public boolean isDownOdd() {
		return downOdd;
	}
	/**
	 * @param downOdd the downOdd to set
	 */
	public void setDownOdd(boolean downOdd) {
		this.downOdd = downOdd;
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
		return locked;
	}
	/**
	 * @param locked the locked to set
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	
}

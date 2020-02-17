package mx.gambit.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Result extends BaseBean{
	private Number odd;
	private String sortOrder;
	private boolean isLive;	
	private String  eventNodeTypeId;		
	private boolean Locked;
	private Date dateOfGambitCheck;
	
	public String toString() {
		return NodeId +", "+ Name+", "+Priority+", "+ParentNodeId
				+", "+Locked+", "+odd +", "+ dateOfGambitCheck;
	}
	
	public String sqlInsert() {
		String sql =String.format
        		("insert into GAMBIT_RESULTS values ( %s, \'%s\',\'%s\', %s, %s, \'%s\', %s);",
        				NodeId,Name,getTimeStampFormat(),odd,Priority,Locked,ParentNodeId);
		return sql;
	}
	
	
	/**
	 * @return the timeStampFormat
	 */
	public String getTimeStampFormat() {
		String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(dateOfGambitCheck==null?new Date():dateOfGambitCheck);
	}

	/**
	 * @return the odd
	 */
	public Number getOdd() {
		return odd;
	}

	/**
	 * @param odd the odd to set
	 */
	public void setOdd(Number odd) {
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
	 * @return the locked
	 */
	public boolean isLocked() {
		return Locked;
	}

	/**
	 * @param locked the locked to set
	 */
	public void setLocked(boolean locked) {
		Locked = locked;
	}

	/**
	 * @return the dateOfGambitCheck
	 */
	public Date getDateOfGambitCheck() {
		return dateOfGambitCheck;
	}

	/**
	 * @param dateOfGambitCheck the dateOfGambitCheck to set
	 */
	public void setDateOfGambitCheck(Date dateOfGambitCheck) {
		this.dateOfGambitCheck = dateOfGambitCheck;
	}
	public void setDateOfGambitCheck(long dateOfGambitCheck) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(dateOfGambitCheck);
		this.dateOfGambitCheck = cal.getTime();
	}
	
}

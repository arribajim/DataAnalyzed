package mx.gambit.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends BaseBean{
	private Boolean Locked;
	private Date StarDate;	
	private String StatisticsId;
	

	public String toString() {
		return NodeId +", "+ Name+", "+Priority+", "+ParentNodeId
				+", "+Locked+", "+StarDate+", "+StatisticsId;
	}
	
	public String sqlInsert() {
		String sql =String.format
        		("insert into events values ( %s, \'%s\',\'%s\', %s, %s, \'%s\', %s);",
        				NodeId,Name,getTimeStampFormat(),Priority,Locked,StatisticsId,ParentNodeId);
		return sql;
	}
	/**
	 * @return the locked
	 */
	public Boolean getLocked() {
		return Locked;
	}

	/**
	 * @param locked the locked to set
	 */
	public void setLocked(Boolean locked) {
		Locked = locked;
	}

	/**
	 * @return the starDate
	 */
	public Date getStarDate() {
		return StarDate;
	}

	/**
	 * @param starDate the starDate to set
	 */
	public void setStarDate(Date starDate) {
		StarDate = starDate;
	}
	/**
	 * @return the statisticsId
	 */
	public String getStatisticsId() {
		return StatisticsId;
	}
	/**
	 * @param statisticsId the statisticsId to set
	 */
	public void setStatisticsId(String statisticsId) {
		StatisticsId = statisticsId;
	}

	/**
	 * @return the timeStampFormat
	 */
	public String getTimeStampFormat() {
		String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(StarDate);
	}
	 
}

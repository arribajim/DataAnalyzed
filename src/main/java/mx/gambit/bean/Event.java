package mx.gambit.bean;

import java.util.Date;

public class Event extends BaseBean{
	private Boolean Locked;
	private Date StarDate;
	private String StatisticsId;
	

	public String toString() {
		return NodeId +", "+ Name+", "+Priority+", "+ParentNodeId
				+", "+Locked+", "+StarDate+", "+StatisticsId;
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
}

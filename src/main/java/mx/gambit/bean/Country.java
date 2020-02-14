package mx.gambit.bean;

public class Country extends BaseBean {
	
	private String CountryCode;
	private League[] leagues=null;
	
	
	public String toString() {
		return  NodeId+", "+Name +", "+CountryCode+", "+Priority+", "+ParentNodeId;
	}
	public String sqlInsert() {
		String sql =String.format
        		("insert into countries values ( %s, \'%s\', \'%s\', %s);",
        				NodeId,Name,CountryCode,Priority);
		return sql;
	}
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return CountryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	/**
	 * @return the leagues
	 */
	public League[] getLeagues() {
		return leagues;
	}
	/**
	 * @param leagues the leagues to set
	 */
	public void setLeagues(League[] leagues) {
		this.leagues = leagues;
	}
}

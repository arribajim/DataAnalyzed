package mx.gambit.bean;

public class League extends BaseBean{
	
	public String sqlInsert() {
		String sql =String.format
        		("insert into leagues values ( %s, \'%s\', %s, %s);",
        				NodeId,Name,Priority,ParentNodeId);
		return sql;
	}
}

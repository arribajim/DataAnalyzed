package mx.gambit.bean;

public class Gambit extends Result{
	
	//insert into gambit values (nextval('gambit_nodeid_seq'),'2020-02-12 18:58:20.000',1.2,2599201059);

	public String toString() {
		return NodeId +", "+ getDateOfGambitCheck()+", "+getOdd()+", "+ParentNodeId;
	}
	public String sqlInsert() {
		String sql =String.format
        		("insert into gambit values (nextval( 'gambit_nodeid_seq'), \'%s\', %s, %s);",
        				getTimeStampFormat(),getOdd(),ParentNodeId);
		return sql;
	}
}

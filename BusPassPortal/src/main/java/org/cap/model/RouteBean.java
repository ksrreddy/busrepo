package org.cap.model;

public class RouteBean {
	private int routeid;
	private String routepath;
	private String routename;
	private int totalseats;
	private int occupiedseats;
	private String busno;
	private String driverNo;
	private int totalKilotmeters;
	public RouteBean() {
		
	}
	
	
	public RouteBean(int routeid, String routepath, String routename, int totalseats, int occupiedseats, String busno,
			String driverNo, int totalKilotmeters) {
		super();
		this.routeid = routeid;
		this.routepath = routepath;
		this.routename = routename;
		this.totalseats = totalseats;
		this.occupiedseats = occupiedseats;
		this.busno = busno;
		this.driverNo = driverNo;
		this.totalKilotmeters = totalKilotmeters;
	}
	public int getRouteid() {
		return routeid;
	}
	public void setRouteid(int routeid) {
		this.routeid = routeid;
	}
	public String getRoutepath() {
		return routepath;
	}
	public void setRoutepath(String routepath) {
		this.routepath = routepath;
	}
	public String getRoutename() {
		return routename;
	}
	public void setRoutename(String routename) {
		this.routename = routename;
	}
	public int getTotalseats() {
		return totalseats;
	}
	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}
	public int getOccupiedseats() {
		return occupiedseats;
	}
	public void setOccupiedseats(int occupiedseats) {
		this.occupiedseats = occupiedseats;
	}
	public String getBusno() {
		return busno;
	}
	public void setBusno(String busno) {
		this.busno = busno;
	}
	public String getDriverNo() {
		return driverNo;
	}
	public void setDriverNo(String driverNo) {
		this.driverNo = driverNo;
	}
	public int getTotalKilotmeters() {
		return totalKilotmeters;
	}
	public void setTotalKilotmeters(int totalKilotmeters) {
		this.totalKilotmeters = totalKilotmeters;
	}
	@Override
	public String toString() {
		return "RouteBean [routeid=" + routeid + ", routepath=" + routepath + ", routename=" + routename
				+ ", totalseats=" + totalseats + ", occupiedseats=" + occupiedseats + ", busno=" + busno + ", driverNo="
				+ driverNo + ", totalKilotmeters=" + totalKilotmeters + "]";
	}
	
	
	

}

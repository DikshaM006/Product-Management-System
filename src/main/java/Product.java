
public class Product {
    private int Pid;
    private String Pname;
    private String Ptype;
    private double Pcost;
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public String getPtype() {
		return Ptype;
	}
	public void setPtype(String ptype) {
		Ptype = ptype;
	}
	public double getPcost() {
		return Pcost;
	}
	public void setPcost(double pcost) {
		Pcost = pcost;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(Pcost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Pid;
		result = prime * result + ((Pname == null) ? 0 : Pname.hashCode());
		result = prime * result + ((Ptype == null) ? 0 : Ptype.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (Double.doubleToLongBits(Pcost) != Double.doubleToLongBits(other.Pcost))
			return false;
		if (Pid != other.Pid)
			return false;
		if (Pname == null) {
			if (other.Pname != null)
				return false;
		} else if (!Pname.equals(other.Pname))
			return false;
		if (Ptype == null) {
			if (other.Ptype != null)
				return false;
		} else if (!Ptype.equals(other.Ptype))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Product [Pid=" + Pid + ", Pname=" + Pname + ", Ptype=" + Ptype + ", Pcost=" + Pcost + "]";
	}
	public Product(int pid, String pname, String ptype, double pcost) {
		super();
		Pid = pid;
		Pname = pname;
		Ptype = ptype;
		Pcost = pcost;
	}
	public Product() {
		
	}
}

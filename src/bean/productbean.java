package bean;

public class productbean {
	private int id;
	private String category,image,productname,productdetail,price,mobileno,address;

	public productbean() {
		super();
	}

	public productbean(int id, String category, String image, String productname, String productdetail, String price, String mobileno,
			String address) {
		super();
		this.id = id;
		this.category = category;
		this.image = image;
		this.productname = productname;
		this.productdetail = productdetail;
		this.price = price;
		this.mobileno = mobileno;
		this.address = address;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductdetail() {
		return productdetail;
	}
	public void setProductdetail(String productdetail) {
		this.productdetail = productdetail;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}

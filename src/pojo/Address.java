package pojo;

public class Address {
	private Integer id;
	private String postCode;
	private String addressContent;
	private Integer userId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getAddressContent() {
		return addressContent;
	}
	public void setAddressContent(String addressContent) {
		this.addressContent = addressContent;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}

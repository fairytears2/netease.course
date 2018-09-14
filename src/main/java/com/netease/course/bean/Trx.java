package com.netease.course.bean;

public class Trx {

    private Integer id;
    private Integer personId;
    private long time;
    private Product product;
    private int num;
    private int addsettle;
    private int price;



	public int getAddsettle() {
		return addsettle;
	}

	public void setAddsettle(int addsettle) {
		this.addsettle = addsettle;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}

package com.sp.bdi.test.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("cook")
public class Cook {

	private Food f;

	public Food getF() {
		return f;
	}

	@Autowired
	@Qualifier
	public void setF(Food f) {
		this.f = f;
	}
}

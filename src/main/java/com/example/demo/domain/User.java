package com.example.demo.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{
	/**
	 * Description:
	 * @author yuanshihua
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private int pwd;
	private String username;
}

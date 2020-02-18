package com.OnlineWallet.pl;

import java.util.Scanner;

import com.OnlineWallet.exception.RegisterException;

public class Register {
	private static int userid;
	private String username;
	private String password;
	private String phoneNo;
	private String loginName;
	private String email;
	private String confirm_password;

	public void registerService() throws RegisterException {
		System.out.println("Add Your Details");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Your FullName");
		username = scan.nextLine();
		if (username.length() == 0)
			throw new RegisterException("Name Can't be Empty");
		else if (username.length() < 4)
			throw new RegisterException("Name Can't be Short");
		else if (!username.matches("[a-zA-Z]{5,}"))
			throw new RegisterException("Name Should Not Contain Any Special Characters and Numbers");
		System.out.println("Enter Your Email ");
		email = scan.nextLine();
		if (!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
			throw new RegisterException("Email Convention is not followed properly");
		System.out.println("Enter Your PhoneNumber");
		phoneNo = scan.nextLine();
		if (!phoneNo.matches("[0-9]{10}"))
			throw new RegisterException("PhoneNumber must be of 10 digits");
		System.out.println("Enter Your LoginName");
		loginName = scan.nextLine();
		if (RegisterDAO.Search(loginName))
			throw new RegisterException("LoginName is Already in use");
		/*
		 * At least one upper case letter, (?=.*?[A-Z]) At least one lower case letter,
		 * (?=.*?[a-z]) At least one digit, (?=.*?[0-9]) Minimum eight in length .{8,}
		 * (with the anchors)
		 */
		System.out.println("Enter the Password");
		password = scan.nextLine();
		if (password.length() < 7)
			throw new RegisterException("Password Length is short");
		else if (!password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$"))
			throw new RegisterException("Password is not According to the Convention");
		System.out.println("Confirm Your Password");
		confirm_password = scan.nextLine();
		if (password != confirm_password) {
			throw new RegisterException("Password Is Not Same As Above");
		}

	}

}
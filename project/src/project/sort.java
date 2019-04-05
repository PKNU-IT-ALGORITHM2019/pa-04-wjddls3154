package project;

 

import java.io.BufferedReader;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;

import java.util.Arrays;

import java.util.Comparator;

import java.util.Scanner;

 

public class sort {

	

	public static webLog []log = new webLog[100000];

	public static int n = 0;	

	public static boolean Time=false;

	public static boolean IP = false;

 

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while(true) {

			System.out.print("$ ");

			String reply = scanner.next();

			if(reply.equals("read")) {

				read();

			}

			else if(reply.equals("sort")) {

				String result = scanner.nextLine();

				result = result.substring(1);

				if(result.equals("-ip"))

					SortIp();

				else if(result.equals("-t")) 

					SortTime();

			}

			else if(reply.equals("print")) {

				print();

			}

			else if(reply.equals("exit")) {

				break;

			}

		}

		scanner.close();

	}

	public static void read() {

		try {

			Scanner scanner = new Scanner(new File("webLog.csv"));

			String[] tmp = new String[4];

			String data = scanner.nextLine();

			while(scanner.hasNext()) {

				data = scanner.nextLine();

				tmp = data.split(",");

				log[n++] = new webLog(tmp[0], tmp[1], tmp[2], tmp[3]);

			}

			scanner.close();

		} catch (FileNotFoundException e) {

			System.out.println("No File");

		}

	}

	public static void SortTime()

	{				

		Arrays.sort(log,webLog.timeComparator);

		Time=true;

	}

	public static void SortIp()

	{

		Arrays.sort(log, webLog.ipComparator);

		IP=true;

	}

	static void print() {

		if(IP) {

			for(int i = 0; i < n; i++) {

				System.out.println("IP : " + log[i].IP);

				System.out.println("Time : " + log[i].Time);

				System.out.println("URL : " + log[i].URL);

				System.out.println("Status : " + log[i].Status);

				System.out.println();

			}

		}

		else if(Time) {

			for(int i = 0; i < n; i++) {

				System.out.println("  "+log[i].Time);

				System.out.println("	IP : " + log[i].IP);

				System.out.println("	URL : " + log[i].URL);

				System.out.println("	Status : " + log[i].Status);

				System.out.println();

			}

		}

		else {

			for(int i = 0; i < n; i++) {

				System.out.println("  "+log[i].IP);

				System.out.println("	Time : " + log[i].Time);

				System.out.println("	URL : " + log[i].URL);

				System.out.println("	Status : " + log[i].Status);

				System.out.println();

			}

		}

		

	}

	

}
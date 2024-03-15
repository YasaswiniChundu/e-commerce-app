package org.jsp.lombokdemo;

public class SaveEmployee {
	 public static void main(String[] args) {
			Employee e=new Employee(1,"ABC","GHGE",34567289,"GDGHEH","IUURTUY");
			System.out.println(e);
			
			Employee e1=new Employee();
			e1.setId(5);
			System.out.println(e1);
			
			Employee e3=Employee.builder().desg("Trainer").email("abc@gmail.com").id(1).name("abc").password("hedhgh").build();
		}


}

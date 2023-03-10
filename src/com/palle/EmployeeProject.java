package com.palle;

import java.sql.*;

public class EmployeeProject 
{
	    private static Connection con=null;
		private static Statement s=null;
		private static PreparedStatement ps=null;
		
		private static final String classname="com.mysql.cj.jdbc.Driver";
		private static final String url="jdbc:mysql://localhost:3306/palle";
		private static final String username="root";
		private static final String password="admin";
		
		public static void create()
		{
			try 
			{
				Class.forName(classname);
				con=DriverManager.getConnection(url,username,password);
				s=con.createStatement();
				s.executeUpdate("create table employee(eno int primary key ,ename varchar(40),esal int)");
			} 
			catch (ClassNotFoundException e) 
			{
			   System.out.println("Check The URL");
			} 
			catch (SQLException e) 
			{
				System.out.println("Table ALready Exist");;
			}
			finally
			{
				try 
				{
					if(s!=null)
					{
					  s.close();	
					}
					if(con!=null)
					{
					  con.close();
					}
				} 
				catch (SQLException e) 
				{
				   e.printStackTrace();
				}
			}
	   }
	   public static void insert(int no,String name,int sal)
	   {
		   try 
			{
				Class.forName(classname);
				con=DriverManager.getConnection(url,username,password);
				ps=con.prepareStatement("insert into employee(eno,ename,esal) values(?,?,?)");
				ps.setInt(1, no);
				ps.setString(2, name);
				ps.setInt(3, sal);
				ps.executeUpdate();
				
			} 
			catch (ClassNotFoundException e) 
			{
			   System.out.println("Check The Url");
			} 
			catch (SQLException e) 
			{
			   System.out.println("insert The Presented Columns");
			}
			finally
			{
				try 
				{
					if(ps!=null)
					{
					  ps.close();	
					}
					if(con!=null)
					{
					  con.close();
					}
				} 
				catch (SQLException e) 
				{
				   e.printStackTrace();
				}
			}
        }

	    public static void update(int no,int sal)
	    {
	    	try 
	    	{
				Class.forName(classname);
				con=DriverManager.getConnection(url, username, password);
				ps=con.prepareStatement("update employee set esal=? where eno=?");
				ps.setInt(1, sal);
				ps.setInt(2, no);
				ps.executeUpdate();
			}
	    	catch(ClassNotFoundException e)
	    	{
	    		System.out.println("Check The Url");
	    	}
	    	catch (SQLException e) 
	    	{
				System.out.println("Update The Row Properly");
			} 
	    	finally
	    	{
	    		try
	    		{
	    		if(s!=null)
	    		{
	    		   s.close();
	    		}
	    		if(con!=null)
	    		{
	    			con.close();	
	    		}
	    		}
	            catch(SQLException e)
	    		{
	    			e.printStackTrace();
	    		}
	    	}
	   }
	    public static void delete(int no)
	    {
	    	try 
	    	{
				Class.forName(classname);
				con=DriverManager.getConnection(url, username, password);
		        ps=con.prepareStatement("delete from employee where eno=?");
		        ps.setInt(1,no);
				ps.executeUpdate();
			}
	    	catch(ClassNotFoundException e)
	    	{
	    		System.out.println("Check The Url");
	    	}
	    	catch (SQLException e) 
	    	{
				System.out.println("Already Deleted");
			} 
	        finally
	    	{
	    		try
	    		{
	    		if(s!=null)
	    		{
	    		  s.close();
	    		}
	    		if(con!=null)
	    		{
	    		  con.close();
	    		}
	    		}
	    		catch(SQLException e)
	    		{
	    			e.printStackTrace();
	    		}
	    	 }
	     }
}

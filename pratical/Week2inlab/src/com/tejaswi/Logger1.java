package com.tejaswi;

public class Logger1
{
private static Logger1 instance;
private Logger1()
{

}
public static Logger1 getInstance()
{
if(instance==null)
{
instance=new Logger1();
}
return instance;
}
public void log(String message)
{

System.out.println("Logging message: "+message);
}
}

package com.mysql.adapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.mysql.adapter.annotation.Metric;


//import ModuleQueries.OtherQueries;

public class MysqlReflectionTest {

	public static void main(String[] args) throws Throwable, RuntimeException {
		Scanner sc= new Scanner(System.in);
		MysqlMetrics msm= new MysqlMetrics();
		Class c = msm.getClass();
		Object obj=c.newInstance();
		HashMap<String,Method> metricMap = new HashMap();
		Method[] method=c.getMethods();
		for(Method m:method)
		{
			if(m.isAnnotationPresent(Metric.class))
			{
			Annotation an=m.getAnnotation(Metric.class);
			Metric m1=(Metric)an;
			metricMap.put(m1.name(),m);
			}
			
		}
		
		Set<String> str=new HashSet<String>();
		str=metricMap.keySet();
	    Iterator<String> it=str.iterator();
	    while(it.hasNext())
	    {
		Method m2=metricMap.get(it.next());
		System.out.println(m2.getName());
		m2.invoke(obj);
		System.out.println("");
	    }
		//Annotation[] ann= c.getDeclaredAnnotations(Metric.class);
	 // System.out.println(ann.length);

	}

}

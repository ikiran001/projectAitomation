package com.INB.Listener;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import com.INB.constants.FrameworkConstants;
import com.INB.utils.ExcelUtils;

public class MethodInteceptor 	implements IMethodInterceptor {

	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		/*
		 * List<ImethodInstance>methods contains all the test cases of the class
		 * List<Map<String, String>> list contains all the list of hashmaps of the excelsheet which contaisn test case data to be executed
		 *  List<IMethodInstance> result  will save all the eligible testcases to execute 
		 *  methods and list always start from '0' index
		 */

		List<Map<String, String>> list=ExcelUtils.getTestDetails(FrameworkConstants.getRunManagerSheet());
		List<IMethodInstance> result=new ArrayList<IMethodInstance>();

		for (int i=0 ; i<methods.size() ; i++ ) {
			for(int j=0 ; j<list.size(); j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname")) 
						&& list.get(j).get("execute").equalsIgnoreCase("yes")) {
					methods.get(i).getMethod().setDescription(list.get(j).get("testDescription"));
					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
					methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
					result.add(methods.get(i));//will save all the method instances
				}
			}
		}

	

	return result;
}

}

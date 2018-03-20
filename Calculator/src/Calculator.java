
public class Calculator 
{
	private final static short CONVERTVALUE = 48;   //Unicode中'0'与0的差值
	private int iPos = 0;  
	private int iLenth = 0;
	private String inFormula = null;
	private myStack valStack;  //数值栈     :int类型
	private myStack oprStack;  //操作符栈 :char类型
	public Calculator()
	{
		iPos = 0;
		iLenth = 0;
		valStack = null;
		oprStack = null;
	}
	
	public int run(String sFormula)
	{
		inFormula = sFormula;
		iLenth = inFormula.length();
		
		valStack = new myStack("INT", 200);
		oprStack = new myStack("CHAR", 200);
		for (iPos=0; iPos<iLenth; iPos++)
		{
			switch ( inFormula.charAt(iPos) )
			{
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9': proc_value();break;
				case '+': 
				case '-': oprStack.cPush(inFormula.charAt(iPos));break;
				case '*': 
				case '/': oprStack.cPush(inFormula.charAt(iPos));;break;
				case '(': oprStack.cPush(inFormula.charAt(iPos));;break;
				case ')': proc_right_brackets();break;
				default : break;
			}
			valStack.show();
			//oprStack.show();

		}
		return proc_add_sub();
	}
	
	private int convert(char cVal)
	{
		return cVal - CONVERTVALUE;
	}
	
	private void proc_value()
	{
		int tempAns = 0;
		int rigntVal = 0;
		int leftVal = 0;
		valStack.iPush(convert(inFormula.charAt(iPos)));	
		if (iPos > 0)
		{
			switch ( inFormula.charAt(iPos-1) )
			{
				case '*':
					rigntVal = valStack.iPop();
					leftVal = valStack.iPop();
					tempAns = leftVal * rigntVal;
					valStack.iPush(tempAns);
					oprStack.cPop();
					break;
				case '/':
					rigntVal = valStack.iPop();
					leftVal = valStack.iPop();
					tempAns = leftVal / rigntVal;
					valStack.iPush(tempAns);
					oprStack.cPop();
					break;
			}
		}
	}
	
	private int proc_add_sub()
	{
		int tempAns = 0;
		int rigntVal = 0;
		int leftVal = 0;
		while ( oprStack.getTop() > 0 )
		{
			char tempOpr = oprStack.cPop();
			switch ( tempOpr )
			{
				case '+':
					rigntVal = valStack.iPop();
					leftVal = valStack.iPop();
					tempAns = leftVal + rigntVal;
					valStack.iPush(tempAns);
					break;
				case '-':
					rigntVal = valStack.iPop();
					leftVal = valStack.iPop();
					tempAns = leftVal - rigntVal;
					valStack.iPush(tempAns);
					break;
			}
		}
		return valStack.iPop();
	}	
	
	private void proc_right_brackets()
	{
		int tempAns = 0;
		int rigntVal = 0;
		int leftVal = 0;
		boolean jumpFlag = false;
		char tempOpr = '\0';
		
		do 
		{
			tempOpr = oprStack.cPop();
			oprStack.show();
			switch ( tempOpr )
			{
				case '+':
					rigntVal = valStack.iPop();
					leftVal = valStack.iPop();
					tempAns = leftVal + rigntVal;
					valStack.iPush(tempAns);
					break;
				case '-':
					rigntVal = valStack.iPop();
					leftVal = valStack.iPop();
					tempAns = leftVal - rigntVal;
					valStack.iPush(tempAns);
					break;
				case '(':
					jumpFlag = true;
					break;
			}
		}while(!jumpFlag);
		
		jumpFlag = false;
		do
		{
			if(oprStack.getTop() > 0)
			{
				tempOpr = oprStack.cPop();
			}
			else
			{
				tempOpr = '\0';
			}
			switch ( tempOpr )
			{
				case '*':
					rigntVal = valStack.iPop();
					leftVal = valStack.iPop();
					tempAns = leftVal * rigntVal;
					valStack.iPush(tempAns);
					break;
				case '/':
					rigntVal = valStack.iPop();
					leftVal = valStack.iPop();
					tempAns = leftVal / rigntVal;
					valStack.iPush(tempAns);
					break;
				case '+':
				case '-':
					oprStack.cPush(tempOpr);
					jumpFlag = true;
					break;
				default:
					jumpFlag = true;
					break;
			}
		}while(!jumpFlag);
		
	}
	
	/*
	iLenth = sFormula.length();
	for (int i=0; i<iLenth; i++)
	{
		System.out.print(sFormula.charAt(i));
	}*/
}

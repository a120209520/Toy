public class myStack 
{
	public final int STACKSIZE;	
	enum stackType {tCHAR, tINT};
	
	private stackType type;
	private char[] cStack;
	private int[] iStack;
	private int top = 0;
	public myStack(String sType, int iSize)
	{
		top = 0;
		STACKSIZE = iSize;
		if (sType.equals("CHAR"))
		{
			type = stackType.tCHAR;
			cStack = new char[STACKSIZE];
		}
		else if (sType.equals("INT"))
		{
			type = stackType.tINT;
			iStack = new int[STACKSIZE];
		}
		else
		{
			System.out.println("Type is illegal! use: CHAR INT") ;
		}
	}
	
	public int getTop()
	{
		return top;
	}
	
	public void show()
	{
		if (stackType.tCHAR == type)
		{
			for(int i=0; i<top; i++)
			{
				System.out.printf("[%d]=%c ", i, cStack[i]);
			}
		}
		else if (stackType.tINT == type)
		{
			for(int i=0; i<top; i++)
			{
				System.out.printf("[%d]=%d ", i, iStack[i]);
			}
		}
		else
		{
			System.out.println("New a Object first!");
		}
		System.out.println();
	}
	
	public void cPush(char cVal)
	{
		if (stackType.tCHAR == type)
		{
			if (top < (STACKSIZE-1) ) //检查是否栈满
			{
				cStack[top++] = cVal;
			}
			else
			{
				System.out.println("The Stack is Full!");
			}
		}
		else 
		{
			System.out.println("Type is Wrong!");
		}
	}
	
	public char cPop()
	{
		if (stackType.tCHAR == type)
		{
			if (top > 0)
			{
				return cStack[--top];
			}
			else
			{
				System.out.println("The Stack is Empty!");
				return '\0';
			}
		}
		else 
		{
			System.out.println("Type is Wrong!");
			return '\0';
		}
	}
	
	public void iPush(int iVal)
	{
		if (stackType.tINT == type)
		{
			if (top < (STACKSIZE-1) ) //检查是否栈满
			{
				iStack[top++] = iVal;
			}
			else
			{
				System.out.println("The Stack is Full!");
			}
		}
		else 
		{
			System.out.println("Type is Wrong!");
		}
	}
	
	public int iPop()
	{
		if (stackType.tINT == type)
		{
			if (top > 0)
			{
				return iStack[--top];
			}
			else
			{
				System.out.println("The Stack is Empty!");
				return 0;
			}
		}
		else 
		{
			System.out.println("Type is Wrong!");
			return 0;
		}
	}
}





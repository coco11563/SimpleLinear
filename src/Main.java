
public class Main {
	public static void main(String[] args) 
	{
		ParamClass pc = new ParamClass();
		pc.initParam(20, 20, 0.01);
		pc.GradientDescent(Data.data);
	}
}

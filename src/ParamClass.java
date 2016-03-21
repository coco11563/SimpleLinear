
public class ParamClass {
	
public  double param1 ;
public  double param2;
public static double threshold = 0.1 ; 
public static int times = 1 ; 
public double alpha = 0.1;
//init the param matrix
public void initParam(double  param1 ,double param2)
{
	this.param1 = param1;
	this.param2 = param2;
	}
public void initParam(double  param1 ,double param2 , double alpha)
{
	this.param1 = param1 ;
	this.param2 = param2 ;
	this.alpha = alpha ;
	}
public double[] GradientDescent(double[][] data )
{
	System.out.printf("%f \n" , this.param1 );
	double [] outputParam = new double[2];
	double tmp ; 
	double M1 = 0 ;
	double M2 = 0 ;
	for(int i = 0 ; i < data.length ; i ++)
	{
		M1 = M1 + (param1 * data[i][0] + param2 - data [i][1]) * data[i][0] ; 
	}
	for(int i = 0 ; i < data.length ; i ++)
	{
		M2 = M2 + (param1 * data[i][0] + param2 - data [i][1]) ; 
	}
	tmp = param1 - this.alpha * (double)( 1.0 / data.length ) * M1 ;
	param2 = param2 - this.alpha * (double)( 1.0 / data.length ) * M2 ;
	param1 = tmp ; 
	if(this.times  >= 100000)
	{
		return outputParam ;
	}
	else
	{
	if(Math.abs(M1) <= threshold && Math.abs(M2) <= threshold)
	{
		times ++ ;
		System.out.printf("%f,%f,%f,%f \n" , param1 , param2 , M1 , M2 );
		return outputParam;
	
	}
	else
	{
		times ++ ;
		System.out.printf("%f,%f,%f,%f \n" , param1 , param2 , M1 , M2 );
		return this.GradientDescent(data);
	}
	}
	
	}
}

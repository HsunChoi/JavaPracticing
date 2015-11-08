package xun.stevens.cs561.homework1;


public class Sales {
	// customs data
	Customs customs;//package the name and product
	int day;
	int month;
	int year;
	String state;
	int quant;
	// assistant data in Question1
	int nyCount;
	int njCount;
	int ctCount;
	int nyAverage;
	int njAverage;
	int ctAverage;
	// assistant data in Question2
	int maxQuant;
	int minQuant;
	int aveQuant;
	int maxDay;
	int maxMonth;
	int maxYear;
	String maxState;
	int minDay;
	int minYear;
	int minMonth;
	String minState;
	int count;

	// constructor
	public Sales() {

	}

	// constructor
	public Sales(Customs customs, int day, int month, int year, String state,
			int quant) {
		this.customs = customs;
		this.day = day;
		this.month = month;
		this.year = year;
		this.state = state;
		this.quant = quant;
	}

	/*if the properities should be the private
	we can create set can get methods
	*/

	// overwrite equals methods
	@Override
	public boolean equals(Object arg0) {
		if (this.customs == ((Sales) arg0).customs) {
			return true;
		}

		return false;

	}

	// Create average methods to compute the average quantity
	public int average(Sales sales, int count) {
		int average = this.quant;

		return average;
	}

	// initialize NY
	public void setNY() {
		this.nyAverage = this.quant;
		this.njAverage = 0;
		this.ctAverage = 0;
		this.nyCount = 1;
		this.njCount = 0;
		this.ctCount = 0;
	}

	// initialize NJ
	public void setNJ() {
		this.nyAverage = 0;
		this.njAverage = this.quant;
		this.ctAverage = 0;
		this.nyCount = 0;
		this.njCount = 1;
		this.ctCount = 0;
	}

	// initialize CT
	public void setCT() {
		this.nyAverage = 0;
		this.njAverage = 0;
		this.ctAverage = this.quant;
		this.nyCount = 0;
		this.njCount = 0;
		this.ctCount = 1;
	}

	
	//sole the question 2 and 3;
	public void setMaxAndMinInf(Sales sales) {
		if (sales.quant < this.minQuant) {
			this.minQuant = sales.quant;
			this.minDay = sales.day;
			this.minMonth = sales.month;
			this.minYear = sales.year;
			this.minState = sales.state;
		} else if (sales.quant > this.maxQuant) {
			this.maxQuant = sales.quant;
			this.maxDay = sales.day;
			this.maxMonth = sales.month;
			this.maxYear = sales.year;
			this.maxState = sales.state;
		} else {
			// do nothing
		}
		this.aveQuant = ((this.aveQuant * this.count) + sales.quant) / (this.count + 1);
		this.count++;

	}
	public void inilizeQ2(){
		this.minQuant = this.quant;
		this.maxQuant = this.quant;
		this.aveQuant = this.quant;
		this.count = 1;
		this.minState = this.state;
		this.maxState = this.state;
	}

}

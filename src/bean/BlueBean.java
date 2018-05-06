package bean;

public class BlueBean {
	Integer blueColor,  lower, higher ;
	String guess;
	boolean success;
	String hintMsg;

	public BlueBean() {
		this.guess = "0"; this.lower = 0; this.higher = 255;
		initAnswer();
	}

	// 产生随机整数
	public synchronized void initAnswer() {
		blueColor = (int) (Math.random() * 256);// Math是java的数学类，用它的静态成员方法来进行各种数学计算，random随机产生数
		lower = 0;
		higher = 255;
		hintMsg = "0-255";
		success = false;
	}

	public Integer getBlueColor() {
		return blueColor;
	}
	
	public void setGuess(String guess) {//判断是否猜准
		Integer intGuess;
		try {
			intGuess = Integer.parseInt(guess);// 将字符串强制转换为整数
		} catch (NumberFormatException e) {
			intGuess = -1;
		}

		if(intGuess.compareTo( blueColor)==0){
			success = true;
		}else if (intGuess == -1){
			hintMsg = "请输入一个整数！";
		}else if (intGuess < blueColor) {
			lower = intGuess;
			hintMsg = " " + lower + " - " + higher + " ";
		} else if (intGuess > blueColor) {
			higher = intGuess;
			hintMsg = " " + lower + " - " + higher + " ";
		}
		this.guess = intGuess.toString();
	}

	public String getGuess() {
		return guess;
	}

	public Boolean getSuccess() {
		return success;
	}

	public String getHintMsg() {
		return " " + hintMsg;
	}
}

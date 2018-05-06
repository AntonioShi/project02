import java.util.ArrayList;


public class Statistics {
	Double average(ArrayList<Integer> scores){//要查资料,掌握ArrayList的用法
		double sum = 0.0;
		for(int i = 0; i < scores.size(); i++){
			sum += scores.get(i).doubleValue();
		}
		return sum/scores.size();
	}
	Integer max(ArrayList<Integer> scores){
		int high = scores.get(0).intValue();
		for(int i = 0; i < scores.size(); i++){
			if(high < scores.get(i).intValue()) high = scores.get(i).intValue(); 
		}
		return high;
	}
}

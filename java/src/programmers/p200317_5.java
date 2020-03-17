package programmers;
/*
 * [추석 트래픽]
 * => 못 푼 문제 (참고 :https://readystory.tistory.com/61)
 */
import java.util.*;
import java.text.*;
 
class p200317_5 {
    public int solution(String[] lines) {
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss.SSS");
        Date[] endDate = new Date[lines.length];
        Date[] startDate = new Date[lines.length];
        int max = Integer.MIN_VALUE;
		
        for(int i = 0; i < lines.length; i++) {
            try {
                String[] line = lines[i].split(" ");
                String dateStr = line[0] + " " + line[1];
                int procMilli = (int) (Double.parseDouble(line[2].substring(0, line[2].length()-1)) * -1000);
                endDate[i] = format.parse(dateStr);
                startDate[i] = addMilli(endDate[i], procMilli + 1);
            } catch(ParseException e) {
                e.printStackTrace();
            }
        }
		
        for(int i = 0; i < endDate.length; i++) {
            int maxTemp = 0;
            long endTimeMilliI = endDate[i].getTime();
            long finTimeMilli = addMilli(endDate[i], 1000).getTime();
			
            for(int j = 0; j < startDate.length; j++) {
                long startTimeMilli = startDate[j].getTime();
                long endTimeMilliJ = endDate[j].getTime();
                if((finTimeMilli - startTimeMilli) <= 0) {
                    continue;
                }
                if(((endTimeMilliI - startTimeMilli) <= 0 && (finTimeMilli - startTimeMilli) > 0)
                    || ((endTimeMilliI - endTimeMilliJ) <= 0 && (finTimeMilli - endTimeMilliJ) > 0)
                    || ((endTimeMilliI - startTimeMilli) > 0 && (endTimeMilliI - endTimeMilliJ) <= 0)) {
                    maxTemp++;
                }
            }
            max = Math.max(max, maxTemp);
        }
		
        return max;
    }
	
    private Date addMilli(Date date, int procMilli) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MILLISECOND, procMilli);
        return c.getTime();
    }
}
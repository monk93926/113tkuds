

public class StudentGradeSystem {

   
    public static String getGrade(int score) {
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else return "D";
    }

    public static void printReport(int[] scores, String[] grades) {
        System.out.println("====== 學生成績報告 ======");
        System.out.printf("%-10s%-10s%-10s\n", "學生編號", "分數", "等級");
        System.out.println("--------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10d%-10d%-10s\n", i, scores[i], grades[i]);
        }
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
      
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};
        String[] grades = new String[scores.length];

        int total = 0;
        int max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;
        int countA = 0, countB = 0, countC = 0, countD = 0;

        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            total += score;

            if (score > max) {
                max = score;
                maxIndex = i;
            }
            if (score < min) {
                min = score;
                minIndex = i;
            }

            grades[i] = getGrade(score);
            switch (grades[i]) {
                case "A": countA++; break;
                case "B": countB++; break;
                case "C": countC++; break;
                case "D": countD++; break;
            }
        }

        
        double average = (double) total / scores.length;
        int countAboveAvg = 0;
        for (int score : scores) {
            if (score > average) {
                countAboveAvg++;
            }
        }
        double percentAboveAvg = (double) countAboveAvg / scores.length * 100;

     
        printReport(scores, grades);

     
        System.out.println("====== 成績統計摘要 ======");
        System.out.printf("全班平均分數：%.2f\n", average);
        System.out.println("最高分：" + max + "（學生編號：" + maxIndex + "）");
        System.out.println("最低分：" + min + "（學生編號：" + minIndex + "）");
        System.out.println("等級 A 人數：" + countA);
        System.out.println("等級 B 人數：" + countB);
        System.out.println("等級 C 人數：" + countC);
        System.out.println("等級 D 人數：" + countD);
        System.out.printf("高於平均分數的學生比例：%.1f%%\n", percentAboveAvg);
        System.out.println("============================");
    }
}

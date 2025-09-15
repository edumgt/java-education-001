import java.util.Calendar;

public class EnumExam {
    public static void main(String[] args) {
        Week today = null; // 오늘의 요일(enum 타입)을 저장할 변수

        // 현재 날짜/시간 정보를 가져옴
        Calendar cal = Calendar.getInstance();

        // Calendar.DAY_OF_WEEK → 1(일요일) ~ 7(토요일)
        int week = cal.get(Calendar.DAY_OF_WEEK);

        // 요일 숫자를 enum 값으로 매핑
        switch (week) {
            case Calendar.SUNDAY: // 1
                today = Week.SUNDAY;
                break;
            case Calendar.MONDAY: // 2
                today = Week.MONDAY;
                break;
            case Calendar.TUESDAY: // 3
                today = Week.TUESDAY;
                break;
            case Calendar.WEDNESDAY: // 4
                today = Week.WEDNESDAY;
                break;
            case Calendar.THURSDAY: // 5
                today = Week.THURSDAY;
                break;
            case Calendar.FRIDAY: // 6
                today = Week.FRIDAY;
                break;
            case Calendar.SATURDAY: // 7
                today = Week.SATURDAY;
                break;
            default:
                today = null; // 예외적인 경우 (거의 발생하지 않음)
        }

        // 오늘 요일 출력
        if (today != null) {
            System.out.println("오늘은 " + today + " 입니다.");
        } else {
            System.out.println("요일 정보를 가져올 수 없습니다.");
        }
    }
}

enum Week {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY

}
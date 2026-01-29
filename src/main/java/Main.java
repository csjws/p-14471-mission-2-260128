import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<WiseSaying> list = new ArrayList<>();
        int cnt =1;
        System.out.println("== 명언 앱 ==");
        while(true){
            System.out.print("명령) ");
            String str = sc.nextLine();
            if(str.equals("종료")){
                break;
            }
            else if(str.equals("등록")){
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
                WiseSaying ws = new WiseSaying(cnt, author, content);
                list.add(ws);
                System.out.println(cnt+"번 명언이 등록되었습니다.");
                cnt++;
            }
            else if(str.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int i = list.size() - 1; i >= 0; i--) {
                    WiseSaying ws = list.get(i);
                    System.out.println(ws.id + " / " + ws.author + " / " + ws.content);
                }
            }
            else if (str.startsWith("삭제?id=")) {
                int id = Integer.parseInt(str.substring(6));

                WiseSaying target = null;

                for (WiseSaying ws : list) {
                    if (ws.id == id) {
                        target = ws;
                        break;
                    }
                }

                if (target != null) {
                    list.remove(target);
                    System.out.println(id + "번 명언이 삭제되었습니다.");
                } else {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }
            }
            else if (str.startsWith("수정?id=")) {
                int id = Integer.parseInt(str.substring(6));

                WiseSaying target = null;

                for (WiseSaying ws : list) {
                    if (ws.id == id) {
                        target = ws;
                        break;
                    }
                }

                if (target != null) {
                    System.out.println("명언(기존) :" + target.content);
                    System.out.print("명언 : ");
                    target.content = sc.nextLine();
                    System.out.println("작가(기존) :" + target.author);
                    System.out.print("작가 : ");
                    target.author = sc.nextLine();
                } else {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }
            }
            else{

            }
        }
    }
}

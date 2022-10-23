
public class DeleteMemController {

	DeleteMemService service = new DeleteMemService();
	
	public void process() {
		System.out.println("ID를 삭제하시겠습니까? (Y/N)");
		String check = InpuString.scan.nextLine();
		if(check.equals("N") || check.equals("n")) {
			System.out.println("이전 화면으로 돌아갑니다.");
			// 회원정보 화면으로 이동
		} else if(check.equals("Y") || check.equals("y")) {
			int result = service.deleteMem();
			if(result>0) {
			System.out.println("회원 정보가 삭제되었습니다.");
			// 타이틀 화면으로 이동
			// swtich -case 구문 return;해서 돌아가기..?
			} else {
				System.out.println("오류가 발생하여 탈퇴실패하였습니다.");
			}
		}
	}
}


public class InsertMemController {

	private InsertMemService service = new InsertMemService();

	public void process() {

		while (true) {
			System.out.println("회원 가입을 시작합니다.");
			System.out.print("ID >> ");
			String id = new chkIdService().chkId();
			System.out.print("비밀번호 >> ");
			String password = InputString.scan.nextLine();
			System.out.print("닉네임 >> ");
			String nickname = InputString.scan.nextLine();
			System.out.println("지역 >> ");
			String loc = InputString.scan.nextLine();

			int result = service.insertMem(new UserData(id, password, nickname, loc));

			if (result > 0) {
				System.out.println("가입되었습니다.");
				break;
			}
			else {
				System.out.println("오류가 발생하여 가입실패했습니다.");
				continue;
			}
		}
	}
}

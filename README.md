# OneandAll

## 솔데스크 1차 프로젝트


## 2월 4일 기능 추가 설명
1.CPT_CPTManger 안에 회원정보가 담기는데 이걸 가져오기 위해서 객체를 생성해주었다.
2.memberName이라는 String 배열은 cList의 크기 (회원수) 만큼 크기를 설정해 준다.
3.memberName에 있는 정보를 for문을 돌며 가져온다. 아래와 같은 로직은 모든 정보를 가져오겠다는 의미
4.JComboBox를 만들어서 해당 멤버들의 정보를 담아주면 드랍다운 메뉴에 멤버의 이름들이 출력된다.
5.try~catch로 묶은 이유는 Combobox에 아무것도 없으면 에러가 뜨기 때문. 
->에러 발생시 "비어잇음"이라는 문구를 콘솔창에 띄우고 팀원들의 이름이 들어간 Combobox를 기본적으로 생성
6.p_West라는 패널에 콤보박스를 넣어준다.

		try {
			if(manager.cList.size()!=0) {
				CPT_CPTManager m = new CPT_CPTManager();
				
				memberName = new String[manager.cList.size()];
				
				for(int i=0; i<memberName.length;i++) {
					memberName[i]=m.cList.get(i).name;
					System.out.println(m.cList.get(i).name);
				}
				JComboBox<String> jComboBox = new JComboBox<>(memberName);
				p_West.add(jComboBox);
			}
		} catch (Exception e) {
			System.out.println("비어잇음");
			memberName =  new String[6];
			String[] memberName = {"개인일정" , "김병효(팀장)", "이채윤(부팀장)", "김형우", "김주은", "김지성"};
			
			JComboBox<String> jComboBox = new JComboBox<>(memberName);
			p_West.add(jComboBox);
		} 

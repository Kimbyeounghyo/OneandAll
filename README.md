# OneandAll

## 솔데스크 1차 프로젝트


## 2월 4일 기능 추가 설명
1.CPT_CPTManger 안에 회원정보가 담기는데 이걸 가져오기 위해서 객체를 생성해주었다.<br>
2.memberName이라는 String 배열은 cList의 크기 (회원수) 만큼 크기를 설정해 준다.<br>
3.memberName에 있는 정보를 for문을 돌며 가져온다. 아래와 같은 로직은 모든 정보를 가져오겠다는 의미<br>
4.JComboBox를 만들어서 해당 멤버들의 정보를 담아주면 드랍다운 메뉴에 멤버의 이름들이 출력된다.<br>
5.try~catch로 묶은 이유는 Combobox에 아무것도 없으면 에러가 뜨기 때문. <br>
->에러 발생시 "비어잇음"이라는 문구를 콘솔창에 띄우고 팀원들의 이름이 들어간 Combobox를 기본적으로 생성<br>
6.p_West라는 패널에 콤보박스를 넣어준다.<br>

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
### >>>>>> 화면설명		
		
![a](https://user-images.githubusercontent.com/96603612/216768655-1c1e7eb1-a714-40f3-9639-516901684d98.jpg)
계정 id : 1234 로 회원가입 후 로그인 했을 때 화면 
![1](https://user-images.githubusercontent.com/96603612/216768660-ef5728dd-263f-4f91-bcd7-211c5516af95.jpg)
회원 수가 0 명인 경우
![image](https://user-images.githubusercontent.com/96603612/216768814-ba864f85-3762-4989-a0b6-fd4130b1c621.png)

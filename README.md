# OneandAll

## 솔데스크 1차 프로젝트

## 직접 만든 메소드 1 : 개인 일정 
1. 파라미터(매개변수)로 이름을 넣으면 해당 이름에 해당하는 파일을 불러오는 메소드
2. 파일내에 ㅁ월 ㅁ일 할일 이란 글이 보이면 일자와 할일을 불러와 화면에 띄운다.
3. 일정 두개까지 겹치지 않고 등록 가능<br>
		
		public void personalSch(String name) {//name = 파일 명
		
		try {
			Charset charset = Charset.forName("UTF-8");
			List<String> lines = Files.readAllLines(Paths.get(name),charset);
			System.out.println(lines);
			List<Integer> list = new ArrayList<>();
			for(String line : lines) {
				int day = 0;
				String todo = "";
				
				if(line.charAt(4)=='일') {//숫자가 아니면  1일 ~9일 사이
					//System.out.print(i.charAt(3));
					day = (int)line.charAt(3)-48;
					
					for(int i=6; i<line.length();i++) {
						todo += line.charAt(i);
					}
					
					if(list.contains(day)) {
						 //System.out.println("중복 발생 " );
						 tempH+=12;
					 }else if(!list.contains(day)) {
						// System.out.println("중복이 아니면 높이 초기화");
						 tempH=0;
					 }
					list.add(day);
				}else if(line.charAt(4)>=48&&line.charAt(4)<=57) { //10일 ~31일 사이
					
					//System.out.print(((int)i.charAt(3)-48)*10 +(int)i.charAt(4)-48);
					day = ((int)line.charAt(3)-48)*10 +(int)line.charAt(4)-48;
				
					for(int i=7; i<line.length();i++) {
						todo += line.charAt(i);
					}
					
					if(list.contains(day)) {
						// System.out.println("중복 발생 " );
						 tempH+=12;
					 }else if(!list.contains(day)) {
						 //System.out.println("중복이 아니면 높이 초기화");
						 tempH=0;
					 }
					 list.add(day);
				}
				//System.out.println();
				
				c_textArea.append(line.toString()+"\n");//불러온 글을 텍스트 에리아에 올리는 로직
				
				if(tempH<12) {
					 p_bar_G=new PinkButton(todo);
					 p_bar_G.setBounds(14,tempH,70,12);
				}else if(tempH>=12 && tempH<24) {
					 p_bar_G=new UI_GreenButton(todo);
					 p_bar_G.setBounds(14,tempH,70,12);
				}
				
				 Label_Day[day+2].setBackground(new Color(255,255,242));
				 Label_Day[day+2].add(p_bar_G);
				 
				 p_bar_G.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new S_MemoFrame();
					}
				});
			}//for line end
		} catch (IOException e2) {
			System.out.println("파일이 없음");
			}
		}
		
### >>>>>> 화면설명	
![image](https://user-images.githubusercontent.com/96603612/216769479-39c094d7-1840-499f-b2ff-77a7d643a73e.png)
![image](https://user-images.githubusercontent.com/96603612/216769321-c631ccfe-2985-4151-9c7c-a4dd65f2b46e.png)		
		

## 2월 4일 추가기능 1
1. CPT_CPTManger 안에 회원정보가 담기는데 이걸 가져오기 위해서 객체를 생성해주었다.
2. memberName이라는 String 배열은 cList의 크기 (회원수) 만큼 크기를 설정해 준다.
3. memberName에 있는 정보를 for문을 돌며 가져온다. 아래와 같은 로직은 모든 정보를 가져오겠다는 의미
4. JComboBox를 만들어서 해당 멤버들의 정보를 담아주면 드랍다운 메뉴에 멤버의 이름들이 출력된다.
5. try~catch로 묶은 이유는 Combobox에 아무것도 없으면 에러가 뜨기 때문. 
->에러 발생시 "비어잇음"이라는 문구를 콘솔창에 띄우고 팀원들의 이름이 들어간 Combobox를 기본적으로 생성
6. p_West라는 패널에 콤보박스를 넣어준다.<br>

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
		
![a](https://user-images.githubusercontent.com/96603612/216768655-1c1e7eb1-a714-40f3-9639-516901684d98.jpg)<br>
계정 id : 1234 로 회원가입 후 로그인 했을 때 화면 
![1](https://user-images.githubusercontent.com/96603612/216768660-ef5728dd-263f-4f91-bcd7-211c5516af95.jpg)
회원 수가 0 명인 경우
![image](https://user-images.githubusercontent.com/96603612/216768814-ba864f85-3762-4989-a0b6-fd4130b1c621.png)


## 2월 4일 추가기능 2 
1. 텍스트 화면에서 엔터를 치자마자 화면에 일정이 짠하고 나타나는 기능
2. 저장하는 것까지가 백엔드라면 일단 프론트를 구현했다. 
3. 바의 높이를 tempH로 설정하여 추가로 중복 일정에 따라 생성되는 바의 높이가 다르게 생기게끔 구현할 예정이다.
4. 일정을 바로 바에 담을 수 있도록 하였다.
5. 주의 할 점은 버튼 바의 객체 생성위치 값을 비교할 때 .Text()를 붙여주어야 한다는 점. Label의 배경색을 변경해 주어야 바가 화면에 나타나는 점이다.


 	tf2.addKeyListener(new KeyAdapter() {
			 
			 @Override
			 public void keyTyped(KeyEvent e) {
				
				 if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					 c_textArea.append(cF.month+"월 "+ tf.getText()+"일 "+tf2.getText()+"\n");
					
					 System.out.println(tf.getText());
					 tempH=0;
					 //바로 화면에 띄우는 메소드
					 for(int i=0; i<Label_Day.length;i++) {
						 p_bar_G= new UI_PinkButton(tf2.getText());
						 if(Label_Day[i].getText().equals(tf.getText())){
							 Label_Day[i].setBackground(new Color(255,255,242));
							 p_bar_G= new UI_PinkButton(tf2.getText());
							 Label_Day[i].add(p_bar_G);
							 p_bar_G.setBounds(14,tempH,70,12);
							 break;
						 }
					 }
				 }//if end
			}
		 });

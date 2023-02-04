# OneandAll

## 솔데스크 1차 프로젝트


## 2월 4일 작업

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

package character;

public class PlayerCommands {

	public void command(String input){
		
		int type=-1;
		String[] temp = input.split(":");
		if(temp[0].equals("forward")){
			input=temp[0];
			type=Integer.parseInt(temp[1]);
		}
		
		switch(input){
		
			case("forward"): teleportF(type); break;
			case("reverse"): teleportR(); break;
			case("chopTree"): chopTree(); break;
			case("mineOre"): mineOre(); break;
				
			default: break;
		}
		
	}
	
	private void teleportF(int type){
		System.out.println("teleportF "+type);
	}
	
	private void teleportR(){
		System.out.println("teleportR");
	}
	
	private void chopTree(){
		System.out.println("chop");
	}
	
	private void mineOre(){
		System.out.println("mine");
	}
	
}
package aaaMap;

import java.io.File;
import java.util.Scanner;

public class MapNode {
	
	private static Node Header;
	private static Node currentNode;
	
	public static void forwardMap(int i){
		if(currentNode.getNext()[i]!=null){
			currentNode=currentNode.getNext()[i];
			Map._import(currentNode.getMap());
		}
	}
	
	public static void reverseMap(){
		if(currentNode.getPrev()!=null){
			currentNode=currentNode.getPrev();
			Map._import(currentNode.getMap());
		}
	}
	
	public static void temp(){

		Header = recurs("Start", null);
		currentNode=Header;
		
		Map._import(currentNode.getMap());
		
	}
	
	private static Node recurs(String name, Node prev){
		
		try{
			String startPoint="res\\nodes\\"+name+".node";
			File file = new File(startPoint);
			Scanner in = new Scanner(file);
			
			String mapName="";
			Node nextMaps[] = new Node[3];
			
			if(in.hasNext()){
				mapName = in.nextLine();
			}
			
			Node node = new Node(mapName, prev);
			
			int inc=0;
			while(in.hasNext()){
				String temp=in.nextLine();
				nextMaps[inc++]=recurs(temp, node);
			}
			
			node.setNextMaps(nextMaps);
			
			return(node);
			
		}catch(Exception ex){
			System.out.println(ex.getLocalizedMessage());
			return(null);
		}
		
	}
	
}

class Node{
	
	private Node[] next;
	private Node prev;
	private String map;
	
	public Node(String mapName, Node prevMap){
		map=mapName;
		prev=prevMap;
	}
	
	public Node(String mapName, Node prevMap, Node[] nextMaps){
		map=mapName;
		prev=prevMap;
		next=nextMaps;
	}
	
	public Node[] getNext(){
		return(next);
	}
	
	public Node getPrev(){
		return(prev);
	}
	
	public String getMap(){
		return(map);
	}
	
	public void setNextMaps(Node[] nodes){
		next=nodes;
	}
	
}
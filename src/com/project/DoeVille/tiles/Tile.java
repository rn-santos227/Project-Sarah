package com.project.Doeville.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.project.Doeville.tiles.indoor.BlackTile;
import com.project.Doeville.tiles.indoor.CheckeredTileA;
import com.project.Doeville.tiles.indoor.WoodCarpetA;
import com.project.Doeville.tiles.indoor.WoodCarpetB;
import com.project.Doeville.tiles.indoor.WoodStairA;
import com.project.Doeville.tiles.indoor.WoodStairB;
import com.project.Doeville.tiles.indoor.WoodTileA;
import com.project.Doeville.tiles.indoor.WoodTileB;
import com.project.Doeville.tiles.outdoor.Grass;
import com.project.Doeville.tiles.outdoor.Gutter;
import com.project.Doeville.tiles.outdoor.HRoad0;
import com.project.Doeville.tiles.outdoor.HRoad1;
import com.project.Doeville.tiles.outdoor.HRoad2;
import com.project.Doeville.tiles.outdoor.HRoad3;
import com.project.Doeville.tiles.outdoor.HRoad4;
import com.project.Doeville.tiles.outdoor.HRoad5;
import com.project.Doeville.tiles.outdoor.HRoad6;
import com.project.Doeville.tiles.outdoor.HRoad7;
import com.project.Doeville.tiles.outdoor.HRoad8;
import com.project.Doeville.tiles.outdoor.HRoad9;
import com.project.Doeville.tiles.outdoor.HRoadA;
import com.project.Doeville.tiles.outdoor.HRoadB;
import com.project.Doeville.tiles.outdoor.HRoadC;
import com.project.Doeville.tiles.outdoor.HRoadD;
import com.project.Doeville.tiles.outdoor.HRoadE;
import com.project.Doeville.tiles.outdoor.HRoadF;
import com.project.Doeville.tiles.outdoor.J1Road0;
import com.project.Doeville.tiles.outdoor.J1Road1;
import com.project.Doeville.tiles.outdoor.J1Road2;
import com.project.Doeville.tiles.outdoor.J1Road3;
import com.project.Doeville.tiles.outdoor.J1Road4;
import com.project.Doeville.tiles.outdoor.J1Road5;
import com.project.Doeville.tiles.outdoor.J1Road6;
import com.project.Doeville.tiles.outdoor.J1Road7;
import com.project.Doeville.tiles.outdoor.J1Road8;
import com.project.Doeville.tiles.outdoor.J1Road9;
import com.project.Doeville.tiles.outdoor.J1RoadA;
import com.project.Doeville.tiles.outdoor.J1RoadB;
import com.project.Doeville.tiles.outdoor.J1RoadC;
import com.project.Doeville.tiles.outdoor.J1RoadD;
import com.project.Doeville.tiles.outdoor.J1RoadE;
import com.project.Doeville.tiles.outdoor.J1RoadF;
import com.project.Doeville.tiles.outdoor.JRoad0;
import com.project.Doeville.tiles.outdoor.JRoad1;
import com.project.Doeville.tiles.outdoor.JRoad2;
import com.project.Doeville.tiles.outdoor.JRoad3;
import com.project.Doeville.tiles.outdoor.JRoad4;
import com.project.Doeville.tiles.outdoor.JRoad5;
import com.project.Doeville.tiles.outdoor.JRoad6;
import com.project.Doeville.tiles.outdoor.JRoad7;
import com.project.Doeville.tiles.outdoor.JRoad8;
import com.project.Doeville.tiles.outdoor.JRoad9;
import com.project.Doeville.tiles.outdoor.JRoadA;
import com.project.Doeville.tiles.outdoor.JRoadB;
import com.project.Doeville.tiles.outdoor.JRoadC;
import com.project.Doeville.tiles.outdoor.JRoadD;
import com.project.Doeville.tiles.outdoor.JRoadE;
import com.project.Doeville.tiles.outdoor.JRoadF;
import com.project.Doeville.tiles.outdoor.PedX0;
import com.project.Doeville.tiles.outdoor.PedX1;
import com.project.Doeville.tiles.outdoor.PedX2;
import com.project.Doeville.tiles.outdoor.PedX3;
import com.project.Doeville.tiles.outdoor.PedX4;
import com.project.Doeville.tiles.outdoor.PedX5;
import com.project.Doeville.tiles.outdoor.PedX6;
import com.project.Doeville.tiles.outdoor.PedX7;
import com.project.Doeville.tiles.outdoor.PedX8;
import com.project.Doeville.tiles.outdoor.PedX9;
import com.project.Doeville.tiles.outdoor.PedXA;
import com.project.Doeville.tiles.outdoor.PedXB;
import com.project.Doeville.tiles.outdoor.PedXC;
import com.project.Doeville.tiles.outdoor.PedXD;
import com.project.Doeville.tiles.outdoor.PedXE;
import com.project.Doeville.tiles.outdoor.PedXF;
import com.project.Doeville.tiles.outdoor.RedTile0;
import com.project.Doeville.tiles.outdoor.RedTile1;
import com.project.Doeville.tiles.outdoor.RedTile2;
import com.project.Doeville.tiles.outdoor.RedTile3;
import com.project.Doeville.tiles.outdoor.RedTile4;
import com.project.Doeville.tiles.outdoor.RedTile5;
import com.project.Doeville.tiles.outdoor.RedTile6;
import com.project.Doeville.tiles.outdoor.RedTile7;
import com.project.Doeville.tiles.outdoor.RedTile8;
import com.project.Doeville.tiles.outdoor.VRoad0;
import com.project.Doeville.tiles.outdoor.VRoad1;
import com.project.Doeville.tiles.outdoor.VRoad2;
import com.project.Doeville.tiles.outdoor.VRoad3;
import com.project.Doeville.tiles.outdoor.VRoad4;
import com.project.Doeville.tiles.outdoor.VRoad5;
import com.project.Doeville.tiles.outdoor.VRoad6;
import com.project.Doeville.tiles.outdoor.VRoad7;
import com.project.Doeville.tiles.outdoor.VRoad8;
import com.project.Doeville.tiles.outdoor.VRoad9;
import com.project.Doeville.tiles.outdoor.VRoadA;
import com.project.Doeville.tiles.outdoor.VRoadB;
import com.project.Doeville.tiles.outdoor.VRoadC;
import com.project.Doeville.tiles.outdoor.VRoadD;
import com.project.Doeville.tiles.outdoor.VRoadE;
import com.project.Doeville.tiles.outdoor.VRoadF;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new Grass(0);
	public static Tile gutterTile = new Gutter(1);
	
	//Vertical Road Tile Set
	public static Tile VroadTile0 = new VRoad0(2);
	public static Tile VroadTile1 = new VRoad1(3);
	public static Tile VroadTile2 = new VRoad2(4);
	public static Tile VroadTile3 = new VRoad3(5);
	public static Tile VroadTile4 = new VRoad4(6);
	public static Tile VroadTile5 = new VRoad5(7);
	public static Tile VroadTile6 = new VRoad6(8);
	public static Tile VroadTile7 = new VRoad7(9);
	public static Tile VroadTile8 = new VRoad8(10);
	public static Tile VroadTile9 = new VRoad9(11);
	public static Tile VroadTileA = new VRoadA(12);
	public static Tile VroadTileB = new VRoadB(13);
	public static Tile VroadTileC = new VRoadC(14);
	public static Tile VroadTileD = new VRoadD(15);
	public static Tile VroadTileE = new VRoadE(16);
	public static Tile VroadTileF = new VRoadF(17);
	
	//Junction Road Tile Set
	public static Tile JroadTile0 = new JRoad0(18);
	public static Tile JroadTile1 = new JRoad1(19);
	public static Tile JroadTile2 = new JRoad2(20);
	public static Tile JroadTile3 = new JRoad3(21);
	public static Tile JroadTile4 = new JRoad4(22);
	public static Tile JroadTile5 = new JRoad5(23);
	public static Tile JroadTile6 = new JRoad6(24);
	public static Tile JroadTile7 = new JRoad7(25);
	public static Tile JroadTile8 = new JRoad8(26);
	public static Tile JroadTile9 = new JRoad9(27);
	public static Tile JroadTileA = new JRoadA(28);
	public static Tile JroadTileB = new JRoadB(29);
	public static Tile JroadTileC = new JRoadC(30);
	public static Tile JroadTileD = new JRoadD(31);
	public static Tile JroadTileE = new JRoadE(32);
	public static Tile JroadTileF = new JRoadF(33);
	
	//Horizontal Road Tile Set
	public static Tile HroadTile0 = new HRoad0(34);
	public static Tile HroadTile1 = new HRoad1(35);
	public static Tile HroadTile2 = new HRoad2(36);
	public static Tile HroadTile3 = new HRoad3(37);
	public static Tile HroadTile4 = new HRoad4(38);
	public static Tile HroadTile5 = new HRoad5(39);
	public static Tile HroadTile6 = new HRoad6(40);
	public static Tile HroadTile7 = new HRoad7(41);
	public static Tile HroadTile8 = new HRoad8(42);
	public static Tile HroadTile9 = new HRoad9(43);
	public static Tile HroadTileA = new HRoadA(44);
	public static Tile HroadTileB = new HRoadB(45);
	public static Tile HroadTileC = new HRoadC(46);
	public static Tile HroadTileD = new HRoadD(47);
	public static Tile HroadTileE = new HRoadE(48);
	public static Tile HroadTileF = new HRoadF(49);
	
	//Junction Road Tile Set No Pedestrian Line
	public static Tile J1roadTile0 = new J1Road0(50);
	public static Tile J1roadTile1 = new J1Road1(51);
	public static Tile J1roadTile2 = new J1Road2(52);
	public static Tile J1roadTile3 = new J1Road3(53);
	public static Tile J1roadTile4 = new J1Road4(54);
	public static Tile J1roadTile5 = new J1Road5(55);
	public static Tile J1roadTile6 = new J1Road6(56);
	public static Tile J1roadTile7 = new J1Road7(57);
	public static Tile J1roadTile8 = new J1Road8(58);
	public static Tile J1roadTile9 = new J1Road9(59);
	public static Tile J1roadTileA = new J1RoadA(60);
	public static Tile J1roadTileB = new J1RoadB(61);
	public static Tile J1roadTileC = new J1RoadC(62);
	public static Tile J1roadTileD = new J1RoadD(63);
	public static Tile J1roadTileE = new J1RoadE(64);
	public static Tile J1roadTileF = new J1RoadF(65);
	
	//Left Pedestrian Line
	public static Tile PedestrialLine0 = new PedX0(66);
	public static Tile PedestrialLine1 = new PedX1(67);
	public static Tile PedestrialLine2 = new PedX2(68);
	public static Tile PedestrialLine3 = new PedX3(69);
	
	//Right Pedestrian Line
	public static Tile PedestrialLine4 = new PedX4(70);
	public static Tile PedestrialLine5 = new PedX5(71);
	public static Tile PedestrialLine6 = new PedX6(72);
	public static Tile PedestrialLine7 = new PedX7(73);
	
	//Top Pedestrian Line
	public static Tile PedestrialLine8 = new PedX8(74);
	public static Tile PedestrialLine9 = new PedX9(75);
	public static Tile PedestrialLineA = new PedXA(76);
	public static Tile PedestrialLineB = new PedXB(77);
	
	//Bottom Pedestrian Line
	public static Tile PedestrialLineC = new PedXC(78);
	public static Tile PedestrialLineD = new PedXD(79);
	public static Tile PedestrialLineE = new PedXE(80);
	public static Tile PedestrialLineF = new PedXF(81);
	
	//Red Brick Tiles A
	public static Tile redBrickTileA0 = new RedTile0(82);
	public static Tile redBrickTileA1 = new RedTile1(83);
	public static Tile redBrickTileA2 = new RedTile2(84);
	public static Tile redBrickTileA3 = new RedTile3(85);
	public static Tile redBrickTileA4 = new RedTile4(86);
	public static Tile redBrickTileA5 = new RedTile5(87);
	public static Tile redBrickTileA6 = new RedTile6(88);
	public static Tile redBrickTileA7 = new RedTile7(89);
	public static Tile redBrickTileA8 = new RedTile8(90);
	
	//Indoor Tiles
	public static Tile blackTile = new BlackTile(91);
	public static Tile woodTileA = new WoodTileA(92);
	public static Tile woodTileB = new WoodTileB(93);
	public static Tile woodStairA = new WoodStairA(94);
	public static Tile woodStairB = new WoodStairB(95);
	public static Tile woodCarpetA = new WoodCarpetA(96);
	public static Tile woodCarpetB = new WoodCarpetB(97);
	public static Tile checkeredTileA = new CheckeredTileA(98);
	
	
	public static final int t_Width = 64, t_Height = 64;
	protected BufferedImage texture;
	protected final int id;
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, t_Width, t_Height, null);
	}
	
	public boolean isWalkable(){
		return true;
	}
	
	public int getId() {
		return id;
	}
}

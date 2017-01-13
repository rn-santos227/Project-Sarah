package com.project.Doeville.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	private static final int WIDTH = 32, HEIGHT = 32;
	
	//Male Player Animation
	public static BufferedImage[] player_M_up, player_M_down, player_M_left, player_M_right;
	public static BufferedImage[] player_M_tired, player_M_sleeping;	
	public static BufferedImage[] player_F_eating;
	
	//Buildings
	public static BufferedImage Apartment, ConvienceStore, Library, Pharmacy, IT_Workplace;
	
	//Single Furniture
	public static BufferedImage IndoorPlantA, KeyBox, ClockA, 
	SofaA, SofaB, SideTableA, BookShelfA, PlasticTable, 
	VendingMachineA, VendingMachineB, Refrigerator,
	KitchenSink, KitchenStove, Television, Bed, ComputerA;
	
	public static BufferedImage girl, b_girl, l_girl, r_girl;
	public static BufferedImage player_M_faceUp, player_M_faceDown;
	public static BufferedImage grass, gutter, tree, streetlamp, hotdogcart, trashBinA;
	public static BufferedImage EnergyIcon, HealthIcon, HungerIcon, HygieneIcon, MoodIcon, StaminaIcon;
	public static BufferedImage brownFrame, clockIcon, calendarIcon, capacityIcon, inventoryIcon, homeIcon, storeIcon, pharmacyIcon, libraryIcon, itIcon;
	public static BufferedImage vCursor, hCursor;
	public static BufferedImage[] emotions, stat_bubble;
	public static BufferedImage[] dialogBox, dialogBox1, dialogBox2, TdialogBox, dialogBox_small;
	public static BufferedImage[] windows;
	public static BufferedImage[] clockTick;
	public static BufferedImage[] ConsumableTab, MedicineTab, ToolTab, KeyTab;
	public static BufferedImage[] HRoad, JRoad, J1Road, VRoad;
	public static BufferedImage[] PedestrianLine;
	public static BufferedImage[] RedBrickTile;
	public static BufferedImage[] WhiteFence;
	public static BufferedImage[] HotdogGuy, Johnny, CafeteriaLady;
	public static BufferedImage[] numberPanel1, numberPanel2;
	
	public static BufferedImage[] Doors;
	public static BufferedImage[] Floors;
	public static BufferedImage[] Windows;
	public static BufferedImage[] Wall01;
	
	public static BufferedImage[] WoodenCounterA, CafeteriaCounterA, WChair, CafeteriaBox, WallDecorations, CashRegister;
	
	public static void init() {
		SpriteSheet Player_M = new SpriteSheet(ImageLoader.loadImage("/textures/Player_M.png"));
		SpriteSheet Player_F = new SpriteSheet(ImageLoader.loadImage("/textures/Player_F.png"));
		SpriteSheet env = new SpriteSheet(ImageLoader.loadImage("/textures/Objects.png"));
		SpriteSheet hud = new SpriteSheet(ImageLoader.loadImage("/textures/HUD.png"));
		SpriteSheet road = new SpriteSheet(ImageLoader.loadImage("/textures/Roads.jpg"));
		SpriteSheet road1 = new SpriteSheet(ImageLoader.loadImage("/textures/Roads1.jpg"));
		SpriteSheet win = new SpriteSheet(ImageLoader.loadImage("/textures/Windows.png"));
		SpriteSheet build = new SpriteSheet(ImageLoader.loadImage("/textures/Buildings.png"));
		SpriteSheet indoors = new SpriteSheet(ImageLoader.loadImage("/textures/Indoor.png"));
		SpriteSheet furniture = new SpriteSheet(ImageLoader.loadImage("/textures/Furniture.png"));
		
		SpriteSheet npc = new SpriteSheet(ImageLoader.loadImage("/textures/NPC.png"));
		
		player_M_up = new BufferedImage[2];
		player_M_down = new BufferedImage[2];
		player_M_left = new BufferedImage[4];
		player_M_right = new BufferedImage[4];
		player_M_tired = new BufferedImage[2];
		player_M_sleeping = new BufferedImage[4];
		
		
		player_F_eating = new BufferedImage[5];
		
		dialogBox = new BufferedImage[9];
		dialogBox1 = new BufferedImage[9];
		dialogBox2 = new BufferedImage[13];
		TdialogBox= new BufferedImage[9];
		dialogBox_small = new BufferedImage[3];
		windows = new BufferedImage[2];
		clockTick = new BufferedImage[24];
		ConsumableTab = new BufferedImage[3];
		MedicineTab = new BufferedImage[3];
		ToolTab = new BufferedImage[3];
		KeyTab = new BufferedImage[3];
		stat_bubble = new BufferedImage[5];
		WhiteFence = new BufferedImage[8];
		
		//NPCs
		HotdogGuy = new BufferedImage[4];
		Johnny = new BufferedImage[4];
		CafeteriaLady = new BufferedImage[4];
		
		//Number Panel
		numberPanel1 = new BufferedImage[10];
		numberPanel2 = new BufferedImage[10];
		
		//Indoor Assets
		Floors = new BufferedImage[32];
		Doors = new BufferedImage[16];
		Windows = new BufferedImage[16];
		Wall01 = new BufferedImage[16];
		
		//Roads
		PedestrianLine = new BufferedImage[16];
		VRoad = new BufferedImage[16];
		JRoad = new BufferedImage[16];
		J1Road = new BufferedImage[16];
		HRoad = new BufferedImage[16];
		
		//Furniture
		CafeteriaBox = new BufferedImage[4];
		CafeteriaCounterA = new BufferedImage[9];
		WoodenCounterA = new BufferedImage[9];
		WChair = new BufferedImage[8];
		WallDecorations = new BufferedImage[8];
		CashRegister = new BufferedImage[3];
		
		//Tile Set
		RedBrickTile = new BufferedImage[9];
		
		//Male Player Assets
		player_M_faceUp = Player_M.crop(0, 0, WIDTH, HEIGHT);
		player_M_faceDown = Player_M.crop(0, HEIGHT * 2, WIDTH, HEIGHT);
		
		player_M_up[0] = Player_M.crop(WIDTH, 0, WIDTH, HEIGHT);
		player_M_up[1] = Player_M.crop(WIDTH * 2, 0, WIDTH, HEIGHT);
		
		player_M_down[0] = Player_M.crop(WIDTH, HEIGHT * 2 , WIDTH, HEIGHT);
		player_M_down[1] = Player_M.crop(WIDTH * 2, HEIGHT * 2 , WIDTH, HEIGHT);
		
		player_M_left[0] = Player_M.crop(0, HEIGHT, WIDTH, HEIGHT);
		player_M_left[1] = Player_M.crop(WIDTH, HEIGHT, WIDTH, HEIGHT);
		player_M_left[2] = Player_M.crop(0, HEIGHT, WIDTH, HEIGHT);
		player_M_left[3] = Player_M.crop(WIDTH * 2, HEIGHT, WIDTH, HEIGHT);
		
		player_M_right[0] = Player_M.crop(0, HEIGHT * 3, WIDTH, HEIGHT);
		player_M_right[1] = Player_M.crop(WIDTH, HEIGHT * 3, WIDTH, HEIGHT);
		player_M_right[2] = Player_M.crop(0, HEIGHT * 3, WIDTH, HEIGHT);
		player_M_right[3] = Player_M.crop(WIDTH * 2, HEIGHT *3, WIDTH, HEIGHT);
		
		player_M_tired[0] = Player_M.crop(0, HEIGHT * 4, WIDTH, HEIGHT);
		player_M_tired[1] = Player_M.crop(WIDTH, HEIGHT * 4, WIDTH, HEIGHT);
		
		player_M_sleeping[0] = Player_M.crop(0, HEIGHT * 6, WIDTH, HEIGHT);
		player_M_sleeping[1] = Player_M.crop(WIDTH, HEIGHT * 6, WIDTH, HEIGHT);
		player_M_sleeping[2] = Player_M.crop(WIDTH * 2, HEIGHT * 6, WIDTH, HEIGHT);
		player_M_sleeping[3] = Player_M.crop(WIDTH * 3, HEIGHT * 6, WIDTH, HEIGHT);
		
		//Female Player Assets
		player_F_eating[0] = Player_F.crop(0, HEIGHT * 4, WIDTH, HEIGHT * 2);
		player_F_eating[1] = Player_F.crop(WIDTH, HEIGHT * 4, WIDTH, HEIGHT * 2);
		player_F_eating[2] = Player_F.crop(WIDTH, HEIGHT * 4, WIDTH, HEIGHT * 2);
		player_F_eating[3] = Player_F.crop(WIDTH * 2, HEIGHT * 4, WIDTH, HEIGHT * 2);
		player_F_eating[4] = Player_F.crop(WIDTH * 2, HEIGHT * 4, WIDTH, HEIGHT * 2);
		
		
		//NPCs
		for(int i = 0; i < HotdogGuy.length; i++) HotdogGuy[i] = npc.crop(32 * i, 0, 32, 32);	
		for(int i = 0; i < Johnny.length; i++) Johnny[i] = npc.crop(32 * i, 32 * 2, 32, 32);
		for(int i = 0; i < CafeteriaLady.length; i++) CafeteriaLady[i] = npc.crop(32 * i, 32 * 5, 32, 32);	
		
		
		//Game Structures
		Apartment = build.crop(0, 0, 32 * 3, 32 * 4);
		ConvienceStore = build.crop(16 * 6, 0, 16 * 5, 16 * 5);
		Library = build.crop(16 * 11, 0, 16 * 8, 16 * 10);
		Pharmacy = build.crop(16 * 6, 16 * 5, 16 * 5, 16 * 5);
		IT_Workplace = build.crop(16 * 19, 0, 16 * 9, 16 * 10);
		
		//Game Environment
		grass = env.crop(0, 16 * 4, 32, 32);
		gutter = env.crop(16 * 2, 16 * 4, 32, 32);
		tree = env.crop(0, 0, 16 * 4, 16 * 4);
		streetlamp = env.crop(16 * 4, 0, 16, 16 * 3);
		hotdogcart = env.crop((32 * 4), 0, 32, 32);
		trashBinA = env.crop((32 * 4), 32, 32, 32);
		girl = Player_F.crop(0, HEIGHT * 2, WIDTH, HEIGHT);
		b_girl = Player_F.crop(0, 0 * 2, WIDTH, HEIGHT);
		l_girl = Player_F.crop(0, HEIGHT, WIDTH, HEIGHT);
		r_girl = Player_F.crop(0, HEIGHT * 3, WIDTH, HEIGHT);
		
		//Heads Up Display Objects
		EnergyIcon = hud.crop(0, 0, 16, 16);
		HealthIcon = hud.crop(16, 0, 16, 16);
		HungerIcon = hud.crop(0, 16, 16, 16);
		HygieneIcon = hud.crop(16, 16, 16, 16);
		MoodIcon = hud.crop(32, 0, 16, 16);
		StaminaIcon = hud.crop(32, 16, 16, 16);
		
		//Icons
		calendarIcon = hud.crop(16 * 12, 16 * 4, 16, 16);
		capacityIcon = hud.crop(32 * 7, 32 * 8, 32, 32);
		clockIcon = hud.crop(32 * 6, 32, 32, 32);
		homeIcon = hud.crop(32 * 5, 32 * 9, 32, 32);
		storeIcon = hud.crop(32 * 6, 32 * 9, 32, 32);
		pharmacyIcon = hud.crop(32 * 7, 32 * 9, 32, 32);
		libraryIcon = hud.crop(32 * 8, 32 * 9, 32, 32);
		itIcon = hud.crop(32 * 9, 32 * 9, 32, 32);
		inventoryIcon = hud.crop(32 * 6, 32 * 8, 32, 32);

		
		//Status Bubble
		stat_bubble[0] = hud.crop(0, HEIGHT * 9, WIDTH, HEIGHT);
		stat_bubble[1] = hud.crop(WIDTH, HEIGHT * 9, WIDTH, HEIGHT);
		stat_bubble[2] = hud.crop(WIDTH * 2, HEIGHT * 9, WIDTH, HEIGHT);
		stat_bubble[3] = hud.crop(WIDTH * 3, HEIGHT * 9, WIDTH, HEIGHT);
		stat_bubble[4] = hud.crop(WIDTH * 4, HEIGHT * 9, WIDTH, HEIGHT);
		
		//Number Panels
		for(int i = 0; i < numberPanel1.length; i++) numberPanel1[i] = hud.crop(16 * i, 16 * 20, 16, 16);
		for(int i = 0; i < numberPanel2.length; i++) numberPanel2[i] = hud.crop(16 * i, 16 * 21, 16, 16);	
		
		//Cursors
		vCursor = hud.crop(16 * 12, 16 * 5, 16, 16);
		hCursor = hud.crop(16 * 13, 16 * 5, 16, 16);
		
		//Clock Tick
		clockTick[0] = hud.crop(0, HEIGHT * 3, WIDTH, HEIGHT); //12:00
		clockTick[1] = hud.crop(WIDTH, HEIGHT * 3, WIDTH, HEIGHT); //12:30
		clockTick[2] = hud.crop(WIDTH * 2, HEIGHT * 3, WIDTH, HEIGHT); //1:00
		clockTick[3] = hud.crop(WIDTH * 3, HEIGHT * 3, WIDTH, HEIGHT); //1:30
		clockTick[4] = hud.crop(WIDTH * 4, HEIGHT * 3, WIDTH, HEIGHT); //2:00
		clockTick[5] = hud.crop(WIDTH * 5, HEIGHT * 3, WIDTH, HEIGHT); //2:30
		clockTick[6] = hud.crop(WIDTH * 6, HEIGHT * 3, WIDTH, HEIGHT); //3:00
		clockTick[7] = hud.crop(WIDTH * 7, HEIGHT * 3, WIDTH, HEIGHT); //3:30
		clockTick[8] = hud.crop(0, HEIGHT * 4, WIDTH, HEIGHT); //4:00
		clockTick[9] = hud.crop(WIDTH, HEIGHT * 4, WIDTH, HEIGHT); //4:30
		clockTick[10] = hud.crop(WIDTH * 2, HEIGHT * 4, WIDTH, HEIGHT); //5:00
		clockTick[11] = hud.crop(WIDTH * 3, HEIGHT * 4, WIDTH, HEIGHT); //5:30
		clockTick[12] = hud.crop(WIDTH * 4, HEIGHT * 4, WIDTH, HEIGHT); //6:00
		clockTick[13] = hud.crop(WIDTH * 5, HEIGHT * 4, WIDTH, HEIGHT); //6:30
		clockTick[14] = hud.crop(WIDTH * 6, HEIGHT * 4, WIDTH, HEIGHT); //7:00
		clockTick[15] = hud.crop(WIDTH * 7, HEIGHT * 4, WIDTH, HEIGHT); //7:30
		clockTick[16] = hud.crop(0, HEIGHT * 5, WIDTH, HEIGHT); //8:00
		clockTick[17] = hud.crop(WIDTH, HEIGHT * 5, WIDTH, HEIGHT); //8:30
		clockTick[18] = hud.crop(WIDTH * 2, HEIGHT * 5, WIDTH, HEIGHT); //9:00
		clockTick[19] = hud.crop(WIDTH * 3, HEIGHT * 5, WIDTH, HEIGHT); //9:30
		clockTick[20] = hud.crop(WIDTH * 4, HEIGHT * 5, WIDTH, HEIGHT); //10:00
		clockTick[21] = hud.crop(WIDTH * 5, HEIGHT * 5, WIDTH, HEIGHT); //10:30
		clockTick[22] = hud.crop(WIDTH * 6, HEIGHT * 5, WIDTH, HEIGHT); //11:00
		clockTick[23] = hud.crop(WIDTH * 7, HEIGHT * 5, WIDTH, HEIGHT); //11:30
				
		//Dialog Box
		dialogBox[0] = hud.crop(WIDTH * 3, 0, WIDTH, HEIGHT); //Top Left
		dialogBox[1] = hud.crop(WIDTH * 4, 0, WIDTH, HEIGHT); //Top
		dialogBox[2] = hud.crop(WIDTH * 5, 0, WIDTH, HEIGHT); //Top Right
		dialogBox[3] = hud.crop(WIDTH * 3, HEIGHT, WIDTH, HEIGHT); //Left
		dialogBox[4] = hud.crop(WIDTH * 4, HEIGHT, WIDTH, HEIGHT); //Center
		dialogBox[5] = hud.crop(WIDTH * 5, HEIGHT, WIDTH, HEIGHT); //Right
		dialogBox[6] = hud.crop(WIDTH * 3, HEIGHT * 2, WIDTH, HEIGHT); //Bottom Left
		dialogBox[7] = hud.crop(WIDTH * 4, HEIGHT * 2, WIDTH, HEIGHT); //Bottom
		dialogBox[8] = hud.crop(WIDTH * 5, HEIGHT * 2, WIDTH, HEIGHT); //Bottom Right
		
		//Dialog Box 1
		dialogBox1[0] = hud.crop(0, HEIGHT * 6, WIDTH, HEIGHT); //Top Left
		dialogBox1[1] = hud.crop(WIDTH, HEIGHT * 6, WIDTH, HEIGHT); //Top
		dialogBox1[2] = hud.crop(WIDTH * 2, HEIGHT * 6, WIDTH, HEIGHT); //Top Right
		dialogBox1[3] = hud.crop(0, HEIGHT * 7, WIDTH, HEIGHT); //Left
		dialogBox1[4] = hud.crop(WIDTH, HEIGHT * 7, WIDTH, HEIGHT); //Center
		dialogBox1[5] = hud.crop(WIDTH * 2, HEIGHT * 7, WIDTH, HEIGHT); //Right
		dialogBox1[6] = hud.crop(0, HEIGHT * 8, WIDTH, HEIGHT); //Bottom Left
		dialogBox1[7] = hud.crop(WIDTH, HEIGHT * 8, WIDTH, HEIGHT); //Bottom
		dialogBox1[8] = hud.crop(WIDTH * 2, HEIGHT * 8, WIDTH, HEIGHT); //Bottom Right
		
		//Dialog Box 2
		dialogBox2[0] = hud.crop(WIDTH * 8, HEIGHT * 6, WIDTH, HEIGHT); //Top Left
		dialogBox2[1] = hud.crop(WIDTH * 9, HEIGHT * 6, WIDTH, HEIGHT); //Top
		dialogBox2[2] = hud.crop(WIDTH * 10, HEIGHT * 6, WIDTH, HEIGHT); //Top Right
		dialogBox2[3] = hud.crop(WIDTH * 8, HEIGHT * 7, WIDTH, HEIGHT); //Left
		dialogBox2[4] = hud.crop(WIDTH * 9, HEIGHT * 7, WIDTH, HEIGHT); //Center
		dialogBox2[5] = hud.crop(WIDTH * 10, HEIGHT * 7, WIDTH, HEIGHT); //Right
		dialogBox2[6] = hud.crop(WIDTH * 8, HEIGHT * 8, WIDTH, HEIGHT); //Bottom Left
		dialogBox2[7] = hud.crop(WIDTH * 9, HEIGHT * 8, WIDTH, HEIGHT); //Bottom
		dialogBox2[8] = hud.crop(WIDTH * 10, HEIGHT * 8, WIDTH, HEIGHT); //Bottom Right
		dialogBox2[9] = hud.crop(WIDTH * 6, HEIGHT * 6, WIDTH, HEIGHT); //Sharp Top Left
		dialogBox2[10] = hud.crop(WIDTH * 7, HEIGHT * 6, WIDTH, HEIGHT); //Sharp Top Right
		dialogBox2[11] = hud.crop(WIDTH * 6, HEIGHT * 7, WIDTH, HEIGHT); //Sharp Bottom Left
		dialogBox2[12] = hud.crop(WIDTH * 7, HEIGHT * 7, WIDTH, HEIGHT); //Sharp Bottom Right
		
		//Transparent Dialog Box
		TdialogBox[0] = hud.crop(WIDTH * 3, HEIGHT * 6, WIDTH, HEIGHT); //Top Left
		TdialogBox[1] = hud.crop(WIDTH * 4, HEIGHT * 6, WIDTH, HEIGHT); //Top
		TdialogBox[2] = hud.crop(WIDTH * 5, HEIGHT * 6, WIDTH, HEIGHT); //Top Right
		TdialogBox[3] = hud.crop(WIDTH * 3, HEIGHT * 7, WIDTH, HEIGHT); //Left
		TdialogBox[4] = hud.crop(WIDTH * 4, HEIGHT * 7, WIDTH, HEIGHT); //Center
		TdialogBox[5] = hud.crop(WIDTH * 5, HEIGHT * 7, WIDTH, HEIGHT); //Right
		TdialogBox[6] = hud.crop(WIDTH * 3, HEIGHT * 8, WIDTH, HEIGHT); //Bottom Left
		TdialogBox[7] = hud.crop(WIDTH * 4, HEIGHT * 8, WIDTH, HEIGHT); //Bottom
		TdialogBox[8] = hud.crop(WIDTH * 5, HEIGHT * 8, WIDTH, HEIGHT); //Bottom Right	

		
		//Windows
		windows[0] = win.crop(0, 0, WIDTH * 4, HEIGHT * 4);
		windows[1] = win.crop(WIDTH * 4, 0, WIDTH * 11, HEIGHT * 4);
			
		//Small Dialog Box
		dialogBox_small[0] = hud.crop(16 * 12, 0, 16, 32);
		dialogBox_small[1] = hud.crop(16 * 13, 0, 16, 32);
		dialogBox_small[2] = hud.crop(16 * 14, 0, 16, 32);
		
		//Item Window Tabs
		ConsumableTab[0] = hud.crop(WIDTH * 8, 0, WIDTH * 2, HEIGHT);
		ConsumableTab[1] = hud.crop(WIDTH * 8, HEIGHT, WIDTH * 2, HEIGHT);
		ConsumableTab[2] = hud.crop(WIDTH * 8, HEIGHT * 2, WIDTH * 2, HEIGHT);
		
		MedicineTab[0] = hud.crop(WIDTH * 10, 0, WIDTH * 2, HEIGHT);
		MedicineTab[1] = hud.crop(WIDTH * 10, HEIGHT, WIDTH * 2, HEIGHT);
		MedicineTab[2] = hud.crop(WIDTH * 10, HEIGHT * 2, WIDTH * 2, HEIGHT);
		
		ToolTab[0] = hud.crop(WIDTH * 8, HEIGHT * 3, WIDTH * 2, HEIGHT);
		ToolTab[1] = hud.crop(WIDTH * 8, HEIGHT * 4, WIDTH * 2, HEIGHT);
		ToolTab[2] = hud.crop(WIDTH * 8, HEIGHT * 5, WIDTH * 2, HEIGHT);
		
		KeyTab[0] = hud.crop(WIDTH * 10,  HEIGHT * 3, WIDTH * 2, HEIGHT);
		KeyTab[1] = hud.crop(WIDTH * 10,  HEIGHT * 4, WIDTH * 2, HEIGHT);
		KeyTab[2] = hud.crop(WIDTH * 10,  HEIGHT * 5, WIDTH * 2, HEIGHT);
				
		//Character's Mood
		brownFrame = hud.crop(WIDTH * 2, 0, WIDTH, HEIGHT);
		emotions = new BufferedImage[6];
		emotions[0] = hud.crop(WIDTH, HEIGHT, WIDTH, HEIGHT);
		emotions[1] = hud.crop(WIDTH * 2, HEIGHT, WIDTH, HEIGHT);
		emotions[2] = hud.crop(0, HEIGHT, WIDTH, HEIGHT);
		
		//Horizontal Road
		HRoad[0] = road1.crop(0, 0, 32, 32);
		HRoad[1] = road1.crop(32, 0, 32, 32);
		HRoad[2] = road1.crop(32 * 2, 0, 32, 32);
		HRoad[3] = road1.crop(32 * 3, 0, 32, 32);
		HRoad[4] = road1.crop(0, 32, 32, 32);
		HRoad[5] = road1.crop(32, 32, 32, 32);
		HRoad[6] = road1.crop(32 * 2, 32, 32, 32);
		HRoad[7] = road1.crop(32 * 3, 32, 32, 32);
		HRoad[8] = road1.crop(0, 32 * 2, 32, 32);
		HRoad[9] = road1.crop(32, 32 * 2, 32, 32);
		HRoad[10] = road1.crop(32 * 2, 32 * 2, 32, 32);
		HRoad[11] = road1.crop(32 * 3, 32 * 2, 32, 32);
		HRoad[12] = road1.crop(0, 32 * 3, 32, 32);
		HRoad[13] = road1.crop(32, 32 * 3, 32, 32);
		HRoad[14] = road1.crop(32 * 2, 32 * 3, 32, 32);
		HRoad[15] = road1.crop(32 * 3, 32 * 3, 32, 32);
		
		//Junction Road
		JRoad[0] = road.crop(32 * 8, 0, 32, 32);
		JRoad[1] = road.crop(32 * 9, 0, 32, 32);
		JRoad[2] = road.crop(32 * 10, 0, 32, 32);
		JRoad[3] = road.crop(32 * 11, 0, 32, 32);
		JRoad[4] = road.crop(32 * 8, 32, 32, 32);
		JRoad[5] = road.crop(32 * 9, 32, 32, 32);
		JRoad[6] = road.crop(32 * 10, 32, 32, 32);
		JRoad[7] = road.crop(32 * 11, 32, 32, 32);
		JRoad[8] = road.crop(32 * 8, 32 * 2, 32, 32);
		JRoad[9] = road.crop(32 * 9, 32 * 2, 32, 32);
		JRoad[10] = road.crop(32 * 10, 32 * 2, 32, 32);
		JRoad[11] = road.crop(32 * 11, 32 * 2, 32, 32);
		JRoad[12] = road.crop(32 * 8, 32 * 3, 32, 32);
		JRoad[13] = road.crop(32 * 9, 32 * 3, 32, 32);
		JRoad[14] = road.crop(32 * 10, 32 * 3, 32, 32);
		JRoad[15] = road.crop(32 * 11, 32 * 3, 32, 32);
		
		//Junction Road No Pedestrian Line
		J1Road[0] = road1.crop(32 * 8, 0, 32, 32);
		J1Road[1] = road1.crop(32 * 9, 0, 32, 32);
		J1Road[2] = road1.crop(32 * 10, 0, 32, 32);
		J1Road[3] = road1.crop(32 * 11, 0, 32, 32);
		J1Road[4] = road1.crop(32 * 8, 32, 32, 32);
		J1Road[5] = road1.crop(32 * 9, 32, 32, 32);
		J1Road[6] = road1.crop(32 * 10, 32, 32, 32);
		J1Road[7] = road1.crop(32 * 11, 32, 32, 32);
		J1Road[8] = road1.crop(32 * 8, 32 * 2, 32, 32);
		J1Road[9] = road1.crop(32 * 9, 32 * 2, 32, 32);
		J1Road[10] = road1.crop(32 * 10, 32 * 2, 32, 32);
		J1Road[11] = road1.crop(32 * 11, 32 * 2, 32, 32);
		J1Road[12] = road1.crop(32 * 8, 32 * 3, 32, 32);
		J1Road[13] = road1.crop(32 * 9, 32 * 3, 32, 32);
		J1Road[14] = road1.crop(32 * 10, 32 * 3, 32, 32);
		J1Road[15] = road1.crop(32 * 11, 32 * 3, 32, 32);
		
		//Vertical Road
		VRoad[0] = road1.crop(32 * 12, 0, 32, 32);
		VRoad[1] = road1.crop(32 * 13, 0, 32, 32);
		VRoad[2] = road1.crop(32 * 14, 0, 32, 32);
		VRoad[3] = road1.crop(32 * 15, 32, 32, 32);
		VRoad[4] = road1.crop(32 * 12, 32, 32, 32);
		VRoad[5] = road1.crop(32 * 13, 32, 32, 32);
		VRoad[6] = road1.crop(32 * 14, 32, 32, 32);
		VRoad[7] = road1.crop(32 * 15, 32, 32, 32);
		VRoad[8] = road1.crop(32 * 12, 32 * 2, 32, 32);
		VRoad[9] = road1.crop(32 * 13, 32 * 2, 32, 32);
		VRoad[10] = road1.crop(32 * 14, 32 * 2, 32, 32);
		VRoad[11] = road1.crop(32 * 15, 32 * 2, 32, 32);
		VRoad[12] = road1.crop(32 * 12, 32 * 3, 32, 32);
		VRoad[13] = road1.crop(32 * 13, 32 * 3, 32, 32);
		VRoad[14] = road1.crop(32 * 14, 32 * 3, 32, 32);
		VRoad[15] = road1.crop(32 * 15, 32 * 3, 32, 32);
		
		//Pedestrian Line Vertical
		PedestrianLine[0] = road.crop(0, 0, 32, 32);
		PedestrianLine[1] = road.crop(0, 32, 32, 32);
		PedestrianLine[2] = road.crop(0, 32 * 2, 32, 32);
		PedestrianLine[3] = road.crop(0, 32 * 3, 32, 32);
		
		PedestrianLine[4] = road.crop(32 * 3, 0, 32, 32);
		PedestrianLine[5] = road.crop(32 * 3, 32, 32, 32);
		PedestrianLine[6] = road.crop(32 * 3, 32 * 2, 32, 32);
		PedestrianLine[7] = road.crop(32 * 3, 32 * 3, 32, 32);
		
		//Pedestrian Line Horizontal
		PedestrianLine[8] = road.crop(32 * 12, 0, 32, 32);
		PedestrianLine[9] = road.crop(32 * 13, 0, 32, 32);
		PedestrianLine[10] = road.crop(32 * 14, 0, 32, 32);
		PedestrianLine[11] = road.crop(32 * 15, 0, 32, 32);
		
		PedestrianLine[12] = road.crop(32 * 12, 32 * 3, 32, 32);
		PedestrianLine[13] = road.crop(32 * 13, 32 * 3, 32, 32);
		PedestrianLine[14] = road.crop(32 * 14, 32 * 3, 32, 32);
		PedestrianLine[15] = road.crop(32 * 15, 32 * 3, 32, 32);
		
		//Red Brick Tiles
		RedBrickTile[0] = env.crop(0, 32 * 3, 32, 32);
		RedBrickTile[1] = env.crop(32, 32 * 3, 32, 32);
		RedBrickTile[2] = env.crop(32 * 2, 32 * 3, 32, 32);
		RedBrickTile[3] = env.crop(0, 32 * 4, 32, 32);
		RedBrickTile[4] = env.crop(32, 32 * 4, 32, 32);
		RedBrickTile[5] = env.crop(32 * 2, 32 * 4, 32, 32);
		RedBrickTile[6] = env.crop(0, 32 * 5, 32, 32);
		RedBrickTile[7] = env.crop(32, 32 * 5, 32, 32);
		RedBrickTile[8] = env.crop(32 * 2, 32 * 5, 32, 32);
		
		//White Fence
		WhiteFence[0] = env.crop(16 * 5, 0, 16, 16);
		WhiteFence[1] = env.crop(16 * 6, 0, 16, 16);
		WhiteFence[2] = env.crop(16 * 7, 0, 16, 16);
		WhiteFence[3] = env.crop(16 * 5, 16, 16, 16);
		WhiteFence[4] = env.crop(16 * 7, 16, 16, 16);
		WhiteFence[5] = env.crop(16 * 5, 16 * 2, 16, 16);
		WhiteFence[6] = env.crop(16 * 6, 16 * 2, 16, 16);
		WhiteFence[7] = env.crop(16 * 7, 16 * 2, 16, 16);
		
		//Floor Tiles
		Floors[0] = indoors.crop(0, 0, 32, 32); //Default Black Tile
		Floors[1] = indoors.crop(32, 0, 32, 32);
		Floors[2] = indoors.crop(32 * 2, 0, 32, 32);
		Floors[3] = indoors.crop(32 * 3, 0, 32, 32);
		Floors[4] = indoors.crop(32 * 4, 0, 32, 32);
		Floors[5] = indoors.crop(32 * 5, 0, 32, 32);
		Floors[6] = indoors.crop(32 * 6, 0, 32, 32);
		Floors[7] = indoors.crop(32 * 7, 0, 32, 32);
		
		//Door
		Doors[0] = indoors.crop(32 * 2, 32, 32, 32);
		Doors[1] = indoors.crop(32 * 3, 32, 16 * 3, 32);
		Doors[2] = indoors.crop(16 * 9, 32, 32, 32);
		
		//Window
		Windows[0] = indoors.crop(32 * 2, 32 * 2, 32, 32);
		
		//IndoorWalls
		Wall01[0] = indoors.crop(0, 32, 16, 16 * 3);
		Wall01[1] = indoors.crop(0, 16 * 5, 16, 16);
		Wall01[2] = indoors.crop(16, 32, 16, 16 * 3);
		Wall01[3] = indoors.crop(16, 16 * 5, 16, 16);
		Wall01[4] = indoors.crop(0, 16 * 6, 16, 16 * 3);
		Wall01[5] = indoors.crop(32, 32, 16, 16 * 3);
		Wall01[6] = indoors.crop(16 * 3, 32, 16, 16 * 3);
		Wall01[7] = indoors.crop(32, 16 * 5, 16, 16);
		Wall01[8] = indoors.crop(16 * 3, 16 * 5, 16, 16);
		Wall01[9] = indoors.crop(32, 16 * 6, 16, 16);
		Wall01[10] = indoors.crop(16, 16 * 6, 16, 16 * 3);
		Wall01[11] = indoors.crop(0, 16 * 9, 16, 16 * 3);
		Wall01[12] = indoors.crop(16, 16 * 9, 16, 16 * 3);
		Wall01[13] = indoors.crop(32, 16 * 7, 16, 16);
		Wall01[14] = indoors.crop(16 * 3, 16 * 7, 16, 16);
		
		//Wooden Counter
		WoodenCounterA[0] = furniture.crop(0, 0, 32, 32);
		WoodenCounterA[1] = furniture.crop(32 * 2, 0, 32, 32);
		WoodenCounterA[2] = furniture.crop(0, 32, 32, 32);
		WoodenCounterA[3] = furniture.crop(32, 32, 32, 32);
		WoodenCounterA[4] = furniture.crop(32 * 2, 32, 32, 32);
		
		//Cafeteria Counter
		CafeteriaCounterA[0] = furniture.crop(0, 32 * 2, 32, 32);
		CafeteriaCounterA[1] = furniture.crop(32 * 2, 32 * 2, 32, 32);
		CafeteriaCounterA[2] = furniture.crop(0, 32 * 3, 32, 32);
		CafeteriaCounterA[3] = furniture.crop(32, 32 * 3, 32, 32);
		CafeteriaCounterA[4] = furniture.crop(32 * 2, 32 * 3, 32, 32);
		
		//Cafeteria Box
		CafeteriaBox[0] = furniture.crop(16 * 6, 16 * 5, 16, 16 * 3);
		CafeteriaBox[1] = furniture.crop(16 * 7, 16 * 5, 16, 16 * 3);
		CafeteriaBox[2] = furniture.crop(16 * 8, 16 * 5, 16, 16 * 3);
		CafeteriaBox[3] = furniture.crop(16 * 9, 16 * 5, 16, 16 * 3);
		
		//White Chair
		int chair = 0;
		for(int i = 10; i < 14; i++) { WChair[chair] = furniture.crop(16 * i, 32 * 2, 16, 16 * 2); chair++; }
		for(int i = 10; i < 14; i++) { WChair[chair] = furniture.crop(16 * i, 32 * 3, 16, 16 * 2); chair++; }
		
		//Cash Register Machine
		CashRegister[0] = furniture.crop(16 * 6, 16 * 7, 16, 16 * 3);
		
		//Wall Decorations
		WallDecorations[0] = furniture.crop(16 * 13, 0 , 16 * 3, 32);
		WallDecorations[1] = furniture.crop(16 * 16, 0, 32, 32);
		
		//Single Furniture
		IndoorPlantA = furniture.crop(16 * 6, 0, 16, 16 * 2);
		SofaA = furniture.crop(16 * 6, 16 * 2, 32, 16 * 3);
		SofaB = furniture.crop(16* 14, 32 * 4, 32 * 2, 32);
		KeyBox = furniture.crop(16 * 7, 0, 16, 16 * 2);
		ClockA = furniture.crop(16 * 8, 0, 16, 16 * 2);
		SideTableA = furniture.crop(32 * 4, 32, 16, 16);
		BookShelfA = furniture.crop(16 * 9, 16, 32, 32);
		PlasticTable = furniture.crop(16 * 11, 0, 32, 32 * 2);
		VendingMachineA = furniture.crop(16 * 14, 16 * 3, 32, 16 * 3);
		VendingMachineB = furniture.crop(16 * 16, 16 * 3, 32, 16 * 3);
		Refrigerator = furniture.crop(16 * 18, 16 * 3, 32, 16 * 3);
		KitchenSink = furniture.crop(16 * 14, 32 * 3, 32, 32);
		KitchenStove = furniture.crop(16 * 16, 32 * 3, 32, 32);
		Television = furniture.crop(16 * 14, 32 * 5, 16 * 3, 16 * 3);
		Bed = furniture.crop(32 * 9, 32 * 3, 32, 32 * 2);
		
		
	}
}

function getMessage00(Tree)
	id = Tree:getSelect()
	if(id == 0) then Tree:setMessage("It's a tree. You ain't seeing shits.")
	elseif(id == 1) then Tree:setMessage("It's a mo'fuckin' tree, men!")
	elseif(id == 2) then Tree:setMessage("It's a tree, nothing else.")
	elseif(id == 3) then Tree:setMessage("The birds are now chirping.") end
end

function getMessage01(StreetLamp)
	con = StreetLamp:getLighten()
	if(con == "true") then StreetLamp:setMessage("The Street Light is emitting light.")
	else StreetLamp:setMessage("The Street Light is currently turned off.") end
end

function getMessage02(Sarah)
end

function getInteriorMessage00(ApartmentInterior)
	ApartmentInterior:setSleepMessageA("You do not feel like sleeping yet.");
	ApartmentInterior:setSleepMessageB("Sweet Dreams.");
	ApartmentInterior:setSleepMessageC("Rise and Shine, sleepy head!");
	ApartmentInterior:setBathMessage("Fresh from the Bath.");
end

function getInteriorMessage01(LibraryInterior)
	LibraryInterior:setBook1("Information is a signal or character representing data or a knowledge obtained from investigation, study, or instruction. On the other hand, technology is the practical application of knowledge especially in a particular area. The idea of technology in this age of modern communication and information is about accomplishing a task especially using technical process, methods, or knowledge. When these two ideas are merged, information technology is born, which would translate as the technology involving the development, maintenance, and use or computer systems, software, and networks for the processing and distribution of data.");
	LibraryInterior:setBook2("As technological change speeds up from time to time, the demand for people which would be needed in managing it gets higher and higher as well. Fortunately, in the field of information technology, several professions have been lining up for some qualified applicant to get. Such things can be programmer, systems analyst, database administrator, network administrator, and many more.");
	LibraryInterior:setBook3("Since the rise of technology and modernization, computers have taken humans beyond where information must go into. From a single byte up to the vast memory and data, these electronic machines have been powerful enough to give assistance to humans in terms of doing the tasks which must be done in real world. Computers can store and work with large amounts of information that is why more and more are reaching out to this idea of using computers in offices, homes, and everywhere. ");
	LibraryInterior:setBook4("Basically, computer is not just a single thing or product that is built and stood as it is. Computer is actually a composition of several parts with essential functions, that when joined altogether, make up an innovative machine that does the computing and all. To say, there are several parts of a computer, but the following are the basic ones to remember: Monitor is a part which shows everything we are supposed to see using a computer. Keyboard is the one that we use to input the data keys to a computer. Mouse is used to navigate the cursor in a computer screen.");
	LibraryInterior:setBook5("The legend has it that there was an unnamed wealthy town that had been hidden since the dawn of modernization. The town was said to be governed by a rich and renowned clan of Benjamin Roe which was believed to be killed in a massacre. In order to sustain the prosperity of the town, the family workers promised to keep it functioning; however, in the long run, the town had diminished its luck which resulted to its forever shutdown. Even so, some modern idealists claimed that this might not be just a make-believe story; wherefore to have the folklore alive, the town was named DoeVille, which was named after the mayor of the town.");
end

function getInteriorMessage02(ITWorkplaceInterior)
	id = ITWorkplaceInterior:getActivity()

	if(id == 0) then ITWorkplaceInterior:setActivityMessage("You encoded several files.")
	elseif(id == 1) then ITWorkplaceInterior:setActivityMessage("You fixed a PC unit at a different department.")
	elseif(id == 2) then ITWorkplaceInterior:setActivityMessage("You fixed a computer by changing its RAM.")
	elseif(id == 3) then ITWorkplaceInterior:setActivityMessage("You configured the network router and fixed the wiring.")
	elseif(id == 4) then ITWorkplaceInterior:setActivityMessage("You debugged an existing system.")
	elseif(id == 5) then ITWorkplaceInterior:setActivityMessage("You spend the whole hour doing nothing.") end


end

function getItemDescription001(SandwichA)
	SandwichA:setDescription("An ordinary sandwich that has ham inside, slightly satsifies hunger.")
end

function getItemDescription002(MilkCartonA)
	MilkCartonA:setDescription("A fresh healthy milk contained in a carton, best if consumed immediately.")
end

function getItemDescription003(FlowerA)
	FlowerA:setDescription("A purple marigold flower.")
end

function getItemDescription004(EmptyMilkCarton)
	EmptyMilkCarton:setDescription("An empty carton of milk, better to just throw it away.")
end

function getItemDescription005(Hotdog)
	Hotdog:setDescription("A tasty looking hotdog sandwich dressed with ketchup and mustard.")
end

function getItemDescription006(ATMCard)
	ATMCard:setDescription("A magnetic card used to withdraw money from an Automated Teller Machine.")
end

function getItemDescription007(IDCard)
	IDCard:setDescription("A small card that used to prove a person's identity and citezenship.")
end

function getItemDescription008(EnergyDrinkA)
	EnergyDrinkA:setDescription("A Drink that slightly increases someone's energy when consumed.")
end

function getItemDescription009(EmptyCanA)
	EmptyCanA:setDescription("A useless emtpy can, you can kick it around for amusement.")
end

function getItemDescription010(PotatoChips)
	PotatoChips:setDescription("An everyday snack made from fried potatoes, quite salty.")
end

function getItemDescription011(EmptyBag)
	EmptyBag:setDescription("An empty bag of snack, why would you even want to keep this?")
end

function getItemDescription012(HeathTablet)
	HeathTablet:setDescription("A tablet that will help you recover some health, with a bit of rest.")
end

function getItemDescription013(HeathCapsule)
	HeathCapsule:setDescription("A capsule that will make you recover some health instantly.")
end

function getItemDescription014(HandSanitizer)
	HandSanitizer:setDescription("A Gel made from Ethyl alcohol that kills bacteria on your hands.")
end

function getItemDescription015(EmptySanitizer)
	EmptySanitizer:setDescription("An empty bottle of hand sanitzer.")
end

function getItemDescription016(KopikoUno)
	KopikoUno:setDescription("A drink that restores energy. It also has 30% of palpitation.")
end

function getItemDescription017(Soda0)
	Soda0:setDescription("Lime flavored softdrink in a can that has a sweet and sour taste.")
	Soda0:setMessage("You drunk some Lime Soda.")
end

function getItemDescription018(Soda1)
	Soda1:setDescription("A softdrink in a can that has 20% more foam and 30% sweeter than a common softdrink.")
	Soda1:setMessage("You drunk some Rootbeer.")
end

function getItemDescription019(Soda2)
	Soda2:setDescription("Orange flavored softdrink in a can, it seems very common nowadays.")
	Soda2:setMessage("You drunk some Orange Soda.")
end

function getItemDescription020(Soda3)
	Soda3:setDescription("Grape flavored softdrink but it doesn't contain alcohol, quite sweet.")
	Soda3:setMessage("You drunk some Grape Soda.")
end

function getItemDescription021(Soda4)
	Soda4:setDescription("The common softdrink flavor, do not drink too much or it will burn your throat.")
	Soda4:setMessage("You drunk some Soda.")
end

function getItemDescription022(BottledDrinks0)
	BottledDrinks0:setDescription("Cold water in a bottle.")
	BottledDrinks0:setMessage("You drunk some water.")
end

function getItemDescription023(BottledDrinks1)
	BottledDrinks1:setDescription("Chocolate drink in a bottle.")
	BottledDrinks1:setMessage("You drunk some chocolate.")
end

function getItemDescription024(BottledDrinks2)
	BottledDrinks2:setDescription("Orange juice in a bottle.")
	BottledDrinks2:setMessage("You drunk some orange juice.")
end

function getItemDescription025(Snack0)
	Snack0:setDescription("A snack that is so good, it melts in your mouth.")
	Snack0:setMessage("You ate a chocolate bar.")
end

function getItemDescription026(Snack1)
	Snack1:setDescription("A white chocolate bar that has more milk, it is rich in Calcium.")
	Snack1:setMessage("You ate a milk chocolate bar.")
end

function getItemDescription027(Snack2)
	Snack2:setDescription("A gooey caramel bar that stick on your gums, munch it carefully.")
	Snack2:setMessage("You ate a milk chocolate bar.")
end

function getItemDescription028(Snack3)
	Snack3:setDescription("A nutritious snack which is made in whole grain, raspberries and raisins.")
	Snack3:setMessage("You ate a granola bar.")
end

function getItemDescription029(Snack4)
	Snack4:setDescription("A non-greasy peanuts in a bag, rich in Protein.")
	Snack4:setMessage("You ate a bag of peanuts.")
end

function getItemDescription030(Snack5)
	Snack5:setDescription("Perfectly roasted cashew nuts in a bag, a good aphrodisiac.")
	Snack5:setMessage("You ate a bag of cashew nuts.")
end


function getItemDescription031(Snack6)
	Snack6:setDescription("Soft sponge chocolate flavored sponge cake filled with custard.")
	Snack6:setMessage("You ate a sponge cake.")
end

function getTriggerDialouge001(ATM)
	mID = ATM:getmID()
	oID = ATM:getoID()
	cID = ATM:getcID()
	currentBalance = ATM:getCurrentBalance()
	recieved = ATM:getRecieve();

	if(cID == 0) then
		if(mID == 0) then
			ATM:setMessage("The ATM Card has been inserted. Select your transaction:")
			ATM:addOptions("Balance Inquiry.")
			ATM:addOptions("Withdraw.")
			ATM:addOptions("Cancel Transaction.")
		elseif(mID == 1) then
			if(recieved == "true") then
				ATM:setMessage("Withdrawal Successful. Do you want to have another transaction?")
			else
				ATM:setMessage("Your current Balance is " .. currentBalance .. ". Do you want have another transaction?")
			end
			ATM:addOptions("Yes.")
			ATM:addOptions("No.")
		end
	else ATM:setMessage("It requires an ATM Card to use.") end
end

function getNPCDialog000(Sarah)
	id = Sarah:getMessageID()

	if(id == 0) then Sarah:setMessage("The basic control is directional button to move, z button to interact and x button to run.")
	elseif(id == 1) then Sarah:setMessage("Some buildings here requires your identity card to enter.")
	elseif(id == 2) then Sarah:setMessage("Maintain your health, don't let yourself get hungry, get too tired or get dirty. It will affect your health.")
	elseif(id == 3) then Sarah:setMessage("Try to talk to anyone so that you may maintain a good mood.")
	elseif(id == 4) then Sarah:setMessage("Your sleeping time is always fixed to eight hours regardless the time.")
	elseif(id == 5) then Sarah:setMessage("Hello, my name is Sarah, just talk to me if you need some tips about the game.")
	elseif(id == 6) then Sarah:setMessage("Happy New Year!")
	end
end

function getNPCDialog001(HotdogGuy)
	mID = HotdogGuy:getmID()
	oID = HotdogGuy:getoID()

	if(mID == 0) then
	HotdogGuy:setMessage("Get your hotdog sandwich here for only ten doellars!")
	HotdogGuy:addOptions("Yes please.")
	HotdogGuy:addOptions("No thanks.")
	HotdogGuy:addOptions("Talk to the Hotdog Vendor.")
	elseif(mID == 1) then
		if(oID == 0) then HotdogGuy:setMessage("Here you go, thank you for buying.")
		elseif(oID == 1) then HotdogGuy:setMessage("Well that's too bad, hope you change your mind.")
		elseif(oID == 2) then HotdogGuy:setMessage("Great weather we're having today lad, want to buy some hotdog?") end
	end
end

function getVendingManchineOptionA(VendingMachineA)
	mID = VendingMachineA:getmID()
	oID = VendingMachineA:getoID()
	chance = VendingMachineA:getChance()

	if(mID == 0) then
	VendingMachineA:setMessage("You see a Vending Machine, what will you do?")
	VendingMachineA:addOptions("Buy something.")
	VendingMachineA:addOptions("Check under the machine.")
	VendingMachineA:addOptions("Do nothing.")
	elseif(mID == 1) then
		if(oID == 1) then
			if(chance == 1) then VendingMachineA:setMessage("You found 10 Doellars under the vending machine.")
			else VendingMachineA:setMessage("You checked below the machine but you didn't find anything useful.") end
		elseif(oID == 2) then VendingMachineA:setMessage("You decided to leave it alone.") end
	end
end

function getVendingManchineOptionB(VendingMachineB)
	mID = VendingMachineB:getmID()
	oID = VendingMachineB:getoID()

	if(mID == 0) then
	VendingMachineB:setMessage("You see a Vending Machine, what will you do?")
	VendingMachineB:addOptions("Buy something.")
	VendingMachineB:addOptions("Check under the machine.")
	VendingMachineB:addOptions("Do nothing.")
	elseif(mID == 1) then
		if(oID == 1) then VendingMachineB:setMessage("You checked below the machine but you didn't find anything useful.")
		elseif(oID == 2) then VendingMachineB:setMessage("You decided to leave it alone.") end
	end
end

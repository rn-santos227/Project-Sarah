package com.project.Doeville.scripts;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;

public class LoadScript {
	final private String path = "res/scripts/";
	private LuaValue _G; 
	
	public LoadScript( String fileName) {
		_G = JsePlatform.standardGlobals();
		_G.get("dofile").call(LuaValue.valueOf(path + fileName));
	}
	
	public void runScript(String functionName, Object obj) {
		LuaValue myFunction = _G.get(functionName);
		myFunction.call(CoerceJavaToLua.coerce(obj));
	}
}
